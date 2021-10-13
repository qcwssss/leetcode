package dfs;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LowestCommonAncestorOfABinaryTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>(); // <children, parent>
    Deque<TreeNode> queue = new LinkedList<>();

    // BFS
    queue.push(root);
    TreeNode cur;
    while (!queue.isEmpty()) {
      int sizeQ = queue.size();
      for (int i = 0; i < sizeQ; i++) {
        cur = queue.poll();
        if (cur.left != null) {
          parentMap.put(cur.left, cur);
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          parentMap.put(cur.right, cur);
          queue.offer(cur.right);
        }
      }
    }

    // find parent
  return findParent(parentMap, p, q);

  }

  private TreeNode findParent(Map<TreeNode, TreeNode> map, TreeNode p, TreeNode q) {
    if (map.get(p) == q) return q;
    if (map.get(q) == p) return p;
    if (map.get(p) == map.get(q)) return map.get(p);

    return findParent(map, map.get(p), map.get(q));
  }
}
