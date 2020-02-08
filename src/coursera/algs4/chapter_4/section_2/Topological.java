package coursera.algs4.chapter_4.section_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author denisbelokopytov
 */
public class Topological {
	
	private DirectedCycle cycle;
	private DepthFirstOrder order;
	
	public Topological(SymbolDigraph symbolGraph) {
		this.cycle = new DirectedCycle(symbolGraph.getDigraph());
		if (!cycle.hasCycle()) {
			this.order = new DepthFirstOrder(symbolGraph.getDigraph());
		}
	}
	
	public boolean isDAG() {
		return order == null;
	}
	
	public Iterable<Integer> postOrder() {
		return 	order.getPost();
	}
	public Iterable<Integer> preOrder() {
		return 	order.getPre();
	}
	public Iterable<Integer> reverseOrder() {
		return 	order.getReverse();
	}
	
	public static void main(String[] args) {
		String filename = args[0];
		String sp = args[1];
		SymbolDigraph symbolDigraph = new SymbolDigraph(filename, sp);
		Topological top = new Topological(symbolDigraph);
		if(!top.isDAG()) {
			for(int v : top.reverseOrder()) {
				StdOut.println(symbolDigraph.name(v));
			}
		}
	}
}
