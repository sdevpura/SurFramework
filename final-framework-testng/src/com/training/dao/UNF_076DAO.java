package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.training.bean.UNF_076Bean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class UNF_076DAO {
	
	Properties properties; 
	
	public UNF_076DAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UNF_076Bean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<UNF_076Bean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<UNF_076Bean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				UNF_076Bean temp = new UNF_076Bean(); 
				temp.setUserName(gc.rs1.getString(1));				
				temp.setPassword(gc.rs1.getString(2));
				temp.setProductName(gc.rs1.getString(3));
				temp.setQuantity(gc.rs1.getInt(4));
				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new UNF_076DAO().getLogins().forEach(System.out :: println);
	}
	
	
}
