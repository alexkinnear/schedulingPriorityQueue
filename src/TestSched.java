import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class TestSched {



    public static void readTasks(String filename, ArrayList<Task> task1, ArrayList<Task> task2, ArrayList<Task> task3) throws FileNotFoundException {
        int count = 1;
        Scanner fileScanner = new Scanner(new File("data/"+filename));
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            line = line.replaceAll("[ \\s+]", " ");
            String[] arr  = line.split(" ");
            ArrayList<Integer> arr2 = new ArrayList<Integer>();
            for (String s : arr) {
                if (!s.equals("")) {
                    arr2.add(Integer.parseInt(s));
                }
            }

            Task1 tsk1 = new Task1(count, arr2.get(0), arr2.get(1), arr2.get(2));
            Task2 tsk2 = new Task2(count, arr2.get(0), arr2.get(1), arr2.get(2));
            Task3 tsk3 = new Task3(count, arr2.get(0), arr2.get(1), arr2.get(2));
            count++;
            task1.add(tsk1);
            task2.add(tsk2);
            task3.add(tsk3);
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scheduler s = new Scheduler();
        String [] files = {"taskset1.txt","taskset2.txt","taskset3.txt","taskset4.txt","taskset5.txt" };
        for (String f : files) {
            ArrayList<Task> t1 = new ArrayList();    // elements are Task1
            ArrayList<Task> t2 = new ArrayList();    // elements are Task2
            ArrayList<Task> t3 = new ArrayList();    // elements are Task3
            readTasks(f, t1, t2, t3);
            s.makeSchedule("Deadline Priority "+ f, t1);
            s.makeSchedule("Startime Priority " + f, t2);
            s.makeSchedule("Wild and Crazy priority " + f, t3);
       }

    }
}
