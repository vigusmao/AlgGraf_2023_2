import org.junit.Test;

import static org.junit.Assert.*;

public class VertexTest {

    @Test
    public void testVertexCreation() {
        Vertex v = new Vertex(15, "Fifteen");
        assertEquals(15, v.getId());
        assertEquals("Fifteen", v.getLabel());
    }

    @Test
    public void testVertexCreationWithoutLabel() {
        Vertex v = new Vertex(15, null);
        assertEquals(15, v.getId());
        assertEquals("15", v.getLabel());
    }
}