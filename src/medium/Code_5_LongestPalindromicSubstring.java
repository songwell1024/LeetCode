package medium;

/**
 * @ClassName: Code_5_LongestPalindromicSubstring
 * @Description:
 * 最长的回文子串
 * @Author: WilsonSong
 * @Date: 2019/6/9 19:56
 * @Version 1.0
 **/
public class Code_5_LongestPalindromicSubstring {

    //暴力解决
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        int left = 0;
        int[] se = new int[2];
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j < s.length(); j++){
                if (isPalindromic(s, i,j)){
                    if ((j -i) > (se[1]-se[0])){
                        se[0] = i;
                        se[1] = j;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = se[0]; i <= se[1];i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();

    }
    private boolean isPalindromic(String s, int l, int r){
        while (l < r){
            if (s.charAt(l)!= s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    //dp解决
    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = "";

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res.equals("") || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }



}
