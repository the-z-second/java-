package bus;

import java.util.*;
import javax.swing.JFrame;

import java.awt.BasicStroke;
import java.awt.GridLayout;
import dao.UserDAO;
import formdata.ChartPanelform;

public class UserBUS {
	public UserDAO D;
	public UserBUS(){
		D=new UserDAO();
	}
	void show(String arg1,String arg2) {
    	Map<String, String> M=D.reflect(arg1, arg2);
   	 	Set<Map.Entry<String,String>> entrys=M.entrySet();
   	 		for(Map.Entry<String,String> entry: entrys) {
   	 			System.out.println(entry.getKey()+"   "+entry.getValue());
   	 		}
    }
    
    public void display1(String year,String month) {
    	String pattern=year+"-"+month;
	   	JFrame frame=new JFrame("Java数据统计图");      //创建框架
	   	frame.setLayout(new GridLayout(2,2,10,10));
	   	ChartPanelform chart=new ChartPanelform();                //创建折线图对象
	   	chart.title=year+"年"+month+"月股价";
	   	chart.y="股价（元）";
	   	Map<String,String> a=D.reflect("daytime", "[最高价(元)]");
	   	Map<String,String> b=D.reflect("daytime", "[最低价(元)]");
	   	Map<String,String> c=D.reflect("daytime", "[开盘价(元)]");
	   	Map<String,String> d=D.reflect("daytime", "[收盘价(元)]");
	   	Set<Map.Entry<String,String>> A=a.entrySet();
	   	Set<Map.Entry<String,String>> B=b.entrySet();
	   	Set<Map.Entry<String,String>> C=c.entrySet();
	   	Set<Map.Entry<String,String>> D=d.entrySet();
	   	for(Map.Entry<String,String> entry:A) {
	   		if(entry.getKey().contains(pattern)) {
	   			chart.dataset.addValue(Double.parseDouble(entry.getValue()),
	   					"最高价", entry.getKey().substring(8));
	   		}
	   	}
	   	for(Map.Entry<String,String> entry:B) {
	   		if(entry.getKey().contains(pattern)) {
	   			chart.dataset.addValue(Double.parseDouble(entry.getValue()),
	   					"最低价", entry.getKey().substring(8));
	   		}
	   	}
	   	for(Map.Entry<String,String> entry:C) {
	   		if(entry.getKey().contains(pattern)) {
	   			chart.dataset.addValue(Double.parseDouble(entry.getValue()),
	   					"开盘价", entry.getKey().substring(8));
	   		}
	   	}
	   	for(Map.Entry<String,String> entry:D) {
	   		if(entry.getKey().contains(pattern)) {
	   			chart.dataset.addValue(Double.parseDouble(entry.getValue()),
	   					"收盘价", entry.getKey().substring(8));
	   		}
	   	}
	   	frame.add(chart.getChartPanel());           
	   	frame.setBounds(100, 50, 800, 600);
	   	frame.setVisible(true);
    }
    
    public Map<String,String> a;
    public String s;
    public void display2(String year,String month) {
    	a=D.reflect("daytime", "[总股本(股)]");
    	Set<String> key = a.keySet();
    	for (Iterator<String> it = key.iterator(); it.hasNext();) {
    		s = it.next();
    		//System.out.println(s+":"+a.get(s));
    	}
    }
    
    public void display3(String year,String month) {
    	a=D.reflect("daytime", "[成交金额(元)]");
    	Set<String> key = a.keySet();
    	for (Iterator<String> it = key.iterator(); it.hasNext();) {
    		s = it.next();
    		//System.out.println(s+":"+a.get(s));
    	}
    }
    public void display4(String year,String month) {
    	D.calculate(year, month);
    }
}
