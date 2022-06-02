import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Name:    Kevin Wayne
 *  Login:   wayne
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner Login:   N/A
 *  Partner Precept: N/A
 * 
 *  Compilation:  javac-algs4 Permutation.java
 *  Execution:    java-algs4 Permutation k < <filename>
 *  Dependencies: RandomizedQueue.java StdIn.java StdOut.java
 *
 *  Description:  Takes an integer k as a command-line argument; reads in a sequence of strings from standard input using StdIn.readString(); and prints exactly k of them, uniformly at random. 
 *  Prints each item from the sequence at most once. 
 ******************************************************************************/
public class Permutation {

  public static void main(String[] args) {
	System.out.println(args[0]);
	RandomizedQueue<String> kwayway = new RandomizedQueue<String>();
	  while(!StdIn.isEmpty()) {
		  String item = StdIn.readString();
		  StdOut.println(item);
		  kwayway.enqueue(item);
	  }
	  System.out.println("Quit while loop");
	  for(int i = 0; i < Integer.parseInt(args[0]); i++) {
		  StdOut.printf("%s /n", kwayway.dequeue());
	  }
  }

}
