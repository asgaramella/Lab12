package it.polito.tdp.rivers.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.FlowIdMap;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.RiverIdMap;

public class RiversDAO {
	
	
	public List<River> listRiver(RiverIdMap riverIdMap) {
		final String sql ="SELECT * "+
				"FROM river ORDER BY name";

                                                                                 
		try {                                                           
			java.sql.Connection conn = DBConnect.getConnection();
			java.sql.PreparedStatement st = conn.prepareStatement(sql);                               
			                                                                                                                         
			ResultSet res = st.executeQuery() ;
			
			List<River> list = new ArrayList<>() ;
			
			while(res.next()) {
				River r= riverIdMap.get(res.getInt("id"));
				if(r==null){
				r = new River(res.getInt("id"), res.getString("name")) ;
				r= riverIdMap.put(r);
				}
				
				list.add(r);
			
			}
			
			res.close();
			conn.close();
			
			return list ;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null ;
		}
	}

	public void getFlowsofRiver(River r, FlowIdMap flowIdMap) {
		final String sql ="select * "+
				"from flow "+
				"where river=? "+
				"order by day";

                                                                                 
		try {                                                           
			java.sql.Connection conn = DBConnect.getConnection();
			java.sql.PreparedStatement st = conn.prepareStatement(sql);   
			st.setInt(1, r.getId());
			                                                                                                                         
			ResultSet res = st.executeQuery() ;
			
			
			
			while(res.next()) {
				Flow f= flowIdMap.get(res.getInt("id"));
				if(f==null){
				f = new Flow(res.getInt("id"), res.getDate("day").toLocalDate(),res.getFloat("flow"),r) ;
				f= flowIdMap.put(f);
				}
				
				r.getFlows().add(f);
			
			}
			
			res.close();
			conn.close();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		}
		
		
	}
	

}
