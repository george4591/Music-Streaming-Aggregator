package com.musicaggregator.spotify.artist;

import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;

import java.util.function.Function;

@Service
public class ArtistSimplifiedDTOMapper implements Function<ArtistSimplified, ArtistSimplifiedDTO> {
    @Override
    public ArtistSimplifiedDTO apply(ArtistSimplified artist) {
        return new ArtistSimplifiedDTO(artist.getName(), artist.getId(), artist.getHref(), artist.getUri());
    }
}
