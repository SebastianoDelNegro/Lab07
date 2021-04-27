package it.polito.tdp.poweroutages.model;

import java.util.Comparator;

public class comparatoredata implements Comparator<blackout> {

	@Override
	public int compare(blackout o1, blackout o2) {

		return o1.getInizio().compareTo(o2.getInizio());
	}

}
