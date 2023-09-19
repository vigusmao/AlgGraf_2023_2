import org.junit.Before;

public class AdjacencyMatrixGraphTest extends GraphTest {

    private Graph graph;

    @Before
    public void setUp() {
        graph = new AdjacencyMatrixGraph(N);
    }

    public Graph getGraph() {
        return graph;
    }
}