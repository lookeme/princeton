
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
* @author denisbelokopytov
*/
/**
* Main class Outcast finding.
*
*/
public class Outcast {
   private final WordNet wordNet;

  public Outcast(WordNet wordnet) {
    this.wordNet = wordnet;

  }
  
  /**
   * Main class Outcast finding.
   *
   */
  public String outcast(String[] nouns) {
		int max = 0;
		String outcast = null;
		for (String nounA : nouns) {
			int dist = 0;
			for (String nounB : nouns) {
				if (!nounA.equals(nounB)) {
					dist += wordNet.distance(nounA, nounB);
				}
			}
			if (dist > max) {
				max = dist;
				outcast = nounA;
			}
	}
	return outcast;
	
}

	public static void main(String[] args) {
		WordNet wordnet = new WordNet(args[0], args[1]);
		Outcast outcast = new Outcast(wordnet);
		for (int t = 2; t < args.length; t++) {
			In in = new In(args[t]);
			String[] nouns = in.readAllStrings();
			StdOut.println(args[t] + ": " + outcast.outcast(nouns));
		}
	}
}
