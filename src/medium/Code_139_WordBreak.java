package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: Code_139_WordBreak
 * @Description:
 * 给定非空字符串s和包含非空字列表的字典wordDict，确定s是否可以被分段为一个或多个字典单词的空格分隔序列。
 *
 *
 * 注意：
 *
 * 字典中的相同单词可以在分段中多次重复使用。
 * 您可能认为字典不包含重复的单词。
 * 例1：
 *
 * 输入： s =“leetcode”，wordDict = [“leet”，“code”]
 *  输出： true
 *  说明：返回true，因为"leetcode"可以分段为"leet code"。
 * @Author: WilsonSong
 * @Date: 2019/4/25 14:59
 * @Version 1.0
 **/
public class Code_139_WordBreak {

    //有问题啊
    public static boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.equals("")){
            return false;
        }
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        ArrayList<String> help = new ArrayList<>(wordDict);
        for (String s1 : wordDict){
            if (s.contains(s1)){
                s = s.replaceAll(s1,"");
                help.remove(s1);
            }

        }
        if (s.equals("")){
            return true;
        }else {
            for (String s1 : help){
                if (s1.contains(s)){
                    s1 = s1.replaceAll(s, "");
                    if (s1.equals("")){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    /**
     * @Author: WilsonSong
     * @Description:
     * 该算法的基本策略是检查整个子字符串：if the left substring is in dict && if the right substring is in dict。
     * 因此，考虑到右子串是第一个i字母的情况s(i.e. the same as the whole substring)，如果右子串在dict，
     * 则整个子串应该在dict，对吗？所以我们知道f[i] = true。
     * 但是左子串是空的，从上面的&&操作中，我们知道左边的检查应该是= true，所以f[0] = true;
     * @Date: 16:04 2019/4/25
     * @Param: [s, dict]
     * @return boolean
     **/

    public static boolean wordBreak(String s, List<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        //思路就是list中的string 能否组成s,可以允许存在重复
        //DP 就是若是 leetcode能被切成 成功就成功，因为相当于"" + leetcode, list中一定是包含"" 的；
        //  能被切成"l"(list中包含l)，那么"eetcode"能切分成功就成功
        //依次递归
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
//        list.add("leet");
        wordBreak("aaaaaaa",list);
    }
}
