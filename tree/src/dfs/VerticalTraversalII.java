public class VerticalTraversalII {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<TreeNode, Integer> position = new HashMap<>();
        Map<Integer, List<Integer>> colToNodes = new HashMap<>();
        
        // BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        position.put(root, 0);
        int min = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, List<Integer>> rowToNodes = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int col = position.get(cur);
                if (!rowToNodes.containsKey(col)) {
                    rowToNodes.put(col, new ArrayList<>());
                }

                rowToNodes.get(col).add(cur.val);

                if (cur.left != null) {
                    q.offer(cur.left);
                    position.put(cur.left, col - 1);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    position.put(cur.right , col + 1);
                }
                min = Math.min(min, col);                
            }
            for (int key : rowToNodes.keySet()) {
                List<Integer> column = rowToNodes.get(key);
                Collections.sort(column);
                if (!colToNodes.containsKey(key)) {
                    colToNodes.put(key, new ArrayList<>());
                }
                colToNodes.get(key).addAll(column);
            }
            
        }
        for (int i : colToNodes.keySet()) {
            List<Integer> column = colToNodes.get(min);
            res.add(column);
            min++;
        }
        
        return res;
    }
}
// BFS: around O(n) time