package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import formdata.uiform;

public class UserDAO {
	public dbConnection conn;

    public UserDAO() {
        conn=new dbConnection();
        conn.openConnection();
    }

    public Map<String,String> reflect(String arg1,String arg2){
   	 ResultSet r1=conn.executeSelectQuery(arg1);
   	 ResultSet r2=conn.executeSelectQuery(arg2);
   	 Map<String,String> m=new LinkedHashMap<String,String>();
   	 try {
			while(r1.next()&&r2.next()) {
				 m.put(r1.getString(1),r2.getString(1));
			 }
			return m;
	}catch (SQLException e){
		e.printStackTrace();
		return null;
	    }
    }
    public double calculate(String year,String month){
    	String pattern=year+"-"+month;
    	double finum=0.0;
   	 	ResultSet r1=conn.executeSelectQuery("daytime");
   	 	ResultSet r2=conn.executeSelectQuery("[总市值(元)]");
   	 	ResultSet r3=conn.executeSelectQuery("[成交金额(元)]");
   	 	//Map<String,Double> m=new LinkedHashMap<String,Double>();
   	 	try {
			while(r1.next()&&r2.next()&&r3.next()) {
					if(r1.getString(1).contains(pattern)) {
						String num=r2.getString(1);
						double num1=Double.parseDouble(num);
						finum=Double.parseDouble(r3.getString(1))/num1*100;
					}
				}
		} catch (NumberFormatException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
   	 	return finum;
    }
} 
