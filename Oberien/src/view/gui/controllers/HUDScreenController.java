/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.gui.controllers;

import controller.Controller;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.builder.PanelBuilder;
import de.lessvoid.nifty.controls.ButtonClickedEvent;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import event.HUDModelClickedAdapter;
import event.ModelClickedListener;
import event.PlayerStatsListener;
import event.TurnChangedListener;
import java.util.ArrayList;
import model.BuildingModel;
import model.Model;
import model.ModelList;
import model.player.Player;
import view.data.Globals;
import view.data.StartData;
import view.gamesstates.GameRunning;

public class HUDScreenController extends HUDModelClickedAdapter implements ModelClickedListener, ScreenController, PlayerStatsListener, TurnChangedListener {

	private Nifty nifty;
	private Element turnText, playerName;
	private Loadingbar moneyBar, energyBar, populationBar;
	private Screen screen;
	private Element unitBox;
	private Element moneyBarText, energyBarText, populationBarText;
	private Controller c;
	private final ArrayList<Element> modelImageBoxes = new ArrayList<>();
	private final ArrayList<Element> subBoxes = new ArrayList<>();

	public HUDScreenController() {

	}

	@Override
	public void bind(Nifty nifty, Screen screen) {
		Globals.setHUDController(this);
		this.nifty = nifty;
		this.screen = screen;

		turnText = screen.findElementById("turnText");
		playerName = screen.findElementById("playerName");

		moneyBar = screen.findNiftyControl("moneyBar", Loadingbar.class);
		energyBar = screen.findNiftyControl("energyBar", Loadingbar.class);
		populationBar = screen.findNiftyControl("populationBar", Loadingbar.class);

		moneyBarText = screen.findElementById("moneyBarText");
		energyBarText = screen.findElementById("energyBarText");
		populationBarText = screen.findElementById("populationBarText");

		unitBox = screen.findElementById("unitBox");

		for (int i = 0; i < unitBox.getHeight(); i += Globals.TILE_SIZE) {
			subBoxes.add(
					new PanelBuilder("vertOrderPanel" + i / Globals.TILE_SIZE) {
						{
							height(Globals.TILE_SIZE + "px");
							width("100%");
							childLayout(ChildLayoutType.Horizontal);
							interactOnClick("unitBoxClick()");
						}
					}.build(nifty, screen, unitBox));
		}
	}

	@NiftyEventSubscriber(pattern = ".*ImageBox")
	public void unitImageBoxClicked(String name, ButtonClickedEvent e) {
		for (Model l : ModelList.getInstance().getAllModels()) {
			if ((l.getName() + "ImageBox").equals(name)) {
				HUDModelClicked(l);
			}
		}
	}

	@NiftyEventSubscriber(id = "endTurnButton")
	public void endTurnButtonClicked(String id, ButtonClickedEvent e) {
		if (c != null) {
			c.endTurn();
		}
	}

	public void unitBoxClick() {
		for (int i = subBoxes.size() - 1; i >= 0; i--) {
			Element el = subBoxes.get(i);
			for (Element e : el.getChildren()) {
				e.markForRemoval();
			}
		}
	}

	@Override
	public void onStartScreen() {
	}

	@Override
	public void onEndScreen() {
	}

	public void registerListeners(StartData sd, GameRunning gr) {
		System.out.println("yes");
		c = sd.getController();
		c.addTurnChangedListener(this);
		c.addPlayerStatsListener(this);
		gr.addModelClickedEventListener(this);

		Player p = c.getState().getCurrentPlayer();
		moneyChanged(p.getMoney());
		energyChanged(p.getEnergy());
		populationChanged(p.getPopulation());
		playernameChanged(p.getName());
	}

	@Override
	public void moneyChanged(float money) {
		moneyBar.setProgress(money / ((float) c.getState().getCurrentPlayer().getStorage()));
		moneyBarText.getRenderer(TextRenderer.class).setText(((int) money) + "/" + c.getState().getCurrentPlayer().getStorage() + "M");
	}

	@Override
	public void energyChanged(float energy) {
		energyBar.setProgress(energy / ((float) c.getState().getCurrentPlayer().getStorage()));
		energyBarText.getRenderer(TextRenderer.class).setText(((int) energy) + "/" + c.getState().getCurrentPlayer().getStorage() + "E");
	}

	@Override
	public void populationChanged(float population) {
		populationBar.setProgress(population / ((float) c.getState().getCurrentPlayer().getPopulationStorage()));
		populationBarText.getRenderer(TextRenderer.class).setText(((int) population) + "/" + c.getState().getCurrentPlayer().getPopulationStorage() + "P");
	}

	@Override
	public void roundChanged(int turn) {
		turnText.getRenderer(TextRenderer.class).setText("Turn " + Integer.toString(turn));
		//clear the current selection
		unitBoxClick();
	}

	@Override
	public void playernameChanged(String playername) {
		playerName.getRenderer(TextRenderer.class).setText(playername);
	}

	@Override
	public void modelClicked(Model m) {
		unitBoxClick();
		if (m == null || !(m instanceof BuildingModel)) {
			return;
		}
		BuildingModel b = (BuildingModel) m;
		Model[] list = ModelList.getInstance().getModelsOfType(b.getBuilds());
		int a = 0;
		Element subBox = subBoxes.get(0);
		int i = 0;
		for (final Model e : list) {
			if (i * Globals.TILE_SIZE > unitBox.getWidth()) {
				a++;
				subBox = subBoxes.get(a);
			}
			modelImageBoxes.add(
					new ButtonBuilder(e.getName() + "ImageBox") {
						{
							name("buttonImage");
							filename("/res/imgs/units/" + e.getId() + ".2.png");
							height(Globals.TILE_SIZE + "px");
							width(Globals.TILE_SIZE + "px");
						}
					}.build(nifty, screen, subBox));
			i++;
		}
	}
}
