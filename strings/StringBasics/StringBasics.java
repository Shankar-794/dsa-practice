public class StringBasics {

    public static void main(String[] args) {

        String s = "hello";

        // length
        System.out.println(s.length());

        // access characters
        System.out.println(s.charAt(1)); // 'e'

        // iterate
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + " ");
        }
        System.out.println();

        // convert to char array
        char[] arr = s.toCharArray();
        System.out.println(arr[0]);

        // substring
        System.out.println(s.substring(1, 4)); // "ell"
    }
}
