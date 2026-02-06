public class MaxSumSubarrayK {
    static int maxSum(int[] arr, int k){
        int windowSum = 0;
        int maxSum = 0;
        for(int i=0;i<k;i++){
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for(int i=k;i<arr.length;i++){
            windowSum += arr[i];
            windowSum -= arr[i-k];
            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] arr = {2,1,5,1,3,2};
        System.out.print("Max sum of sub array K: "+maxSum(arr, 3));
    }
}
