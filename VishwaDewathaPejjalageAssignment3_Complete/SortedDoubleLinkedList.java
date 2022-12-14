package Assignment3;

import java.util.Comparator;

/**
 * This is a child class of BasicDoubleLinkedList which is a SortedDoubleLinkedList
 * of generic Type
 * @author Vishwa Dewatha Pejjalage
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{

    private Comparator<T> comparator;

    /**
     * Constructor for SortedDoubleLinkedList that takes a certain comparator
     * @param comparator
     */
    public SortedDoubleLinkedList (Comparator<T> comparator){
        super();
        this.comparator = comparator;
    }


    /**
     * Method to add elements to the SortedDoubleLinkedList based on comparator
     * @param data
     * @return created list
     */
    public SortedDoubleLinkedList<T> add(T data){

//        iterator = iterator();
        Node t;
        Node next = first;
        while(next != null && comparator.compare(data, next.getData()) >= 0) {
            next = next.getNext();
        }

        Node oldPrevious = (next != null ? next.getPrevious() : null);

        //empty list
        if(SizeOfList == 0){
           t = new Node(data, null, null);
           first = last = t;
        }
        //insert at beginning of non empty list
        else if( oldPrevious == null && next != null){
            t = new Node(data, oldPrevious, next);
            next.setPrevious(t);
            first = t;
        }
        //insert at end of non empty list
        else if(next == null){
            t = new Node(data, last, null);
            last.setNext(t);
            last = t;
        }
        //insert at middle of list
        else{
            t = new Node(data, oldPrevious, next);
            oldPrevious.setNext(t);
            next.setPrevious(t);
        }



        SizeOfList++;
        return this;
    }
//        if(!(comparator.compare(data, nextGuy.getData()) <= 0)) {
//            throw new RuntimeException("We should not have gotten here");
//        }

    /**
     * Method is not supported for this class
     * @param data
     * @return
     * @throws UnsupportedOperationException
     */
    @Override
    public SortedDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException
    { throw new UnsupportedOperationException(); }

    /**
     * Method is not supported for this class
     * @param data to be added via node
     * @return
     * @throws UnsupportedOperationException
     */
    @Override
    public SortedDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

}