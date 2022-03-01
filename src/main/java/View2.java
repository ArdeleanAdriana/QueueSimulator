import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class View2  extends JFrame{
	public JPanel contentPane;
	private static JFrame content=new JFrame("View");

	
	public JLabel minATL;
	public JLabel maxATL;
	public JLabel minPTL;
	public JLabel maxPTL;
	public JLabel nrCL;
	public JLabel nrQL;
	public JLabel simTL;


	public JTextField minAT;
	public JTextField maxAT;
	public JTextField minPT;
	public JTextField maxPT;
	public JTextField nrC;
	public JTextField nrQ;
	public JTextField simT;

	public JButton start;

	public View2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 20, 300, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	

		start = new JButton("Start");
		start.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		start.setBounds(100, 250, 70, 20);
		contentPane.add(start);

		minATL = new JLabel("Min Arrival Time:");
		minATL.setBounds(10, 20, 200, 20);
		contentPane.add(minATL);

		maxATL = new JLabel("Max Arrival Time:");
		maxATL.setBounds(10, 50, 200, 20);
		contentPane.add(maxATL);

		minPTL = new JLabel("Min Processing Time:");
		minPTL.setBounds(10, 80, 200, 20);
		contentPane.add(minPTL);

		maxPTL = new JLabel("Max Processing Time:");
		maxPTL.setBounds(10, 110, 200, 20);
		contentPane.add(maxPTL);

		nrCL = new JLabel("Nr clients:");
		nrCL.setBounds(10, 140, 200, 20);
		contentPane.add(nrCL);

		nrQL = new JLabel("Nr Queues:");
		nrQL.setBounds(10, 170, 200, 20);
		contentPane.add(nrQL);

		simTL = new JLabel("Simulatian Time:");
		simTL.setBounds(10, 200, 200, 20);
		contentPane.add(simTL);

		minAT = new JTextField();
		minAT.setBounds(160, 20, 70, 20);
		contentPane.add(minAT);

		maxAT = new JTextField();
		maxAT.setBounds(160, 50, 70, 20);
		contentPane.add(maxAT);

		minPT = new JTextField();
		minPT.setBounds(160, 80, 70, 20);
		contentPane.add(minPT);

		maxPT = new JTextField();
		maxPT.setBounds(160, 110, 70, 20);
		contentPane.add(maxPT);

		nrC = new JTextField();
		nrC.setBounds(160, 140, 70, 20);
		contentPane.add(nrC);

		nrQ = new JTextField();
		nrQ.setBounds(160, 170, 70, 20);
		contentPane.add(nrQ);

		simT = new JTextField();
		simT.setBounds(160, 200, 70, 20);
		contentPane.add(simT);


	}

	public JButton getStart() {
		return start;
	}

	public String minArrTime() {
		return minAT.getText();
	}

	public String maxArrTime() {
		return maxAT.getText();
	}

	public String minProcTime() {
		return minPT.getText();
	}

	public String maxProcTime() {
		return maxPT.getText();
	}

	public String nrClients() {
		return nrC.getText();
	}

	public String nrQueues() {
		return nrQ.getText();
	}

	public String simulationTime() {
		return simT.getText();
	}

	public static void showError(String errMessage)
	{
		JOptionPane.showMessageDialog(content, errMessage);
	}




}
