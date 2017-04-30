package com.wrapper.spotify.models;

public class Device {
	private String id;
	private boolean isActive;
	private boolean isRestricted;
	private String name;
	private String type;
	private Integer volumePercent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isRestricted() {
		return isRestricted;
	}

	public void setRestricted(boolean isRestricted) {
		this.isRestricted = isRestricted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getVolumePercent() {
		return volumePercent;
	}

	public void setVolumePercent(Integer volumePercent) {
		this.volumePercent = volumePercent;
	}
}
