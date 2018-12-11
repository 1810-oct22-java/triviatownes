package com.ex.beans.game;

public class JoinLobbyResponse {
	
	int userId;
	StringBuffer lobbyId;
	int hasError;
	StringBuffer error;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public StringBuffer getLobbyId() {
		return lobbyId;
	}
	public void setLobbyId(StringBuffer lobbyId) {
		this.lobbyId = lobbyId;
	}
	public int getHasError() {
		return hasError;
	}
	public void setHasError(int hasError) {
		this.hasError = hasError;
	}
	public StringBuffer getError() {
		return error;
	}
	public void setError(StringBuffer error) {
		this.error = error;
	}

}
