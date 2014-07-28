package model.unit.infantry;

import model.Layer;
import model.Player;
import model.Type;

public class Sharpshooter extends Infantry {

	public Sharpshooter(Player player) {
		super("Sharpshooter", Type.Infantry, 3 ,player, 
				100, 35, 1, 
				50, 1, 2, 5,
				1, true, false, false, false, false, Layer.Ground,
				100, 5, 5, Type.Infantry);
		
	}

}