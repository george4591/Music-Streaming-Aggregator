package com.musicaggregator.spotify.audiofeatures;

import com.musicaggregator.spotify.SpotifyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import se.michaelthelin.spotify.enums.Modality;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class AudioFeaturesTest {

    private final SpotifyService spotifyService = new SpotifyService();
    private final AudioFeaturesDTOMapper audioFeaturesDTOMapper = new AudioFeaturesDTOMapper();
    private AudioFeaturesService audioFeaturesService;

    @BeforeEach
    void setUp() {
        audioFeaturesService = new AudioFeaturesService(spotifyService, audioFeaturesDTOMapper);
    }

    @Test
    void getFeatures_withValidId_shouldReturnProperly() {
        String id = "3GKN5PYjlS7baPtrbdLtev";

        AudioFeaturesDTO expected = new AudioFeaturesDTO(0.199F, 0.758F, 0.68F, 0.184F, 6, 0.243F,
                                                         -7.685F, Modality.MINOR, 0.0808F, 138.079F, 4, 0.127F);

        AudioFeaturesDTO actual = audioFeaturesService.getTrackAudioFeatures(id);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
