package patron.factorymethod.clases.mazegame;

import patron.factorymethod.abstracta.MazeGame;
import patron.factorymethod.abstracta.Room;
import patron.factorymethod.clases.room.OrdinaryRoom;

public class OrdinaryMazeGame extends MazeGame {
	/*
	 * {En BD esta sería la conexión o podría ser los DAO. Por ejemplo la conexión a
	 * MySQL}
	 */
	@Override
	protected Room makeRoom() {
		// #regionfactorymethod
		return new OrdinaryRoom();
		// #endregion
	}
}
