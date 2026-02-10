public class LongestSubstringAtMostKDistinct {

    static int longestSubstring(String s, int k) {

        if (k == 0)
            return 0;

        int[] freq = new int[256];
        int left = 0;
        int distinct = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (freq[c] == 0)
                distinct++;

            freq[c]++;

            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;

                if (freq[leftChar] == 0)
                    distinct--;

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("eceba", 2)); // 3
        System.out.println(longestSubstring("aa", 1));    // 2
    }
}
