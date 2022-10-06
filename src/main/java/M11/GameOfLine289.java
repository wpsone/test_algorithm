package M11;

//289. ⽣命游戏
public class GameOfLine289 {
//    public void gameOfLife(int[][] board) {
//        int m = board.length, n = board[0].length;
//        int[][] dir = {
//                {1,0},{0,1},
//                {-1,0},{0,-1},
//                {1,1},{-1,-1},
//                {1,-1},{-1,1}
//        };
//        int[][] cnt = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < 8; k++) {
//                    int x = i + dir[k][0];
//                    int y = j + dir[k][1];
//
//                    if (x<0 || x>=m|| y<0||y>=n) continue;
//                    cnt[i][j] += board[x][y] == 1 ? 1 : 0;
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j]==1) {
//                    if (cnt[i][j]!=2 && cnt[i][j]!=3) board[i][j]=0;
//                } else {
//                    if (cnt[i][j]==3) board[i][j]=1;
//                }
//            }
//        }
//    }

    public void gameOfLife(int[][] board) {
        int m = board.length,n = board[0].length;
        int[][] dir = {
                {1,0},{0,1},
                {-1,0},{0,-1},
                {1,1},{-1,-1},
                {1,-1},{-1,1},
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    if (x<0||x>=m||y<0||y>=n) continue;
                    cnt += (board[x][y]%2==1?1:0);
                }
                if (board[i][j] == 1) {
                    if (cnt == 2 || cnt == 3) board[i][j]=3;
                } else {
                    if (cnt==3) board[i][j]=2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]>>=1;
            }
        }
    }
}
