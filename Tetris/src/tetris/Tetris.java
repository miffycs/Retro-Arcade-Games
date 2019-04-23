package tetris;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Tetris extends JFrame
{
	private JMenuBar menuBar;
	private Board gameBoard;
	
	public Tetris()
	{
		initComponents();
		
		setTitle("Tetris :: Miffy Chen © 2019");
		setSize(350, 850);
		setJMenuBar(menuBar);
		setLocationRelativeTo(null); // set window to center
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initComponents() {
		initMenuBar();
		initBoard();
	}
	
	private void initMenuBar() {
		menuBar = new JMenuBar();
		JMenu menu_game = new JMenu("Game");
		JMenuItem menu_game_newGame = new JMenuItem("New Game");
		JMenuItem menu_game_pauseGame = new JMenuItem("Pause Game");
		JMenuItem menu_game_exitGame = new JMenuItem("Exit Game");
		
		JMenu menu_help = new JMenu("Help");
		JMenuItem menu_help_about = new JMenuItem("About");
		JMenuItem menu_help_howToPlay = new JMenuItem("How to Play");

		menuBar.add(menu_game);
		menu_game.add(menu_game_newGame);
		menu_game.add(menu_game_pauseGame);
		menu_game.add(menu_game_exitGame);
		
		menu_game_newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				onClick_game_newGame(evt);
			}
		});
		
		menu_game_pauseGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				onClick_game_pauseGame(evt);
			}
			private void onClick_game_pauseGame(ActionEvent evt) {
				gameBoard.pause();
			}
		});
		
		menu_game_exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				onClick_game_exitGame(evt);
			}
		});
		
		menuBar.add(menu_help);
		menu_help.add(menu_help_about);
		menu_help.add(menu_help_howToPlay);
		
		menu_help_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				onClick_help_about(evt);
			}
			private void onClick_help_about(ActionEvent evt) {
				gameBoard.pause();
				new About().setVisible(true);
			}
		});

		menu_help_howToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				onClick_help_howToPlay(evt);
			}
			private void onClick_help_howToPlay(ActionEvent evt) {
				gameBoard.pause();
				new HowToPlay().setVisible(true);
			}
		});
	}
	
	private void onClick_game_newGame(ActionEvent evt) {
		this.dispose();
		new Tetris().setVisible(true);
	}
	
	private void onClick_game_exitGame(ActionEvent evt) {
		this.dispose();
	}
	
	private void initBoard() {
		gameBoard = new Board();
		getContentPane().add(gameBoard);
		getContentPane().add(gameBoard.getStatusBar(), BorderLayout.SOUTH);
		gameBoard.start();
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Tetris().setVisible(true);
			}
		});
	}
}