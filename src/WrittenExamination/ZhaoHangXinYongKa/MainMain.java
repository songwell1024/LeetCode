package WrittenExamination.ZhaoHangXinYongKa;

/**
 * @ClassName: MainMain
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/15 22:07
 * @Version 1.0
 **/
import WrittenExamination.Huatai.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MainMain {
    public static void KRUSKAL(int [] V,Edge [] E){
        HashMap<Integer, Integer> map = new HashMap<>();
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

    public static void main(String [] args){

        int [] V={1,2,3,4,5,6};
        Edge [] E=new Edge[10];
        E[0]=new Edge(1,2,6);
        E[1]=new Edge(1,3,1);
        E[2]=new Edge(1,4,5);
        E[3]=new Edge(2,3,5);
        E[4]=new Edge(2,5,3);
        E[5]=new Edge(3,4,5);
        E[6]=new Edge(3,5,6);
        E[7]=new Edge(3,6,4);
        E[8]=new Edge(4,6,2);
        E[9]=new Edge(5,6,6);
        KRUSKAL(V, E);
    }

}
//class Edge implements Comparable<Object> {
//    public int i, j, w;
//
//    public Edge(int i, int j, int w) {
//        this.i = i;
//        this.j = j;
//        this.w = w;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        Edge to = (Edge) o;
//        if (this.w > to.w)
//            return 1;
//        else if (this.w == to.w)
//            return 0;
//        else
//            return -1;
//
//    }
//
//    @Override
//    public String toString() {
//        return "start=" + i + "||end=" + j + "||w=" + w;
//    }
//}
