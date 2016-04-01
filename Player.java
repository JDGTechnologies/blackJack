package blackJack;

public class Player {
	private int total;
	
	public Player(){
		total = 100;
	}
	
	//when money respository can be set
	/*public Player(int money){
		total = money;
	}*/
	public int getTotal(){
		return total;
	}
	
	public void withdraw(int amount){
		total = total - amount;
	}
	public void deposit(int amount){
		total = total + amount;
	}
}
