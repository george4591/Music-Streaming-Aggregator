package com.musicaggregator.spotify.artist;

import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.Artist;

import java.util.Arrays;
import java.util.function.Function;

@Service
public class ArtistDTOMapper implements Function<Artist, ArtistDTO> {
    @Override
    public ArtistDTO apply(Artist artist) {
        return new ArtistDTO(artist.getName(), artist.getId(), Arrays.asList(artist.getGenres()), artist.getHref(),
                             artist.getUri(), artist.getPopularity());
    }
}
