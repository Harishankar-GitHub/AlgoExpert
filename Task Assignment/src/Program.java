import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> resultList = taskAssignment(3, new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4)));

        for (ArrayList<Integer> list : resultList) {
            list.forEach(System.out::print);
        }
    }

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<>();
        Map<Integer, List<Integer>> taskDurationsAndIndices = getTaskDurationsAndIndices(tasks);

        Collections.sort(tasks);

        for (int i = 0; i < k; i++) {
            int taskDuration = tasks.get(i);
            List<Integer> indicesWithTask1Duration = taskDurationsAndIndices.get(taskDuration);
            int task1Index = indicesWithTask1Duration.remove(indicesWithTask1Duration.size() - 1);

            int task2Duration = tasks.get(tasks.size() - 1 - i);
            List<Integer> indicesWithTask2Duration = taskDurationsAndIndices.get(task2Duration);
            int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1);

            ArrayList<Integer> pairedTask = new ArrayList<>();
            pairedTask.add(task1Index);
            pairedTask.add(task2Index);

            pairedTasks.add(pairedTask);
        }

        return pairedTasks;
    }

    private static Map<Integer, List<Integer>> getTaskDurationsAndIndices(ArrayList<Integer> tasks) {
        Map<Integer, List<Integer>> tasksAndIndices = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {
            int task = tasks.get(i);

            if (tasksAndIndices.containsKey(task)) {
                tasksAndIndices.get(task).add(i);
            } else {
                List<Integer> indicesList = new ArrayList<>();
                indicesList.add(i);
                tasksAndIndices.put(task, indicesList);
            }
        }

        return tasksAndIndices;
    }
}
