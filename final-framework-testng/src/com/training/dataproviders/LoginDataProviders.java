package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.UNF_076Bean;
import com.training.dao.ELearningDAO;
import com.training.dao.UNF_076DAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public static Object [][] getDBData() {

		List<UNF_076Bean> list = new UNF_076DAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(UNF_076Bean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getProductName();
			obj[3] = temp.getQuantity();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	

	
	@DataProvider(name = "excel-inputs")
	public static Object[][] getExcelData(){
		String fileName ="C:\\Users\\SurbhiDevpura\\Desktop\\Test Data.xlsx"; 
		String SheetName = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public static Object[][] getExcelData1(){
		String fileName ="C:\\Users\\SurbhiDevpura\\Desktop\\Test Data_UNF_077.xlsx"; 
		String SheetName = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "UNF078excel-inputs")
	public static Object[][] getExcelDataUNF078(){
		String fileName ="C:\\Users\\SurbhiDevpura\\Desktop\\Test Data_UNF_078.xlsx"; 
		String SheetName = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
