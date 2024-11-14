package org.StructuralPatterns.Proxy;

import java.util.Arrays;
import java.util.List;

public class MusicStreamingDriver {
    public static void main(String[] args) {
        List<Song> songs = Arrays.asList(
                new Song(1, "Soft Spot", "Keshi", "Requiem", 180),
                new Song(2, "Espressp", "Sabrina Carpenter", "Short n' Sweet", 200),
                new Song(3, "On Melancholy Hill", "Gorillaz", "Plastic Beach", 210),
                new Song(4, "eternal sunshine", "Ariana Grande", "eternal sunshine", 220),
                new Song(5, "Sticky", "Tyler, The Creator", "CHROMAKOPIA", 230)
        );

        RealSongService realService = new RealSongService(songs);
        SongService proxy = new SongServiceProxy(realService);

        System.out.println("First request for Album1: " + proxy.searchByAlbum("Requiem"));
        System.out.println("Second request for Album1 (should be cached): " + proxy.searchByAlbum("Requiem"));
    }
}
