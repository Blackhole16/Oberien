package controller;

import org.newdawn.slick.Color;

import model.*;
import model.map.*;

public class Main {
	public static void main(String[] args) {
		Map map = MapList.getInstance().getMap("Test");
		String s = map.toString();
		System.out.println(map);
		State state = new State(MapList.getInstance().getCurrentMap(), new Player[]{new Player("BH16", Color.green, 0), new Player("Enemy", Color.red, 1)});
		Controller controller = new Controller(state);
		controller.addModel(9, 12, "Infantry");
		long time = System.currentTimeMillis();
		Coordinate[] c = state.getViewrange(new Coordinate(9, 12, Layer.Ground));
		System.out.println("time getSight: " + (System.currentTimeMillis()-time));
		for (Coordinate c1 : c) {
			System.out.println(c1);
		}
//		System.out.println(controller.getCurrentPlayer().getMoney());
//		System.out.println(controller.buildModel(new Coordinate(0, 2, Layer.Ground), 0, 1, 0));
//		controller.endTurn();
//		Coordinate[] c = controller.getModelPositionsInArea(controller.getSight());
//		System.out.println(controller.getModel(c[0]));
//		System.out.println(controller.getModel(c[2]).getCurrentBuilding());
//		int ret = controller.attack(c[0], c[2]);
//		System.out.println(ret);
//		System.out.println(controller.getModel(c[1]).getCurrentBuilding());
	}
}
