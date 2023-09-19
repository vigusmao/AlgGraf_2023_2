import org.junit.Before;

public class AdjacencyListsGraphTest extends GraphTest {

    private Graph graph;

    @Before
    public void setUp() {
        graph = new AdjacencyListsGraph(N);
    }

    public Graph getGraph() {
        return graph;
    }
}