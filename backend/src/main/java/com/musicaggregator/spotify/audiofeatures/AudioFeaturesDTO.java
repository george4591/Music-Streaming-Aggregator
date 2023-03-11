package com.musicaggregator.spotify.audiofeatures;

import se.michaelthelin.spotify.enums.Modality;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;

/**
 * Represents the audio features of a track retrieved from the Spotify API.
 *
 * @param acousticness     The acousticness of the track, ranging from 0.0 to 1.0.
 * @param danceability     The danceability of the track, ranging from 0.0 to 1.0.
 * @param energy           The energy of the track, ranging from 0.0 to 1.0.
 * @param instrumentalness The instrumentalness of the track, ranging from 0.0 to 1.0. Values above 0.5 are intended
 *                         to represent instrumental tracks.
 * @param key              The key the track is in. Integers map to pitches using standard
 *                         <a href="https://en.wikipedia.org/wiki/Pitch_class">Pitch Class notation</a>.
 *                         If no key was detected, the value is -1.
 * @param liveness         The liveness of the track, ranging from 0.0 to 1.0. A value above 0.8 means that the track
 *                         is a live performance.
 * @param loudness         The loudness of the track, ranging from -60.0 to 0.0 decibels (dB).
 * @param mode             The modality of the track (major or minor).
 * @param speechiness      The speechiness of the track, ranging from 0.0 to 1.0.
 * @param tempo            The tempo of the track in beats per minute (BPM).
 * @param time_signature   The time signature of the track, represented as an integer between 3 and 7.
 * @param valence          The valence of the track, ranging from 0.0 to 1.0. Tracks with high valence sound more
 *                         positive (e.g. happy, cheerful, euphoric), while tracks with low valence sound more
 *                         negative (e.g. sad, depressed, angry).
 * @see AudioFeaturesDTOMapper#apply(AudioFeatures)
 * @see
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-features">Official documentation about audio features</a>
 */
public record AudioFeaturesDTO(Float acousticness,
                               Float danceability,
                               Float energy,
                               Float instrumentalness,
                               Integer key,
                               Float liveness,
                               Float loudness,
                               Modality mode,
                               Float speechiness,
                               Float tempo,
                               Integer time_signature,
                               Float valence
) {
}
