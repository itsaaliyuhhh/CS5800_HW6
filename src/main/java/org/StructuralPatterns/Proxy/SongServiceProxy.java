package org.StructuralPatterns.Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private final RealSongService realService;
    private final Map<Integer, Song> idCache = new HashMap<>();
    private final Map<String, List<Song>> titleCache = new HashMap<>();
    private final Map<String, List<Song>> albumCache = new HashMap<>();

    public SongServiceProxy(RealSongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer songID) {
        return idCache.computeIfAbsent(songID, realService::searchById);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return titleCache.computeIfAbsent(title, realService::searchByTitle);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return albumCache.computeIfAbsent(album, realService::searchByAlbum);
    }
}