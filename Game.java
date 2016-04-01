package blackJack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;

public class Game {

	private JFrame frmBlackjack;
	private JTextField bankDisplay;
	private JTextField playerScoreDisplay;

	/**
	 * Launch the application.
	 */
	
	Deck n = new Deck();
	Player one = new Player();
	Card drawn = new Card();
	private JTextField potDisplay;
	int pot = 0;
	int score = 0;
	int dscore = 0;
	private JTextField dealerScoreDisplay;
	private JTextField winlose;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frmBlackjack.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlackjack = new JFrame();
		frmBlackjack.setTitle("BlackJack by NRG");
		frmBlackjack.setBounds(100, 100, 450, 300);
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjack.getContentPane().setLayout(null);
		
		final JButton hit = new JButton("Hit");
		hit.setEnabled(false);
		
		hit.setBounds(6, 225, 117, 29);
		frmBlackjack.getContentPane().add(hit);
		
		final JButton stay = new JButton("Stay");
		
		stay.setEnabled(false);
		stay.setBounds(124, 225, 117, 29);
		frmBlackjack.getContentPane().add(stay);
		
		bankDisplay = new JTextField();
		bankDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		bankDisplay.setBounds(352, 223, 78, 30);
		frmBlackjack.getContentPane().add(bankDisplay);
		bankDisplay.setColumns(10);
		bankDisplay.setText(Integer.toString(one.getTotal()));
		JLabel lblBank = new JLabel("Bank:");
		lblBank.setBounds(352, 208, 61, 16);
		frmBlackjack.getContentPane().add(lblBank);
		
		playerScoreDisplay = new JTextField();
		playerScoreDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		playerScoreDisplay.setText("0");
		playerScoreDisplay.setBounds(253, 223, 82, 30);
		frmBlackjack.getContentPane().add(playerScoreDisplay);
		playerScoreDisplay.setColumns(10);
		
		JLabel lblTotal = new JLabel("Score:");
		lblTotal.setBounds(253, 208, 61, 16);
		frmBlackjack.getContentPane().add(lblTotal);
		
		final JButton bet5 = new JButton("5");
		bet5.setBounds(6, 169, 117, 29);
		frmBlackjack.getContentPane().add(bet5);
		
		final JButton bet10 = new JButton("10");
		
		bet10.setBounds(124, 169, 117, 29);
		frmBlackjack.getContentPane().add(bet10);
		
		final JButton bet25 = new JButton("25");
		
		bet25.setBounds(248, 169, 117, 29);
		frmBlackjack.getContentPane().add(bet25);
		
	
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(160, 37, -105, 42);
		frmBlackjack.getContentPane().add(textArea);
		
		final JTextPane playerDisplay = new JTextPane();
		playerDisplay.setBounds(6, 27, 117, 130);
		frmBlackjack.getContentPane().add(playerDisplay);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(6, 6, 61, 16);
		frmBlackjack.getContentPane().add(lblPlayer);
		
		final JTextPane dealerDisplay = new JTextPane();
		dealerDisplay.setBounds(304, 27, 117, 98);
		frmBlackjack.getContentPane().add(dealerDisplay);
		
		JLabel lblDealer = new JLabel("Dealer");
		lblDealer.setBounds(304, 6, 61, 16);
		frmBlackjack.getContentPane().add(lblDealer);
		
		potDisplay = new JTextField();
		potDisplay.setEditable(false);
		potDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		potDisplay.setText("0");
		potDisplay.setBounds(135, 129, 134, 28);
		frmBlackjack.getContentPane().add(potDisplay);
		potDisplay.setColumns(10);
		
		JLabel lblPot = new JLabel("Pot:");
		lblPot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPot.setBounds(169, 111, 61, 16);
		frmBlackjack.getContentPane().add(lblPot);
		
		dealerScoreDisplay = new JTextField();
		dealerScoreDisplay.setBounds(368, 137, 62, 29);
		frmBlackjack.getContentPane().add(dealerScoreDisplay);
		dealerScoreDisplay.setColumns(10);
		
		JLabel lblDealerScore = new JLabel("Dealer Score:");
		lblDealerScore.setBounds(281, 143, 84, 16);
		frmBlackjack.getContentPane().add(lblDealerScore);
		
