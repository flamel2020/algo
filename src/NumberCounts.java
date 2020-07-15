import java.util.Arrays;
import java.util.Random;

public class NumberCounts {
    private static int MAX_N = 40; //100_000;
    private static int MAX_VALUE = 10; //100_000_000;
    private static int[] inputs = new int[MAX_N];
    private static int[] outputs = new int[MAX_VALUE+1];

    private static void makeArr() {
        for (int i = 0; i < MAX_N; i++) {
            Random random = new Random();
            inputs[i] = random.nextInt(MAX_VALUE);
        }
    }
    private static void printArr(int[] inputs) {
        Arrays.stream(inputs).forEach(i -> System.out.print(i+", "));
        System.out.println();
    }

    private static void printArr(int[] inputs, int limit) {
        Arrays.stream(Arrays.copyOfRange(inputs, 0, limit)).forEach(i -> System.out.print(i + ", "));
        System.out.println();
    }

    public static void main(String[] args) {
        makeArr();
        double start = System.currentTimeMillis();
        solve();
        System.out.printf("elapsed : %f\n", System.currentTimeMillis() - start);
    }

    private static void solve() {
        Arrays.sort(inputs);
        printArr(inputs);

        for (int v : inputs) {
            outputs[v] = outputs[v] + 1;
        }

        for (int i = 0, length = outputs.length; i < length; i++) {
            if (outputs[i] != 0) System.out.printf("%s:%s, ", i, outputs[i]);
        }
        System.out.println();
    }
}
