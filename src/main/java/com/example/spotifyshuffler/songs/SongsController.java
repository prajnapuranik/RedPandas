package com.example.spotifyshuffler.songs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongsController {

    @Autowired
    private SongsService songsService;

    //Read operations
    @GetMapping("/findAllSongs")
    public List<Songs> getSongs() {
        return songsService.getAllSongs();
    }

    @GetMapping("/findSongByArtist/{artist}")
    public List<Songs> getSongsByArtist(@PathVariable String artist) {
        return songsService.getSongsByArtist(artist);
    }

    @GetMapping("/findSongByYear/{year}")
    public List<Songs> getSongsByYear(@PathVariable int year) {
        //String stringYear = Integer.toString(year);
        return songsService.getSongsByYear(year);
    }

    @GetMapping("/findSongByTitle/{title}")
    public Songs getSongsByTitle(@PathVariable String title) {
        System.out.println(title);
        return songsService.getSongsByTitle(title);
    }

    @PostMapping("/addSong")
    public Songs addSong(@RequestBody Songs song){
        System.out.println("Added Successfully");
        return songsService.saveSongService(song);
    }

    @PutMapping("/updateSongYear/")
    public Songs updateSongTitle(@RequestBody Songs song){
        System.out.println("Updated year successfully");
        return songsService.updateSongYear(song);
    }

    @PutMapping("/updateSongArtist/")
    public Songs updateSongArtist(@RequestBody Songs song){
        System.out.println("Updated artist successfully");
        return songsService.updateSongArtist(song);
    }

    @DeleteMapping("/delete/{title}")
    public String deleteSongByTitle(@PathVariable String title){
        return songsService.deleteSongByTitle(title);
    }

}
