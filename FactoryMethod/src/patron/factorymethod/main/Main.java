package patron.factorymethod.main;

import patron.factorymethod.abstracta.MazeGame;
import patron.factorymethod.clases.mazegame.MagicMazeGame;
import patron.factorymethod.clases.mazegame.OrdinaryMazeGame;

public class Main {

	public static void main(String[] args) {
		MazeGame ordinaryGame = new OrdinaryMazeGame();
		MazeGame magicGame = new MagicMazeGame();

	}
	
}
