package Easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 查找是否包含重复值
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums){
            if (hashSet.contains(num)){
                return true;
            }else {
                hashSet.add(num);
            }
        }
        return false;
    }
}
