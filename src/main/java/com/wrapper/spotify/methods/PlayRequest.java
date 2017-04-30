package com.wrapper.spotify.methods;

import java.io.IOException;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.exceptions.WebApiException;
import net.sf.json.JSONObject;

public class PlayRequest extends AbstractRequest {

	public PlayRequest(Builder builder) {
		super(builder);
	}

	public SettableFuture<Boolean> getAsync() {
		SettableFuture<Boolean> playFuture = SettableFuture.create();

		try {
			putJson();
			playFuture.set(true);
		} catch (Exception e) {
			playFuture.setException(e);
		}

		return playFuture;
	}

	public Boolean get() throws IOException, WebApiException {
		putJson();
		return true;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder extends AbstractRequest.Builder<Builder> {

		final private Map<String, Object> properties = Maps.newHashMap();

		public Builder accessToken(String accessToken) {
			return header("Authorization", "Bearer " + accessToken);
		}

		public Builder deviceId(String deviceId) {
			parameter("device_id", deviceId);
			return this;
		}

		public Builder contextUri(String contextUri) {
			properties.put("context_uri", contextUri);
			return this;
		}

		public Builder trackUris(String[] trackUris) {
			properties.put("uris", trackUris);
			return this;
		}

		public Builder offset(int offset) {
			properties.put("offset", offset);
			return this;
		}

		public Builder offset(String startTrackUri) {
			properties.put("offset", startTrackUri);
			return this;
		}

		public PlayRequest build() {
			assert (!(properties.containsKey("context_uri") && properties.containsKey("uris")));
			header("Content-Type", "application/json");
			body(JSONObject.fromObject(properties));
			return new PlayRequest(this);
		}
	}
}
