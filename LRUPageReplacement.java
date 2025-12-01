import java.util.*;

public class LRUPageReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int frames = sc.nextInt();
        System.out.print("Enter size of reference string: ");
        int n = sc.nextInt();

        int[] ref = new int[n];
        System.out.println("Enter reference string:");
        for (int i = 0; i < n; i++) ref[i] = sc.nextInt();

        ArrayList<Integer> frameList = new ArrayList<>();
        int pageFaults = 0;

        System.out.println("\nPage Replacement Steps:");
        for (int i = 0; i < n; i++) {
            if (!frameList.contains(ref[i])) {
                if (frameList.size() == frames) {
                    frameList.remove(0); // Remove LRU
                }
                frameList.add(ref[i]);
                pageFaults++;
            } else {
                // Move referenced page to most recently used position
                frameList.remove((Integer) ref[i]);
                frameList.add(ref[i]);
            }
            System.out.println(frameList);
        }

        System.out.println("\nTotal Page Faults = " + pageFaults);
    }
}
