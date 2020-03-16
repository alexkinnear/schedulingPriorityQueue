// Duration priority
public class Task3 extends Task {
    public Task3(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }
    // Prioirity is deadline
    @Override
    public int compareTo(Task t2) {
        if (t2.duration > this.duration) return -1;
        else if (t2.duration < this.duration) return 1;
        return 0;
    }

}
