package formdata;

import java.awt.GridLayout;
import javax.swing.JFrame;


public class resultform {
	public static void main(String args[]){
		JFrame frame=new JFrame("Java����ͳ��ͼ");
		frame.setLayout(new GridLayout(2,2,10,10));
		frame.add(new ChartPanelform().getChartPanel());           //�������ͼ
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
	}
}
