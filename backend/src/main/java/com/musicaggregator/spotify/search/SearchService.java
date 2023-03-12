package com.musicaggregator.spotify.search;

import com.musicaggregator.spotify.SpotifyService;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.special.SearchResult;
import se.michaelthelin.spotify.requests.data.search.SearchItemRequest;

import java.io.IOException;


@Service
public class SearchService {
    private final SpotifyService spotifyService;

    @Autowired

    public SearchService(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    public SearchResult searchItem(String query, String type) {
        SearchItemRequest searchItemRequest = spotifyService.api.searchItem(query, type).build();

        try {
            SearchResult searchResult = searchItemRequest.execute();
            return searchResult;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
