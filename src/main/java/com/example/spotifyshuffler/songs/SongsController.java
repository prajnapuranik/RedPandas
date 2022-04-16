package com.example.spotifyshuffler.songs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongsController {

    @Autowired
    private SongsService songsService;

    @PostMapping("/addSong")
    public Songs saveBook(@RequestBody Songs song){
        System.out.println("Added Successfully");
        return songsService.saveSongService(song);
    }

    @GetMapping("/findAllSongs")
    public List<Songs> getSongs() {
        return songsService.getAllSongs();
    }

    /*
    @GetMapping("/findSongByArtist")
    public Songs getSongs() {
        return songsService.getSongsByArtist();
    }*/

    /*
    @PostMapping("/addSong")
    public String insertSong(@RequestBody Songs song) {
        return songsService.insertSongService(song);
    }
     */

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id){
        return songsService.deleteService(id);
    }

}
