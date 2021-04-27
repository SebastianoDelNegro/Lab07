package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.blackout;

public class PowerOutageDAO {
	
	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	
	
	public List<blackout> tuttiiblackout(){
		List<blackout> blackout = new ArrayList<blackout>();
		
		String sql = "SELECT * "
				+ "FROM poweroutages";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				Timestamp c = res.getTimestamp("date_event_began");
				LocalDateTime inizio = c.toLocalDateTime();
				Timestamp c1 = res.getTimestamp("date_event_finished");
				LocalDateTime fine = c.toLocalDateTime();
				blackout b = new blackout(res.getInt("id"),res.getInt("event_type_id"),res.getInt("tag_id"),
						res.getInt("area_id"),res.getInt("nerc_id"),res.getInt("responsible_id"),res.getInt("customers_affected"),inizio,fine,res.getInt("demand_loss"));
				
				blackout.add(b);
			}
			
			conn.close();
			return blackout;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	

}
