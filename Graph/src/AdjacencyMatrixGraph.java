import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph extends Graph {

    private boolean[][] adjMatrix;

    public AdjacencyMatrixGraph(int n) {
        super(n);

        adjMatrix = new boolean[n][n];
    }

    @Override
    protected void addEdgeToInternalStructures(
            int originId, int destinationId) {
        verifyVertexId(originId);
        verifyVertexId(destinationId);
        this.adjMatrix[originId][destinationId] = true;
    }

    @Override
    public boolean hasEdge(int originId, int destinationId) {
        return this.adjMatrix[originId][destinationId];
    }

    @Override
    public List<Vertex> getOutNeighbors(int vertexId) {
        verifyVertexId(vertexId);

        List<Vertex> outNeighbors = new ArrayList<>();
        for (int v = 0; v < this.n; v++) {
            if (this.adjMatrix[vertexId][v]) {
                outNeighbors.add(getVertex(v));
            }
        }

        return outNeighbors;
    }
}
