package blackJack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	public Deck(){
		char s = ' ';
		for(int i = 0; i < 4; i++){
			if (i == 0){
				s = 'h';
			}
			else if (i == 1){
				s = 'd';
			}
			else if (i ==2){
				s = 's';
			}
			else if (i == 3){
				s = 'c';
			}
			
			for (int j = 1; j < 14; j++){
				Card n = new Card(j,s);
				deck.add(n);
			}
		}
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	public Card draw(){
		Card temp = new Card();
		temp = deck.get(0);
		deck.remove(0);
		return temp;
	}
	/*public static void main(String[] args) {
		Deck one = new Deck();
		
		System.out.println(one.deck.size());
		
		one.shuffle();
		for (int i = 0; i < one.deck.size(); i++){
			System.out.println(one.deck.get(i));
		}
	}*/

}
