package com.musicaggregator.spotify.track;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tracks")
public class TrackController {

    private final TrackService trackService;

    public TrackController() {
        trackService = new TrackService();
    }

    @GetMapping
    public TrackDTO getOne(@RequestParam("id") String id) {
        return trackService.getTrack(id);
    }
}
