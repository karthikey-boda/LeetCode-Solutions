/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeMap<Integer, List<int[]>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        vertical(root, 0, 0);

        for (List<int[]> l : map.values()) {

            l.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            
            List<Integer> temp = new ArrayList<>();

            for (int[] x : l) {
                temp.add(x[0]);
            }

            list.add(temp);
        }

        return list;
    }

    public void vertical(TreeNode root, int column, int row) {

        if (root == null) {
            return;
        }

        if (map.containsKey(column)) {
            map.get(column).add(new int[] { root.val, row });
        } else {
            List<int[]> l = new ArrayList<>();
            l.add(new int[] { root.val, row });
            map.put(column, l);
        }

        vertical(root.left, column - 1, row + 1);
        vertical(root.right, column + 1, row + 1);
    }
}