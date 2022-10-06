package M11;

//1094. 拼⻋
public class CarPooling1094 {
    public boolean carPooling(int[][] trips ,int capacity) {
        int[] dist = new int[1001];

        for (int[] x : trips) {
            int l = x[1];
            int r = x[2];
            int n = x[0];

            dist[l] += n;
            dist[r] -= n;
        }
        for (int i = 0; i < 1001; i++) {
            capacity -= dist[i];
            if (capacity<0) return false;
        }
        return true;
    }
}
