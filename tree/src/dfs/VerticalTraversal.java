public class VerticalTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // BFS
        Deque<TreeNode> q = new LinkedList<>();
        Map<Integer, List<Integer>> colToNodes = new HashMap<>();
        Map<TreeNode, Integer> position = new HashMap<>();

        q.offer(root);
        position.put(root, 0);
        int min = 0;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int col = position.get(cur);
            if (!colToNodes.containsKey(col)) {
                colToNodes.put(col, new ArrayList<>());
            }
            colToNodes.get(col).add(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
                position.put(cur.left, col - 1);
            }
            if (cur.right != null) {
                q.offer(cur.right);
                position.put(cur.right, col + 1);
            }
            min = Math.min(col, min);
        }
        for (int i : colToNodes.keySet()) {
            res.add(colToNodes.get(min));
            min++;
        }
        return res;
    }
}