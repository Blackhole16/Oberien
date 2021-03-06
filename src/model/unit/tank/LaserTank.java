package model.unit.tank;

import model.Layer;
import model.Type;
import model.player.Player;

public class LaserTank extends Tank {

	public LaserTank(Player player) {
		super("Laser Tank", Type.Tank, 65, player, 
				25, 50, 3,
				150, 5, 20, 7,
				7, true, false, false, false, false, Layer.Ground,
				95, 99, 2, Type.Robot);
	}
	
	@Override
	public String getDescription() {
		return "<html><body><h4>" + getName() + "</h4>"
				+ "Type: " + getType() + "<br>"
				+ "Costs " + getCostMoney() + " money, " + getCostEnergy() + " energy, " + getCostPopulation() + " population<br>"
				+ "HP: " + getMaxLife() + "<br>Defense: " + getDefense() + "<br>Viewrange: " + getViewRange() + "<br>"
				+ "Movespeed: " + getMovespeed() + "<br>Can move on (Ground/Water/Air/Underground/Underwater): " + isMoveGround() + "/" + isMoveWater() + "/"
				+ isMoveAir() + "/" + isMoveUnderground() + "/" + isMoveUnderwater() + "<br>Standard layer: " + getDefaultLayer() + "<br>"
				+ "Damage: " + getDamage() + "<br>Strikechance: " + getStrike() + "%<br>Attackrange: " + getAttackRange() + "<br>Strong against: " + getStrongAgainst() + "<br><br>"
				+ "<i>Laz0r tanks for even more laz0rs in this game.</i></body></html>";
	}


}
