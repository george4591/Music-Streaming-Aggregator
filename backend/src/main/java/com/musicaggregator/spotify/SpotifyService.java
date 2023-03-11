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
    private static SpotifyApi spotifyApi = null;

    private SpotifyService() {

    }

    /**
     * Returns a singleton instance of the Spotify API client. If an instance has not yet been created, a new one will
     * be created and initialized with the client ID, client secret, and redirect URL specified in the {@link
     * SpotifyConfig} class. The client will also be authenticated with the Spotify Web API using the client credentials
     * flow.
     *
     * @return An instance of the Spotify API client.
     * @throws RuntimeException if an error occurs while initializing the client or authenticating with the Spotify
     *                          Web API.
     */
    public static SpotifyApi getInstance() {
        if (spotifyApi == null) {
            spotifyApi = new SpotifyApi.Builder()
                    .setClientId(SpotifyConfig.clientId)
                    .setClientSecret(SpotifyConfig.clientSecret)
                    .setRedirectUri(URI.create(SpotifyConfig.redirectUrl))
                    .build();

            // Authenticate the client using the client credentials flow
            ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
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
