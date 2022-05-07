package com.example.spotifyshuffler.songs;

import java.util.List;

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

    @GetMapping("/findSongByTitle/{title}")
    public List<Songs> getSongsByTitle(@PathVariable String title) {
        System.out.println(title);
        return songsService.getSongsByTitle(title);
    }

    @GetMapping("/findSongByArtist/{artist}")
    public List<Songs> getSongsByArtist(@PathVariable String artist) {
        System.out.println(artist);
        return songsService.getSongsByArtist(artist);
    }

    @GetMapping("/findSongByRank/{rank}")
    public List<Songs> getSongsByRank(@PathVariable int rank) {
        String srank = Integer.toString(rank);
        return songsService.getSongsByRank(srank);
    }
    
    @GetMapping("/findSongByRegion/{region}")
    public List<Songs> getSongsByRegion(@PathVariable String region) {
        System.out.println(region);
        return songsService.getSongsByRegion(region);
    }

    @GetMapping("/findSongsLessThanRank")
    public List<Songs> getSongsByRankLessThan() {
        return songsService.getSongsByRankLessThan();
    }

    @GetMapping("/findSongByStreams/{streams}")
    public List<Songs> getSongsByStreams(@PathVariable Double streams) {
        System.out.println(streams);
        return songsService.getSongsByStreams(streams);
    }

    //Create
    @PostMapping("/addSong")
    public Songs addSong(@RequestBody Songs song){
        System.out.println("Added Successfully");
        return songsService.saveSongService(song);
    }

    /*
    //Update
    @PutMapping("/updateSongArtist/")
    public Songs updateSongArtist(@RequestBody Songs song){
        System.out.println("Updated artist successfully");
        return songsService.updateSongArtist(song);
    }

     */

    //Delete
    @DeleteMapping("/delete/{title}")
    public String deleteSongByTitle(@PathVariable String title){
        return songsService.deleteSongByTitle(title);
    }


}

