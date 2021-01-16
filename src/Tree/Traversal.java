package Tree;

/*
         1
      /     \
     2       3
   /   \     /  \
  4     5   6    7
        \
         8
*/

public class Traversal {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
//    tree.root = new Node(1);
//    tree.root.left = new Node(2);
//    tree.root.right = new Node(3);
//    tree.root.left.left = new Node(4);
//    tree.root.left.right = new Node(5);
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    tree.root.right.left.right = new Node(8);
    System.out.println("\n  The recursive preorder ");
    tree.preOrder();
    System.out.println("\n The iterative preorder ");
    tree.iterativePreorder();
    System.out.print(" \n The recursive Inorder ");
    tree.inOrder();
    System.out.print("\n The iterative Inorder ");
    tree.iterativeInorder();
    System.out.print("\n  The recursive postOrder ");
    tree.postOrder();
    System.out.print("\n The iterative postOrder ");
//    tree.iterativeInorder();
    System.out.print(" \n The recursive postOrder ");
    tree.postOrder();
    System.out.print(" \n The zigzag traversal ");
    tree.zigzag();
    System.out.print(" \n The boundary  traversal ");
    tree.printBoundary(tree.root);
    System.out.print("\n Level order traversal of binary tree is - ");
    tree.printLevelOrder();
    System.out.print(" \n Reverse Level order traversal of binary tree is - ");
    tree.printReverseLevelOrder();

  }
}
