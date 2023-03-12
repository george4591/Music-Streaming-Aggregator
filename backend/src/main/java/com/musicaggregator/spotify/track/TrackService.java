package com.musicaggregator.spotify.track;

import com.musicaggregator.spotify.SpotifyService;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.tracks.GetSeveralTracksRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A service class that provides methods for retrieving information about Spotify tracks.
 */
@Service
public class TrackService {
    private final SpotifyService spotifyService;
    private final TrackDTOMapper trackDTOMapper;

    @Autowired
    public TrackService(SpotifyService spotifyService, TrackDTOMapper trackDTOMapper) {
        this.spotifyService = spotifyService;
        this.trackDTOMapper = trackDTOMapper;
    }

    /**
     * Retrieves information about the track with the specified ID from Spotify.
     *
     * @param id The id of the track to retrieve.
     * @return The {@code TrackDTO} object representing the retrieved track information or {@code null} if there is an error.
     */
    public TrackDTO getTrack(String id) {
        GetTrackRequest getTrackRequest = spotifyService.api.getTrack(id).build();
        try {
            Track track = getTrackRequest.execute();
            return trackDTOMapper.apply(track);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            return null;
        }
    }

    /**
     * Retrieves information about several tracks with the specified IDs from Spotify.
     *
     * @param ids An array of track IDs to retrieve.
     * @return A list of {@code TrackDTO} objects representing the retrieved track information.
     * @throws RuntimeException If there is an error retrieving the track information from Spotify.
     */
    public List<TrackDTO> getSeveralTracks(String[] ids) {
        GetSeveralTracksRequest getSeveralTracksRequest = spotifyService.api.getSeveralTracks(ids).build();
        try {
            List<Track> tracks = List.of(getSeveralTracksRequest.execute());
            return tracks.stream().map(trackDTOMapper).collect(Collectors.toList());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
