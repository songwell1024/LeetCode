package Easy;

import java.util.HashMap;

/**
 * @author WilsonSong
 * @date 2019/1/6/006
 */
public class Code_169_MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int num : nums){
            if (hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num) + 1);
            }else {
                hashMap.put(num,1);
            }
        }

        for (int num : nums){
            if (hashMap.get(num) > (nums.length /2)){
                return num;
            }
        }
        return 0;
    }
}
