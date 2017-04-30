package com.wrapper.spotify.methods;

import java.io.IOException;

import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.exceptions.WebApiException;

public class PauseRequest extends AbstractRequest {

	public PauseRequest(Builder builder) {
		super(builder);
	}

	public SettableFuture<Boolean> getAsync() {
		SettableFuture<Boolean> pauseFuture = SettableFuture.create();

		try {
			putJson();
			pauseFuture.set(true);
		} catch (Exception e) {
			pauseFuture.setException(e);
		}

		return pauseFuture;
	}

	public Boolean get() throws IOException, WebApiException {
		putJson();
		return true;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder extends AbstractRequest.Builder<Builder> {

		public Builder accessToken(String accessToken) {
			return header("Authorization", "Bearer " + accessToken);
		}

		public PauseRequest build() {
			return new PauseRequest(this);
		}
	}
}
