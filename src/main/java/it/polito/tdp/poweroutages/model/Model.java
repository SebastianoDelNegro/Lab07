package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	List<blackout> blackoutTotali;
	List<blackout> best;
	List<blackout> listafiltrata ; 
	
	int numeroMassimoDiPersone = 0;
	
	public Model() {
		podao = new PowerOutageDAO();
		blackoutTotali = podao.tuttiiblackout();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<blackout> getSoluzionePeggiore(int y, int x, Nerc nerc){
		best = new ArrayList<blackout>();
		listafiltrata = new ArrayList<blackout>();
		
		for(blackout c : blackoutTotali) {
			if(c.getNerc_id()==nerc.getId()) {
				listafiltrata.add(c);
			}
		}
		Collections.sort(listafiltrata, new comparatoredata());
		
		
		cerca(new ArrayList<blackout>(),x,y);
		
		return best;
	}

	
	
	
	private void cerca(List<blackout> parziale, int x, int y) {
		
		if(numMassimoPersone(parziale)>numeroMassimoDiPersone) {
			numeroMassimoDiPersone = numMassimoPersone(parziale);
			best = new ArrayList<blackout>(parziale);
		}
		
		for(blackout v : listafiltrata) {
			if(!parziale.contains(v)) {
			parziale.add(v);
			
			if(numMaxAnni(parziale,x) && numMaxOre(parziale,y)) {
				cerca(parziale,x,y);
			}
			
			parziale.remove(v);
			}
		}
		
	}

	
	
	private boolean numMaxOre(List<blackout> parziale, int y) {
		
		int ore =0;
		for(blackout b : parziale) {
			ore+=b.getDuration();
			
		}
		if(ore<=y) return true;
		
		else return false;
	}

	private boolean numMaxAnni(List<blackout> parziale,int y) {
		if(parziale.size()>=2) {
		int y1 = parziale.get(0).getYear();
		int y2 = parziale.get(parziale.size()-1).getYear();

		if((y2-y1+1)>y) return false;
		else return true;}
		
		return true;
	}

	private int numMassimoPersone(List<blackout> parziale) {
		int sum = 0;
		for(blackout b : parziale) {
			sum+=b.getCustomers_aff();
		}
		
		return sum;
	}

}
