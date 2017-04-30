package com.wrapper.spotify.models;

public class CurrentlyPlayingContext {
	private Device device;
	private RepeatState repeatState;
	private boolean shuffleState;
	private Context context;
	private int timestamp;
	private int progressMs;
	private boolean isPlaying;
	private Track item;

	public RepeatState getRepeatState() {
		return repeatState;
	}

	public void setRepeatState(RepeatState repeatState) {
		this.repeatState = repeatState;
	}

	public boolean isShuffleState() {
		return shuffleState;
	}

	public void setShuffleState(boolean shuffleState) {
		this.shuffleState = shuffleState;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getProgressMs() {
		return progressMs;
	}

	public void setProgressMs(int progressMs) {
		this.progressMs = progressMs;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public Track getItem() {
		return item;
	}

	public void setItem(Track item) {
		this.item = item;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public class Context {
		private String uri;
		private String href;
		private ExternalUrls externalUrls;
		private SpotifyEntityType type;

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public String getHref() {
			return href;
		}

		public void setHref(String href) {
			this.href = href;
		}

		public ExternalUrls getExternalUrls() {
			return externalUrls;
		}

		public void setExternalUrls(ExternalUrls externalUrls) {
			this.externalUrls = externalUrls;
		}

		public SpotifyEntityType getType() {
			return type;
		}

		public void setType(SpotifyEntityType type) {
			this.type = type;
		}
	}
}
