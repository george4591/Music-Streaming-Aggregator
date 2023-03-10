package com.musicaggregator;

public class SpotifyConfig {
    public static final String clientId = System.getenv("SPOTIFY_CLIENT_ID");

    public static final String clientSecret =  System.getenv("SPOTIFY_CLIENT_SECRET");
    public static final String redirectUrl = System.getenv("SPOTIFY_REDIRECT_URL");
}