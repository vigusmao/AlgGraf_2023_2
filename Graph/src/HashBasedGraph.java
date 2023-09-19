import java.util.*;

public class HashBasedGraph extends Graph {

    private HashMap<Vertex, HashSet<Vertex>> outNeighborSetByVertex;

    public HashBasedGraph(int n) {
        super(n);
        this.outNeighborSetByVertex = new HashMap<>(n);
    }

    @Override
    protected void addEdgeToInternalStructures(int originId, int destinationId) {
        verifyVertexId(originId);
        verifyVertexId(destinationId);

        Vertex originVertex = getVertex(originId);
        Vertex destinationVertex = getVertex(destinationId);

        // add destination as out-neighbor of origin
        HashSet<Vertex> outNeighborSet =
                this.outNeighborSetByVertex.get(originVertex);

        if (outNeighborSet == null) {
            outNeighborSet = new HashSet<>();
            this.outNeighborSetByVertex.put(
                    originVertex, outNeighborSet);
        }

        outNeighborSet.add(destinationVertex);
    }

    @Override
    public boolean hasEdge(int originId, int destinationId) {
        if (originId < 0 || originId >= this.n ||
                destinationId < 0 || destinationId >= this.n) {
            return false;
        }

        Vertex originVertex = getVertex(originId);
        Vertex destinationVertex = getVertex(destinationId);

        HashSet<Vertex> outNeighborSet =
                this.outNeighborSetByVertex.get(originVertex);

        if (outNeighborSet == null) {
            return false;
        }

        return outNeighborSet.contains(destinationVertex);
    }

    @Override
    public Collection<Vertex> getOutNeighbors(int vertexId) {
        verifyVertexId(vertexId);

        Set<Vertex> outNeighbors =
                this.outNeighborSetByVertex.get(getVertex(vertexId));

        return outNeighbors == null ? null :
                Collections.unmodifiableSet(outNeighbors);
    }
}
