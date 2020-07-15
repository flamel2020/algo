public class Permutation {
    private static int N = 7;
    private static int[] visited = new int[N];

    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        solve(N);
        System.out.printf("elapsed : %f\n", System.currentTimeMillis() - start);
    }

    private static void solve(int d) {
        if (d <= 0) {
            for (int i : visited) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            visited[N-d] = i+1;
            solve(d-1);
        }
    }

}
