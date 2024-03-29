package Random.PID01.Ex01;

class Node {                                                // Elements of our list
    int elem;                                               // Identification
    Node next;                                              // Pointing to next element

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }
}

public class LinkedList {
    Node first = null;

    public void add(int elem) {
        if (first == null)                                  // LinkedList is empty
            first = new Node(elem, null);             // Create first element
        else {
            Node current = first;                           // Starting from first
            while (current.next != null)                    // If there exist next one
                current = current.next;                     // Then go to successor
            current.next = new Node(elem, null);      // Add new one after "no successor" element
        }
    }

    int get(int index) {
        // 2 cases
        if (first == null) {                                // case 1: zero elements
            throw new IndexOutOfBoundsException("list is empty");
        } else {                                            // case 2: at least one element
            int counnter = 0;
            Node current = first;
            while (current.next != null && counnter < index) {
                current = current.next;
                counnter++;
            }
            if (counnter == index) {
                return current.elem;
            } else {
                throw new IndexOutOfBoundsException("index greater then the lenght of the list");
            }
        }
    }
}
