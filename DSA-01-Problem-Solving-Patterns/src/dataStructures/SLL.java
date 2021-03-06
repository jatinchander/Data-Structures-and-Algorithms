/*Data Structures are collections of values, the relationships among them, and the functions or operations that can be applied to the data.*/
package dataStructures;

public class SLL {
	/*
	 * Linked list is a data structure that contains a head, tail, and length
	 * property. Linked Lists consists of nodes, and each node has a value and a
	 * pointer to another node or null.
	 * Example: (HEAD)|4| --> |15| --> |7| --> |40|(TAIL) --> NULL
	 */
	
	Node head = null;
	
	public static void main(String[] args) {
		SLL list = new SLL();
		insert(list, 4);
		insert(list, 15);
		insert(list, 7);
		insert(list, 40);	
		printList(list);
		insert(list, 13);
		printList(list);
		delete(list);
		printList(list);
		deleteFromStart(list);
		printList(list);
		insertToStart(list, 4);
		printList(list);
	}
	
		
	// Node Class
	static class Node {
		// pointer
		Node next;
		// value
		int data;

		// constructor
		public Node(int data) {
			this.data = data;
			next = null;
		} // end constructor
	} // end node class
	
	// helper print method
	public static void printList(SLL list) {
		System.out.println();
		
        Node temp = list.head; 
   
        System.out.print("LinkedList: "); 
   
        // Traverse through the LinkedList 
        while (temp != null) { 
            // Print the data at current node 
            System.out.print("|" + temp.data + "| --> "); 
   
            // Go to next node 
            temp = temp.next; 
        } 
        
       System.out.print("NULL");
    } 
	
	// insert at tail method
	public static SLL insert(SLL list, int data) {
		// Create a new node
		Node newNode = new Node(data);
		newNode.next = null;
		
		// empty list
		if(list.head == null) {
			list.head = newNode;
		}
		else {
			Node temp = list.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			
			temp.next = newNode;
		}
		
		return list;
	} // end insert
	
	// delete at tail method
	public static SLL delete(SLL list) {
		// empty list
		if(list.head == null) {
			return null;
		}
		
		// keeps track of current node & will go all the way to the end
		Node current = list.head;
		// keeps track of node before current
		Node newTail = current;
		
		// traverse to the end of the list
		while(current.next != null) {
			newTail = current;
			current = current.next;
		}
		
		// when there is only 1 item in list
		if(current.data == newTail.data) {
			list.head = null;
		}
		else {
			current = null;
			newTail.next = current;
		}
				
		return list;
	} // end of delete
	
	// shift method
	public static SLL deleteFromStart(SLL list) {
		if (list.head == null) {
			return null;
		} else {
			Node temp = list.head.next;
			list.head = temp;
		}

		return list;
	} // end of deleteFromStart
	
	// insert in beginning 
	public static SLL insertToStart(SLL list, int data) {
		Node newNode = new Node(data);
		
		Node temp = list.head;
		list.head = newNode;
		newNode.next = temp;
		
		return list;
		
	}
	
	// get method - given a position, return the node
	public static Node getByIndex (SLL list, int index) {
		if(index < 0) {
			return null;
		}
		int counter = 0;
		Node current = list.head;
		while(counter != index) {
			current = current.next;
			counter++;
		}
		return current;
	}
	
	
} // end SLL class
