package com.example.spotifyshuffler.Controller;

import java.util.List;

import com.example.spotifyshuffler.Model.Songs;
import com.example.spotifyshuffler.Service.SongsService;
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
    public Songs getSongsByTitle(@PathVariable String title) {
        return songsService.getSongsByTitle(title);
    }

    @GetMapping("/findSongByArtist/{artist}")
    public List<Songs> getSongsByArtist(@PathVariable String artist) {
        System.out.println(artist);
        return songsService.getSongsByArtist(artist);
    }

    @GetMapping("/findSongByRegion/{region}")
    public List<Songs> getSongsByRegion(@PathVariable String region) {
        System.out.println(region);
        return songsService.getSongsByRegion(region);
    }

    @GetMapping("/findSongCountByArtist/{artist}")
    public Integer getSongsCountByArtist(@PathVariable String artist) {
        System.out.println(artist);
        return songsService.getSongsCountByArtist(artist);
    }

    @GetMapping("/findSongRankGreaterThan/{rank}")
    public List<Songs> findSongRankGreaterThan(@PathVariable int rank) {
        return songsService.getSongRankGreaterThan(rank);
    }

    @GetMapping("/findSongByRank/{rank}")
    public List<Songs> getSongsByRank(@PathVariable int rank) {
        return songsService.getSongsByRank(rank);
    }

    @GetMapping("/getTotalCount")
    public Long getSongsCount() {
        return songsService.countAllDocuments();
    }

    @GetMapping("/getAllSongsInDate/{date}")
    public List<Songs> getSongsDate(@PathVariable String date) {
        return songsService.getDate(date);
    }

    @GetMapping("/checkSongExists/{title}")
    public void checkSongExists(@PathVariable String title){
        System.out.println(songsService.checkSongExists(title));
    }

    @GetMapping("/getMostPopular/")
    public Songs getMostPopular() {
        return songsService.getMostPopular();
    }

    //Create
    @PostMapping("/addSong")
    public Songs addSong(@RequestBody Songs song){
        System.out.println("Added Successfully");
        return songsService.saveSongService(song);
    }

    //Update
    @PutMapping("/updateSongArtist")
    public Songs updateSongArtist(@RequestBody Songs song){
        System.out.println("Updated artist successfully");
        return songsService.updateSongArtist(song);
    }

    @PutMapping("/updateSongTitle")
    public Songs updateSongTitle(@RequestBody Songs song){
        System.out.println("Updated title successfully");
        return songsService.updateSongTitle(song);
    }

    @PutMapping("/updateSongRegion")
    public Songs updateSongRegion(@RequestBody Songs song){
        System.out.println("Updated region successfully");
        return songsService.updateSongRegion(song);
    }

    @PutMapping("/updateSongChart")
    public Songs updateSongChart(@RequestBody Songs song){
        System.out.println("Updated chart successfully");
        return songsService.updateSongChart(song);
    }

    //Delete
    @DeleteMapping("/deleteSongByArtist/{title}")
    public String deleteSongByTitle(@PathVariable String title){
        return songsService.deleteSongByTitle(title);
    }

    @DeleteMapping("/deleteSongByTitle/{artist}")
    public String deleteSongByArtist(@PathVariable String artist){
        return songsService.deleteSongByArtist(artist);
    }

}

