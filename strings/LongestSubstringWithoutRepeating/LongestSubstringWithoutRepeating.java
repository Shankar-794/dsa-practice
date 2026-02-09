public class LongestSubstringWithoutRepeating{
    static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c]++;
            
            while (freq[c] > 1) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    }
}