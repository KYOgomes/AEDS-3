import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        LabelManager labelManager = new LabelManager();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Adicionar Rótulo a Tarefa");
            System.out.println("3. Buscar por Palavra-Chave");
            System.out.println("4. Buscar por Rótulo");
            System.out.println("5. Ver Todos os Rótulos");
            System.out.println("6. Ver Todas as Tarefas");
            System.out.println("0. Sair");
            System.out.print("Escolha opcao: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                System.out.print("Enter task description: ");
                String description = scanner.nextLine();
                taskManager.addTask(new Task(0, description)); // O ID será ignorado e gerado automaticamente
                System.out.println("Task added.");
                break;

                case 2:
                    System.out.print("Digitar tarefa ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Adicionar Rotulo: ");
                    String label = scanner.nextLine();
                    labelManager.addLabel(label);
                    for (Task task : taskManager.searchTasksByWord("")) {
                        if (task.getId() == taskId) {
                            task.addLabel(label);
                            System.out.println("Rotulo adicionado a tarefa.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Adicionar palavra chave para busca: ");
                    String word = scanner.nextLine();
                    System.out.println("Tasks containing '" + word + "':");
                    for (Task task : taskManager.searchTasksByWord(word)) {
                        System.out.println(task);
                    }
                    break;

                case 4:
                    System.out.print("adicionar rotulo para busca: ");
                    String searchLabel = scanner.nextLine();
                    System.out.println("Tasks with label '" + searchLabel + "':");
                    for (Task task : taskManager.searchTasksByLabel(searchLabel)) {
                        System.out.println(task);
                    }
                    break;

                case 5:
                    labelManager.printLabels();
                    break;

                case 6:
                    taskManager.printTasks();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
        } while (option != 0);

        scanner.close();
    }
}
