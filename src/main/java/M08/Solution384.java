package M08;

import java.util.Random;

public class Solution384 {
    int[] orderly;
    int[] chaos;

    public Solution384(int[] nums) {
        orderly=nums;
        chaos=nums.clone();
    }

    public int[] reset() {
        chaos=orderly.clone();
        return orderly;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < chaos.length; i++) {
            int j = random.nextInt(chaos.length-i   )+i;
            int t = chaos[i];
            chaos[i]=chaos[j];
            chaos[j]=t;
        }
        return chaos;
    }
}
