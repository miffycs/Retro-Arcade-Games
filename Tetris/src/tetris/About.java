package tetris;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame {
	
	private GroupLayout layout;
	private JLabel projectTitle;
	private JLabel projectID;
	private JLabel className;
	private JLabel author;
	private JButton exit;
	
	public About() {
		initComponents();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("About");
		getContentPane().setLayout(layout);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initComponents() {
		initLabels();
		initButtons();
		initLayout();
	}
	
	private void initLabels() {
		projectTitle = new JLabel("Tetris");
		projectTitle.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		projectID = new JLabel("CS622 Final Project");
		projectID.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		className = new JLabel("Advance Programming in Java");
		className.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		author = new JLabel("by Miffy Chen © 2019");
		author.setFont(new Font("Lucida Grande", Font.BOLD, 20));
	}
	
	private void initButtons() {
		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});
	}
	
	private void initLayout() {
		
		layout = new GroupLayout(getContentPane());
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup().addGap(400))
						.addGroup(layout.createSequentialGroup().addComponent(projectTitle))
						.addGroup(layout.createSequentialGroup().addComponent(projectID))
						.addGroup(layout.createSequentialGroup().addComponent(className))
						.addGroup(layout.createSequentialGroup().addComponent(author))
						.addGroup(layout.createSequentialGroup().addComponent(exit)));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup().addGap(30)
						.addComponent(projectTitle).addGap(20)
						.addComponent(projectID).addGap(20)
						.addComponent(className).addGap(20)
						.addComponent(author).addGap(20)
						.addComponent(exit).addGap(30)));
	}

	private void exitActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
	public static void main(String args[]) {
		
		/*
		// Creating a frame
	    JFrame frame = new JFrame("Example");
	    // Setting the position and the size of the frame
	    frame.setBounds(0,0,800,600);
	    // This will terminate the program when closing the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // Then you can display your frame
	    frame.setVisible(true);
	    */
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new About().setVisible(true);
			}
		});
	}
	
}