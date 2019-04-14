package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;
import java.lang.*;
import java.util.*;

public class photo implements IPlayersFinder {

	private static int area = 0;
	private static int maxX = -1;
	private static int minX = 10000;
	private static int maxY = -1;
	private static int minY = 10000;
	private static HashSet<Point> vis = new HashSet<Point>();
	private static void dfs(int i, int j, String[] photo, char team) {
		Point a = new Point(i, j);
		if (i>=photo.length||i<0) {
			return;
		}
		if (j >= photo[1].length() || j < 0) {
			return;
		}

		if (photo[i].charAt(j) != team) {
			return;
		}
		if (vis.contains(a)) {
			return;
		}
		maxX = Math.max(2 * (j ) + 2, maxX);
		maxY = Math.max(2 * (i+1), maxY);
		minX = Math.min(2 * (j ), minX);
		minY = Math.min(2 * (i+1) - 2, minY);
		vis.add(a);
		area += 4;
		dfs(i + 1, j, photo, team);
		dfs(i - 1, j, photo, team);
		dfs(i, j + 1, photo, team);
		dfs(i, j - 1, photo, team);

	}

	public Point[] findPlayers(String[] photo, int team, int threshold) {
		Point[] ans = new Point[1000];
		int counter = 0;
		int i = 0;
		while (i<photo.length) {
			for (int j = 0; j < photo[i].length(); j++) {
				area = 0;
				maxX = -1;
				minX = 10000;
				maxY = -1;
				minY = 10000;
				char x = photo[i].charAt(j);
				Point a = new Point(i, j);
				if (x == (char) (team + '0') && !vis.contains(a)) {
					dfs(i, j, photo, x);
					if (area >= threshold) {
						ans[counter] = new Point((maxX + minX) / 2, (maxY + minY) / 2);
						counter++;
					}
				}
			}
			i++;
		}
		Arrays.sort(ans, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				if (a == null || b == null) {
					return 0;
				}
				int xComp = Integer.compare(a.x, b.x);
				if (xComp == 0)
					return Integer.compare(a.y, b.y);
				else
					return xComp;
			}
		});
		for (i = 0; i < counter; i++) {
			System.out.println(ans[i]);
		}
		return ans;
	}

}
