package model.unit.recon;

import model.Layer;
import model.Type;
import model.player.Player;

public class Spy extends Recon {

	public Spy(Player player) {
		super("Spy", Type.Recon, 96, player, 
				20, 5, 1,
				1, 0, 0, 30,
				15, true, false, false, false, false, Layer.Ground,
				0, 0, 0, null);
	}

}
