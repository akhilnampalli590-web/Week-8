import java.util.Scanner;

public class BankersAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        System.out.print("Enter number of resources: ");
        int m = sc.nextInt();

        int[][] allocation = new int[n][m];
        int[][] max = new int[n][m];
        int[][] need = new int[n][m];
        int[] available = new int[m];

        System.out.println("\nEnter Allocation Matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                allocation[i][j] = sc.nextInt();

        System.out.println("\nEnter Max Matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                max[i][j] = sc.nextInt();

        System.out.println("\nEnter Available Resources:");
        for (int j = 0; j < m; j++)
            available[j] = sc.nextInt();

        // Calculate Need matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                need[i][j] = max[i][j] - allocation[i][j];

        boolean[] finished = new boolean[n];
        int[] safe = new int[n];
        int index = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (!finished[i]) {
                    int flag = 0;
                    for (int j = 0; j < m; j++) {
                        if (need[i][j] > available[j]) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        safe[index++] = i;
                        for (int y = 0; y < m; y++)
                            available[y] += allocation[i][y];
                        finished[i] = true;
                    }
                }
            }
        }

        boolean safeState = true;
        for (boolean f : finished)
            if (!f) safeState = false;

        if (safeState) {
            System.out.print("\nSystem is in SAFE state.\nSafe sequence: ");
            for (int i = 0; i < n; i++)
                System.out.print("P" + safe[i] + " ");
        } else {
            System.out.println("\nSystem is NOT in safe state (Deadlock Possible!).");
        }
    }
}
