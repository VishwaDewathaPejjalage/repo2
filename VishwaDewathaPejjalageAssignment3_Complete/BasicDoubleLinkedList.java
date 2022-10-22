package Assignment3;

import java.util.*;

/**
 * This is a generic BasicDoubleLinkedList class that implements iterable
 * @author Vishwa dewatha Pejjalage
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected Node first, last;
    protected int SizeOfList;
    protected DoubleLinkedListIterator iterator;


    /**
     * non parameterized constructor for BasicDoubleLinked List
     */
    BasicDoubleLinkedList(){
        first = null;
        last = null;
        SizeOfList = 0;
    }

    /**
     * method to add a node to the end of the Basic Double Linked List
     * @param data to be added via node
     * @return the new BasicDoubleLinkedList
     */
    public BasicDoubleLinkedList<T> addToEnd(T data){
        if(last == null){
            first = new Node(data);
            last = first;
        }
        else{
            Node tempNode = new Node(data, last,null);
            last.setNext(tempNode);
            last = tempNode;
         }
        SizeOfList++;
        return this;
    }

    /**
     * method to add an element to the front of the BasicDoubleLinkedList
     * @param data
     * @return the new list
     */
    public BasicDoubleLinkedList<T> addToFront(T data) {
        if(first == null){
            first = new Node(data);
            last = first;
        }
        else{
            Node tempNode = new Node(data, null, first);
            first.setPrevious(tempNode);
            first = tempNode;
        }
        SizeOfList++;
        return this;
    }

    /**
     * Method to return the data in the first element
     * @return T first node data
     * @throws NoSuchElementException
     */
    public T getFirst() throws NoSuchElementException {
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.getData();
    }

    /**
     * Method to return the data in the last element in the list
     * @return lastNode data
     * @throws NoSuchElementException
     */
    public T getLast() throws NoSuchElementException {
        if(last == null){
            throw new NoSuchElementException();
        }
        return last.getData();
    }

    /**
     * method to get the sized of the basic double linked list
     * @return size
     */
    public int getSize(){
        return this.SizeOfList;
    }

    /**
     * implements iterable to create class iterator
     * @return DoubleLinkedListIterator
     * @throws UnsupportedOperationException
     * @throws NoSuchElementException
     */
    @Override
    public DoubleLinkedListIterator iterator() throws UnsupportedOperationException,NoSuchElementException{
        return new DoubleLinkedListIterator();
    }

    /**
     * Created DoubleLinkedListIterator for the class
     */
    public class DoubleLinkedListIterator implements ListIterator<T> {

        Node current;

        DoubleLinkedListIterator(){
            current = null;
        }

        @Override
        public boolean hasNext() {
           return (current == null && first != null) || ((current != null) && (current.next != null));
        }

        @Override
        public boolean hasPrevious() {
//            return (current == null && lastNode != null) || ((current != null) && (current.previous != null));
            return (current == null && last != null) || ((current != null) );
        }

        @Override
        public T previous() {
            T returndata = null;
            if (!hasPrevious() || SizeOfList == 0) {
                throw new NoSuchElementException();
            }
            if (current == null){
                throw new NoSuchElementException();
            }
            returndata = current.getData();
            current = current.previous;
            return returndata;
        }


        @Override
        public T next() throws NoSuchElementException {

            if (!hasNext() || SizeOfList == 0) {
                throw new NoSuchElementException();
            }
            if (current == null && first != null){
                current = first;
            }
            else if((current!= null) && (current.next != null)){
                current = current.next;
            }
            else{
                throw new NoSuchElementException();
            }
            return current.getData();
        }

        @Override
        public int nextIndex() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T t) throws UnsupportedOperationException{
            throw new UnsupportedOperationException();

        }
    }

    /**
     * this method uses a comparator to remove element
     * @param targetData
     * @param comparator
     * @return
     */
    public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){

        Node tempNode;
        if (SizeOfList == 0){
            return this;
        }
        else if( SizeOfList == 1){
            if(comparator.compare(first.getData(), targetData) == 0){
            first = null;
            last = null;
            SizeOfList--;
             }
            return this;
        }
        tempNode = first;

        while(tempNode != null){

            if(comparator.compare(tempNode.getData(),targetData) == 0){
            if(SizeOfList == 1){
                SizeOfList = 0;
                first = null;
                last = null;
                SizeOfList --;
                break;
            }
            if(tempNode.equals(first)){
                first = first.getNext();
                first.setPrevious(null);
            }
            else if(tempNode.equals(last)){
                last = last.getPrevious();
                last.setNext(null);
            }
            else{
                tempNode.getPrevious().setNext(tempNode.getNext());
                tempNode.getNext().setPrevious(tempNode.getPrevious());
            }
            SizeOfList--;
            break;

            }
            tempNode = tempNode.getNext();
        }

        return this;
    }

    /**
     * This method is to return the data of the first element and supsequently update list
     * @return element of firstNode
     */
    public T retrieveFirstElement(){
        T firstElement;

        if(first != null){
            firstElement = first.getData();
        }
        else{
            firstElement = null;
        }
        if(SizeOfList > 1){
            first = first.getNext();
            first.setPrevious(null);
        }
        else{
            first = null;
            last = null;
        }
        if (SizeOfList > 0){
            SizeOfList --;
        }
        return firstElement;
    }

    /**
     * This method will return the data of the last element and supsequently update list
     * @return data of last element
     */
    public T retrieveLastElement(){
        T lastElement;

        if(last != null){
            lastElement = last.getData();
        }
        else{
            lastElement = null;
        }
        last = last.getPrevious();

        if (SizeOfList > 0){
            SizeOfList --;
        }
        return lastElement;
    }

    /**
     * This method will convert the list into a displayable arraylist
     * @return arraylist of generic type created
     */
    public ArrayList<T> toArrayList() {

        ArrayList<T> outputList = (ArrayList<T>) new ArrayList<Object>();
        iterator = iterator();

        while(iterator.hasNext()) {
            iterator.next();
            outputList.add(iterator.current.getData());
        }

        return outputList;

    }


    /**
     * this subclass will be used to generate the nodes required for the
     * skeleton of the linked list
     */
    class Node{
        private T data;
        private Node previous, next;

    /**
     * this is a constructor that initializes a node with a previous and a next node
     * @param data
     * @param previous
     * @param next
     */
        Node(T data, Node previous, Node next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        Node(T data){
            this.data = data;
            this.previous = null;
            this.next = null;
        }

        public void setData(T data){
            this.data = data;
        }

        public T getData(){
            return this.data;
        }

        public void setNext(Node next){
            this.next = next;
            if (next != null) next.previous = this;
        }

        public Node getNext(){
            return this.next;
        }

        public boolean hasNext(){
        if (this.next == null){
            return false;
        }
        else{
            return true;
        }
        }

        public void setPrevious(Node previous){
            this.previous = previous;
            if(previous != null) previous.next = this;
        }

        public Node getPrevious(){
            return this.previous;
        }

        public boolean hasPrevious(){
            if (this.previous == null){
                return false;
            }
            else{
                return true;
            }
        }


}

}
