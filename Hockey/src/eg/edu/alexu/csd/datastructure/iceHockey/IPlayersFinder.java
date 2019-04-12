package eg.edu.alexu.csd.datastructure.iceHockey;

import java.lang.*;

import java.util.*;

public interface IPlayersFinder {
	java.awt.Point[] findPlayers(String[] photo, int team, int threshold);
}