package coursera.algs4.chapter_1.section_5;

/**
 * @author denisbelokopytov
 */
public interface UFI {
	void union(int p, int q);
	int find(int p);
	boolean connected(int p, int q);
	int count();
}
