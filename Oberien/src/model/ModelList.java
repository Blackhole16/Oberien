package model;

import java.util.ArrayList;

import model.building.base.Base;
import model.building.producing.Barracks;
import model.building.producing.Factory;
import model.building.producing.SpyCenter;
import model.building.resourceCollector.HamsterWheel;
import model.building.resourceCollector.House;
import model.building.resourceCollector.NuclearReactor;
import model.building.resourceCollector.SolarCell;
import model.building.storage.BigStorage;
import model.building.storage.MediumStorage;
import model.building.storage.SmallStorage;
import model.building.turret.GatlingGun;
import model.building.turret.LaserCannon;
import model.unit.builder.HighRangeTurretBuilder;
import model.unit.builder.ProducingBuilder;
import model.unit.builder.ResourceCollectorBuilder;
import model.unit.builder.StorageBuilder;
import model.unit.builder.TurretBuilder;
import model.unit.infantry.HeavyAssaultWalker;
import model.unit.infantry.Rocketeer;
import model.unit.infantry.Soldier;
import model.unit.recon.Spy;
import model.unit.robot.Strider;
import model.unit.tank.LaserTank;
import model.unit.tank.Leopard5;


public class ModelList {
	private final static ModelList instance = new ModelList();
	private Model[] models;
	
	
	public static ModelList getInstance() {
		return instance;
	}

//	private ModelList() {
//		ArrayList<Model> modelList = new ArrayList<Model>();
//		for (int i = 0; i < 384; i++) {
//			Model model = get(i, null);
//			if (model != null) {
//				modelList.add(model);
//			}
//		}
//		Object[] o = modelList.toArray();
//		models = new Model[o.length];
//		for (int i = 0; i < o.length; i++) {
//			models[i] = (Model) o[i];
//		}
//	}
	
	public Model[] getAllModels() {
		return models;
	}
	
	public Model[] getModelsOfType(Type type) {
		ArrayList<Model> ret = new ArrayList<Model>();
		for (int i = 0; i < models.length; i++) {
			if (models[i].getType() == type) {
				ret.add(models[i]);
			}
		}
		Object[] o = ret.toArray();
		Model[] retur = new Model[o.length];
		for (int i = 0; i < o.length; i++) {
			retur[i] = (Model) o[i];
		}
		return retur;
	}
	
	public Model getModel(String name, Player player) {
		if(name.equals("Soldier")) {
			return new Soldier(player);
		} else if(name.equals("Rocketeer")) {
			return new Rocketeer(player);
		} else if(name.equals("Heavy Assault Walker")) {
			return new HeavyAssaultWalker(player);
		} else if(name.equals("Strider")) {
			return new Strider(player);
		} else if(name.equals("Leopard 5")) {
			return new Leopard5(player);
		} else if(name.equals("Laser Tank")) {
			return new LaserTank(player);
		} else if(name.equals("Spy")) {
			return new Spy(player);
		} else if(name.equals("Resource Collector Builder")) {
			return new ResourceCollectorBuilder(player);
		} else if(name.equals("Storage Builder")) {
			return new StorageBuilder(player);
		} else if(name.equals("Producing Builder")) {
			return new ProducingBuilder(player);
		} else if(name.equals("Turret Builder")) {
			return new TurretBuilder(player);
		} else if(name.equals("High Range Turret Builder")) {
			return new HighRangeTurretBuilder(player);
		} else if(name.equals("Solar Cell")) {
			return new SolarCell(player);
		} else if(name.equals("Hamster Wheel")) {
			return new HamsterWheel(player);
		} else if(name.equals("House")) {
			return new House(player);
		} else if(name.equals("Nuclear Reactor")) {
			return new NuclearReactor(player);
		} else if(name.equals("Small Storage")) {
			return new SmallStorage(player);
		} else if(name.equals("Medium Storage")) {
			return new MediumStorage(player);
		} else if(name.equals("Big Storage")) {
			return new BigStorage(player);
		} else if(name.equals("Barracks")) {
			return new Barracks(player);
		} else if(name.equals("Factory")) {
			return new Factory(player);
		} else if(name.equals("Spy Center")) {
			return new SpyCenter(player);
		} else if(name.equals("Gatling Gun")) {
			return new GatlingGun(player);
		} else if(name.equals("Laser Cannon")) {
			return new LaserCannon(player);
		} else if(name.equals("Base")) {
			return new Base(player);
		} else {
			return null;
		}
	}
		//Infantry
//		case 0:
//			return new Model("Soldier", Type.Infantry, 0, player,
//					10, 1, 1,
//					50, 5, 5,
//					90, 0, 10, 1, Type.Infantry,
//					5, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
			
//		case 1:
//			return new Model("Rocketeer", Type.Infantry, 1, player,
//					15, 2, 1,
//					30, 2, 7,
//					75, 0, 10, 2, Type.Tank,
//					6, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
//		case 2:
//			return new Model("Heavy Assault Walker", Type.Infantry, 2, player,
//					150, 25, 1, 
//					500, 5, 3,
//					70, 10, 10, 1, null,
//					3, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
		//Robots
//		case 32:
//			return new Model("Strider", Type.Robot, 32, player,
//					20, 10, 0,
//					50, 2, 5,
//					95, 10, 7, 1, null,
//					10, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
		
//		//Tanks
//		case 64:
//			return new Model("Leopard 5", Type.Tank, 64, player,
//					50, 20, 5,
//					250, 5, 7,
//					85, 0, 50, 3, Type.Tank,
//					7, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
//				case 65:
//			return new Model("Laser Tank", Type.Tank, 65, player,
//					25, 50, 3,
//					150, 5, 7,
//					95, 0, 20, 2, Type.Robot,
//					7, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
		
