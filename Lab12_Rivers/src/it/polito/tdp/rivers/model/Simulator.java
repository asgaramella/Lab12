package it.polito.tdp.rivers.model;

import java.util.PriorityQueue;


import it.polito.tdp.rivers.model.Event.EventType;

public class Simulator {
	
	//stato del mondo
	private float Q;
	private float C;
	private float fMed;
	
	//lista eventi
	private PriorityQueue<Event> queue;
	
	
	private Statistiche st;

	public Simulator(int k, float media, River r) {
		super();
		st=new Statistiche();
		this.queue=new PriorityQueue<>();
		this.popolaListaEventi(r);
		fMed= media*24*3600;
		Q=k*fMed*30;
		C=Q/2;
		
		
	}
	
	
	private void popolaListaEventi(River r){
		for(Flow ftemp: r.getFlows()){
			queue.add(new Event(ftemp,EventType.IN));
			st.setTotIngressi(st.getTotIngressi()+1);
		}
		
	}

	public Statistiche getSt() {
		return st;
	}
	
	
	public void run() {
		while (!queue.isEmpty()) {
			Event e = queue.poll();
			

			switch (e.getType()) {
			case IN:
				processEventIngresso(e);
				break;
			
			default:
				System.err.println("Errore !");
	
			}
			

		}
	}


	private void processEventIngresso(Event e) {
		float fOut;
		float fIn=e.getFlow().getFlow()*3600*24;
		 double prob=Math.random();
		 if(prob<0.95)
			 fOut=(float) (0.8*fMed);
		 else
			 fOut=(float) (10*0.8*fMed);
		C+=fIn-fOut;
		if(C<0){
			C=0;
			st.setNrGiorniInsoddisfatti(st.getNrGiorniInsoddisfatti()+1);
		}
		else{
			if(C>Q)
				C=Q;
			
			
			
			st.setOccupazioneTot(st.getOccupazioneTot()+C);
		}
		 
		
		
	}
	
	
	
	
	

}
