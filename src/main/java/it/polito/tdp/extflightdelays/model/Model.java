package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Graph<Airport,DefaultWeightedEdge> grafo;
	private List<Airport> aeroporti;
	private List<Airport> allAeroporti;
	private Map<Integer,Airport> aeroportiIdMap;
	private double distanza = 0;
	
	public Graph<Airport,DefaultWeightedEdge> creaGrafo(double distanza) {
		this.distanza=distanza;
		//creo oggetto grafo
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//aggiungo vertici
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		this.allAeroporti = dao.loadAllAirports();
		this.aeroportiIdMap = new HashMap<>();
		for(Airport a : this.allAeroporti) {
			this.aeroportiIdMap.put(a.getId(), a);
		}
		
		List<CoppiaA> coppie = dao.getCoppie(this.aeroportiIdMap, this.distanza);
		this.aeroporti = new LinkedList<>();
		for(CoppiaA c : coppie) {
			this.aeroporti.add(c.getPartenza());
		}
		for(CoppiaA c : coppie) {
			this.aeroporti.add(c.getDestinazione());
		}
		Graphs.addAllVertices(this.grafo, this.aeroporti);
		
		//aggiungo archi
		for(CoppiaA c : coppie) {
				grafo.addEdge(c.getPartenza(), c.getDestinazione());
				grafo.setEdgeWeight(c.getPartenza(), c.getDestinazione(), c.getDistanza());
		}
		
//		System.out.println("Grafo creato con "+grafo.vertexSet().size()+" vertici e "+grafo.edgeSet().size()+" archi");
		
		return grafo;
	}
}
