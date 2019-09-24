package WrittenExamination.Qianxin;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/9 19:49
 * @Version 1.0
 **/
public class Main1 {
    

        private static int res = 0;
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] strPid = scanner.nextLine().split(" ");
            String[] strPpid = scanner.nextLine().split(" ");
            int[] pids = new int[strPid.length];
            for (int i=0; i<=pids.length-1; i++){
                pids[i] = Integer.parseInt(strPid[i]);
            }
            int[] ppids = new int[strPpid.length];
            for (int i=0; i<=ppids.length-1; i++){
                ppids[i] = Integer.parseInt(strPpid[i]);
            }
            int id2Kill = Integer.parseInt(scanner.nextLine());
            kill(pids, ppids, id2Kill);
            System.out.println(res);
        }

        private static void kill(int[] pids, int[] ppids, int id2Kill){
            for (int i=0; i<pids.length; i++){
                if (pids[i] == id2Kill){
                    res++;
                    break;
                }
            }
            for (int i=0; i<=ppids.length-1; i++){
                if (ppids[i] == id2Kill){
                    kill(pids, ppids, pids[i]);
                }
            }
        }
}
