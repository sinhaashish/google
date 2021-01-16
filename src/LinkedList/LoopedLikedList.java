package LinkedList;

public class LoopedLikedList {
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
   list.head.next.next.next.next.next.next.next.next = list.head.next.next;

    System.out.print(" \n Does loop exist " + list.loopExist(list.head));
    System.out.print(" \n Staring  point .loop ");
    Node node = list.startingPointOfLoop(list.head);
    System.out.print(  node.data);
    System.out.print(" \n Remove loop in linked list ");
    list.removeLoop(list.head);
    System.out.print(" \n Does loop exist " + list.loopExist(list.head));
  }

}
