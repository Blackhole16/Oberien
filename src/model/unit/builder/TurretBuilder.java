package model.unit.builder;

import model.Layer;
import model.Type;
import model.player.Player;

public class TurretBuilder extends Builder {

	public TurretBuilder(Player player) {
		super("Turret Builder", Type.Builder, 771, player, 
				25, 25, 1,
				10, 0, 0, 3,
				8, true, false, false, false, false, Layer.Ground, 
				Type.Turret, 5, 1);
	}
	
	@Override
	public String getDescription() {
		return "<html><body><h4>" + getName() + "</h4>"
				+ "Type: " + getType() + "<br>"
				+ "Costs " + getCostMoney() + " money, " + getCostEnergy() + " energy, " + getCostPopulation() + " population<br>"
				+ "HP: " + getMaxLife() + "<br>Defense: " + getDefense() + "<br>Viewrange: " + getViewRange() + "<br>"
				+ "Movespeed: " + getMovespeed() + "<br>Can move on (Ground/Water/Air/Underground/Underwater): " + isMoveGround() + "/" + isMoveWater() + "/"
				+ isMoveAir() + "/" + isMoveUnderground() + "/" + isMoveUnderwater() + "<br>Standard layer: " + getDefaultLayer() + "<br>"
				+ "Builds: " + getBuilds() + "<br>Buildspeed: " + getBuildSpeed() + "<br>Buildrange: " + getBuildRange() + "<br><br>"
				+ "<i>Builds Turrets.</i></body></html>";
	}
	
}
