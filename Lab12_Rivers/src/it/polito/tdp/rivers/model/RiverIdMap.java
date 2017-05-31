package it.polito.tdp.rivers.model;

import java.util.HashMap;
import java.util.Map;

public class RiverIdMap {
	private Map<Integer,River> map;

	public RiverIdMap() {
		super();
		map=new HashMap<>();
	}
	
	public River get(Integer id){
		return map.get(id);
	}
	
	public River put(River a){
		River old=map.get(a.getId());
		if(old==null){
			map.put(a.getId(), a);
			return a;
		}
		else
			return old;
	}
	

}
