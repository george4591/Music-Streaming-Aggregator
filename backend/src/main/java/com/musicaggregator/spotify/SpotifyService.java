package com.musicaggregator.spotify;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.io.IOException;
import java.net.URI;

/**
 * Provides a singleton instance of the Spotify API client, which can be used to make authenticated requests to the
 * Spotify Web API.
 * To obtain an instance of the Spotify API client, call the {@link #getInstance()} method.
 * <p>Example:</p>
 *
 * <pre>{@code
 * SpotifyApi spotifyApi = SpotifyService.getInstance();
 * SearchItemRequest searchItemRequest = spotifyApi.searchItem("Muse", ModelObjectType.ARTIST.getType()).build();
 * Paging<Artist> artistPaging = searchItemRequest.execute();
 * }</pre>
 *
 * @see <a href="https://developer.spotify.com/documentation/web-api/">Spotify Web API documentation</a>
 */
@Service
public class SpotifyService {
    public SpotifyApi api;

    public SpotifyService() {
        api = new SpotifyApi.Builder()
                .setClientId(SpotifyConfig.clientId)
                .setClientSecret(SpotifyConfig.clientSecret)
                .setRedirectUri(URI.create(SpotifyConfig.redirectUrl))
                .build();

        // Authenticate the client using the client credentials flow
        ClientCredentialsRequest clientCredentialsRequest = api.clientCredentials().build();
        ClientCredentials clientCredentials;
        try {
            clientCredentials = clientCredentialsRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
        api.setAccessToken(clientCredentials.getAccessToken());
    }
}
