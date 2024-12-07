
import java.util.ArrayList;
import java.util.List;

public class Task {
    private int id;
    private String description;
    private List<String> labels; // Rótulos associados à tarefa.

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.labels = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void addLabel(String label) {
        if (!labels.contains(label)) {
            labels.add(label);
        }
    }

    public void removeLabel(String label) {
        labels.remove(label);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", labels=" + labels +
                '}';
    }
}
