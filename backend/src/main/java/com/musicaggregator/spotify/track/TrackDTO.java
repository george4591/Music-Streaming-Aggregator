package com.musicaggregator.spotify.track;

import com.musicaggregator.spotify.artist.ArtistDTO;

import java.util.List;

/**
 * @param id          The id of the track
 * @param href        The link to the track. This also includes the id.
 * @param name        The name of the track.
 * @param artists     The artists that released the track.
 * @param uri
 * @param popularity  The popularity of the track measured from 0 to 100. Bigger values means that the track is
 *                    listened to a lot recently.
 * @param duration_ms
 */
public record TrackDTO(String id,
                       String href,
                       String name,
                       List<ArtistDTO> artists,
                       String uri,
                       Integer popularity,
                       Integer duration_ms) {
}
