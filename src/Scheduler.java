
import java.util.ArrayList;


public class Scheduler {

    public void makeSchedule(String priority, ArrayList schedule) {
        LeftistHeap<Task> minHeap = new LeftistHeap<>();
        for (Object item : schedule) {
            minHeap.insert((Task) item);
        }
        int time = 1;
        while (!minHeap.isEmpty()) {
            System.out.println("Time: " + time + " " + minHeap.deleteMin().toStringL());
            time++;
        }
        System.out.println("------------------------");
    }

}
