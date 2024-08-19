package com.TwentySevenFour.back.controller;

import com.TwentySevenFour.back.algorithm.AlgorithmDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RouteController.class)
public class RouteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShortestRoute() throws Exception {
        // Initialize the graph with edges (same as the ones used in the AlgorithmDefinition test)
        Map<String, Map<String, Double>> graph = new HashMap<>();
        AlgorithmDefinition.addEdge(graph, "A", "B", 0.44);
        AlgorithmDefinition.addEdge(graph, "A", "C", 1.89);
        AlgorithmDefinition.addEdge(graph, "A", "D", 0.10);
        AlgorithmDefinition.addEdge(graph, "B", "H", 2.44);
        AlgorithmDefinition.addEdge(graph, "C", "F", 0.49);
        AlgorithmDefinition.addEdge(graph, "D", "L", 2.34);

        // Test the endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/shortestRoute/A/L"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Distance: 2.44")))
            .andExpect(content().string(org.hamcrest.Matchers.containsString("Path: A -> D -> L")));
    }

    @Test
    public void testShortestRouteNoPath() throws Exception {
        // Initialize the graph with a single edge
        Map<String, Map<String, Double>> graph = new HashMap<>();
        AlgorithmDefinition.addEdge(graph, "A", "B", 0.44);

        // Test the endpoint for no path
        mockMvc.perform(MockMvcRequestBuilders.get("/shortestRoute/A/C"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("The end node C is unreachable from A.")));
    }
}