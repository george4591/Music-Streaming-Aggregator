package com.musicaggregator.spotify.audiofeatures;

import com.musicaggregator.spotify.SpotifyService;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;
import se.michaelthelin.spotify.requests.data.tracks.GetAudioFeaturesForSeveralTracksRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetAudioFeaturesForTrackRequest;

import java.io.IOException;
import java.util.List;

/**
 * A service class that provides methods for retrieving information about audio features of Spotify tracks.
 */
@Service
public class AudioFeaturesService {
    private final SpotifyService spotifyService;
    private final AudioFeaturesDTOMapper audioFeaturesDTOMapper;

    @Autowired
    public AudioFeaturesService(SpotifyService spotifyService, AudioFeaturesDTOMapper audioFeaturesDTOMapper) {
        this.spotifyService = spotifyService;
        this.audioFeaturesDTOMapper = audioFeaturesDTOMapper;
    }

    /**
     * Retrieves the audio features for the track with the specified ID from Spotify.
     *
     * @param id The ID of the track to retrieve.
     * @return The {@code AudioFeaturesDTO} object representing the retrieved track's audio features.
     * @throws RuntimeException If there is an error retrieving the audio features information from Spotify.
     */
    public AudioFeaturesDTO getTrackAudioFeatures(String id) {
        GetAudioFeaturesForTrackRequest getAudioFeaturesRequest = spotifyService.api.getAudioFeaturesForTrack(id)
                                                                                    .build();
        try {
            AudioFeatures audioFeatures = getAudioFeaturesRequest.execute();
            return audioFeaturesDTOMapper.apply(audioFeatures);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the audio features for several tracks with the specified IDs from Spotify.
     *
     * @param ids An array of track IDs to retrieve.
     * @return The {@code List<AudioFeaturesDTO>} object representing the retrieved tracks' audio features.
     * @throws RuntimeException If there is an error retrieving the audio features information from Spotify.
     */
    public List<AudioFeaturesDTO> getAudioFeaturesForSeveralTracks(String[] ids) {
        GetAudioFeaturesForSeveralTracksRequest getAudioFeaturesRequest =
                spotifyService.api.getAudioFeaturesForSeveralTracks(ids).build();
        try {
            List<AudioFeatures> features = List.of(getAudioFeaturesRequest.execute());
            return features.stream().map(audioFeaturesDTOMapper).toList();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
