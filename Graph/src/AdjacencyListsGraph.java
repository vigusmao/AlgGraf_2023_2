import java.util.ArrayList;
import java.util.List;

public class AdjacencyListsGraph extends Graph {

    private List<List<Vertex>> adjLists;

    public AdjacencyListsGraph(int n) {
        super(n);

        adjLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjLists.add(null);
        }
    }

    @Override
    public void addEdge(int originId, int destinationId) {
        // ToDo IMPLEMENT ME!!!!
    }

    @Override
    public boolean hasEdge(int originId, int destinationId) {
        return false;  // ToDo IMPLEMENT ME!!!!
    }
}
