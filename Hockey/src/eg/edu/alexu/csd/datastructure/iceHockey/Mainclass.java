package eg.edu.alexu.csd.datastructure.iceHockey;

import java.lang.*;
import java.awt.Point;
import java.util.*;

public class Mainclass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] s = new String[1000];
		s[1] = scan.nextLine();
		int team,threshold;
		int i = 1;
		while (s[i].charAt(s[i].length() - 1) == ',') {
			i++;
			s[i] = scan.nextLine();
		}
		team=scan.nextInt();
		threshold=scan.nextInt();
		IPlayersFinder f=new photo();
		f.findPlayers(s, team, threshold);
		
	}

}