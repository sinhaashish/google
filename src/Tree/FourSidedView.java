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

public class FourSidedView {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    tree.root.right.left.right = new Node(8);

    System.out.println(" The left view of tree is ");
    tree.leftView(tree.root);
    System.out.println(" \n The right view of tree is ");
    tree.rightView(tree.root);

  }

}
