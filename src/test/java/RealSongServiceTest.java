import org.StructuralPatterns.Proxy.RealSongService;
import org.StructuralPatterns.Proxy.Song;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RealSongServiceTest {

    @Test
    void testSearchByAlbum() {
        List<Song> songs = Arrays.asList(
                new Song(1, "Song1", "Artist1", "Album1", 180),
                new Song(2, "Song2", "Artist2", "Album1", 200)
        );

        RealSongService realService = new RealSongService(songs);
        List<Song> results = realService.searchByAlbum("Album1");

        assertEquals(2, results.size(), "Should find 2 songs in Album1");
    }

    @Test
    void testSearchByTitle() {
        List<Song> songs = Arrays.asList(
                new Song(1, "Song1", "Artist1", "Album1", 180),
                new Song(2, "Song2", "Artist2", "Album2", 200)
        );

        RealSongService realService = new RealSongService(songs);
        List<Song> results = realService.searchByTitle("Song1");

        assertEquals(1, results.size(), "Should find 1 song with the title 'Song1'");
    }
}
