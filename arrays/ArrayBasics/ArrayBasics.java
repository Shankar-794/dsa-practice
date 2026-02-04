public class ArrayBasics{
    public static void main(String[] args){
        int[] arr = {5,2,9,1,7};

        //Traverse
        System.out.print("Array Elements: ");
        for(int x: arr){
            System.out.print(x+" ");
        }
        System.out.println();

        //Find Maximum
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Max Element: "+max);

        //Find Sum
        int sum = 0;
        for(int x: arr){
            sum += x;
        }
        System.out.println("Sum: "+sum);
    }
}