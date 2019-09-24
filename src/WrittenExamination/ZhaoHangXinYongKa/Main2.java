package WrittenExamination.ZhaoHangXinYongKa;

import javax.tools.Diagnostic;
import java.net.Inet4Address;
import java.util.*;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/15 21:22
 * @Version 1.0
 **/
public class Main2 {
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] V= new int[n];
        for (int i = 0; i< n; i++){
            V[i] = i+1;
        }
        Edge [] E=new Edge[n];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i< n-1; i++){
            List<Integer> list = new ArrayList<>();

            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            hashSet.add(u);
            hashSet.add(v);
            E[i]=new Edge(u,v,-c);
        }
        KRUSKAL(V, E);
        for (int i = 0; i< n; i++){
            if (map.containsKey(i+1)){
                System.out.println(map.get(i+1));
            }else {
                System.out.println(0);
            }

        }
    }
    public static void KRUSKAL(int [] V,Edge [] E){

        Arrays.sort(E);//将边按照权重w升序排序
        ArrayList<HashSet<Integer>> sets=new ArrayList<HashSet<Integer>>();
        for(int i=0;i<V.length;i++){
            HashSet<Integer> set=new HashSet<Integer>();
            set.add(V[i]);
            sets.add(set);
        }
        for(int i=0;i<E.length;i++){
            int start=E[i].i,end=E[i].j;
            int counti=-1,countj=-2;
            for(int j=0;j<sets.size();j++){
                HashSet<Integer> set=sets.get(j);
                if(set.contains(start)){
                    counti=j;
                }
                if(set.contains(end)){
                    countj=j;
                }
            }
            if(counti<0||countj<0) System.err.println("没有在子树中找到节点，错误");
            if(counti!=countj){
                if (map.containsKey(start)){
                    map.put(start, Math.min(map.get(start), E[i].w));
                }else {
                    map.put(start,E[i].w);
                }
                HashSet<Integer> setj=sets.get(countj);
                sets.remove(countj);
                HashSet<Integer> seti=sets.get(counti);
                sets.remove(counti);
                seti.addAll(setj);
                sets.add(seti);
            }
        }
    }
}
class Edge implements Comparable<Object> {
    public int i, j, w;

    public Edge(int i, int j, int w) {
        this.i = i;
        this.j = j;
        this.w = w;
    }

    @Override
    public int compareTo(Object o) {
        Edge to = (Edge) o;
        if (this.w > to.w)
            return 1;
        else if (this.w == to.w)
            return 0;
        else
            return -1;

    }

    @Override
    public String toString() {
        return "start=" + i + "||end=" + j + "||w=" + w;
    }
}

