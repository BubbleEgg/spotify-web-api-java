/**
 * Copyright (C) 2014 Spotify AB
 */
package com.wrapper.spotify.methods;

import java.io.IOException;

import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.JsonUtil;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.CurrentlyPlayingContext;

import net.sf.json.JSONObject;

public class PlaybackInformationRequest extends AbstractRequest {

	public PlaybackInformationRequest(AbstractRequest.Builder<Builder> builder) {
		super(builder);
	}

	public SettableFuture<CurrentlyPlayingContext> getAsync() {
		SettableFuture<CurrentlyPlayingContext> libraryTracksFuture = SettableFuture.create();

		try {
			final String jsonString = getJson();
			final JSONObject jsonObject = JSONObject.fromObject(jsonString);

			libraryTracksFuture.set(JsonUtil.createCurrentlyPlayingContext(jsonObject));
		} catch (Exception e) {
			libraryTracksFuture.setException(e);
		}

		return libraryTracksFuture;
	}

	public CurrentlyPlayingContext get() throws IOException, WebApiException {
		final String jsonString = getJson();
		final JSONObject jsonObject = JSONObject.fromObject(jsonString);

		return JsonUtil.createCurrentlyPlayingContext(jsonObject);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder extends AbstractRequest.Builder<Builder> {

		public Builder accessToken(String accessToken) {
			return header("Authorization", "Bearer " + accessToken);
		}

		public PlaybackInformationRequest build() {
			return new PlaybackInformationRequest(this);
		}
	}
}
