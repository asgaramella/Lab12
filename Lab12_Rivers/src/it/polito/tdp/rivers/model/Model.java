package it.polito.tdp.rivers.model;

import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	private RiverIdMap riverIdMap;
	private FlowIdMap flowIdMap;
	private List<River> rivers;
	private Simulator sim;

	public Model() {
		super();
		riverIdMap=new RiverIdMap();
		flowIdMap=new FlowIdMap();
	}

	
	
	public List<River> getAllRivers(){
		if(this.rivers==null){
			RiversDAO dao=new RiversDAO();
			this.rivers=dao.listRiver(riverIdMap);
			
		}
		
		return rivers;
	}
	
	
	public float getMediaFlows(River r){
		float sum=0;
		if(r.getFlows().isEmpty()){
		RiversDAO dao=new RiversDAO();
		dao.getFlowsofRiver(r,flowIdMap);
		}
		for( Flow ftemp: r.getFlows()){
			sum+=ftemp.getFlow();
		}
		return sum/r.getFlows().size();
		
	}
	
	
	public Statistiche startSimulazione(int k, River r){
		
		float media=this.getMediaFlows(r);
		sim=new Simulator(k,media,r);
		sim.run();
		return sim.getSt();
	}
	
	
	

}
