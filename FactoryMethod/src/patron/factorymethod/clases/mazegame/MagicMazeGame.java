package patron.factorymethod.clases.mazegame;

import patron.factorymethod.abstracta.MazeGame;
import patron.factorymethod.abstracta.Room;
import patron.factorymethod.clases.room.MagicRoom;

public class MagicMazeGame extends MazeGame {
	/*
	 * {En BD esta sería la conexión o podría ser los DAO. 
	 * Por ejemplo la conexión a
	 * Derby}
	 */
	@Override
	protected Room makeRoom() {
		// #regionfactorymethod
		return new MagicRoom();
		// #endregion
	}
}