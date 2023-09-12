public class AdjacencyMatrixGraph extends Graph {

    private boolean[][] adjMatrix;

    public AdjacencyMatrixGraph(int n) {
        super(n);

        adjMatrix = new boolean[n][n];
    }

    @Override
    public void addEdge(int originId, int destinationId) {
        this.adjMatrix[originId][destinationId] = true;
    }

    @Override
    public boolean hasEdge(int originId, int destinationId) {
        return this.adjMatrix[originId][destinationId];
    }
}
