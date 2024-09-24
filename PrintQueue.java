import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintQueue {

    public static void main(String[] args){
        
        try {
            Scanner sc = new Scanner(new File("printer.txt"));
            int n = sc.nextInt(); // Number of printer queue scenarios
            for (int k = 1; k <= n; k++){
                System.out.println("Printer #" + k + ":\n");

                int r = sc.nextInt(); //Number of requests
                Heap heap = new Heap();

                for (int i = 0; i < r; i++){
                    int time = sc.nextInt();
                    String docName = sc.next();
                    int priority = sc.nextInt();
                    int pages = sc.nextInt();
                    heap.insert(new PrintJob(time, docName, priority, pages));
                }

                int currentTime = 0;
                while (!heap.isEmpty()){
                    PrintJob job = heap.extractMin();

                    // Start time for the job will be the max of the current time or job's submission time
                    currentTime = Math.max(currentTime, job.time);

                    // Compute the time it will finish (2 seconds to prepare + number of pages)
                    currentTime += (2 + job.pages);
                    job.completionTime = currentTime;

                    // Output the result
                    System.out.println(job.docName + " completed printing at time " + job.completionTime + ".");

                }

                System.out.println(); // Blank line after each printer scenario
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. ");
        }


    } // end driver
    



} // end class PrintQueue
