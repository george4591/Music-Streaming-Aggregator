package com.musicaggregator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import se.michaelthelin.spotify.model_objects.specification.Track;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TrackControllerTest {
    @InjectMocks
    private TrackController trackController;

    @Test
    void getOne_returnsTrack() {
        String id = "1Ezn3sh9v9mhhyLYaIGHWC";
        Track expectedTrack = new Track.Builder().setId(id).setName("Blow Your Mind").build();
        Track actualTrack = trackController.getOne(id);

        assertEquals(expectedTrack.getName(), actualTrack.getName());
        assertEquals(expectedTrack.getId(), actualTrack.getId());
    }
}