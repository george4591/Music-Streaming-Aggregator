package com.musicaggregator;

import org.apache.hc.core5.http.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/tracks")
public class TrackController {

    private final SpotifyApi spotifyApi;

    public TrackController() {
        this.spotifyApi = SpotifyClient.getInstance();
    }

    @GetMapping
    public Track getOne(@RequestParam("id") String id) {
        try {
            GetTrackRequest getTrackRequest = spotifyApi.getTrack(id).build();
            return getTrackRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
