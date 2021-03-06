package view.gamesstates;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyInputConsumer;
import de.lessvoid.nifty.nulldevice.NullSoundDevice;
import de.lessvoid.nifty.render.batch.BatchRenderDevice;
import de.lessvoid.nifty.renderer.lwjgl.render.LwjglBatchRenderBackendFactory;
import de.lessvoid.nifty.spi.input.InputSystem;
import de.lessvoid.nifty.tools.TimeProvider;
import de.lessvoid.nifty.tools.resourceloader.NiftyResourceLoader;
import logger.ErrorLogger;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.customgui.components.Panel;
import view.data.StartData;
import view.gui.event.KeyboardEvent;
import view.gui.event.MouseEvent;

import java.awt.Font;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameStarting extends BasicGameState {

	private Font f;
	private UnicodeFont uf;
	private StartData sd;
	private Panel panel;

	private int count = 0;
	
	public GameStarting(StartData sd) {
		this.sd = sd;
	}

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		try {
			f = Font.createFont(Font.TRUETYPE_FONT, new File("./res/fonts/digital_tech.ttf"));
			sd.setFont(f);
			f.deriveFont(Font.BOLD, 20);
		} catch (FontFormatException e) {
			ErrorLogger.logger.severe(e.getMessage());
		} catch (IOException e) {
			ErrorLogger.logger.severe(e.getMessage());
		}
		uf = new UnicodeFont(f);
		uf.getEffects().add(new ColorEffect(java.awt.Color.white));
		uf.addAsciiGlyphs();
		uf.loadGlyphs();

		Image logo = new Image("res/imgs/ui/logo.png");
		panel = new Panel(0, 0, gc.getWidth(), gc.getHeight());
		panel.setBackgroundImage(logo, gc.getWidth() / 2 - logo.getWidth() / 2, gc.getHeight() / 2 - logo.getHeight() / 2);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		panel.repaint(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		if (count == 0) {
			Nifty nifty = new Nifty(new BatchRenderDevice(LwjglBatchRenderBackendFactory.create()), new NullSoundDevice(), new InputSystem() {
				@Override
				public void forwardEvents(final NiftyInputConsumer inputEventConsumer) {
					for (MouseEvent event : sd.getMouseEvents()) {
						event.processMouseEvents(inputEventConsumer);
					}
					sd.getMouseEvents().clear();
					
					for (KeyboardEvent event : sd.getKeyEvents()) {
						event.processKeyboardEvent(inputEventConsumer);
					}
					sd.getKeyEvents().clear();
				}

				@Override
				public void setMousePosition(int x, int y) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void setResourceLoader(
						NiftyResourceLoader niftyResourceLoader) {
					// TODO Auto-generated method stub
					
				}
			}, new TimeProvider());
			nifty.fromXml("res/xml/main.xml", "start");
			nifty.addXml("res/xml/gamesetup.xml");
			nifty.addXml("res/xml/multiplayer/login.xml");
			nifty.addXml("res/xml/multiplayer/validateMail.xml");
			nifty.addXml("res/xml/multiplayer/register.xml");
			nifty.addXml("res/xml/multiplayer/menu.xml");
			nifty.addXml("res/xml/multiplayer/chat.xml");
			nifty.addXml("res/xml/settings.xml");
			nifty.addXml("res/xml/tutorial.xml");
            //nifty.setDebugOptionPanelColors(true);
			sd.setNifty(nifty);
		} else {
			sbg.getState(getID() + 1).init(gc, sbg);
			sbg.enterState(getID() + 1);
		}
		count++;
	}
}
