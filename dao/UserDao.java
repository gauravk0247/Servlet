package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import utility.DBUTil;

public class UserDao {
	// This method will add user details into DB
	public User addUser(User user) {
		try(Connection con = DBUTil.getDBConnect();){
			String  insertUqery = "insert into UserInfo(user_name, user_password, user_dob, user_address, user_phone, user_email, user_gender, user_uqalification, user_state, user_type) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertUqery);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			// java.sql.Date class having a static method called valueOf(localDate ld)
			
			Date sqlDate = Date.valueOf(user.getDob());
			ps.setDate(3, sqlDate);
			ps.setString(4, user.getAddress());
			ps.setLong(5, user.getPhone());
			ps.setString(6, user.getEmailId());
			ps.setString(7, user.getGender());
			ps.setString(8, user.getQualification());
			ps.setString(9, user.getState());
			ps.setString(10, user.getUserType());
			
			int status = ps.executeUpdate();
			if(status>0) {
				return user;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public User getLogIn(String emailId, String password) {
		User user = null;
		try(Connection con = DBUTil.getDBConnect();){
			String fetchQuery = "select user_name, user_password, user_email, user_type from UserInfo where user_email=? and user_password=?";
			PreparedStatement ps = con.prepareStatement(fetchQuery);
			ps.setString(1, emailId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String userName = rs.getString(1);
				String userPassword = rs.getString(2);
				String userEmail = rs.getString(3);
				String userType = rs.getString(4);
				user = new User();
				user.setName(userName);
				user.setEmailId(userEmail);
				user.setPassword(userPassword);
				user.setUserType(userType);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}
}