package Tree;

// The diameter of a tree (sometimes called the width)
// is the number of nodes on the longest path between two end nodes.
// The diagram below shows two trees each with diameter nine, the leaves
// that form the ends of the longest path are shaded (note that there is more t
// han one path in each tree of length nine, but no path longer than nine nodes)

public class DiameterOfTres {

  public static void main(String args[]) {
    // creating a binary tree and entering the nodes
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    // Function Call
    System.out.println(
      "The diameter of given binary tree is : "
        + tree.diameter(tree.root));
  }
}
