package dao;

import java.sql.*;

public class dbConnection {
	private String diver;
	private String url;
	private String username="zca";
	private String password="1";
	//private String password="mypassword";

    private static Connection connection;
    dbConnection(){
    	diver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		url="jdbc:sqlserver://localhost:1433;DatabaseName=pubs";
		//url="jdbc:sqlserver://dbinstance.c4c9bslus6hd.us-east-1.rds.amazonaws.com:1433;DatabaseName=sa_job2";
    }
    public void openConnection(){
    	try
		{
		    Class.forName(diver);
		    System.out.println("���������ɹ���");
		}catch(Exception e){
		    e.printStackTrace();
		    System.out.println("��������ʧ�ܣ�");
		}
		try{
			connection =DriverManager.getConnection(url,username,password);
		        System.out.println("�������ݿ�ɹ���");
		}catch(Exception e)
		{
		    e.printStackTrace();
		    System.out.println("SQL Server����ʧ�ܣ�");
		}
    }
    public ResultSet executeSelectQuery(String arg){
        try {
        	Statement stat=connection.createStatement();
			ResultSet result=stat.executeQuery("select "+arg+" from data"); 
			return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
