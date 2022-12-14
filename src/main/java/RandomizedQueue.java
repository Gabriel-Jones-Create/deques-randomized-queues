import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * 
 * @author gabrieljones
 * 
 * 
 * 
 *         A {@link RandomizedQueue<Item>} represents a program which directs
 * 
 *         the random addition or removal of items from a list
 * 
 * 
 * 
 * @param <Item> generic type of data stored
 * 
 */

public class RandomizedQueue<Item> implements Iterable<Item> {

	private static final int CAPACITY = 8; // initial capacity of array

	private int count; // // indicates number of elements stored

	private Item[] arr; // the array

	/**
	 * 
	 * Constructs an empty randomized queue
	 * 
	 */

	public RandomizedQueue() {

		arr = (Item[]) new Object[CAPACITY];

	}

	/**
	 * 
	 * If the size of the list is 0, return <code>true</code>
	 * 
	 * 
	 * 
	 * @return <code>true</code> if the size of the list is 0
	 * 
	 */

	public boolean isEmpty() {

		return count == 0;

	}

	/**
	 * 
	 * Returns the number of items in the randomized queue
	 * 
	 * 
	 * 
	 * @return the number of items in the randomized queue
	 * 
	 */

	public int size() {

		return count;

	}

	/**
	 * 
	 * Adds an item to the list by resizing the array length and adding the item to
	 * 
	 * the end
	 * 
	 * 
	 * 
	 * @param item is the element added to the end of the list
	 * 
	 */

	public void enqueue(Item item) {

		if (item == null) {

			throw new IllegalArgumentException("you need to enter an item!");

		}

		if (!isEmpty() && count == arr.length) {

			resize(2 * arr.length);

		}

		arr[count++] = item;

	}

	/**
	 * 
	 * Removes and returns a random item from the list
	 * 
	 * 
	 * 
	 * @return the random removed item
	 * 
	 */

	public Item dequeue() {

		if (isEmpty()) {

			throw new NoSuchElementException("no elements inside the array");

		}

		int random = StdRandom.uniform(0, count);

		Item item = arr[random];

		arr[random] = arr[count - 1];

		arr[count - 1] = null;

		count--;

		// shrink size of array if necessary

		if (count > 0 && count == arr.length / 4) {

			resize(arr.length / 2);

		}

		return item;

	}

	/**
	 * 
	 * Returns a random item from the list
	 * 
	 * 
	 * 
	 * @return the random item
	 * 
	 */

	public Item sample() {

		if (isEmpty()) {

			throw new NoSuchElementException("no elements inside the array");

		}

		return arr[StdRandom.uniform(0, count)];

	}

	/**
	 * 
	 * Alters the size of the array by creating a copy of the array with the number
	 * 
	 * of indexes specified in capacity
	 * 
	 * 
	 * 
	 * @param capacity is the number of indexes the new array will have
	 * 
	 */

	private void resize(int capacity) {

		Item[] copy = (Item[]) new Object[capacity];

		for (int i = 0; i < copy.length; i++) {

			if (i < arr.length) {

				copy[i] = arr[i];

			}

		}

		arr = copy;

	}

	/**
	 * 
	 * Returns an iterator over items in random order
	 * 
	 */

	public Iterator<Item> iterator() {

		resize(count);

		StdRandom.shuffle(arr);

		return new ListIterator(arr);

	}

	/**
	 * 
	 * @author sagesilberman
	 *
	 * 
	 * 
	 *         A {@link RandomizedQueueIterator} represents an iterator which allows
	 * 
	 *         the traversal through the list of items
	 * 
	 * 
	 * 
	 */

	private class ListIterator implements Iterator<Item> {

		private int current; // the current size of the array

		private final Item[] randomizedArr; // array that holds the items in the queue

		/**
		 * 
		 * Constructs an Iterator containing an array
		 * 
		 * 
		 * 
		 * @param array array of items to iterate through
		 * 
		 * 
		 * 
		 */

		public ListIterator(Item[] array) {

			randomizedArr = array;

			current = count;

		}

		@Override

		public boolean hasNext() {

			return current > 0;

		}

		@Override

		public Item next() {

			if (!hasNext()) {

				throw new NoSuchElementException("it's empty so can't execute code");

			}

			return randomizedArr[--current];

		}

		@Override

		public void remove() {

			throw new UnsupportedOperationException("opperation is unsupported");

		}

	}

	public static void main(String[] args) {

// unit testing (optional)

	}

}