import java.util.*;

public class InvertedIndex {
    private Map<String, List<Integer>> index;

    public InvertedIndex() {
        this.index = new HashMap<>();
    }

    public void addTask(int taskId, String description) {
        String[] words = description.toLowerCase().split("\\W+");
        for (String word : words) {
            index.putIfAbsent(word, new ArrayList<>());
            if (!index.get(word).contains(taskId)) {
                index.get(word).add(taskId);
            }
        }
    }

    public List<Integer> search(String word) {
        return index.getOrDefault(word.toLowerCase(), new ArrayList<>());
    }

    public void printIndex() {
        for (Map.Entry<String, List<Integer>> entry : index.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
