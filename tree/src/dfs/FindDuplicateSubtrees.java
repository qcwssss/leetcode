package dfs;

import org.junit.Test;

import java.util.*;

public class FindDuplicateSubtrees {
  /**
   * https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution
   */

  List<TreeNode> dup = new LinkedList<>();
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Integer> subMap = new HashMap<>();
    dfs(root, subMap);
    return dup;
  }


  String dfs(TreeNode root, Map<String, Integer> subMap) {
    if (root == null) return "#";
    // postorder
    String left = dfs(root.left, subMap);
    String right = dfs(root.right, subMap);
    String subtree =  left + "," + right + "," +root.val;
    subMap.put(subtree, subMap.getOrDefault(subtree, 0) + 1);
    // in case of duplicates root, add to list only when map == 2.
    if (subMap.get(subtree) == 2) dup.add(root);
    return subtree;
  }

  @Test
  public void testDfsString() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    Set<String> subTreeSet = new HashSet<>();

    //System.out.println(dfs(root, subTreeSet));
  }
}
