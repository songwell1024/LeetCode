import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/27 19:49
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.valueOf(s.split(" ")[0]);
        int Total = Integer.valueOf(s.split(" ")[1]);
        int Cost = Integer.valueOf(s.split(" ")[2]);
        String A = sc.nextLine();
        String[] charsA = A.split(" ");

        StringBuilder strA = new StringBuilder();
        for (String s1: charsA){
            strA.append(s1);
        }
        String B = sc.nextLine();
        String[] charsB = B.split(" ");
        StringBuilder strB = new StringBuilder();
        for (String s1: charsB){
            strB.append(s1);
        }
        String result = maxSubseq(strA.toString(),strB.toString());
        int res = 0;
        int help = 1;
        for (int i = 0; i< result.length(); i++){
            if (help * Cost <= Total){
                res ++;
                help++;
            }else {
                break;
            }
        }
        System.out.println(res);


    }

    // 求解两个字符号的最长公共子串
    public static String maxSubseq(String strOne, String strTwo){
        // 参数检查
        if(strOne==null || strTwo == null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }
        // 矩阵的横向长度
        int len1 = strOne.length();
        // 矩阵的纵向长度
        int len2 = strTwo.length();
        // 二维数组用来保存中间结果
        int[][] datas = new int[len1+1][len2+1];
        // 使用另外一个二维数组作为标记数组，用来保存从前一步到这一步的路径
        String[][] index = new String[len1+1][len2+1];
        // 填充二维数组
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                int leftTop = datas[i-1][j-1];
                int top = datas[i-1][j];
                int left = datas[i][j-1];
                if(strOne.charAt(i-1) == strTwo.charAt(j-1)){
                    leftTop ++;
                }
                int maxTemp = Math.max(leftTop, top);
                datas[i][j] = Math.max(maxTemp, left);
                // 填写标记数组
                if(datas[i][j] == leftTop){
                    index[i][j] = "leftTop";
                } else if(datas[i][j]==left){
                    index[i][j] = "left";
                } else{
                    index[i][j] = "top";
                }
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        // 从二维矩阵的最后一个元素向前查找结果，当（左上， 左， 上）数字相同时，查找顺序：左上-> 左 -> 上
        int maxLen = datas[len1][len2];
//            System.out.println("LCS长度为:" + maxLen);
        int i= len1;
        int j = len2;
        String indexStr = "";
        char currentCh = ' ';
        int currentLen = 0;
        while(i>0 && j>0){
            currentLen = datas[i][j];
            currentCh = strOne.charAt(i-1);
            indexStr = index[i][j];
            if(indexStr.equals("leftTop")){
                i--;
                j--;
            } else if(indexStr.equals("left")){
                j--;
            } else{
                i--;
            }
            if(currentLen > datas[i][j]){
                sBuilder.insert(0, currentCh);
            }
        }
        return sBuilder.toString();
    }
}
