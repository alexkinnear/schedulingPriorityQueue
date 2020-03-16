
import java.util.ArrayList;


public class Scheduler {

    public void makeSchedule(String priority, ArrayList schedule) {
        int tasksLate= 0, totalLate = 0;
        System.out.println(priority);
        LeftistHeap<Task> minHeap = new LeftistHeap<>();
        for (Object item : schedule) {
            if (priority.startsWith("Start"))
                minHeap.insert((Task2) item);
            else if (priority.startsWith("Wild")) {
                minHeap.insert((Task3) item);
            }
            else
                minHeap.insert((Task) item);
        }
        int time = 1;
        while (!minHeap.isEmpty()) {
            Task current = minHeap.deleteMin();
            for (int i = 1; i <= current.duration; i++) {
                System.out.print("Time: " + time + " Task " + current.ID + " ");
                if (i == current.duration) {
                    System.out.print("** ");
                    if (time > current.deadline) {
                        tasksLate++;
                        totalLate += time - current.deadline;
                        System.out.print("Late " + (time - current.deadline));
                    }
                }
                time++;
                System.out.println();
            }
        }
        System.out.println("Tasks Late: " + tasksLate + " Total Late: " + totalLate);
        System.out.println("\n");
    }

}
