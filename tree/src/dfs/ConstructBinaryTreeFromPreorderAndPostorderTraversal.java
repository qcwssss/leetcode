package dfs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
  int[] preorder;
  int[] postorder;
  Map<Integer, Integer> preorderMap = new HashMap<>(); // <val, index>

  public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    this.preorder = preorder;
    this.postorder = postorder;
    int N = preorder.length;
    for (int i = 0; i < N; i++) {
      preorderMap.put(preorder[i], i);
    }
    return helper(N - 1, 0, N - 1);
  }

  private TreeNode helper(int postEnd, int preStart, int preEnd) {
    int val = preorder[preStart];
    TreeNode root = new TreeNode(val);
    int rootIdx = preorderMap.get(postorder[postEnd - 1]); // next root
    int leftSize = rootIdx - (preStart + 1);
    root.left = helper(postEnd - 1, preStart + 1, rootIdx - 1);
    root.right = helper(postEnd - 1 - leftSize, rootIdx + 1, preEnd);
    return root;


  }
}
