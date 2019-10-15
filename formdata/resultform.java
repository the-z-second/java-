package formdata;

import java.awt.GridLayout;
import javax.swing.JFrame;


public class resultform {
	public static void main(String args[]){
		JFrame frame=new JFrame("Java数据统计图");
		frame.setLayout(new GridLayout(2,2,10,10));
		frame.add(new ChartPanelform().getChartPanel());           //添加折线图
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
	}
}
