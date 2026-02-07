public class PrefixSumBasics {

    static int[] buildPrefixSum(int[] arr) {

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }

    static int rangeSum(int[] prefix, int l, int r) {

        if (l == 0)
            return prefix[r];

        return prefix[r] - prefix[l - 1];
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 3, 5};
        int[] prefix = buildPrefixSum(arr);

        System.out.println(rangeSum(prefix, 1, 3)); // 4 + 1 + 3 = 8
        System.out.println(rangeSum(prefix, 0, 4)); // 15
    }
}
