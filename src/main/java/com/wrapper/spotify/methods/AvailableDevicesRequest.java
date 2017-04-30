/**
 * Copyright (C) 2014 Spotify AB
 */
package com.wrapper.spotify.methods;

import java.io.IOException;
import java.util.List;

import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.JsonUtil;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.Device;

import net.sf.json.JSONObject;

public class AvailableDevicesRequest extends AbstractRequest {

	public AvailableDevicesRequest(AbstractRequest.Builder<Builder> builder) {
		super(builder);
	}

	public SettableFuture<List<Device>> getAsync() {
		SettableFuture<List<Device>> libraryTracksFuture = SettableFuture.create();

		try {
			final String jsonString = getJson();
			final JSONObject jsonObject = JSONObject.fromObject(jsonString);

			libraryTracksFuture.set(JsonUtil.createDevices(jsonObject));
		} catch (Exception e) {
			libraryTracksFuture.setException(e);
		}

		return libraryTracksFuture;
	}

	public List<Device> get() throws IOException, WebApiException {
		final String jsonString = getJson();
		final JSONObject jsonObject = JSONObject.fromObject(jsonString);

		return JsonUtil.createDevices(jsonObject);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder extends AbstractRequest.Builder<Builder> {

		public Builder accessToken(String accessToken) {
			return header("Authorization", "Bearer " + accessToken);
		}

		public AvailableDevicesRequest build() {
			return new AvailableDevicesRequest(this);
		}
	}
}
