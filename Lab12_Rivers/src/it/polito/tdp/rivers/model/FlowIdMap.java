package it.polito.tdp.rivers.model;

import java.util.HashMap;
import java.util.Map;

public class FlowIdMap {
	private Map<Integer,Flow> map;

	public FlowIdMap() {
		super();
		map=new HashMap<>();
	}
	
	public Flow get(Integer id){
		return map.get(id);
	}
	
	public Flow put(Flow a){
		Flow old=map.get(a.getId());
		if(old==null){
			map.put(a.getId(), a);
			return a;
		}
		else
			return old;
	}
	

}
