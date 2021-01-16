package LinkedList;


public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.head.next.next.next = new Node(4);
    list.head.next.next.next.next = new Node(5);
    list.head.next.next.next.next.next = new Node(6);
    list.head.next.next.next.next.next.next = new Node(7);
    list.head.next.next.next.next.next.next.next = new Node(8);
    list.head.next.next.next.next.next.next.next.next = new Node(9);


    System.out.println("Given Linked list");
    list.printList(list.head);

    System.out.println("\n Iterative reversal of list");
    Node head1 = list.iterativeReversalOfList(list.head);
    list.printList(head1);

    System.out.println("\n Recursive reversal of list");
    Node head2 = list.recursiveReverse(head1);
    list.printList(head2);

    System.out.println("\n program to reverse a linked list in groups of  given size ");
    list.printList(list.iterativeReversalOfList(head2));



  }
}
