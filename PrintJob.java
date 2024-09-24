public class PrintJob implements Comparable<PrintJob> {

    int time;           // Submission time
    String docName;     // Document name
    int priority;       // Job priority
    int pages;          // Number of pages
    int completionTime; // Time job completes printing

    public PrintJob (int time, String docName, int priority, int pages){
        this.time = time;
        this.docName = docName;
        this.priority = priority;
        this.pages = pages;
    }

    // Compare based on priority, then by submission time
    @Override
    public int compareTo(PrintJob other) {
        if (this.priority != other.priority){
            return Integer.compare(this.priority, other.priority);
        } else {
            return Integer.compare(this.time, other.time);
        }
    } // end compareTo function
    
} // end class PrintJob
