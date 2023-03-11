package com.musicaggregator.spotify.audiofeatures;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing audio features information.
 */
@RestController
@RequestMapping("/api/v1/audio-features")
public class AudioFeaturesController {
    private final AudioFeaturesService audioFeaturesService;

    public AudioFeaturesController() {
        audioFeaturesService = new AudioFeaturesService();
    }

    /**
     * Retrieves the audio features for  the track with the specified ID from Spotify.
     *
     * @param id The id of the track to retrieve.
     * @return The {@link AudioFeaturesDTO} object representing the retrieved track's audio features.
     */
    @GetMapping("{id}")
    public AudioFeaturesDTO getAudioFeatures(@PathVariable String id) {
        return audioFeaturesService.getTrackAudioFeatures(id);
    }
}
