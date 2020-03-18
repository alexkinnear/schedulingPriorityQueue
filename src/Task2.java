// start priority
public class Task2 extends Task {
    public Task2(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }
    // Priority is start time
    @Override
    public int compareTo(Task t2) {
        if (t2.start > this.start) return -1;
        else if (t2.start < this.start) return 1;
        if (t2.deadline > this.deadline) return -1;
        else if (t2.deadline < this.deadline) return 1;
        return 0;
    }

}
