package M09;

import java.util.*;

import M09.Utils.TreeNode;

//987. 二叉树的垂序遍历
public class VerticalTraversal {
    TreeMap<Integer, List<int[]>> map;

    void getResult(TreeNode root, int i, int j) {
        if (root == null) return;
        if (!map.containsKey(j)) map.put(j,new ArrayList<int[]>());
        map.get(j).add(new int[]{i,root.val});
        getResult(root.left,i+1,j-1);
        getResult(root.right,i+1,j+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        map = new TreeMap<>();
        getResult(root,0,0);
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> arr = entry.getValue();
            Collections.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
                }
            });
            List<Integer> temp = new ArrayList<>();
            for (int[] ints : arr) {
                temp.add(ints[1]);
            }
            res.add(temp);
        }
        return res;
    }
}
