package M03;

//2166. 设计位集
public class Bitset2166 {
    int size,base,cnt,n;
    int[] data;
    
    public Bitset2166(int size) {
        this.size = size;
        base = 30;
        cnt = 0;
        n = size/base + (size%base==0?0:1);
        data = new int[n    ];
    }
    
    public void fix(int idx) {
        int x = idx/base,y = idx % base;
        if ((data[x] & (1 << y)) == 0) {
            cnt++;
            data[x] |= (1<<y);
        }
    }
    
    public void unfix(int idx) {
        int x = size/base, y = size%base;
        if ((data[x] & (1 << y)) != 0) {
            cnt--;
            data[x] ^= 1<<y;
        }
    }
    
    public void flip(   ) {
        for (int i = 0; i < n; i++) {
            data[i] = ~data[i];
        }
        cnt = size - cnt;
    }

    public boolean all() {
        return cnt == size;
    }
    
    public boolean one() {
        return cnt>0;
    }
    
    
    public int count() {
        return cnt;
    }
    
    public String toString() {
        StringBuffer s = new StringBuffer();
        int x = size/base, y = size%base;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < base; j++) {
                if ((1 << j & data[i]) != 0) {
                    s.append(1);
                } else {
                    s.append(0);
                }
            }
        }
        for (int i = 0; i < y; i++) {
            if ((1 << i & data[n - 1]) != 0) {
                s.append(1);
            } else {
                s.append(0);
            }
        }
        return s.toString();
    }
}
