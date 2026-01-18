/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    int totalNodes = 0, ans = 0;
    // return the Kth largest element in the given BST rooted at 'root'
    void traverse(Node node, int k) {
        if(node == null) return;
        traverse(node.right, k);
        totalNodes++;
        if(totalNodes == k) {
            ans = node.data;
        }
        traverse(node.left, k);
    }
    public int kthLargest(Node root, int k) {
        // Your code here
        totalNodes = 0;
        traverse(root, k);
        return ans;
    }
}
/*
/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/

// return the Kth largest element in the given BST rooted at 'root'
class Solution {
  public:
    // visiting as In Order
    int totalNodes = 0; int ans;
    void traverse(Node* node, int k) {
        if(node == nullptr) return;
        traverse(node->right, k);
        totalNodes++;
        if(totalNodes == k) {
            ans = node->data;
        }
        traverse(node->left, k);
    }
    int kthLargest(Node *root, int k) {
        // Your code here
        totalNodes = 0;
        traverse(root, k);
        return ans;
        
    }
};*/