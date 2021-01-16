package Tree;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import sun.reflect.generics.tree.Tree;

public class BinaryTree {

  Node root;

  public BinaryTree() {
    root = null;
  }

  public int height(Node root) {
    if (root == null) {
      return 0;
    }

    int lheight = height(root.left);
    int rheight = height(root.right);
// If tree is not empty then height = 1 + max of
    //  left height and right heights
    return (1 + Math.max(height(root.left), height(root.right)));
  }

  public void printLevelOrder() {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    while (!q.isEmpty()) {
      Node tempNode = q.poll();
      System.out.print(tempNode.data + " ");

      if (tempNode.left != null) {
        q.add(tempNode.left);
      }
      if (tempNode.right != null) {
        q.add(tempNode.right);
      }
    }
  }

  public void printReverseLevelOrder() {
    Queue<Node> q = new LinkedList<Node>();
    Stack<Node> s = new Stack<Node>();
    q.add(root);
    while (!q.isEmpty()) {
      Node tempNode = q.peek();
      s.push(tempNode);
      q.remove();

      if (tempNode.right != null) {
        q.add(tempNode.right);
      }
      if (tempNode.left != null) {
        q.add(tempNode.left);
      }
    }

    while (!s.isEmpty()) {
      Node t = s.peek();
      System.out.print(t.data + " ");
      s.pop();
    }
  }

  int diameter(Node root) {
    // base case if tree is empty
    if (root == null) {
      return 0;
    }

    // get the height of left and right sub-trees
    int lheight = height(root.left);
    int rheight = height(root.right);

    // get the diameter of left and right sub-trees
    int ldiameter = diameter(root.left);
    int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right subtree + 1
         */
    return Math.max(lheight + rheight + 1,
      Math.max(ldiameter, rdiameter));
  }

  // Mirror of a Tree: Mirror of a Binary sun.reflect.generics.tree.Tree T
  // is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
  void mirror() {
    root = mirror(root);
  }

  Node mirror(Node node) {
    if (node == null) {
      return node;
    }        /* do the subtrees */
    Node left = mirror(node.left);
    Node right = mirror(node.right);

    /* swap the left and right pointers */
    node.left = right;
    node.right = left;
    return node;
  }

  /* Helper function to test mirror(). Given a binary
     search tree, print out its data elements in
     increasing sorted order.*/
  // LNR
  void inOrder() {
    inOrder(root);
  }

  void inOrder(Node node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.data + " ");
    inOrder(node.right);
  }

  void iterativeInorder() {
    iterativeInorder(root);
  }

  void iterativeInorder(Node root) {
    if (root == null) {
      return;
    }
    Stack<Node> s = new Stack<Node>();
    Node curr = root;
    // traverse the tree
    while (curr != null || s.size() > 0) {
            /* Reach the left most Node of the
            curr Node */
      while (curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
        s.push(curr);
        curr = curr.left;
      }
      /* Current must be NULL at this point */
      curr = s.pop();
      System.out.print(curr.data + " ");
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
      curr = curr.right;
    }
  }

  // NLR
  void preOrder() {
    preOrder(root);
  }

  void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.data + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  void iterativePreorder() {
    iterativePreorder(root);
  }

  void iterativePreorder(Node node) {
    if (node == null) {
      return;
    }
    Stack<Node> st = new Stack<Node>();
    st.push(node);
    while (!st.isEmpty()) {
      Node temp = st.peek();
      System.out.print(temp.data + " ");
      st.pop();
      if (temp.right != null) {
        st.add(temp.right);
      }
      if (temp.left != null) {
        st.add(temp.left);
      }
    }
  }

  void postOrder() {
    inOrder(root);
  }

  void postOrder(Node node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.data + " ");
  }

  void leftView( Node node ){
    if( node == null) {
      return ;
    }
    Queue< Node > q = new LinkedList<Node>();
    q.add(node);
    while(!q.isEmpty()){
      int size = q.size();
      for ( int i = 1;i <= size; i++) {
        Node temp = q.poll();
        // Print the left most element at
        // the level
        if (i == 1)
          System.out.print(temp.data + " ");
        if(temp.left != null){
          q.add(temp.left);
        }
        if(temp.right != null){
          q.add(temp.right);
        }
      }
    }
  }


  void rightView( Node node ){
    if( node == null) {
      return ;
    }
    Queue< Node > q = new LinkedList<Node>();
    q.add(node);
    while(!q.isEmpty()){
      int size = q.size();
      for ( int i = 1;i <= size; i++) {
        Node temp = q.poll();
        // Print the left most element at
        // the level
        if (i == size)
          System.out.print(temp.data + " ");
        if(temp.left != null){
          q.add(temp.left);
        }
        if(temp.right != null){
          q.add(temp.right);
        }
      }
    }
  }

}
