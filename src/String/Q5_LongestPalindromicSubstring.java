package String;

public class Q5_LongestPalindromicSubstring {

    /**
     * 判断是否是回文字符串
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public String longestPalindrome(String s) {
        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String str = s.substring(i, j + 1);

                if (j - i + 1 > maxLen && isPalindrome(str)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 在字符串s中寻找以s[l]和s[r]为中心的最长回文串
     */
    public String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    /**
     * 使用从中心向两端扩散的双指针得到最长回文子串
     */
    public String longestPalindrome2(String s) {
        String res = "";

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 寻找以s[l]为中心的回文子串
            String s1 = palindrome(s, i, i);
            // 寻找以s[r]为中心的回文子串
            String s2 = palindrome(s, i, i + 1);

            // 得到更长的回文子串
            if (s1.length() > res.length()) {
                res = s1;
            }

            if (s2.length() > res.length()) {
                res = s2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Q5_LongestPalindromicSubstring solution = new Q5_LongestPalindromicSubstring();
        String res = solution.longestPalindrome2("bc");
        System.out.println(res);
    }

}
