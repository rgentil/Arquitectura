package patron.singleton;

/*  Restringe la instanciación de una clase a una única instancia
 *	---> Provee consistencia para el resto de los objetos del sistema.
 *	---> En Java, se implementa normalmente con métodos de clase
 **/
public class Coin {
	/*
	 * {Crea de antemano cuando levanta el programa (forma eager) una variable la
	 * clase (instance) que será la única instancia de la clase. El constructor es
	 * privado para que no se creen más de una instancia (no se puede hacer new). A
	 * la instancia sólo se accede por medio del método getInstance(). Se puede ver
	 * como un objeto "variable global". Normalmente se usa para el gestor de la BD.
	 * }
	 */

	// FIELDS

	private static final int ADD_MORE_COIN = 10;
	
	private int coin;
	
	// #regionpatron
	private static Coin instance = new Coin(); // Eagerly loading of singleton instance

	// CONSTRUCTOR

	private Coin() {
		// private to prevent anyone else from instantiating
	}

	// METHODS

	// GETTERS & SETTERS

	public static Coin getInstance() {
		return instance;
	}

	// #endregion

	public int getCoin() {
		return coin;
	}

	public void addMoreCoin() {
		coin += ADD_MORE_COIN;
	}

	public void deductCoin() {
		coin--;
	}
}