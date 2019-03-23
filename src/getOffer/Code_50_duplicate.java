package getOffer;

/**
 * @program:
 * @description:
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author: Song
 * @create: Created in 2019-03-23 18:53
 * @Modified by:
 **/
public class Code_50_duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    //O(n) O(n)
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length <=1){
            return false;
        }
        int[] res = new int[length];
        for (int i = 0; i < numbers.length; i++){
            if (res[numbers[i]] != 0){
                duplication[0] = numbers[i];
                return true;
            }
            res[numbers[i]] = numbers[i];
        }
        return false;

    }

    //把当前序列当成是一个下标和下标对应值是相同的数组；
    //遍历数组，判断当前位的值和下标是否相等： 2.1. 若相等，则遍历下一位； 2.2. 若不等，
    // 则将当前位置i上的元素和a[i]位置上的元素比较：若它们相等，则成功！若不等，
    // 则将它们两交换。换完之后a[i]位置上的值和它的下标是对应的，
    // 但i位置上的元素和下标并不一定对应；重复2.2的操作，直到当前位置i的值也为i，将i向后移一位，再重复2.
    //O(n) O(1)
    public boolean duplicate2(int array[],int length,int [] duplication) {
        if ( array==null ) return false;

        // 判断数组是否合法（每个数都在0~n-1之间）
        for ( int i=0; i<length; i++ ) {
            if ( array[i]<0 || array[i]>length-1 ) {
                return false;
            }
        }

        // key step
        for( int i=0; i<length; i++ ){
            while( i!=array[i] ){
                if ( array[i] == array[array[i]] ) {
                    duplication[0] = array[i];
                    return true;
                }

                int temp = array[i];
                array[i] = array[array[i]];
                array[array[i]] = temp;
            }
        }

        return false;
    }
}
