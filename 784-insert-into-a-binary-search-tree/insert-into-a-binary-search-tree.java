
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If the tree is empty, create a new node
        if (root == null) {
            return new TreeNode(val);
        }

        // Go left or right depending on the value
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}