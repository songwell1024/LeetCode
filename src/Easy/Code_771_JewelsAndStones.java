package Easy;

/**
 * 你会得到J代表珠宝类型的字符串，S代表你拥有的宝石。
 * 每个角色S都是你拥有的一种石头。你想知道你有多少宝石也是珠宝。
 * @author WilsonSong
 * @date 2019/1/8/008
 */
public class Code_771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        char[] cJ = J.toCharArray();
        char[] cS = S.toCharArray();
        int res = 0;
        for(char c : cJ){
            for (char cc : cS){
                if (cc == c){
                    res ++;
                }
            }
        }
        return res;
    }


}
