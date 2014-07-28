package model.building.resourceCollector;

import model.Layer;
import model.Player;
import model.Type;

public class Windmill extends ResourceCollector {

	public Windmill(Player player) {
		super("Windmill", Type.RescourceCollector, 260, player, 
				250, 50, 2, 
				100, 0, 2, 
				0, true, false, false, false, false, Layer.Ground, 
				0, 10, 0);
	}
}