package model.building.producing;

import model.Layer;
import model.Model;
import model.Player;
import model.Type;
import model.building.Building;

public class Producing extends Building {
	private Type builds;
	private int buildSpeed;
	private int buildRange;
	
	private Model currentBuilding;
	
	public Producing(String name, Type type, int id, Player player,
			int costMoney, int costEnergy, int costPopulation, 
			int maxLife, int defense, int viewrange, 
			int movespeed, boolean moveGround, boolean moveWater, boolean moveAir, boolean moveUnderground, boolean moveUnderwater, Layer defaultLayer,
			Type builds, int buildSpeed, int buildRange) {
		super(name, type, id, player, 
				costMoney, costEnergy, costPopulation,
				maxLife, defense, viewrange, 
				movespeed, moveGround, moveWater, moveAir, moveUnderground, moveUnderwater, defaultLayer);
		this.builds = builds;
		this.buildSpeed = buildSpeed;
		this.buildRange = buildRange;
		this.currentBuilding = null;
	}
	
	public Type getBuilds() {
		return builds;
	}

	public int getBuildSpeed() {
		return buildSpeed;
	}

	public int getBuildRange() {
		return buildRange;
	}
	
	public Model getCurrentBuilding() {
		return currentBuilding;
	}
	
	public void setCurrentBuilding(Model m) {
		this.currentBuilding = m;
	}
}