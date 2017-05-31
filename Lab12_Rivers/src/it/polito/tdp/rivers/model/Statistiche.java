package it.polito.tdp.rivers.model;

public class Statistiche {
	
	private int totIngressi;
	private int nrGiorniInsoddisfatti;
	private double occupazioneTot;
	
	
	public Statistiche() {
		super();
		totIngressi=0;
		this.nrGiorniInsoddisfatti=0;
		this.occupazioneTot=0;
		
	}


	public int getTotIngressi() {
		return totIngressi;
	}


	public void setTotIngressi(int totIngressi) {
		this.totIngressi = totIngressi;
	}


	public int getNrGiorniInsoddisfatti() {
		return nrGiorniInsoddisfatti;
	}


	public void setNrGiorniInsoddisfatti(int nrGiorniInsoddisfatti) {
		this.nrGiorniInsoddisfatti = nrGiorniInsoddisfatti;
	}


	public double getOccupazioneTot() {
		return occupazioneTot;
	}


	public void setOccupazioneTot(double occupazioneTot) {
		this.occupazioneTot = occupazioneTot;
	}


	
	
	

}
