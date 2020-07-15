public class PermutationDistinct {
    private static int N = 4;
    private static int[] visited = new int[N];

    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        solve(1);
        System.out.printf("elapsed : %f\n", System.currentTimeMillis() - start);
    }

    private static void solve(int d) {
        if (d > N) {
            for (int i : visited) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited(d-1, i+1)) continue;
            visited[d-1] = i+1;
            solve(d+1);
        }
    }

    private static boolean isVisited(int until, int v) {
        for (int i = 0; i < until; i++) {
            if (visited[i] == v) return true;
        }
        return false;
    }

}
