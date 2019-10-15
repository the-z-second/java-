package formdata;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartPanelform {
	ChartPanel frame1;
	public String title;
	public String y;
	public DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	public void borechart(){
        JFreeChart chart = ChartFactory.createLineChart(
       		                 title, // ͼ�����
                            "daytime", // Ŀ¼��
                            y, // ��ֵ��
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,           // �Ƿ���ʾͼ��
                            false,          // �Ƿ����ɹ���
                            false           // �Ƿ�����URL����
                            );
        
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
        domainAxis.setLabelFont(new Font("����",Font.BOLD,15));         //ˮƽ�ײ�����
        domainAxis.setTickLabelFont(new Font("����",Font.BOLD,15));  //��ֱ����
        ValueAxis rangeAxis=plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
        frame1=new ChartPanel(chart,true);       
	}
	public ChartPanel getChartPanel(){
		borechart();
		return frame1;
	}
}
