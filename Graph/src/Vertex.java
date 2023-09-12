public class Vertex {

    private final int id;

    private final String label;

    public Vertex(int id, String label) {
        this.id = id;
        if (label == null) {
            label = "" + id;
        }
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
