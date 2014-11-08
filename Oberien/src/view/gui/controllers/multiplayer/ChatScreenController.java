package view.gui.controllers.multiplayer;

import controller.multiplayer.client.Client;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.Chat;
import de.lessvoid.nifty.controls.ChatTextSendEvent;
import de.lessvoid.nifty.controls.Label;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.render.batch.BatchRenderFont;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import event.NiftyMenuUpdateListener;
import event.multiplayer.ChatEvent;
import event.multiplayer.ChatEventListener;
import event.multiplayer.UserEvent;
import event.multiplayer.UserEventListener;
import view.gamesstates.NiftyMenu;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ChatScreenController implements ScreenController, NiftyMenuUpdateListener, ChatEventListener, UserEventListener {
	private Nifty nifty;
	private Screen screen;
	private Chat chat;
	private ArrayList<ChatEvent> chatEventBuffer = new ArrayList<>();
	private ArrayList<UserEvent> userEventBuffer = new ArrayList<>();
	private String user = "asdf";

	@Override
	public void bind(Nifty nifty, Screen screen) {
		this.nifty = nifty;
		this.screen = screen;
		chat = screen.findNiftyControl("chat", Chat.class);
	}

	@Override
	public void onStartScreen() {
		Client.addChatEventListener(this);
		Client.addUserEventListener(this);
		NiftyMenu.addNiftyMenuUpdateListener(this);
	}

	@Override
	public void onEndScreen() {
		Client.removeChatEventListener(this);
		Client.removeUserEventListener(this);
		NiftyMenu.removeNiftyMenuUpdateListener(this);
	}

	@Override
	public void update() {
		for (ChatEvent e : chatEventBuffer) {
			switch (e.getType()) {
				case BroadcastMessageReceived:
				case PrivateMessageReceived:
					chat.receivedChatLine(e.getUsername() + ": " + e.getMessage(), null);
					break;
			}
		}
		chatEventBuffer.clear();
		for (UserEvent e : userEventBuffer) {
			switch (e.getType()) {
				case Kick:
					break;
				case UserAdded:
					chat.addPlayer(e.getData(), null);
					break;
				case UserRemoved:
					chat.removePlayer(e.getData());
					break;
			}
		}
		userEventBuffer.clear();
	}

	@NiftyEventSubscriber(id="chat")
	public void messageSent(String id, ChatTextSendEvent e) {
		try {
			System.out.println(e.getText());
			Client.send(e.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void broadcastMessageReceived(ChatEvent e) {
		chatEventBuffer.add(e);
	}

	@Override
	public void privateMessageReceived(ChatEvent e) {
		chatEventBuffer.add(e);
	}

	@Override
	public void kicked(UserEvent e) {
		userEventBuffer.add(e);
	}

	@Override
	public void userAdded(UserEvent e) {
		userEventBuffer.add(e);
	}

	@Override
	public void userRemoved(UserEvent e) {
		userEventBuffer.add(e);
	}

	public void back() {
		Client.logout();
		nifty.gotoScreen("start");
	}
}
