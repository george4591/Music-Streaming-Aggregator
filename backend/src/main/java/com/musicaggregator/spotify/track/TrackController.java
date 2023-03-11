package com.musicaggregator.spotify.track;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing track information.
 */
@RestController
@RequestMapping("/api/v1/tracks")
public class TrackController {

    private final TrackService trackService;

    public TrackController() {
        trackService = new TrackService();
    }

    /**
     * Retrieves information about the track with the specified ID from Spotify.
     *
     * @param id The ID of the track to retrieve.
     * @return The TrackDTO object representing the retrieved track information.
     */
    @GetMapping("{id}")
    public TrackDTO getTrack(@PathVariable String id) {
        return trackService.getTrack(id);
    }

    /**
     * Retrieves information about several tracks with the specified IDs from Spotify.
     *
     * @param ids An array of track IDs to retrieve.
     * @return A list of TrackDTO objects representing the retrieved track information.
     */
    @GetMapping()
    public List<TrackDTO> getSeveralTracks(@RequestParam String[] ids) {
        return trackService.getSeveralTracks(ids);
    }
}
