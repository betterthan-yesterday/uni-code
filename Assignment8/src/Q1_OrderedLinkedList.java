/* Assignment 8 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (40 marks)
    1. Inherit from LKList.A2_LinkedList to implement a subclass Q1_OrderedLinkedList that overrides the sortLinkedList()
    method by using insertion sort instead of the original bubble sort in LKList.A2_LinkedList. Please sort all nodes in
    ascending order of data values.
    2. Implement an orderedInsert() method that inserts a new node in an ordered linked list without breaking the order of
    nodes. Please use one or multiple of the methods of the super class LKList.A2_LinkedList such as insertAtBeginning(),
    insertAtEnd(int new_data) and insertAfter().
 */

import LKList.*;

public class Q1_OrderedLinkedList extends LKList.A2_LinkedList{
    // Use the following method to override the original sortLinkedList() method.
    // The following method should implement insertion sort.
    // (25 marks)
    public void sortLinkedList(Node headref)
    {
        System.out.println("Running insertion sort of A1_OrderedLinkedList ...");
        /* place your code here */
        boolean sorted = false;
        while (!sorted) {
            sorted = true;

            Node prev_node = null;
            Node temp_head = headref;
            while (temp_head != null) {
                if (prev_node != null && temp_head.data < prev_node.data) {
                    prev_node.next = temp_head.next;

                    Node temp_head2 = headref;
                    while (true) {
                        if (temp_head.data < temp_head2.data) {
                            insertAtBeginning(temp_head.data);
                            sorted = false;
                            break;
                        } else if (temp_head.data > temp_head2.data && temp_head.data < temp_head2.next.data) {
                            temp_head.next = temp_head2.next;
                            temp_head2.next = temp_head;
                            sorted = false;
                            break;
                        }
                        temp_head2 = temp_head2.next;
                    }
                    break;
                }
                prev_node = temp_head;
                temp_head = temp_head.next;
            }
        }
    }

    // Use the following method to implement orderedInsert().
    // The 'newnode' should be inserted without breaking the order of a LinkedList in ascending order.
    // Only the methods insertAtBeginning(), insertAtEnd(int new_data) and insertAfter() of the superclass LKList.A2_LinkedList can be used.
    // (15 marks)
    public void orderedInsert(Node newnode) {
        /* place your code here */
        Node temp_head = head;
        while (true) {
            if (newnode.data < head.data) {
                insertAtBeginning(newnode.data);
                break;
            }  else if (temp_head.next == null) {
                insertAtEnd(newnode.data);
                break;
            }  else if (newnode.data > temp_head.data && newnode.data <= temp_head.next.data) {
                insertAfter(temp_head, newnode.data);
                break;
            }
            temp_head = temp_head.next;
        }
    }

    public static void main (String args[]) {
        // test A1_OrderedLinkedList
        Q1_OrderedLinkedList llist1 = new Q1_OrderedLinkedList();

        llist1.insertAtEnd(1);
        llist1.insertAtBeginning(3);
        llist1.insertAtBeginning(5);
        llist1.insertAtEnd(7);
        llist1.insertAfter(llist1.head.next, 9);
        llist1.printList();

        llist1.sortLinkedList(llist1.head);
        llist1.printList();

        Node newnode = new Node(10);
        llist1.orderedInsert(newnode);
        llist1.printList();

        // test A2_LinkedList
        A2_LinkedList llist2 = new A2_LinkedList();

        llist2.insertAtEnd(2);
        llist2.insertAtBeginning(4);
        llist2.insertAtBeginning(6);
        llist2.insertAtEnd(8);
        llist2.insertAfter(llist2.head.next, 10);
        llist2.printList();

        llist2.sortLinkedList(llist2.head);
        llist2.printList();
    }
}
