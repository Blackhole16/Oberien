package util;

import controller.MyHashMap;
import model.Model;
import model.map.Coordinate;
import model.player.Player;

import java.io.Serializable;

public class SerializableState implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mapName;
	private String winConditionName;
	private Player[] players;
	private int currentPlayerIndex;
	private int round;
	private MyHashMap<Coordinate, Model> models;
	private MyHashMap<Model, Coordinate[]> viewranges;
	private MyHashMap<Model, Coordinate[]> moveranges;
	private MyHashMap<Model, Coordinate[]> fullAttackranges;
	private MyHashMap<Model, Coordinate[]> directAttackranges;
	private MyHashMap<Model, Coordinate[]> buildranges;
	
	public SerializableState(String mapName, String winConditionName, Player[] players,
			int currentPlayerIndex, int round,
			MyHashMap<Coordinate, Model> models,
			MyHashMap<Model, Coordinate[]> viewrange,
			MyHashMap<Model, Coordinate[]> moverange,
			MyHashMap<Model, Coordinate[]> fullAttackrange,
			MyHashMap<Model, Coordinate[]> directAttackrange,
			MyHashMap<Model, Coordinate[]> buildrange) {
		super();
		this.mapName = mapName;
		this.winConditionName = winConditionName;
		this.players = players;
		this.currentPlayerIndex = currentPlayerIndex;
		this.round = round;
		this.models = models;
		this.viewranges = viewrange;
		this.moveranges = moverange;
		this.fullAttackranges = fullAttackrange;
		this.directAttackranges = directAttackrange;
		this.buildranges = buildrange;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMapName() {
		return mapName;
	}

	public String getWinConditionName() {
		return winConditionName;
	}

	public Player[] getPlayers() {
		return players;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public int getRound() {
		return round;
	}

	public MyHashMap<Coordinate, Model> getModels() {
		return models;
	}

	public MyHashMap<Model, Coordinate[]> getViewranges() {
		return viewranges;
	}

	public MyHashMap<Model, Coordinate[]> getMoveranges() {
		return moveranges;
	}

	public MyHashMap<Model, Coordinate[]> getFullAttackranges() {
		return fullAttackranges;
	}

	public MyHashMap<Model, Coordinate[]> getDirectAttackranges() {
		return directAttackranges;
	}

	public MyHashMap<Model, Coordinate[]> getBuildranges() {
		return buildranges;
	}
	
	
}