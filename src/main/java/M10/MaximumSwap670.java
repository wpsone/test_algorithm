package M10;

//670. 最⼤交换
public class MaximumSwap670 {
    public int maximumSwap(int num) {
        char[] digit = String.valueOf(num).toCharArray();
        int max_ind = -1;
        for (int i = 0; i < digit.length - 1; i++) {
            if (digit[i+1]<=digit[i]) continue;
            max_ind = i+ 1;
            break;
        }
        if (max_ind == -1) return num;
        for (int i = max_ind; i < digit.length - 1; i++) {
            if (digit[max_ind]>digit[i+1]) continue;
            max_ind = i + 1;
        }
        for (int i = 0; i < digit.length; i++) {
            if (digit[i]>=digit[max_ind]) continue;
            digit[i] ^= digit[max_ind];
            digit[max_ind]^=digit[i];
            digit[i]^=digit[max_ind];
            break;
        }
        return Integer.parseInt(new String(digit));
    }
}
