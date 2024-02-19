package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.tomcat.jni.Local;

import com.mysql.cj.xdevapi.DbDoc;

import model.FlightClass;
import utility.DBUTil;

public class FlightDao {
	public FlightClass addFlight(FlightClass flight) 
	{
		try(Connection con = DBUTil.getDBConnect();){
			String insertQuery = "insert into FlightInfo(flight_name, flight_src, flight_dest, flight_date, flight_price) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, flight.getFlightName());
			ps.setString(2, flight.getFlightSrc());
			ps.setString(3, flight.getFlightDesc());
			Date date = Date.valueOf(flight.getFlightDate());
			ps.setDate(4, date);
			ps.setDouble(5, flight.getFlightPrice());
			
			int status = ps.executeUpdate();
			if(status>0) {
				return flight;
			}
			}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
		
		public Set<FlightClass> getAllFlight()
		{
			Set<FlightClass> setOfFlight = new LinkedHashSet();
			try(Connection con = DBUTil.getDBConnect();){
				PreparedStatement ps = con.prepareStatement("select * from FlightInfo");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int fId = rs.getInt(1);
					String name = rs.getString(2);
					String src = rs.getString(3);
					String dest = rs.getString(4);
					Date fdate = rs.getDate(5);
					double price = rs.getDouble(6);
					
					// constructing object of Flight
					FlightClass f = new FlightClass();
					f.setFlightId(fId);
					f.setFlightName(name);
					f.setFlightSrc(src);
					f.setFlightDesc(dest);
					f.setFlightPrice(price);
					
					//since from databse we are getting sql date type for flight_date field
					// sql date object have to converted into Localdate object to set with Flight type
					// object
					
					LocalDate flyDate = fdate.toLocalDate();
					f.setFlightDate(flyDate);
					
					// Adding flight object with set object
					setOfFlight.add(f);
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			return setOfFlight;
		}
		
		public int deleteFlight(int flightId) {
			int delStatus = 0;
			try(Connection con = DBUTil.getDBConnect();){
				PreparedStatement ps = con.prepareStatement("delete from flightInfo where flight_id=?");
				ps.setInt(1, flightId);
				delStatus = ps.executeUpdate();
			}catch(Exception e) {
				System.out.println(e);
			}
			return delStatus;
		}
	}