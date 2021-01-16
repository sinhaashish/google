package LinkedList;

public class LinkedList {

  public Node head;

  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  void recursiveRevarsalList(Node node) {

  }

  Node iterativeReversalOfList(Node node) {
    Node prev = null;
    Node next = null;
    Node current = node;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  static Node recursiveReverse(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

        /* reverse the rest list and put
        the first element at the end */
    Node rest = recursiveReverse(head.next);
    head.next.next = head;

    /* tricky step -- see the diagram */
    head.next = null;

    /* fix the head pointer */
    return rest;
  }

  Node reverseInGroups(Node head, int k) {
    Node prev = null;
    Node next = null;
    Node current = head;
    int count = 0;
    while (count < k && current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
     /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
    if (next != null) {
      head.next = reverseInGroups(next, k);
    }

    // prev is now head of input list
    return prev;
  }

  public boolean loopExist(Node head) {
    Node slow = head;
    Node fast = head;
    boolean flag = false;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        flag = true;
        break;
      }
    }
    if (flag) {
      return true;
    }
    return false;

  }

  public Node startingPointOfLoop(Node head) {
    Node slow = head;
    Node fast = head;
    boolean flag = false;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        flag = true;
        break;
      }
    }
    slow = head;
    while (slow!= fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  public Node removeLoop(Node head) {
    Node slow = head;
    Node fast = head;
    boolean flag = false;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        flag = true;
        break;
      }
    }
    Node temp = null;
    slow = head;
    while (slow!= fast) {
      slow = slow.next;
      temp= fast;
      fast = fast.next;
    }
    temp.next = null;
    return head;
  }
}