		//Recons
//		case 96:
//			return new Model("Spy", Type.Recon, 96, player,
//					20, 5, 1,
//					1, 0, 30,
//					0, 0, 0, 0, null,
//					15, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
		
		//Ships
		
			
		//Builders
//		case 160:
//			return new Model("Resource Collector Builder", Type.Builder, 160, player,
//					25, 25, 1,
//					10, 0, 3,
//					0, 0, 0, 0, null,
//					8, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					Type.RescourceCollector, 5, 1,
//					0);
//		case 161:
//			return new Model("Storage Builder", Type.Builder, 161, player,
//					25, 25, 1,
//					10, 0, 3,
//					0, 0, 0, 0, null,
//					8, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					Type.Storage, 5, 1,
//					0);
//		case 162:
//			return new Model("Producing Builder", Type.Builder, 162, player,
//					25, 25, 1,
//					10, 0, 3,
//					0, 0, 0, 0, null,
//					8, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					Type.Producing, 75, 1,
//					0);
//		case 163:
//			return new Model("Turret Builder", Type.Builder, 163, player,
//					25, 25, 1,
//					10, 0, 3,
//					0, 0, 0, 0, null,
//					8, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					Type.Turret, 5, 1,
//					0);
//		case 164:
//			return new Model("High Range Turret Builder", Type.Builder, 164, player,
//					25, 25, 1,
//					10, 0, 3,
//					0, 0, 0, 0, null,
//					8, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					Type.Turret, 2, 10,
//					0);
		//RescourceCollectors
//		case 256:
//			return new Model("Solar Cell", Type.RescourceCollector, 256, player,
//					5, 0, 0,
//					25, 0, 5,
//					0, 0, 0, 0, null,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 2, 0,
//					0, 0,
//					null, 0, 0,
//					0);
//		case 257:
//			return new Model("Hamster Wheel", Type.RescourceCollector, 257, player,
//					2, 0, 0,
//					5, 0, 1,
//					0, 0, 0, 0, null,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 1, 0,
//					0, 0,
//					null, 0, 0,
//					0);
//		case 258:	
//			return new Model("House", Type.RescourceCollector, 258, player,
//					   10, 0, 0,
//					   35, 0, 5,
//					   0, 0, 0, 0, null,
//					   0, true, false, false, false, false, Layer.Ground,
//					   0, 0, 1,
//					   0, 10,
//					   null, 0, 0,
//					   10);
//		case 259:
//			return new Model("Nuclear Rector", Type.RescourceCollector, 259, player,
//					   500, 250, 25,
//					   100, 0, 3,
//					   0, 0, 0, 0, null,
//					   0, true, false, false, false, false, Layer.Ground,
//					   0, 50, 0,
//					   0, 0,
//					   null, 0, 0,
//					   0);
			
		//Storage
//		case 288:
//			return new Model("Small Storage", Type.Storage, 288, player,
//					100, 100, 0,
//					10, 0, 3,
//					0, 0, 0, 0, null,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					100, 0,
//					null, 0, 0,
//					0);
//		case 289:
//			return new Model("Medium Storage", Type.Storage, 289, player,
//					250, 250, 0,
//					10, 0, 3,
//					0, 0, 0, 0, null,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					250, 0,
//					null, 0, 0,
//					0);
//		case 290:
//			return new Model("Big Storage", Type.Storage, 290, player,
//					500, 500, 0,
//					10, 0, 3,
//					0, 0, 0, 0, null,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					500, 0,
//					null, 0, 0,
//					0);
			
		//Producing
//		case 320:
//			return new Model("Barracks", Type.Producing, 320, player,
//					75, 75, 0,
//					100, 0, 5,
//					0, 0, 0, 0, null,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					Type.Infantry, 10, 1,
//					0);
//		case 321:
//			return new Model("Factory", Type.Producing, 321, player,
//					75, 75, 0,
//					100, 0, 5,
//					0, 0, 0, 0, null,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					Type.Tank, 10, 1,
//					0);
//		case 322:
//			return new Model("Spy Center", Type.Producing, 322, player,
//					75, 75, 0,
//					100, 0, 5,
//					0, 0, 0, 0, null,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					Type.Recon, 10, 1,
//					0);
//		
//		//Turrets:
//		case 352:
//			return new Model("Gatling Gun", Type.Turret, 352, player,
//					50, 50, 0,
//					100, 5, 7,
//					100, 0, 10, 3, Type.Infantry,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
//		case 353:
//			return new Model("Laser Cannon", Type.Turret, 353, player,
//					75, 75, 0,
//					75, 5, 7,
//					95, 0, 15, 3, Type.Robot,
//					0, true, false, false, false, false, Layer.Ground,
//					0, 0, 0,
//					0, 0,
//					null, 0, 0,
//					0);
//			
//			
//		//BASE
////		case 512:
////			return new Model("Base", Type.Base, 512, player,
////					500, 500, 50,
////					500, 0, 10,
////					100, 0, 25, 3, null,
////					0, true, false, false, false, false, Layer.Ground,
////					10, 10, 1,
////					100, 10,
////					Type.Builder, 25, 1,
////					5);
//		default:
//			return null;
//		}
//	}
}
