import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AdjacencyListsGraph extends Graph {

    private List<List<Vertex>> outNeighborsById;

    public AdjacencyListsGraph(int n) {
        super(n);

        outNeighborsById = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            outNeighborsById.add(null);
        }
    }

    @Override
    protected void addEdgeToInternalStructures(
            int originId, int destinationId) {

        verifyVertexId(originId);
        verifyVertexId(destinationId);

        Vertex destinationVertex = getVertex(destinationId);

        // add destination as out-neighbor of origin
        List<Vertex> outNeighbors =
                this.outNeighborsById.get(originId);
        if (outNeighbors == null) {
            outNeighbors = new ArrayList<>();
            this.outNeighborsById.set(originId, outNeighbors);
        }

        outNeighbors.add(destinationVertex);
    }

    @Override
    public boolean hasEdge(int originId, int destinationId) {
        if (originId < 0 || originId >= this.n ||
                destinationId < 0 || destinationId >= this.n) {
            return false;
        }

        List<Vertex> outNeighbors =
                this.outNeighborsById.get(originId);

        if (outNeighbors == null) {
            return false;
        }

        Vertex destinationVertex = getVertex(destinationId);

        return outNeighbors.contains(destinationVertex);
    }

    @Override
    public Collection<Vertex> getOutNeighbors(int vertexId) {
        verifyVertexId(vertexId);

        List<Vertex> outNeighbors =
                this.outNeighborsById.get(vertexId);

        return Collections.unmodifiableList(outNeighbors);
    }
}
