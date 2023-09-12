import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {

    private Graph adjMatrixG;
    private Graph adjListsG;
    private List<Graph> graphs;

    @Before
    public void setUp() {
        adjMatrixG = new AdjacencyMatrixGraph(5);
        adjListsG = new AdjacencyListsGraph(5);

        graphs = new ArrayList<>();
        graphs.add(adjMatrixG);
//        graphs.add(adjListsG);
    }

    @Test
    public void testGraphCreationWithVertexCount() {
        for (Graph g : graphs) {
            doTestGraphCreationWithVertexCount(g);
        }
    }

    private void doTestGraphCreationWithVertexCount(Graph g) {
        assertEquals(5, g.getVertexCount());
        assertEquals(0, g.getEdgeCount());

        assertEquals("2", g.getVertex(2).getLabel());
        assertNull(g.getVertex(198));
    }

    @Test
    public void testGraphCreationWithVerticesAndEdges() {
        for (Graph g : graphs) {
            doTestGraphCreationWithVerticesAndEdges(g);
        }
    }

    private void doTestGraphCreationWithVerticesAndEdges(Graph g) {

    }

    @Test
    public void testAddEdge() {
        for (Graph g : graphs) {
            doTestAddEdge(g);
        }
    }

    private void doTestAddEdge(Graph g) {
        g.addEdge(2, 4);
        assertTrue(g.hasEdge(2, 4));
    }
}