		winlose = new JTextField();
		winlose.setEnabled(false);
		winlose.setEditable(false);
		winlose.setBounds(135, 37, 134, 28);
		frmBlackjack.getContentPane().add(winlose);
		winlose.setColumns(10);
		
		JButton reset = new JButton("New Game");
		
		reset.setBounds(157, 77, 84, 16);
		frmBlackjack.getContentPane().add(reset);
		
		bet5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				one.withdraw(5);
				pot = 5;
				potDisplay.setText("5");
				n.shuffle();
				bankDisplay.setText(Integer.toString(one.getTotal()));
				bet5.setEnabled(false);
				bet10.setVisible(false);
				bet25.setVisible(false);
				hit.setEnabled(true);
				stay.setEnabled(true);
				
			}
		});
		
		bet10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				one.withdraw(10);
				pot = 10;
				potDisplay.setText("10");
				n.shuffle();
				bankDisplay.setText(Integer.toString(one.getTotal()));
				bet10.setEnabled(false);
				bet5.setVisible(false);
				bet25.setVisible(false);
				hit.setEnabled(true);
				stay.setEnabled(true);
			}
		});
		
		bet25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				one.withdraw(25);
				pot = 25;
				potDisplay.setText("25");
				n.shuffle();
				bankDisplay.setText(Integer.toString(one.getTotal()));
				bet25.setEnabled(false);
				bet5.setVisible(false);
				bet10.setVisible(false);
				hit.setEnabled(true);
				stay.setEnabled(true);
			}
		});
		
		hit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawn = n.draw();
				if(drawn.getRank() > 9){
					score = score + 10;
				}
				else{
					score = score + drawn.getRank();
				}
				playerScoreDisplay.setText(Integer.toString(score));
				
				try {
					playerDisplay.getDocument().insertString(0, "\n", null);
					playerDisplay.getDocument().insertString(0,drawn.toString(), null);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(score > 21){
				winlose.setText("Bust! You Lose");
				bet5.setVisible(false);
				bet10.setVisible(false);
				bet25.setVisible(false);
				hit.setVisible(false);
				stay.setVisible(false);
			}
			}
		});
		
		stay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (dscore < score | dscore < 21){
					drawn = n.draw();
					
					try{
						dealerDisplay.getDocument().insertString(0,  "\n" + drawn.toString(), null);
					}
					catch(BadLocationException e1){
						e1.printStackTrace();
					}
					if(drawn.getRank() > 9){
						dscore = dscore + 10;
					}
					else{
						dscore = dscore + drawn.getRank();
					}
					dealerScoreDisplay.setText(Integer.toString(dscore));
				}
				if(dscore > score && dscore <= 21){
					winlose.setText("You Lose!");
					bet5.setVisible(false);
					bet10.setVisible(false);
					bet25.setVisible(false);
					hit.setVisible(false);
					stay.setVisible(false);
				
					
				}
				else if(score == dscore){
					one.deposit(pot);
					bankDisplay.setText(Integer.toString(one.getTotal()));
					winlose.setText("Push!");
					bet5.setVisible(false);
					bet10.setVisible(false);
					bet25.setVisible(false);
					hit.setVisible(false);
					stay.setVisible(false);
				}
				else{
					one.deposit(pot * 2);
					bankDisplay.setText(Integer.toString(one.getTotal()));
					winlose.setText("You Win!");
					bet5.setVisible(false);
					bet10.setVisible(false);
					bet25.setVisible(false);
					hit.setVisible(false);
					stay.setVisible(false);
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pot = 0;
				potDisplay.setText(Integer.toString(pot));
				playerDisplay.setText("");
				dealerDisplay.setText("");
				bet5.setVisible(true);
				bet10.setVisible(true);
				bet25.setVisible(true);
				hit.setVisible(true);
				stay.setVisible(true);
				hit.setEnabled(false);
				stay.setEnabled(false);
				bet5.setEnabled(true);
				bet10.setEnabled(true);
				bet25.setEnabled(true);
				score = 0;
				dscore = 0;
				playerScoreDisplay.setText("0");
				dealerScoreDisplay.setText("0");
				winlose.setText("");
				
			}
		});
	}
}
