package com.example.spotifyshuffler.songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongsService {

    @Autowired
    SongsRepository songsRepo;

    //CREATE
    public Songs saveSongService(Songs song){
        return songsRepo.save(song);
        //return "Added song successfully";
    }

    //Read operations
    public List<Songs> getAllSongs() {
        List<Songs> songsList = new ArrayList<Songs>();
        songsRepo.findAll().forEach(songsList::add);

        return songsList;
    }

    public List<Songs> getSongsByArtist(String artist){
        List<Songs> songsList = new ArrayList<Songs>();
        for(Songs s: songsRepo.findByArtist(artist)){
            songsList.add(s);
        }
        return songsList;
    }

    public List<Songs> getSongsByYear(int year){
        List<Songs> songsList= songsRepo.findByYear(year);
        return songsList;
    }

    public Songs getSongsByTitle(String title){
        Songs getSong = songsRepo.findByTitle(title);
        return getSong;
    }

    //UPDATE
    public Songs updateSongYear(Songs song){
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setYear(song.getYear());
        return songsRepo.save(newSong);
    }

    public Songs updateSongArtist(Songs song){
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setArtist(song.getArtist());
        return songsRepo.save(song);
    }

    //DELETE
    public String deleteSongByTitle(String title){
        songsRepo.deleteByTitle(title);
        return "Deleted Successfully";
    }
}
