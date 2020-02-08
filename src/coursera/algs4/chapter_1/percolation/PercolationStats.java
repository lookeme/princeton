
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  private final double[] threshold;
  private final int experimentsCnt;
  private static final double CONFIDENCE_95 = 1.96;
  
  
  /** perform trials independent experiments on an n-by-n grid. */
  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }
    experimentsCnt = trials;
    Percolation percolation;
    threshold = new double[trials];
    for (int t = 0; t < experimentsCnt; t++) {
      percolation = new Percolation(n);
      int openSides = 0;
      while (!percolation.percolates()) {
        int i = StdRandom.uniform(1, n + 1);
        int j = StdRandom.uniform(1, n + 1);
        if (!percolation.isOpen(i, j)) {
          percolation.open(i, j);
          openSides++;
        }
      }
      double fraction = (double) openSides / (n * n);
      threshold[t] = fraction;

    }
  }
  
  /** sample mean of percolation threshold. */
  public double mean() {
    return StdStats.mean(threshold);
  }
  
  /** sample standard deviation of percolation threshold. */
  public double stddev()  {
    return StdStats.stddev(threshold);
  }
  
  /** low  endpoint of 95% confidence interval. */
  public double confidenceLo() {
    return (mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(experimentsCnt)));
  }
  
  /** high endpoint of 95% confidence interval. */
  public double confidenceHi() {
    return  (mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(experimentsCnt)));
  }


  /** test client (described below). */
  public static void main(String[] args) {
    if (args.length < 2) {
      throw new IllegalArgumentException();
    }
    int n = Integer.parseInt(args[0]);
    int t = Integer.parseInt(args[1]);
    PercolationStats percolationStats = new PercolationStats(n, t);
    
    String confidence = percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi();
    StdOut.println("mean                    = " + percolationStats.mean());
    StdOut.println("stddev                  = " + percolationStats.stddev());
    StdOut.println("95% confidence interval = " + confidence);
  
  
  }
}
