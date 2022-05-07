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

    //TEST again
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

    /*
    @GetMapping("/findSongRankLesserThan/{rank}")
    public List<Songs> findSongRankLesserThan(@PathVariable int rank) {
        return songsService.getSongRankLesserThan(rank);
    }
     */

    //NOT WORKING
    @GetMapping("/findSongByRank/{rank}")
    public List<Songs> getSongsByRank(@PathVariable int rank) {
        return songsService.getSongsByRank(rank);
    }

    @GetMapping("/getTotalCount")
    public Long getSongsCount() {
        return songsService.countAllDocuments();
    }

    //NOT WORKING
    @GetMapping("/findSongsLessThanRank")
    public List<Songs> getSongsByRankLessThan() {
        return songsService.getSongsByRankLessThan();
    }

    //NOT WORKING
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

    //Update
    @PutMapping("/updateSongArtist")
    public Songs updateSongArtist(@RequestBody Songs song){
        System.out.println("Updated artist successfully");
        return songsService.updateSongArtist(song);
    }

    /*
    @PutMapping
    public ResponseEntity<?> update(@RequestBody SuperHero superHero) {
        SuperHero updatedSuperHero = superHeroService.update(superHero);
        return ResponseEntity.ok().body(updatedSuperHero);
    }
     */

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

