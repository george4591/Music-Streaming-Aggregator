package com.musicaggregator.spotify.artist;

import com.musicaggregator.spotify.audiofeatures.AudioFeaturesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing artist information.
 */
@RestController
@RequestMapping("api/v1/artists")
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    /**
     * Retrieves the audio features for  the track with the specified ID from Spotify.
     *
     * @param id The id of the track to retrieve.
     * @return The {@link AudioFeaturesDTO} object representing the retrieved track's audio features.
     */
    @GetMapping("{id}")
    public ArtistDTO getArtist(@PathVariable String id) {
        return artistService.getArtist(id);
    }
}
