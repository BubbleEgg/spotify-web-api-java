package com.wrapper.spotify.models;

public enum RepeatState {
	OFF("off"),
	TRACK("track"),
	CONTEXT("context");

	private final String state;

	RepeatState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
