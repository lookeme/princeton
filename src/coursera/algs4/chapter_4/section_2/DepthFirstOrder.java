package coursera.algs4.chapter_4.section_2;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * @author denisbelokopytov
 */
public class DepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reverse;
	
	public DepthFirstOrder(Digraph digraph) {
		this.marked = new boolean[digraph.V()];
		this.pre = new Queue<>();
		this.post = new Queue<>();
		this.reverse = new Stack<>();
		
		for (int v = 0; v < digraph.V(); v++) {
			if(!marked[v]) {
				dfs(digraph, v);
			}
		}
		
		
	}
	
	private void dfs(Digraph digraph, int v) {
		pre.enqueue(v);
		marked[v] = true;
		for (int w: digraph.adj(v)) {
			if(!marked[w])  dfs(digraph, w);
		}
		post.enqueue(v);
		reverse.push(v);
	}
	
	
	public Queue<Integer> getPre() {
		return pre;
	}
	
	public Queue<Integer> getPost() {
		return post;
	}
	
	public Stack<Integer> getReverse() {
		return reverse;
	}
	
	public static void main(String[] args) {
	
	}
}
