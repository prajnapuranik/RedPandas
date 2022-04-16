package com.example.spotifyshuffler.songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongsService {

    @Autowired
    SongsRepository songsRepo;

    public Songs saveSongService(Songs song){
        return songsRepo.save(song);
    }

    public List<Songs> getAllSongs() {
        System.out.println("Hello!");

        List<Songs> songsList = new ArrayList<Songs>();
        songsRepo.findAll().forEach(songsList::add);

       /* for(Songs song: songsList){
            System.out.println(song.getArtist());
        }*/
        return songsList;
    }

    public String insertSongService(Songs song) {
        songsRepo.save(song);
        return "Added song successfully";
    }

    public String deleteService(String id){
        songsRepo.deleteById(id);
        return "Deleted Successfully";
    }
}
