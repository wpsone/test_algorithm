package HuaWei;

import java.util.*;

/**
 * 假设有搅乱顺序的一群儿童成一个队列。每个儿童由一个整数对(w,k)表示，其中w是这个儿童，k是排在这个儿童前面且体重大于或等于w的儿童数量。
 * 编写一个算法来重建这个队列。
 * 
 * 1.总儿童数量少于1100人
 * 2.输入的数据是合理的，只是顺序给打乱了
 */
public class Question001 {
    public static int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        });
        
        int tag = 0;
        List<Node> list = new ArrayList<>();
        int[][] arr = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            if (people[i][1]==0) {
                Node node = new Node();
                node.w = people[i][0];
                node.k = 0;
                list.add(0,node);
                tag++;
                continue;
            }
            if (tag > 0) {
                arr[i-tag][0]=people[i][0];
                arr[i-tag][1]=people[i][1];
                continue;
            } else if (tag==0){
                arr[i][0]=people[i][0];
                arr[i][1]=people[i][1];
                continue;
            }
        }

        for (int i = 0; i < arr.length-tag; i++) {
            Node node = new Node();
            node.w = arr[i][0];
            node.k = arr[i][1];
            int num = 0;
            int j = 0;
            for (; j < list.size() && num< node.k; j++) {
                if (node.w <= list.get(j).w && num < node.k) {
                    num++;
                }
                if (num == node.k) {
                    break;
                }
            }
            if (j == list.size()) {
                list.add(node);
            }else {
                list.add(j+1,node);
            }          
        }
        
        int[][] result = new int[people.length][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0]=list.get(i).w;
            result[i][1]=list.get(i).k;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] people = {{8,0},{8,1},{5,0},{6,1},{5,2},{4,4}};
        int[][] ints = reconstructQueue(people);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i][0]+":"+ints[i][1]);
        }
    }
}

class Node {
    int w;
    int k;

    public Node() {
    }

    public Node(int w, int k) {
        this.w = w;
        this.k = k;
    }
}
