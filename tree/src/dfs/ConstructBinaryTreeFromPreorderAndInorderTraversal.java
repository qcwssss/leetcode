package dfs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {


  int[] preorder;
  int[] inorder;
  Map<Integer, Integer> inorderMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;
    int N = preorder.length;
    return helper(0, 0, N - 1);

  }

  //recursive, time O(n)
  private TreeNode helper(int preStart, int inStart, int inEnd) {
    if (inStart > inEnd) return null;
    TreeNode root = new TreeNode(preorder[preStart]);
    int rootIdx = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (preorder[preStart] == inorder[i]) {
        rootIdx = i;
      }
    }
    int leftTreeSize = rootIdx - inStart;
    root.left = helper(preStart + 1, inStart, rootIdx - 1);
    root.right = helper(preStart + 1 + leftTreeSize, rootIdx + 1, inEnd);

    return root;

  }

  // time O(1)
  public TreeNode buildTree2(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;
    int N = inorder.length;
    inorderMap = new HashMap<>(); // <val, indx>
    for (int i = 0; i < N; i++) {
      inorderMap.put(inorder[i], i);
    }
    return build(0, 0, N -1);

  }

  private TreeNode build(int preStart, int inStart, int inEnd) {
    if (inStart > inEnd) return null;
    TreeNode root = new TreeNode(preorder[preStart]);
    int rootIdx = inorderMap.get(preorder[preStart]);

    int leftSize = rootIdx - inStart;
    root.left = build(preStart + 1, inStart, rootIdx - 1);
    root.right = build(preStart + 1 + leftSize, rootIdx + 1, inEnd);
    return root;

  }
}
