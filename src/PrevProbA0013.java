import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrevProbA0013 {
    private static int T;
    private static int N; // 2 <= N <= 10
    private static int MAX_N = 10;
    private static int[][] M = new int[MAX_N][MAX_N];
    private static int[] VISITED = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.valueOf(in.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.valueOf(in.readLine());
            for (int n = 0; n < N; n++) {
                int i = 0;
                for (String s : in.readLine().split("\\s+")) {
                    M[n][i++] = Integer.valueOf(s);
                };
            }

            System.out.printf("#%d %d\n", t+1, solve(0));
        }

    }

    private static int solve(final int depth) {
        if (depth >= N) {
            return sumOfVisited();
        }

        int MAX = 0;
        for (int i = 0; i < N; i++) {
            if (isVisited(i, depth)) continue;
            VISITED[depth] = i;
            MAX = Math.max(MAX, solve(depth + 1));
        }
        return MAX;
    }

    private static boolean isVisited(final int value, final int to) {
        for (int i = 0; i < to; i++) {
            if (VISITED[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static int sumOfVisited() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int index = VISITED[i];
            sum += M[i][index];
        }
        return sum;
    }
}
