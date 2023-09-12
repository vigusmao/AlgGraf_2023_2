import java.util.ArrayList;
import java.util.List;

public abstract class Graph {

    private int n;

    private int m;

    List<Vertex> vertices;

    public Graph(int n) {
        this.n = n;
        this.vertices = new ArrayList<>(n);

        for (int i = 0 ; i < n; i++) {
            addVertex();
        }
    }

    private void addVertex() {
        addVertex(null);
    }

    private void addVertex(String label) {
        int nextId = this.vertices.size();
        Vertex v = new Vertex(nextId, label);
        this.vertices.add(v);
    }

    /**
     * Creates a graph with the informed vertices
     * and edges. Each edge is given as a pair of
     * vertex labels (origin, destination).
     *
     * @param vertexLabels the intended vertices
     * @param edges a list of pairs of labels
     */
    public Graph(List<String> vertexLabels,
                 List<LabelPair> edges) {
        // ToDo IMPLEMENT ME!!!
    }


    public int getEdgeCount() {
        return m;
    }

    public int getVertexCount() {
        return n;
    }

    /** Returns the vertex with the given id.
     *  Ids range from 0 to n-1.
     *
     * @param id
     * @return the intended vertex, if exists; null, otherwise
     */
    public Vertex getVertex(int id) {
        if (id < 0 || id >= this.n) {
            return null;
        }
        return vertices.get(id);
    }

    public abstract void addEdge(int originId,
                                 int destinationId);

    public abstract boolean hasEdge(int originId,
                                    int destinationId);

}
