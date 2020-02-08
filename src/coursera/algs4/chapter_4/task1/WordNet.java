

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author denisbelokopytov
 */
public class WordNet {
	
	private final Digraph G;
	private final SAP sap;
	private ST<Integer, Set<String>> indexVertex;
	private ST<String, Set<Integer>> indexString;
	

	public WordNet(String synsets, String hypernyms) {
		if (synsets == null || hypernyms == null) throw new IllegalArgumentException();
		this.indexVertex = new ST<>();
		this.indexString = new ST<>();
		In synsetsIn = new In(synsets);
		In hypernymsIn = new In(hypernyms);
		
		while (synsetsIn.hasNextLine()) {
			String[] a = synsetsIn.readLine().split(",");
			int key = Integer.parseInt(a[0]);
			String[] words = a[1].split(" ");
			for(int i = 0; i < words.length; i++) {
				String word = words[i];
				Set<String> setOfWords = indexVertex.contains(key) ? indexVertex.get(key) : new TreeSet<String>() ;
				Set<Integer> setOfKeys = indexString.contains(word) ? indexString.get(word) : new TreeSet<Integer>();
				setOfWords.add(word);
				setOfKeys.add(key);
				indexVertex.put(key, setOfWords);
				indexString.put(word, setOfKeys);
			}
		}
		G = new Digraph(indexVertex.size());
		DirectedCycle cycle = new DirectedCycle(G);
		
		//check constructor when input is not a rooted DAG
		if(cycle.hasCycle()) throw new IllegalArgumentException();
		
		while (hypernymsIn.hasNextLine()) {
			String[] a = hypernymsIn.readLine().split(",");
			int v = Integer.parseInt(a[0]);
			for (int i = 1; i < a.length; i++) {
				int w = Integer.parseInt(a[i]);
				G.addEdge(v, w);
			}
		}
		sap = new SAP(G);

	}
	

	public Iterable<String> nouns() {
		return indexString.keys();
	}
	

	public boolean isNoun(String word) {
		if (word == null) throw new IllegalArgumentException();
		return indexString.contains(word);
	}
	

	public int distance(String nounA, String nounB) {
		if (nounA == null || nounB == null) throw new IllegalArgumentException();
		Set<Integer> vertexA = indexString.get(nounA);
		Set<Integer> vertexB = indexString.get(nounB);
		
		return sap.length(vertexA, vertexB);
		
	}
	
	public String sap(String nounA, String nounB) {
		if (!isNoun(nounA) || !isNoun(nounB) ) throw new IllegalArgumentException();
		Set<Integer> vertexA = indexString.get(nounA);
		Set<Integer> vertexB = indexString.get(nounA);
		int ancestorVertex = sap.ancestor(vertexA, vertexB);
		String nounC = null;
		Set<String> result = indexVertex.get(ancestorVertex);
		for(String noun: result) {
			nounC = noun;
			break;
		}
		return nounC;
	}
}
