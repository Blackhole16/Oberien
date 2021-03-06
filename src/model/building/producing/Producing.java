package model.building.producing;

import model.BuildingModel;
import model.Layer;
import model.Model;
import model.Type;
import model.building.Building;
import model.player.Player;

public class Producing extends Building implements BuildingModel {
	private Type builds;
	private int buildSpeed;
	private int buildRange;
	
	private Model currentBuilding;
	
	public Producing(String name, Type type, int id, Player player,
			int costMoney, int costEnergy, int costPopulation, 
			int maxLife, int defense, int viewRange,
			Type builds, int buildSpeed, int buildRange, Layer defaultLayer) {
		super(name, type, id, player, 
				costMoney, costEnergy, costPopulation,
				maxLife, defense, viewRange, defaultLayer);
		this.builds = builds;
		this.buildSpeed = buildSpeed;
		this.buildRange = buildRange;
		this.currentBuilding = null;
	}

	@Override
	public Type getBuilds() {
		return builds;
	}

	@Override
	public int getBuildSpeed() {
		return buildSpeed;
	}

	@Override
	public int getBuildRange() {
		return buildRange;
	}

	@Override
	public Model getCurrentBuilding() {
		return currentBuilding;
	}

	@Override
	public void setCurrentBuilding(Model m) {
		this.currentBuilding = m;
	}
}
