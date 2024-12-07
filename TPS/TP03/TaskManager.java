import java.util.List;
import java.util.ArrayList;

public class TaskManager {
    private List<Task> tasks;
    private InvertedIndex invertedIndex;
    private int nextId; // Contador para IDs sequenciais

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.invertedIndex = new InvertedIndex();
        this.nextId = 1; // Inicia o ID com 1
    }

    public void addTask(Task task) {
        task.setId(nextId++); // Atualize o ID da tarefa existente
        tasks.add(task);
        invertedIndex.addTask(task.getId(), task.getDescription());
    }

    public void removeTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }

    public List<Task> searchTasksByWord(String word) {
        List<Integer> taskIds = invertedIndex.search(word);
        List<Task> result = new ArrayList<>();
        for (int taskId : taskIds) {
            for (Task task : tasks) {
                if (task.getId() == taskId) {
                    result.add(task);
                }
            }
        }
        return result;
    }

    public List<Task> searchTasksByLabel(String label) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getLabels().contains(label)) {
                result.add(task);
            }
        }
        return result;
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void addLabelToTask(int taskId, String label) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.addLabel(label); // Adiciona o rótulo na tarefa
                return; // Sai do método após encontrar a tarefa
            }
        }
        System.out.println("Task ID " + taskId + " not found.");
    }
}
