/**
 * Reverse bits of a given 32 bits unsigned integer.
 * @author songzhiyong
 *
 */
public class Code_190_ReverseBits {
	public static int reverseBits(int n) {
        int res = 0;
        
        for(int i= 31; i >= 0; i --){
        	int f = (n>>>i)&1;
        	res += getNum(f, i);
        }
        
		return res;
    }
	
	public static int getNum(int f, int i){
		if (f == 0){
			return 0;
		}
		while(31 - i > 0){
			f = f * 2;
			i ++;
		}
		return f;
	}
	
	public static void main(String[] args){
		int n = 43261596;
		System.out.println(reverseBits(n));
	}
}
