import org.junit.Before;

public class HashBasedGraphTest extends GraphTest {

    private Graph graph;

    @Before
    public void setUp() {
        graph = new HashBasedGraph(N);
    }

    public Graph getGraph() {
        return graph;
    }
}