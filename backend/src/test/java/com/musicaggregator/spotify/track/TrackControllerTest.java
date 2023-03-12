package com.musicaggregator.spotify.track;

import com.musicaggregator.spotify.SpotifyService;
import com.musicaggregator.spotify.artist.ArtistDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TrackControllerTest {
    private final SpotifyService spotifyService = new SpotifyService();
    private final TrackDTOMapper trackDTOMapper = new TrackDTOMapper();
    private TrackService trackService;


    @BeforeEach
    void setUp() {
        trackService = new TrackService(spotifyService, trackDTOMapper);
    }

    @Test
    void getTrack_withInvalidId_shouldReturnNull() {
        String id = "1234";
        TrackDTO track = trackService.getTrack(id);

        assertNull(track);
    }

    @Test
    void getTrack_withValidId_shouldReturnProperly() {
        String id = "1Ezn3sh9v9mhhyLYaIGHWC";
        List<ArtistDTO> artists = List.of(
                new ArtistDTO("luisleonparma", "2siDtLI5wfoaVomOLd1OYF",
                              "https://api.spotify.com/v1/artists/2siDtLI5wfoaVomOLd1OYF",
                              "spotify:artist:2siDtLI5wfoaVomOLd1OYF"),
                new ArtistDTO("Rae Jean", "1KnnOKSMpG0heNDVU2WHLQ",
                              "https://api.spotify.com/v1/artists/1KnnOKSMpG0heNDVU2WHLQ",
                              "spotify:artist:1KnnOKSMpG0heNDVU2WHLQ")
        );

        TrackDTO expected = new TrackDTO(id, "https://api.spotify.com/v1/tracks/1Ezn3sh9v9mhhyLYaIGHWC",
                                         "Blow Your Mind", artists, "spotify:track:1Ezn3sh9v9mhhyLYaIGHWC", 34, 219742);
        TrackDTO actual = trackService.getTrack(id);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}