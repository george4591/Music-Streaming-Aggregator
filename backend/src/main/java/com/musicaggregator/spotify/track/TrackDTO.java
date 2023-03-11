package com.musicaggregator.spotify.track;

import com.musicaggregator.spotify.artist.ArtistDTO;

import java.util.List;

public record TrackDTO(String id,
                       String href,
                       String name,
                       List<ArtistDTO> artists,
                       String uri,
                       Integer popularity,
                       Integer duration_ms) {
}
