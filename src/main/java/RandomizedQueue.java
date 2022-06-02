import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int count; // number of things in array aka the size variable
	private Item[] arr; // the array
	private Item[] randomized;

// done: construct an empty randomized queue
	public RandomizedQueue() {
		arr = (Item[]) new Object[1];
		randomized = arr;
		StdRandom.shuffle(randomized);
	}

// done: is the randomized queue empty?
	public boolean isEmpty() {
		return count == 0;
	}

// done: return the number of items on the randomized queue
	public int size() {
		return count;
	}

// add the item
	public void enqueue(Item item) {
        if (item == null) {
        	throw new java.lang.IllegalArgumentException("Enter an entry");
        }
        if (count == arr.length) { 
        	resize(2 * arr.length);
        }
        arr[count++] = item;
    }

// remove and return a random item
	public Item dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException("There are no elements");
        int random = StdRandom.uniform(count);
        if (!(count == 1 || count - 1 == random)) {
            swap(random);
        }
        Item item = arr[--count];
        arr[count] = null;
        if (count > 1 && count == arr.length / 4) resize(arr.length / 2);
        return item;
    }
	private void swap(int x) {
        Item txt;
        txt = arr[x];
        arr[x] = arr[count - 1];
        arr[count - 1] = txt;
    }

// done: return a random item (but do not remove it)
	public Item sample() {
		if (isEmpty()) {
			throw new NullPointerException("no elements inside the array");
		}
		int random = StdRandom.uniform(count);
		return arr[random];
	}

// done: return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private int current = count;
		private Item[] shuffledArr;

		public ListIterator() {
			shuffledArr = arr;
			StdRandom.shuffle(shuffledArr);
		}

		public boolean hasNext() {
			return current > 0;
		}

		public Item next() {
			if (hasNext()) {
				return shuffledArr[--current];
			} else {
				throw new NoSuchElementException("it's empty so can't execute code");
			}
		}

		public void remove() {
			throw new UnsupportedOperationException("opperation is unsupported");
		}
	}

	private Item[] resize(int newLen, Item[] ray) {
		Item[] temp = (Item[]) new Object[newLen];
		for (int i = 0; i < newLen; i++) {
			if (i < ray.length) {
				temp[i] = ray[i];
			}
			temp[i] = null;
		}
		return temp;
	}
	 private void resize(int capacity) {
	        Item[] copy = (Item[]) new Object[capacity];
	        for (int i = 0; i < count; i++) copy[i] = arr[i];
	        arr = copy;
	    }


	public static void main(String[] args) {
// unit testing (optional)

	}
}
