package view.gamesstates;

import model.map.MapList;
import model.player.Player;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.SlickCallable;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controller.Controller;
import controller.wincondition.Conquest;
import view.data.StartData;
import de.lessvoid.nifty.Nifty;

public class NiftyMenu extends BasicGameState {
	private static StartData sd;
	private static StateBasedGame sbg;
	private Nifty nifty;
	
	public NiftyMenu(StartData sd) {
		this.sd = sd;
	}
		
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.sbg = game;
		this.nifty = sd.getNifty();
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		nifty.update();
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		SlickCallable.enterSafeBlock();
		nifty.render(true);
		SlickCallable.leaveSafeBlock();
	}
	
	public static void startGame(Controller controller) {
		sd.setMap(MapList.getInstance().getCurrentMap());
		sd.setController(controller);
		sd.setState(controller.getState());
		sbg.enterState(2);
	}
	
	@Override
	public int getID() {
		return 1;
	}
}