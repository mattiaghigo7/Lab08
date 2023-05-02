package it.polito.tdp.extflightdelays.model;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();

		Graph<Airport,DefaultWeightedEdge> grafo = model.creaGrafo(0);
		
		System.out.println("Grafo creato con "+grafo.vertexSet().size()+" vertici e "+grafo.edgeSet().size()+" archi");
	}

}
