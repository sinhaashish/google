package Tree;

import static javafx.scene.input.KeyCode.Q;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
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

  //LRN
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

  void zigzag() {
    printZigZagTraversal(root);
  }

  void printZigZagTraversal(Node root) {

    // if null then return
    if (root == null) {
      return;
    }

    // declare two stacks
    Stack<Node> currentLevel = new Stack<>();
    Stack<Node> nextLevel = new Stack<>();

    // push the root
    currentLevel.push(root);
    boolean leftToRight = true;

    // check if stack is empty
    while (!currentLevel.isEmpty()) {

      // pop out of stack
      Node node = currentLevel.pop();

      // print the data in it
      System.out.print(node.data + " ");

      // store data according to current
      // order.
      if (leftToRight) {
        if (node.left != null) {
          nextLevel.push(node.left);
        }

        if (node.right != null) {
          nextLevel.push(node.right);
        }
      } else {
        if (node.right != null) {
          nextLevel.push(node.right);
        }

        if (node.left != null) {
          nextLevel.push(node.left);
        }
      }

      if (currentLevel.isEmpty()) {
        leftToRight = !leftToRight;
        Stack<Node> temp = currentLevel;
        currentLevel = nextLevel;
        nextLevel = temp;
      }
    }
  }

  void leftView(Node node) {
    if (node == null) {
      return;
    }
    Queue<Node> q = new LinkedList<Node>();
    q.add(node);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 1; i <= size; i++) {
        Node temp = q.poll();
        // Print the left most element at
        // the level
        if (i == 1) {
          System.out.print(temp.data + " ");
        }
        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
    }
  }


  void rightView(Node node) {
    if (node == null) {
      return;
    }
    Queue<Node> q = new LinkedList<Node>();
    q.add(node);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 1; i <= size; i++) {
        Node temp = q.poll();
        // Print the left most element at
        // the level
        if (i == size) {
          System.out.print(temp.data + " ");
        }
        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
    }
  }

  public void topView(Node node) {
    class QueueNode {

      Node node;
      int didtanceFromcentre;

      public QueueNode(Node node, int didtanceFromcentre) {
        this.node = node;
        this.didtanceFromcentre = didtanceFromcentre;
      }
    }
    Queue<QueueNode> q = new LinkedList<QueueNode>();
    Map<Integer, Node> hs = new TreeMap<Integer, Node>();

    if (root == null) {
      return;
    } else {
      q.add(new QueueNode(root, 0));
    }
    while (!q.isEmpty()) {
      QueueNode temp = q.poll();
      if (!hs.containsKey(temp.didtanceFromcentre)) {
        hs.put(temp.didtanceFromcentre, temp.node);
      }
      if (temp.node.left != null) {
        q.add(new QueueNode(temp.node.left, temp.didtanceFromcentre - 1));
      }
      if (temp.node.right != null) {
        q.add(new QueueNode(temp.node.right, temp.didtanceFromcentre + 1));
      }
    }
    for (Entry<Integer, Node> entry : hs.entrySet()) {
      System.out.print(entry.getValue().data + " ");
    }
  }


  public void bottomView(Node node) {
    class QueueNode {

      Node node;
      int didtanceFromcentre;

      public QueueNode(Node node, int didtanceFromcentre) {
        this.node = node;
        this.didtanceFromcentre = didtanceFromcentre;
      }
    }
    Queue<QueueNode> q = new LinkedList<QueueNode>();
    Map<Integer, Node> hs = new TreeMap<Integer, Node>();

    if (root == null) {
      return;
    } else {
      q.add(new QueueNode(root, 0));
    }
    while (!q.isEmpty()) {
      QueueNode temp = q.poll();
      hs.put(temp.didtanceFromcentre, temp.node);
      if (temp.node.left != null) {
        q.add(new QueueNode(temp.node.left, temp.didtanceFromcentre - 1));
      }
      if (temp.node.right != null) {
        q.add(new QueueNode(temp.node.right, temp.didtanceFromcentre + 1));
      }
    }
    for (Entry<Integer, Node> entry : hs.entrySet()) {
      System.out.print(entry.getValue().data + " ");
    }
  }

  /// The boundary view

  // A simple function to print leaf nodes of a binary tree
  void printLeaves(Node node)
  {
    if (node == null)
      return;

    printLeaves(node.left);
    // Print it if it is a leaf node
    if (node.left == null && node.right == null)
      System.out.print(node.data + " ");
    printLeaves(node.right);
  }

  // A function to print all left boundary nodes, except a leaf node.
  // Print the nodes in TOP DOWN manner
  void printBoundaryLeft(Node node)
  {
    if (node == null)
      return;

    if (node.left != null) {
      // to ensure top down order, print the node
      // before calling itself for left subtree
      System.out.print(node.data + " ");
      printBoundaryLeft(node.left);
    }
    else if (node.right != null) {
      System.out.print(node.data + " ");
      printBoundaryLeft(node.right);
    }

    // do nothing if it is a leaf node, this way we avoid
    // duplicates in output
  }

  // A function to print all right boundary nodes, except a leaf node
  // Print the nodes in BOTTOM UP manner
  void printBoundaryRight(Node node)
  {
    if (node == null)
      return;

    if (node.right != null) {
      // to ensure bottom up order, first call for right
      // subtree, then print this node
      printBoundaryRight(node.right);
      System.out.print(node.data + " ");
    }
    else if (node.left != null) {
      printBoundaryRight(node.left);
      System.out.print(node.data + " ");
    }
    // do nothing if it is a leaf node, this way we avoid
    // duplicates in output
  }

  // A function to do boundary traversal of a given binary tree
  void printBoundary(Node node)
  {
    if (node == null)
      return;

    System.out.print(node.data + " ");

    // Print the left boundary in top-down manner.
    printBoundaryLeft(node.left);

    // Print all leaf nodes
    printLeaves(node.left);
    printLeaves(node.right);

    // Print the right boundary in bottom-up manner
    printBoundaryRight(node.right);
  }

  public boolean isHeightBalanced(Node node) {
    int lh, rh;
    if (node == null) {
      return true;
    }
    lh = height(node.left);
    rh = height(node.right);

    if (Math.abs(lh - rh) <= 1 && isHeightBalanced(node.left) && isHeightBalanced(node.right)) {
      return true;
    }
    return false;
  }


}
