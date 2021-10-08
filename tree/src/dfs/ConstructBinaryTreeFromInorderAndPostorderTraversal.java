package dfs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> inorderMap = new HashMap<>(); // <val, index>

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      this.inorder = inorder;
      this.postorder = postorder;
      int N = inorder.length;
      for (int i = 0; i < N; i++) {
        inorderMap.put(inorder[i], i);
      }

      return build(N - 1, 0, N - 1);

    }

    private TreeNode build(int postEnd, int inStart, int inEnd) {
      if (inStart > inEnd) return null;
      int val = postorder[postEnd];
      TreeNode root = new TreeNode(val);
      int rootIdx = inorderMap.get(val);
      int rightSize = inEnd - rootIdx;
      root.right = build(postEnd - 1, rootIdx + 1, inEnd);
      root.left = build(postEnd - 1 - rightSize, inStart, rootIdx - 1);
      return root;

    }
}
