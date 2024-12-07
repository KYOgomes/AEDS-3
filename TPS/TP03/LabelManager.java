import java.util.ArrayList;
import java.util.List;

public class LabelManager {
    private List<String> labels; // Lista para simular a estrutura de uma árvore B+

    public LabelManager() {
        this.labels = new ArrayList<>();
    }

    public void addLabel(String label) {
        if (!labels.contains(label)) {
            labels.add(label);
            labels.sort(String::compareTo); // Ordena os rótulos (simula a ordenação da B+).
        }
    }

    public void removeLabel(String label) {
        labels.remove(label);
    }

    public List<String> getAllLabels() {
        return labels;
    }

    public void printLabels() {
        System.out.println("Labels: " + labels);
    }
}
