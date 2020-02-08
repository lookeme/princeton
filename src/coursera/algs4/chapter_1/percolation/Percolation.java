
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private final int size;
  private int sites;
  private static final int top = 0;
  private final int bottom;
  private final WeightedQuickUnionUF qf;
  private boolean[][] opened;
  
  
  /** create n-by-n grid, with all sites blocked. */
  public Percolation(final int n)  {
    if (n <= 0) {
      throw new  IllegalArgumentException();
    }
    size = n;
    bottom = size * size + 1;
    qf = new WeightedQuickUnionUF(size * size + 2);
    opened = new boolean[size][size];
  }

  /** open sites. */
  public void open(final int i, final int j) {
  
    if (0 < i && i <= size && 0 < j && j <= size) {
      opened[i - 1][j - 1] = true;
  
      if (i == 1) {
        qf.union(getQfndex(i, j), top);
      }
      if (i == size) {
        qf.union(getQfndex(i, j), bottom);
      }
  
      if (j > 1 && isOpen(i, j - 1)) {
        qf.union(getQfndex(i, j), getQfndex(i, j - 1));
      }
      if (j < size && isOpen(i, j + 1)) {
        qf.union(getQfndex(i, j), getQfndex(i, j + 1));
      }
      if (i > 1 && isOpen(i - 1, j)) {
        qf.union(getQfndex(i, j), getQfndex(i - 1, j));
      }
      if (i < size && isOpen(i + 1, j)) {
        qf.union(getQfndex(i, j), getQfndex(i + 1, j));
      }
      this.sites++;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /** is site (row, col) open. */
  public boolean isOpen(final int row, final int col) {
    if (0 < row && row <= size && 0 < col && col <= size) {
      return opened[row - 1][col - 1];
    } else {
      throw new IllegalArgumentException();
    }
    
  }

  /** is site (row, col) full. */
  public boolean isFull(int row, int col) {
    if (0 < row && row <= size && 0 < col && col <= size) {
      return qf.connected(top, getQfndex(row, col));
    } else {
      throw new IllegalArgumentException();
    }
  }

  /** number of open sites. */
  public int numberOfOpenSites() {
    return this.sites;
  }
  /** does the system percolate. */

  public boolean percolates() {
    return qf.connected(top, bottom);
  }

  /** get index in WeightedQuickUnionUF array. */

  private int getQfndex(final int i, final int j) {
    return size * (i - 1) + j;
  }

  /** empty. */
  public static void main(final String[] args) {
  

  }




}
