package dfs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

  int[] preorder;
  int[] postorder;
  Map<Integer, Integer> postorderMap = new HashMap<>(); // <val, index>


  public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    this.preorder = preorder;
    this.postorder = postorder;
    int N = preorder.length;
    for (int i = 0; i < N; i++) {
      postorderMap.put(postorder[i], i);
    }
    return helper(0, N - 1, 0, N - 1);
  }

  private TreeNode helper(int preStart, int preEnd, int postStart, int postEnd) {
    if (postStart > postEnd || preStart > preEnd) return null;
    // when prestart == N - 1, should return in case of exception
    if (preStart == preEnd) return new TreeNode(preorder[preStart]);

    TreeNode root = new TreeNode(preorder[preStart]);
    int rootIdx = postorderMap.get(preorder[preStart + 1]); //next root in postorder[]
    int leftSize = rootIdx - postStart; // idx [0, 1, 2], size = 2-0 = 2
    root.left = helper(preStart + 1, preStart + 1 + leftSize, postStart, rootIdx);
    root.right = helper(preStart + 2 + leftSize, preEnd, rootIdx + 1, postEnd - 1);
    return root;


  }
}
