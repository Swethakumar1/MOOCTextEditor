package textgen;

import java.util.AbstractList;

import javax.sound.sampled.TargetDataLine;


/** A class that implements a doubly linked list
 * 
 * @author UC SanDiego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method 
		size=0; 
		//head=new LLNode<E>(null); 
		//tail=new LLNode<E>(null); 
		head=null; 
		tail=null; 
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	
	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public boolean add(E element) {

		if (element == null) {
			throw new NullPointerException("Element is null");
		}
		LLNode<E> n = new LLNode<E>(element);
		if(head==null)
		{
			head=n; 
			tail=n; 
		}
		else {
			tail.next=n; 
			n.prev=tail; 
			tail=n; 
		}
		
		size++; 
		return true; 
		
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E get(int index) {
		if (index > this.size-1|| index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(head==null)
			throw new NullPointerException("Head cannot be null"); 
		LLNode<E> target = this.head;
		for (int i = 0; i <index; i++) {
			target = target.next;
		}
		return target.data;
	}
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
				LLNode<E> target = null;
				
				if(index>this.size||index<0)
					throw new IndexOutOfBoundsException(); 
				
				//if the node is the head 
				if(index==0)
				{
					target = head;
					
					LLNode<E> n=new LLNode<E>(element); 
					head=n; 
					tail=n; 
					if(head != null) {
						head.prev = null;
					}	  
				}	
				//if the node is at the tail 
				else if(index == this.size){
					target = tail;
					tail = tail.prev;
					if(tail != null){
						tail.next = null;
					}
				}
				
				
				//if the node is in the middle
				else{
					target=head;
				for(int i=0;i<index;i++)
				{
					target=target.next; 
				}
				target.prev.next=target.next; 
				target.next.prev=target.prev; 
				}
			size++; 
			
			}

/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> target = null;
		
		if(index>this.size-1||index<0)
			throw new IndexOutOfBoundsException(); 
		if(head==null)
			throw new NullPointerException("Head cannot be null"); 
		//if the node is the head 
		if(index==0)
		{
			target = head;
			head = head.next;
			if(head != null){
				head.prev = null;
			}
			
			  
		}	
		//if the node is at the tail 
		else if(index == size - 1){
			target = tail;
			tail = tail.prev;
			if(tail != null){
				tail.next = null;
			}
		}
		
		
		//if the node is in the middle
		else{
			target=head;
		for(int i=0;i<index;i++)
		{
			target=target.next; 
		}
		target.prev.next=target.next; 
		target.next.prev=target.prev; 
		
		}
	size--; 
	return target.data;
	}
				
		

		
	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
	// TODO: Implement this method
		
			E elem = null;

			if (element == null) {
				throw new NullPointerException("Element is null");
			}

			if (index > this.size-1|| index < 0) {
				throw new IndexOutOfBoundsException();
			}
		
			LLNode<E> target = this.head;
			for (int i = 0; i <index; i++) {
				target = target.next;
			}
			if(target != null){
				elem = target.data;
				target.data = element;
			}
			
			return elem;
	}
	
}		
		
		

 class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	/*//To access the outer class from the inner class 
	public MyLinkedList<E> getOuter(){
		return LLNode<E>; 
		
	}*/
}
//}
	



