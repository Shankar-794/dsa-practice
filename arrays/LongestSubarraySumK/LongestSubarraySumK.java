public class LongestSubarraySumK {

    static int longestSubarray(int[] arr, int k) {

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(longestSubarray(arr, 7)); // 3
    }
}
