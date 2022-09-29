package patron.singleton;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Coins " + Coin.getInstance().getCoin());
		
		Coin.getInstance().addMoreCoin();
		System.out.println("Coins " + Coin.getInstance().getCoin());
		
		Coin.getInstance().addMoreCoin();
		System.out.println("Coins " + Coin.getInstance().getCoin());
		
		Coin.getInstance().deductCoin();
		System.out.println("Coins " + Coin.getInstance().getCoin());
	}

}
