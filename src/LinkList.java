// list1 : 5->2->null
// list2 : 9->0->8->null
// list3 : 1->2->3->4->5->6->7->8->9->null

import java.util.List;

public class LinkList {
  public static void main(String[] args) {
    Node list1 = createLinkList(List.of(5, 2));

    Node list2 = createLinkList(List.of(9, 0, 8));

    Node list3 = createLinkList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

    printList(addTwoLinkList(list1, list2));

    printList(reverseListInKGroup(list3, 3));
  }

  public static Node reverseListInKGroup(Node head, int k) {
    Node prev = null;
    Node current = head;
    Node next = null;

    int count = 0;
    while (count < k && current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

    if (current != null)
      head.next = reverseListInKGroup(current, k);
    
    return prev;
  }

  public static Node reverseList(Node head) {
    Node prev = null;
    Node current = head;
    Node next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  public static Node addTwoLinkList(Node list1, Node list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;

    Node reversedList1 = reverseList(list1);
    Node reversedList2 = reverseList(list2);

    Node head = null, result = null;

    int carry = 0;
    int sum = 0;
    while (reversedList1 != null || reversedList2 != null) {
      int a = (reversedList1 == null) ? 0 : reversedList1.val;
      int b = (reversedList2 == null) ? 0 : reversedList2.val;

      sum = a + b + carry;
      carry = sum / 10;
      sum = sum % 10;

      Node newNode = new Node(sum);

      if (head == null) {
        head = newNode;
        result = newNode;
      } else {
        result.next = newNode;
        result = result.next;
      }

      if (reversedList1 != null)
        reversedList1 = reversedList1.next;

      if (reversedList2 != null)
        reversedList2 = reversedList2.next;
    }

    if (carry != 0) {
      result.next = new Node(carry);
      result = result.next;
    }

    return reverseList(head);
  }

  public static void printList(Node head) {
    while (head != null) {
      System.out.print(head.val + "->");
      head = head.next;
    }
    System.out.println("null");
  }
  
  public static Node createLinkList(List<Integer> list) {
    Node head = null;
    Node pointer = new Node(list.get(0));
    head = pointer;

    for (int i = 1; i < list.size(); i++) {
      pointer.next = new Node(list.get(i));
      pointer = pointer.next;
    }

    return head;
  }
}

class Node {
  int val;
  Node next;

  Node(int val) {
    this.val = val;
    this.next = null;
  }
}
