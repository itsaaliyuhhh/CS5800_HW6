package org.StructuralPatterns.Proxy;

import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    private final List<Song> songLibrary;

    public RealSongService(List<Song> songLibrary) {
        this.songLibrary = songLibrary;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(1000); // Simulating delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkLatency();
        return songLibrary.stream().filter(song -> song.getId().equals(songID)).findFirst().orElse(null);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkLatency();
        List<Song> result = new ArrayList<>();
        for (Song song : songLibrary) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkLatency();
        List<Song> result = new ArrayList<>();
        for (Song song : songLibrary) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                result.add(song);
            }
        }
        return result;
    }
}