import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {
	public JPanel contentPane;
	public JTextArea pane;
	public JScrollPane scroll;
	

	public JTextField AWT;
	public JTextField AST;
	public JTextField PT;

	public JLabel AWTL;
	public JLabel ASTL;
	public JLabel PTL;



	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(200, 20, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pane = new JTextArea();
		pane.setBounds(20, 20, 500, 700);
		pane.setEditable(false);
		scroll=new JScrollPane(pane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(20, 20, 500, 700);
		scroll.setVisible(true);
		contentPane.add(scroll);
		
		AWT = new JTextField();
		AWT.setBounds(700, 400, 70, 20);
		contentPane.add(AWT);

		AST = new JTextField();
		AST.setBounds(700, 430, 70, 20);
		contentPane.add(AST);

		PT = new JTextField();
		PT.setBounds(700, 460, 70, 20);
		contentPane.add(PT);
		
		AWTL = new JLabel("Average Waiting Time:");
		AWTL.setBounds(550, 400, 200, 20);
		contentPane.add(AWTL);

		ASTL = new JLabel("Average Service Time:");
		ASTL.setBounds(550, 430, 200, 20);
		contentPane.add(ASTL);

		PTL = new JLabel("Peak Time:");
		PTL.setBounds(550, 460, 200, 20);
		contentPane.add(PTL);

		
	}
	public void setAverageWaitingTime(double x) {
		String s = String.valueOf(x);
		AWT.setText(s);
	}

	public void setAverageServiceTime(float x) {
		String s = String.valueOf(x);
		AST.setText(s);
	}

	public void setPeakTime(int x) {
		String s = String.valueOf(x);
		PT.setText(s);
	}
	
	
	public void setLogs(String s) {
		String str=new String("");
		str=pane.getText()+s;
		pane.setText(str);
	}

	public String text() {
		String str=new String("");
		str=pane.getText();
		return str;
	}

}
