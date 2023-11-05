/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (40 marks)
    Use java to implement a data structure named LinkedList, and implement several methods of the LinkedList.

 */

class Node {
    int data; // 'data' stores the value of a node.
    Node next; // 'next' refers/points to the next node

    // the construction method of class Node.
    Node(int d) {
        data = d;
        next = null;
    }
}

class Q2_LinkedList {
    Node head;

    // Insert 'new_data' at the beginning of the LinkedList
    // (5 marks)
    public void insertAtBeginning(int new_data) {
        /* place your code here */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        Node new_head = new Node(new_data);
        new_head.next = head;
        head = new_head;
    }

    // Insert 'new_data' at the end of the LinkedList
    // (5 marks)
    public void insertAtEnd(int new_data) {
        /* place your code here */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        Node head_temp = head;
        Node insert = new Node(new_data);
        while (head_temp.next != null) head_temp = head_temp.next;
        head_temp.next = insert;
    }

    // Insert 'new_data' after a node referred to as 'prev_node'
    // (10 marks)
    public void insertAfter(Node prev_node, int new_data) {
        /* place your code here */
        Node insert = new Node(new_data);
        insert.next = prev_node.next;
        prev_node.next = insert;

    }

    // Delete a node located in 'position' of the Linked List. The first element of the LinkedList has a position=0.
    // (10 marks)
    void deleteNode(int position) {
        /* place your code here */
        if (position == 0) {
            head = head.next;
            return;
        }
        Node head_temp = head;
        for (int i = 0; i < position-1; i++) head_temp = head_temp.next;
        head_temp.next = head_temp.next.next;
    }

    // Search for a node containing the value of 'key' in the LinkedList.
    // If there is a node in the LinkedList whose value is equal to 'key', then return 'true'.
    // If there is no node in the LinkedList whose value is equal to 'key', then return 'false'.
    // (15 marks)
    boolean search(Node head, int key) {
        /* place your code here */
        Node head_temp = head;
        while (head_temp.next != null) {
            if (head_temp.data == key) return true;
            head_temp = head_temp.next;
        } return false;
    }

    // Sort the nodes in the LinkedList in ascending orders of their values.
    // Requirement: please use bubble sort.
    // Example: for a LinkedList: head->3->5->1->4->2, the sorted LinkedList should be head->1->2->3->4->5.
    // (15 marks)
    void sortLinkedList(Node head) {
        /* place your code here */
        Node head_temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            head_temp = head;

            while (head_temp.next != null) {
                if (head_temp.data > head_temp.next.data) {
                    Node next_temp = head_temp.next;
                    head_temp.next = head_temp.next.next;
                    next_temp.next = head_temp;
                    head = next_temp;

                    System.out.println(head.data);
                    System.out.println(head.next.data);
                    System.out.println(head.next.next.data);
                    System.out.println(head.next.next.next.data);

                    sorted = false;
                }
                head_temp = head_temp.next;
            }
        }
    }

    // Print the linked list
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        /* TA may test different functions of the LinkedList here */
        /* The following is just an example of how to do the test. */

        Q2_LinkedList llist = new Q2_LinkedList();

        llist.insertAtEnd(1);
        llist.insertAtBeginning(2);
        llist.insertAtBeginning(3);
        llist.insertAtEnd(4);
        llist.insertAfter(llist.head.next, 5);

        System.out.println("Linked list: ");
        llist.printList();

        System.out.println("\nAfter deleting an element: ");
        llist.deleteNode(3);
        llist.printList();

        System.out.println();
        int item_to_find = 3;
        if (llist.search(llist.head, item_to_find))
            System.out.println(item_to_find + " is found");
        else
            System.out.println(item_to_find + " is not found");

        llist.sortLinkedList(llist.head);
        System.out.println("\nSorted List: ");
        llist.printList();
    }
}