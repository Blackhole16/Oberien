package model.building.resourceCollector;

import model.Layer;
import model.Player;
import model.Type;

public class HamsterWheel extends ResourceCollector {

	public HamsterWheel(Player player) {
		super("Hamster Wheel", Type.RescourceCollector, 257, player, 
				2, 0, 0,
				5, 0, 1,
				0, true, false, false, false, false, Layer.Ground,
				0, 1, 0);
	}
}
