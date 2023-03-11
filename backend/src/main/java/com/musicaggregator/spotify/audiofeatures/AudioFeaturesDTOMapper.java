package com.musicaggregator.spotify.audiofeatures;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;

import java.util.function.Function;


/**
 * Mapper for converting AudioFeatures objects to AudioFeaturesDTO objects.
 */
@Service
public class AudioFeaturesDTOMapper implements Function<AudioFeatures, AudioFeaturesDTO> {
    /**
     * Converts an AudioFeatures object to an AudioFeaturesDTO object.
     *
     * @param audioFeatures The {@link AudioFeatures} object to be converted.
     * @return The resulting {@link AudioFeaturesDTO} object.
     * <p>Examples:</p>
     * <pre>{@code
     *  // First get an instance of the class
     *  AudioFeaturesDTOMapper audioFeaturesDTOMapper = new AudioFeaturesDTOMapper();
     *  // If you have only one AudioFeatures object to convert then call the apply function
     *  audioFeaturesDTOMapper.apply(feature);
     *  // If you have a list of objects then
     *  features.stream().map(audioFeaturesDTOMapper).collect(Collectors.toList());
     *   }</pre>
     */
    @Override
    public AudioFeaturesDTO apply(@NotNull AudioFeatures audioFeatures) {
        return new AudioFeaturesDTO(audioFeatures.getAcousticness(),
                                    audioFeatures.getDanceability(),
                                    audioFeatures.getEnergy(),
                                    audioFeatures.getInstrumentalness(),
                                    audioFeatures.getKey(),
                                    audioFeatures.getLiveness(),
                                    audioFeatures.getLoudness(),
                                    audioFeatures.getMode(),
                                    audioFeatures.getSpeechiness(),
                                    audioFeatures.getTempo(),
                                    audioFeatures.getTimeSignature(),
                                    audioFeatures.getValence()
        );
    }
}
