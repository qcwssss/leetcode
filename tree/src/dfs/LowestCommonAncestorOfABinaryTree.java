package dfs;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

  // divide and conquer
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    // recursive
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) return root;
    if (left != null) return left;
    if (right != null) return right;
    return null;

  }

  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>(); // <children, parent>
    dfs(parentMap, root, null); // build parent map

    Set<TreeNode> parentSet = new HashSet<>();
    while (p != null) {
      // (we allow a node to be a descendant of itself)
      parentSet.add(p);
      p = parentMap.get(p);
    }

    while (!parentSet.contains(q)) {
      q = parentMap.get(q);
    }
    return q;
  }

  private void dfs(Map<TreeNode, TreeNode> parent, TreeNode cur, TreeNode parentNode) {
    if (cur == null) return;

    parent.put(cur, parentNode);
    dfs(parent, cur.left, cur);
    dfs(parent, cur.right, cur);

  }


  // my first attempt
  public TreeNode lowestCommonAncestor_Naive(TreeNode root, TreeNode p, TreeNode q) {
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

