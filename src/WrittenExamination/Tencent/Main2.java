package WrittenExamination.Tencent;
import java.util.*;
/**
 * @ClassName: WrittenExamination.dajiang.Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/4/13 20:24
 * @Version 1.0
 **/
public class Main2 {


    public static int number = 0;

    public static class TreeNode
    {
        int val;
        HashSet<TreeNode> next;

        public TreeNode(int val)
        {
            this.val = val;
            next = new HashSet<>();
        }
    }

    public static int getNodeNum(TreeNode node)
    {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty())
        {
            res ++;
            TreeNode p = queue.poll();
            for (TreeNode q : p.next)
                queue.offer(q);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeNode[] nodes = new TreeNode[n+1];
        nodes[1] = new TreeNode(1);
        for (int i=1; i<=n-1; i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (nodes[x] == null)
                nodes[x] = new TreeNode(x);
            if (nodes[y] == null)
                nodes[y] = new TreeNode(y);
            if (x == y)
                continue;
            else if (x < y)
                nodes[x].next.add(nodes[y]);
            else
                nodes[y].next.add(nodes[x]);
        }

        int allTime = 0;

        for (TreeNode p : nodes[1].next)
        {
            if (allTime == 0)
                allTime = getNodeNum(p);
            else
                allTime = Math.max(allTime, getNodeNum(p));
        }

        System.out.println(allTime);
    }
}
