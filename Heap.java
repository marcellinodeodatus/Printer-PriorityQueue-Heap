import java.util.PriorityQueue;

public class Heap {
    private PriorityQueue<PrintJob> jobQueue;

    public Heap(){
        this.jobQueue = new PriorityQueue<>();
    }

    public void insert(PrintJob job) {
        jobQueue.add(job);
    }

    public PrintJob extractMin(){
        return jobQueue.poll();
    }

    public boolean isEmpty(){
        return jobQueue.isEmpty();
    }

    
} // end class Heap
