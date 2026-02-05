public class TwoSumSorted{
    static boolean twoSum(int[] arr, int target){
        int left = 0, right = arr.length-1;
        int sum;
        while(left<right){
            sum = arr[left] + arr[right];
            if(sum==target){
                return true;
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,6,10};
        System.out.println(twoSum(arr, 8));
    }
}