public class twoSumIV {
  // approach #1: brute force using HashMap
    public boolean findTarget(TreeNode root, int k) {
        // space O(n) , time O(n)
        Set<Integer> set = new HashSet<>();
        return helper(set, root, k);
    }

    private boolean helper(Set<Integer> set, TreeNode node, int k) {
        if (node == null) return false;

        if (set.contains(k - node.val)) return true;
        set.add(node.val);
        return helper(set, node.left, k) || helper(set, node.right, k);
    }

    // approach #2: flatten BST then use two pointers

}
