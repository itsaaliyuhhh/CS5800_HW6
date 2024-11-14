import org.StructuralPatterns.Proxy.RealSongService;
import org.StructuralPatterns.Proxy.Song;
import org.StructuralPatterns.Proxy.SongServiceProxy;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SongServiceProxyTest {

    @Test
    void testCachingInProxy() {
        List<Song> songs = Arrays.asList(
                new Song(1, "Song1", "Artist1", "Album1", 180),
                new Song(2, "Song2", "Artist2", "Album1", 200)
        );

        RealSongService realService = new RealSongService(songs);
        SongServiceProxy proxy = new SongServiceProxy(realService);

        List<Song> firstCall = proxy.searchByAlbum("Album1");

        List<Song> secondCall = proxy.searchByAlbum("Album1");

        assertSame(firstCall, secondCall, "Proxy should return the cached result on the second call");
    }
}

