package com.musicaggregator.spotify.artist;

import com.musicaggregator.spotify.SpotifyService;
import com.musicaggregator.spotify.audiofeatures.AudioFeaturesDTO;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;
import se.michaelthelin.spotify.requests.data.artists.GetSeveralArtistsRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetAudioFeaturesForSeveralTracksRequest;

import java.io.IOException;
import java.util.List;

@Service
public class ArtistService {
    private final SpotifyService spotifyService;
    private final ArtistDTOMapper artistDTOMapper;

    @Autowired
    public ArtistService(SpotifyService spotifyService, ArtistDTOMapper artistDTOMapper) {
        this.spotifyService = spotifyService;
        this.artistDTOMapper = artistDTOMapper;
    }

    /**
     * Retrieves the artist the specified ID from Spotify.
     *
     * @param id The ID of the artist to retrieve.
     * @return The {@code ArtistDTO} object representing the artist.
     * @throws RuntimeException If there is an error retrieving the artist information from Spotify.
     */
    public ArtistDTO getArtist(String id) {
        GetArtistRequest getArtistRequest = spotifyService.api.getArtist(id).build();

        try {
            Artist artist = getArtistRequest.execute();
            return artistDTOMapper.apply(artist);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the artist  with the specified IDs from Spotify.
     *
     * @param ids An array of artist IDs to retrieve.
     * @return The {@code List<ArtistDTO>} object representing the retrieved artists.
     * @throws RuntimeException If there is an error retrieving the artists' information from Spotify.
     */
    public List<ArtistDTO> getSeveralArtists(String[] ids) {
        GetSeveralArtistsRequest getSeveralArtistsRequest =
                spotifyService.api.getSeveralArtists(ids).build();
        try {
            List<Artist> features = List.of(getSeveralArtistsRequest.execute());
            return features.stream().map(artistDTOMapper).toList();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
