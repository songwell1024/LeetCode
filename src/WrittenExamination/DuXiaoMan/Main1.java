package WrittenExamination.DuXiaoMan;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/15 20:26
 * @Version 1.0
 **/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int n = scanner.nextInt();
        x += 500;
        y += 500;
        int[][] dis = new int[1001][1001];
        int stop_x = -1, stop_y = -1;
        for (int i=0; i<n; i++){
            stop_x= scanner.nextInt();
            stop_y = scanner.nextInt();
            dis[stop_x+500][stop_y+500] = -1;
        }

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(500);
        qy.offer(500);
        dis[500][500] = 1;
        while (!qx.isEmpty()){
            int nx = qx.poll();
            int ny = qy.poll();
            if (ny+1<=1000 && dis[nx][ny + 1] == 0){
                // up
                dis[nx][ny + 1] = dis[nx][ny] + 1;
                qx.offer(nx);
                qy.offer(ny + 1);
            }
            if (nx+1<=1000 && dis[nx + 1][ny] == 0){
                // right
                dis[nx + 1][ny] = dis[nx][ny] + 1;
                qx.offer(nx + 1);
                qy.offer(ny);
            }
            if (ny-1>=0 && dis[nx][ny - 1] == 0) {
                // down
                dis[nx][ny - 1] = dis[nx][ny] + 1;
                qx.offer(nx);
                qy.offer(ny - 1);
            }
            if (nx-1>=0 && dis[nx - 1][ny] == 0) {
                dis[nx - 1][ny] = dis[nx][ny] + 1;
                qx.offer(nx - 1);
                qy.offer(ny);
            }
            if (dis[x][y] != 0)
                break;
        }

        System.out.println(dis[x][y]-1);
    }
}
