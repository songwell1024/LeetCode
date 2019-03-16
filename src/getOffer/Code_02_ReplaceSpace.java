package getOffer;

/**
 * @program:
 * @description: 替换空格
 * @author: Song
 * @create: Created in 2019-03-11 14:52
 * @Modified by:
 **/
public class Code_02_ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer resStr = new StringBuffer();
        for (int i = 0; i< str.length(); i ++){
            if (str.charAt(i) == ' '){
                resStr.append("%20");
            }else {
                resStr.append(str.charAt(i));
            }
        }
        return resStr.toString();
    }
}
