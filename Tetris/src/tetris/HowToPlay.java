package tetris;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class HowToPlay extends JFrame {

    private GroupLayout layout;
    private JLabel title;
    private JLabel desc;
    private JLabel controls;
    private JTable controlsTable;
    private JScrollPane scrollPane;
    private JButton back;

    public HowToPlay() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("How To Play");
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
        title = new JLabel("How To Play");
        title.setFont(new Font("Lucida Grande", Font.BOLD, 30));

        desc = new JLabel("<html>"
                + "Tetriminos, shapes made up of 4 blocks of squares blocks,<br>"
                + "&nbsp &nbsp will fall in a random sequence from the top of the board all the way down.<br>"
                + "<br>"
                + "Move the shapes sideways, rotate, or drop them to form a horizontal line<br>"
                + "&nbsp &nbsp with no gaps to clear the line.<br>"
                + "<br>"
                + "Players are awarded <b>1 point per lines cleared</b>."
                + "</html>");
        desc.setHorizontalAlignment(SwingConstants.CENTER);
        desc.setHorizontalTextPosition(SwingConstants.CENTER);

        controls = new JLabel("Controls");
        controls.setFont(new Font("Lucida Grande", Font.BOLD, 26));

        String[] columnNames = {"Function", "Key"};
        String[][] data = {
            {"   Move Left", "←"},
            {"   Move Right", "→"},
            {"   Rotate Piece", "↑"},
            {"   Move Down", "↓"},
            {"   Drop Piece", "[space]"},
            {"   Pause Game", "p"}
        };
        controlsTable = new JTable(data, columnNames);
        controlsTable.setFillsViewportHeight(true);
        JTableHeader tableHeader = controlsTable.getTableHeader();
        tableHeader.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        ((DefaultTableCellRenderer) tableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        controlsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        scrollPane = new JScrollPane(controlsTable);
        scrollPane.setPreferredSize(new Dimension(200, 100));
    }

    private void initButtons() {
        back = new JButton("Back");
        back.addActionListener((ActionEvent evt) -> {
            exitActionPerformed(evt);
        });
    }

    private void initLayout() {

        layout = new GroupLayout(getContentPane());

        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.CENTER)
                .addGap(600)
                .addComponent(title)
                .addComponent(desc)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                .addComponent(back)
                .addComponent(controls)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addGap(30)
                        .addComponent(title)
                        .addGap(20)
                        .addComponent(desc)
                        .addGap(30)
                        .addComponent(controls)
                        .addGap(10)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(20)
                        .addComponent(back)
                        .addGap(30))
        );

    }

    private void exitActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new HowToPlay().setVisible(true);
        });
    }
}
