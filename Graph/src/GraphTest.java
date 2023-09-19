import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public abstract class GraphTest {

    protected static final int N = 5;

    public abstract Graph getGraph();

    @Test
    public void testGraphCreationWithVertexCount() {
        assertEquals(5, getGraph().getVertexCount());
        assertEquals(0, getGraph().getEdgeCount());

        assertEquals("2", getGraph().getVertex(2).getLabel());
        assertNull(getGraph().getVertex(198));
    }

    @Test
    public void testGraphCreationWithVerticesAndEdges() {
    }

    @Test
    public void testAddEdge() {
        getGraph().addEdge(2, 4);
        assertTrue(getGraph().hasEdge(2, 4));

        try {
            getGraph().addEdge(2, 2);
            fail("An IllegalArgumentException must be thrown " +
                    "if one tries to add a self-loop");
        } catch (IllegalArgumentException e) {
            // all good!!!
        }
    }

    @Test
    public void testGetOutNeighbors() {
        getGraph().addEdge(1, 2);
        getGraph().addEdge(1, 3);
        getGraph().addEdge(4, 1);
        getGraph().addEdge(2, 3);

        Collection<Vertex> outNeighborsOfVertex1 = getGraph().getOutNeighbors(1);

        assertEquals(2, outNeighborsOfVertex1.size());

        assertTrue(outNeighborsOfVertex1.contains(getGraph().getVertex(2)));
        assertTrue(outNeighborsOfVertex1.contains(getGraph().getVertex(3)));

        assertFalse(outNeighborsOfVertex1.contains(getGraph().getVertex(4)));
        assertFalse(outNeighborsOfVertex1.contains(getGraph().getVertex(1)));
    }
}