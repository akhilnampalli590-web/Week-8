import java.util.*;

public class FIFOPageReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int frames = sc.nextInt();
        System.out.print("Enter size of reference string: ");
        int n = sc.nextInt();

        int[] ref = new int[n];
        System.out.println("Enter reference string:");
        for (int i = 0; i < n; i++) ref[i] = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        int pageFaults = 0;

        System.out.println("\nPage Replacement Steps:");
        for (int i = 0; i < n; i++) {
            if (!q.contains(ref[i])) {
                if (q.size() == frames) {
                    q.poll(); // Remove oldest
                }
                q.add(ref[i]);
                pageFaults++;
            }
            System.out.println(q);
        }

        System.out.println("\nTotal Page Faults = " + pageFaults);
    }
}
