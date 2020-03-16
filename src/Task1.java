// deadline priority
public class Task1 extends Task {
    public Task1(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }
    // Prioirity is deadline
    @Override
    public int compareTo(Task t2) {
        if (t2.deadline > this.deadline) return -1;
        else if (t2.deadline < this.deadline) return 1;
        return 0;
      }

}
