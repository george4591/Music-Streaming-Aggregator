package com.musicaggregator.spotify.track;

import com.musicaggregator.spotify.artist.ArtistSimplifiedDTOMapper;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Mapper for converting Track objects to TrackDTO objects.
 */
@Service
public class TrackDTOMapper implements Function<Track, TrackDTO> {

    private final ArtistSimplifiedDTOMapper artistDTOMapper = new ArtistSimplifiedDTOMapper();
    /**
     * Converts a Track object to a TrackDTO object.
     *
     * @param track The {@link Track} object to be converted.
     * @return The resulting {@link TrackDTO} object.
     * <p>Examples:</p>
     * <pre>{@code
     *  // First get an instance of the class
     *  TrackDTOMapper trackDTOMapper = new TrackDTOMapper();
     *  // If you have only one Track object to convert then call the apply function
     *  trackDTOMapper.apply(track);
     *  // If you have a list of objects then
     *  tracks.stream().map(trackDTOMapper).collect(Collectors.toList());
     *   }</pre>
     */
    @Override
    public TrackDTO apply(Track track) {
        return new TrackDTO(
                track.getId(),
                track.getHref(),
                track.getName(),
                Arrays.stream(track.getArtists())
                      .map(artistDTOMapper)
                      .toList(),
                track.getUri(),
                track.getPopularity(),
                track.getDurationMs()
        );
    }
}
