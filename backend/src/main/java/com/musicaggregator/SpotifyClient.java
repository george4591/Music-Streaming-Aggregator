package com.musicaggregator;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.io.IOException;
import java.net.URI;

@Service
public class SpotifyClient {
    private static SpotifyApi spotifyApi = null;
    private static SpotifyConfig config;

    private SpotifyClient(SpotifyConfig spotifyConfig) {
        config = spotifyConfig;
    }

    public static SpotifyApi getInstance() {
        if (spotifyApi == null) {
            spotifyApi = new SpotifyApi.Builder()
                    .setClientId(config.getClientId())
                    .setClientSecret(config.getClientSecret())
                    .setRedirectUri(URI.create(config.getRedirectUrl()))
                    .build();

            ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
                    .build();

            ClientCredentials clientCredentials;
            try {
                clientCredentials = clientCredentialsRequest.execute();
            } catch (IOException | SpotifyWebApiException | ParseException e) {
                throw new RuntimeException(e);
            }
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
        }

        return spotifyApi;
    }
}
