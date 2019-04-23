package tetris;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class About extends JFrame {

    // variables
    private GroupLayout layout;
    private JLabel projectTitle;
    private JLabel projectID;
    private JLabel className;
    private JLabel author;
    private JButton exit;

    // constructor
    public About() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        getContentPane().setLayout(layout);
        pack();
        setLocationRelativeTo(null);
    }

    // initialize components
    private void initComponents() {
        initLabels();
        initButtons();
        initLayout();
    }

    // set labels
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

    // set buttons
    private void initButtons() {
        exit = new JButton("Exit");
        exit.addActionListener((ActionEvent evt) -> {
            exitActionPerformed(evt);
        });
        /*
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        */
    }

    // set layout
    private void initLayout() {
        layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup().addGap(400))
                        .addGroup(layout.createSequentialGroup().addComponent(projectTitle))
                        .addGroup(layout.createSequentialGroup().addComponent(projectID))
                        .addGroup(layout.createSequentialGroup().addComponent(className))
                        .addGroup(layout.createSequentialGroup().addComponent(author))
                        .addGroup(layout.createSequentialGroup().addComponent(exit))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup().addGap(30)
                                .addComponent(projectTitle).addGap(20)
                                .addComponent(projectID).addGap(20)
                                .addComponent(className).addGap(20)
                                .addComponent(author).addGap(20)
                                .addComponent(exit).addGap(30))
        );
    }

    // exit application
    private void exitActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    // run application
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new About().setVisible(true);
        });
        /*
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new About().setVisible(true);
            }
        });        
        */
    }

}
