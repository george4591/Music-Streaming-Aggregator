package com.musicaggregator.spotify.track;

import com.musicaggregator.spotify.artist.ArtistDTO;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TrackDTOMapper implements Function<Track, TrackDTO> {
    @Override
    public TrackDTO apply(Track track) {
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
    }
}
