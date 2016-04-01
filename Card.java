package blackJack;

public class Card {

	private int rank;
	private char suit;
	
	public Card(int r, char s){
		rank = r;
		suit = s;
	}
	
	public Card(){
		rank = 1;
		suit = 's';
	}
	
	public char getSuit(){
		return suit;
	}
	
	public int getRank(){
		return rank;
	}
	
	public String toString(){
		return "Card:" + suit + " " + rank;
	}
	
}
