package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Code_207_CourseSchedule
 * @Description:
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 *
 *  这道题是拓扑排序的典型应用。先引入一个有向无环图的概念——>
 * 如果一个有向图的任意顶点都无法通过一些有向边回到自身，那么称这个有向图为有向无环图(DAG)。
 * 再引入一个概念拓扑排序——>
 * 拓扑排序是将有向无环图G的所有顶点排成一个线性序列，使得对图G中的任意两个顶点u、v，如果存在边u->v，那么在序列中u一定在v前面。这个序列又被称为拓扑序列。
 * 其实这道题的本质即给定一个图，让我们判断该图是否是拓扑有序。
 * 这里我们需要用到一个图里入度的概念，在初始的图中，入度为0的点，即是课程中最基础的课程（需要先修，比如数据结构、C语言基础），在找到图中所有入度为0的点以后，
 * 将它们依次放入一个队列中，每次循环从队列头提取一个点，然后将这个点放入图中查询，查出
 * 哪些点被这个点所指向，并依次将这些点的入度减1，直观上的看的话，即是一个删除一个入度为0的
 * 点的操作，每次减1时，检测其他节点的入度，若出现新的入度为0的点，将其加入队列，循环往复，
 * 直到队列为空为止。
 *
 * 循环结束后，再次检查每个节点的入度，若该图是拓扑有序的，则在循环操作中，所有的入度都会变为0。若不是拓扑有序的，则还会有入度不为0的点，即存在环。
 *
 * 其实这里即用到了BFS的思想，每次访问目标节点所指向的点！
 * @Author: WilsonSong
 * @Date: 2019/4/16 20:24
 * @Version 1.0
 **/
public class Code_207_CourseSchedule {
    //BFS
    public class Solution1 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList[] graph = new ArrayList[numCourses];
            int[] degree = new int[numCourses];
            Queue queue = new LinkedList();
            int count=0;

            for(int i=0;i<numCourses;i++)
                graph[i] = new ArrayList();

            for(int i=0; i<prerequisites.length;i++){
                degree[prerequisites[i][1]]++;
                graph[prerequisites[i][0]].add(prerequisites[i][1]);
            }
            for(int i=0; i<degree.length;i++){
                if(degree[i] == 0){
                    queue.add(i);
                    count++;
                }
            }

            while(queue.size() != 0){
                int course = (int)queue.poll();
                for(int i=0; i<graph[course].size();i++){
                    int pointer = (int)graph[course].get(i);
                    degree[pointer]--;
                    if(degree[pointer] == 0){
                        queue.add(pointer);
                        count++;
                    }
                }
            }
            if(count == numCourses)
                return true;
            else
                return false;
        }
    }

    //DFS
    public class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList[] graph = new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++)
                graph[i] = new ArrayList();

            boolean[] visited = new boolean[numCourses];
            for(int i=0; i<prerequisites.length;i++){
                graph[prerequisites[i][1]].add(prerequisites[i][0]);           //修某一门课所依赖的课程
            }

            for(int i=0; i<numCourses; i++){
                if(!dfs(graph,visited,i))           //这门课程如果有依赖的课程也依赖他，那么就明显是错误的，所有课程不能修完
                    return false;
            }
            return true;
        }

        private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
            if(visited[course])
                return false;
            else
                visited[course] = true;

            for(int i=0; i<graph[course].size();i++){
                if(!dfs(graph,visited,(int)graph[course].get(i)))
                    return false;
            }
            visited[course] = false;
            return true;
        }
    }
}
