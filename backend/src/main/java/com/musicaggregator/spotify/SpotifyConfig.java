package com.musicaggregator.spotify;

/**
 * A utility class for storing Spotify API configuration properties.
 * The configuration values are retrieved from environment variables, specifically
 * {@code SPOTIFY_CLIENT_ID}, {@code SPOTIFY_CLIENT_SECRET}, and {@code SPOTIFY_REDIRECT_URL}.
 * <br><br>
 * This class is not meant to be instantiated or extended, as it only serves to store static configuration
 * properties.
 *
 * @see SpotifyService
 */
public class SpotifyConfig {
    public static final String clientId = System.getenv("SPOTIFY_CLIENT_ID");
    public static final String clientSecret = System.getenv("SPOTIFY_CLIENT_SECRET");
    /**
     * The redirect URL to be used in the OAuth flow.
     */
    public static final String redirectUrl = System.getenv("SPOTIFY_REDIRECT_URL");
}