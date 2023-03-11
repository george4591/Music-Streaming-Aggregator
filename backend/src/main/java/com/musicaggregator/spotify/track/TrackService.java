package com.musicaggregator.spotify.track;

import com.musicaggregator.spotify.SpotifyService;
import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

import java.io.IOException;

@Service
public class TrackService {
    private final SpotifyApi spotifyService;
    private final TrackDTOMapper trackDTOMapper;

    public TrackService() {
        spotifyService = SpotifyService.getInstance();
        trackDTOMapper = new TrackDTOMapper();
    }

    public TrackDTO getTrack(String id) {
        try {
            GetTrackRequest getTrackRequest = spotifyService.getTrack(id).build();
            Track track = getTrackRequest.execute();
            return trackDTOMapper.apply(track);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
