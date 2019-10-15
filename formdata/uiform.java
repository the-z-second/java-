package formdata;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

import bus.UserBUS;
import dao.UserDAO;
import javax.swing.JTextArea;

public class uiform extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public UserBUS u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uiform frame = new uiform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public uiform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 10, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u5E74");
		label.setBounds(86, 13, 58, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6708");
		label_1.setBounds(182, 13, 58, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(106, 10, 66, 21);
		contentPane.add(textField);
		
		JTextArea textArea = new JTextArea(); 
		JScrollPane scroll = new JScrollPane(textArea); 
		scroll.setBounds(139, 38, 267, 215);
		textArea.setBounds(139, 38, 267, 215);
		contentPane.add(scroll);

		
		JButton btnNewButton = new JButton("查询股价信息");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBUS user=new UserBUS();
				String temp=textField_1.getText().trim();
				String temp2=textField.getText().trim();
				if(temp2.length()==1)temp2="0"+temp2;
				UserBUS u=new UserBUS();
				//user.openconnection();
				u.display1(temp, temp2);
			}
		});
		btnNewButton.setBounds(10, 80, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查询总股本");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp=textField_1.getText().trim();
				String temp2=textField.getText().trim();
				if(temp2.length()==1)temp2="0"+temp2;
				UserBUS u=new UserBUS();
				u.display2(temp, temp2);
				Set<String> key = u.a.keySet();
				for (Iterator<String> it = key.iterator(); it.hasNext();) {
		    		u.s = it.next();
		    		textArea.append("日期:"+u.s+" 总股本(股):"+u.a.get(u.s)+"\r\n");
		    	}
			}
		});
		btnNewButton_1.setBounds(10, 124, 110, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查询成交金额");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp=textField_1.getText().trim();
				String temp2=textField.getText().trim();
				if(temp2.length()==1)temp2="0"+temp2;
				UserBUS u=new UserBUS();
				u.display3(temp, temp2);
				Set<String> key = u.a.keySet();
				for (Iterator<String> it = key.iterator(); it.hasNext();) {
		    		u.s = it.next();
		    		textArea.append("日期:"+u.s+" 成交金额(元):"+u.a.get(u.s)+"\r\n");
		    	}
			}
		});
		btnNewButton_2.setBounds(10, 178, 110, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("计算上证指数");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp=textField_1.getText().trim();
				String temp2=textField.getText().trim();
				if(temp2.length()==1)temp2="0"+temp2;
				UserBUS u=new UserBUS();
				u.display4(temp, temp2);
				double finum=new UserDAO().calculate(temp, temp2);
				textArea.append(finum+"");
			}
		});
		btnNewButton_3.setBounds(10, 230, 110, 23); 
		contentPane.add(btnNewButton_3);
	}
}
