package coursera.algs4.point;


import coursera.algs4.point.LineSegment;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author denisbelokopytov
 */
public class BruteCollinearPoints {
	
	private LineSegment[] segments;
	
	
	public BruteCollinearPoints(Point[] points) {
		checkDuplicatedEntries(points);
		ArrayList<LineSegment> foundSegments = new ArrayList<>();
		
		Point[] pointsCopy = Arrays.copyOf(points, points.length);
		Arrays.sort(pointsCopy);
		int size = pointsCopy.length;
		for (int p = 0; p < size - 3; p++) {
			for (int q = p + 1; q < size - 2; q++) {
				for (int r = q + 1; r < size- 1; r++) {
					for (int s = r + 1; s < size; s++) {
						if (pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[r]) &&
							pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[s])) {
							foundSegments.add(new LineSegment(pointsCopy[p], pointsCopy[s]));
						}
					}
				}
				
			}
		}
		
		segments = foundSegments.toArray(new LineSegment[foundSegments.size()]);
	}
	
	public int numberOfSegments() {
		return segments.length;
	}
	
	public LineSegment[] segments() {
		return Arrays.copyOf(segments, numberOfSegments());
	}
	
	private void checkDuplicatedEntries(Point[] points) {
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].compareTo(points[j]) == 0) {
					throw new IllegalArgumentException("Duplicated entries in given points.");
				}
			}
		}
	}
	
	public static void main(String... args) {
//		In in = new In(args[0]);
		int n = 6;// in.readInt();
		Point[] points= new Point[n];
		
		points[0] = new Point(19000,  10000);
		points[1] = new Point(18000 , 10000);
		points[2]  = new Point(32000,  10000);
		points[3] = new Point(21000, 10000);
		points[5]  = new Point(14000,  10000);
		points[4]  = new Point(1234 ,  5678);


//		for (int i = 0; i < n; i++) {
//			int x = in.readInt();
//			int y = in.readInt();
//			points[i] = new Point(x, y);
//		}
//
		// draw the points
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		for (Point p : points) {
			p.draw();
		}
		StdDraw.show();
		for (Point p : points) {
			p.draw();
		}
		StdDraw.show();
		
		// print and draw the line segments
		BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		for (LineSegment segment : collinear.segments()) {
			StdOut.println(segment);
			segment.draw();
		}
		StdDraw.show();
	}
	

	
}
