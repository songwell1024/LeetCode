package medium;

/**
 * @program:
 * @description:
 * 给定n个非负整数a 1，a 2，...，a n ，其中每个表示坐标（i，a i）处的点。
 * 绘制n条垂直线，使得线i的两个端点位于（i，a i）和（i，0）。找到两条线，
 * 它们与x轴一起形成一个容器，这样容器就含有最多的水。
 * @author: Song
 * @create: Created in 2019-03-05 16:28
 * @Modified by:
 **/
public class Code_11_ContainerWithMostWater {
    /**
     * 暴力解决
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = height.length;
        int res = 0;
        for (int i = 0; i < l; i ++){
            for (int j = i; j <l; j ++){
                res = Math.max(res, (j - i) * (Math.min(height[i], height[j])));
            }
        }
        return res;

    }

    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
