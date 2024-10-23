import java.util.List;

public class Result {
    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        if(n==0 || queries==null || queries.isEmpty()){
            return -1;
        }
        long[] computation = new long[n];

        for (List<Integer> query : queries) {
            int a = query.get(0) - 1;
            int b = query.get(1) - 1;
            int k = query.get(2);

            computation[a] += k;
            if (b + 1 < n) {
                computation[b + 1] -= k;
            }
        }

        long max = 0; long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += computation[i];
            max = Math.max(max, sum);
        }

        return max;

    }
}
