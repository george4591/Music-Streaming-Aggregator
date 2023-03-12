package com.musicaggregator.spotify.artist;

import java.util.List;

public record ArtistDTO(String name, String id, List<String> genres, String href, String uri, Integer popularity) {
}
