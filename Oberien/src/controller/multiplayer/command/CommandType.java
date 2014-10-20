package controller.multiplayer.command;

public enum CommandType {
	ActionFailed, ActionSucceed,
	Register, Login,
	UserAdded, UserRemoved, Kick,
	Broadcast, PrivateMessage
}