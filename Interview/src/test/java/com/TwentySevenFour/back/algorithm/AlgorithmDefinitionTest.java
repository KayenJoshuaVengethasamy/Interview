package com.TwentySevenFour.back.algorithm;

import com.TwentySevenFour.back.algorithm.AlgorithmDefinition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmDefinitionTest {

    @Test
    public void testDijkstraShortestPath() {
        // Initialize the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        AlgorithmDefinition.addEdge(graph, "A", "B", 0.44);
        AlgorithmDefinition.addEdge(graph, "A", "C", 1.89);
        AlgorithmDefinition.addEdge(graph, "A", "D", 0.10);
        AlgorithmDefinition.addEdge(graph, "B", "H", 2.44);
        AlgorithmDefinition.addEdge(graph, "C", "F", 0.49);
        AlgorithmDefinition.addEdge(graph, "D", "L", 2.34);

        // Run Dijkstra's algorithm
        AlgorithmDefinition.PathResult result = AlgorithmDefinition.dijkstra(graph, "A", "L");

        // Expected results
        double expectedDistance = 2.44 + 2.34; // A -> D -> L
        String[] expectedPath = {"A", "D", "L"};

        // Validate the result
        assertEquals(expectedDistance, result.distance, 0.01);
        assertArrayEquals(expectedPath, result.path.toArray(new String[0]));
    }

    @Test
    public void testDijkstraNoPath() {
        // Initialize the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        AlgorithmDefinition.addEdge(graph, "A", "B", 0.44);

        // Run Dijkstra's algorithm
        AlgorithmDefinition.PathResult result = AlgorithmDefinition.dijkstra(graph, "A", "C");

        // Validate the result
        assertEquals(Double.MAX_VALUE, result.distance);
        assertTrue(result.path.isEmpty());
    }
}