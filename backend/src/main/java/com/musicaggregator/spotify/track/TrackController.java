package com.musicaggregator.spotify.track;

import com.musicaggregator.spotify.artist.ArtistDTO;
import com.musicaggregator.spotify.SpotifyService;
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
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tracks")
public class TrackController {

    private final SpotifyApi spotifyService;

    public TrackController() {
        this.spotifyService = SpotifyService.getInstance();
    }

    @GetMapping
    public TrackDTO getOne(@RequestParam("id") String id) {
        try {
            GetTrackRequest getTrackRequest = spotifyService.getTrack(id).build();
            Track track = getTrackRequest.execute();
            return new TrackDTO(
                    track.getId(),
                    track.getHref(),
                    track.getName(),
                    Arrays.stream(track.getArtists())
                          .map(artist -> new ArtistDTO(
                                  artist.getName(),
                                  artist.getId(),
                                  artist.getHref(),
                                  artist.getUri()))
                          .collect(Collectors.toList()),
                    track.getUri(),
                    track.getPopularity(),
                    track.getDurationMs()
            );
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
