package Easy;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * @author WilsonSong
 * @date 2019/1/8/008
 */
public class Code_461_HammingDistance {
    public int hammingDistance(int x, int y) {

        int res = 0;
        for (int i = 0; i <= 31; i++){
            int fx = (x >>> i) & 1;
            int fy = (y>>> i) & 1;
            res += fx ^ fy;
        }
        return res;

    }
}
