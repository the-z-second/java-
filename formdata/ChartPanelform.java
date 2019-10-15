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
       		                 title, // 图表标题
                            "daytime", // 目录轴
                            y, // 数值轴
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,15));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,15));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        frame1=new ChartPanel(chart,true);       
	}
	public ChartPanel getChartPanel(){
		borechart();
		return frame1;
	}
}
