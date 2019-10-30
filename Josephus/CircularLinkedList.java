import java.util.Iterator;

public class CircularLinkedList<E> implements Iterable<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    // Implement a constructor
    public CircularLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    private Node<E> getNode(int index) {
        if(index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds - getNode method :(");
        }
        Node currentNode = head;
        int i = 0;
        while(i < index) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }


    public int getSize() {
        return size;
    }


    public boolean add(E item) {
        this.add(size, item);
        return true;
    }

	// Probably doesn't matter much, but should be Node<E>
    public void add(int index, E item) {
        Node newNode = new Node(item);
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds - add method");
        }

        if (size == 0) {
        	head = newNode;
        	tail = newNode;
        }
        // You're adding to the head, so where should tail be pointing? One line of code.
        else if(index == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }

        // Check your if statement... delete something =)
        // Should be Node<E> as well
        else if(index == size - 1) {
            Node temp = tail;
            tail = newNode;
            temp.next = tail;
            tail.next = head;
        }

        else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
}


    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds - remove method");
        }

        E toReturn = null;

        if(index == 0) {
            toReturn = head.item;
            head = head.next;
            tail.next = head;
        }

        else if(index == size - 1){
            toReturn = tail.item;
            tail = getNode(size - 2);
            tail.next = head;
        }

        else {
            Node<E> node = getNode(index);
            toReturn = node.item;
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = node.next;
        }
        size--;
        return toReturn;
    }


    public String toString() {
        String out = "";
        Node<E> current = head;
        if(size == 0) {
            System.out.println("Empty list");
        }
        for(int i = 0; i < size; i++) {
            out += current.item;
            out += "==>";
            current = current.next;
        }
        return out;
    }


    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Cannot get size :(");
        }
        return getNode(index).item;
    }

    public E set(int index, E data) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Cannot get size :(");
        }
        Node<E> target = getNode(index);
        E oldData = target.item;
        target.item = data;
        return oldData;
    }


    public Iterator<E> iterator() {

        return new ListIterator<E>();
    }

    /*
    *******************************
    END CIRCULAR LINKED LIST CLASS
    BEGINNING ITERATOR CLASS
    *******************************
    */

    // This class is not static because it needs to reference its parent class
    private class ListIterator<E> implements Iterator<E> {
        Node<E> nextItem;
        Node<E> prev;
        int index;

        @SuppressWarnings("unchecked")
        // Creates a new iterator that starts at the head of the list
        public ListIterator() {
            nextItem = (Node<E>) head;
            index = 0;
        }

        // Returns true if there is a next node
        public boolean hasNext() {
            if(size != 0) {
                return true;
            }
            return false;
        }

        // Advances the iterator to the next item
        // Should wrap back around to the head
        public E next() {
//            E item = nextItem.item;
            prev = nextItem;
            nextItem = nextItem.next;
            index = (index + 1) % size; //automatically wraps back around to front
            return prev.item;

        }

        // Remove the last node visited by the .next() call
        // For example, if we had just created an iterator,
        // the following calls would remove the item at index 1 (the second person in the ring)
        // next() next() remove()
        // Use CircularLinkedListFixed.this to reference the CircularLinkedListFixed parent class
        public void remove() {
            int tempIndex = index;
            if(nextItem == head) {
                tempIndex = size - 1;
            }
            else if (index != 0){
                tempIndex = index - 1;
            }
            index--;
            CircularLinkedList.this.remove(tempIndex);

        }

    }

    /*
    ************************
    END LIST ITERATOR CLASS
    BEGINNING NODE CLASS
    ************************
     */


    // The Node class
    private static class Node<E>{
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getNext() {
            return next;
        }

    }

    public static void main(String[] args){
        CircularLinkedList myCircularLinkedListFixed = new CircularLinkedList();
        System.out.println(myCircularLinkedListFixed);
        myCircularLinkedListFixed.add(0, "Head");
        System.out.println(myCircularLinkedListFixed);
        myCircularLinkedListFixed.add(1, "Hello");
        System.out.println(myCircularLinkedListFixed);
        myCircularLinkedListFixed.add(2, "Hey");
        System.out.println(myCircularLinkedListFixed);
        myCircularLinkedListFixed.add(3, "Hi");
        System.out.println(myCircularLinkedListFixed);
        myCircularLinkedListFixed.add(4, "What");
        System.out.println(myCircularLinkedListFixed);
        myCircularLinkedListFixed.add(2, "Added");
        System.out.println(myCircularLinkedListFixed);
        myCircularLinkedListFixed.add(6, "End");
        System.out.println(myCircularLinkedListFixed);
        myCircularLinkedListFixed.remove(4);
        System.out.println(myCircularLinkedListFixed);

        Iterator<String> iter = myCircularLinkedListFixed.iterator();
        //System.out.println(iter.next());
        iter.next();
        iter.next();
        iter.remove();
        System.out.println(myCircularLinkedListFixed);
        iter.next();
        iter.remove();
        System.out.println(myCircularLinkedListFixed);
        iter.next();
        iter.remove();
        System.out.println(myCircularLinkedListFixed);
        iter.next();
        iter.remove();
        System.out.println(myCircularLinkedListFixed);
        iter.next();
        iter.remove();
        System.out.println(myCircularLinkedListFixed);
        iter.next();
        iter.remove();
        System.out.println(myCircularLinkedListFixed);









    }





}
