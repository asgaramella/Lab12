package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;

public class River {
	private int id;
	private String name;
	private List<Flow> flows;
	
	
	public River(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.flows=new ArrayList();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		River other = (River) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  name;
	}
	public List<Flow> getFlows() {
		return flows;
	}
	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}
	
	
	
	
	
	
	
}
