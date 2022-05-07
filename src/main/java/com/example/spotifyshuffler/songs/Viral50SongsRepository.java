package com.example.spotifyshuffler.songs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface Viral50SongsRepository extends MongoRepository<SongsViral50, String> {

    //Read operations
    @Query("{title:'?0'}")
    Songs  findByTitle(String title);

    @Query("{artist:'?0'}")
    List<Songs> findByArtist(String artist);

    @Query("{rank:'?0'}")
    List<Songs> findByRank(int rank);

    @Query("{region:'?0'}")
    List<Songs> findByRegion(String region);

    @Query("{streams:'?0'}")
    List<Songs> findByStreams(Double streams);

    @Query(value ="{artist: ?0}", count=true)
    Integer getSongsCountByArtist(String artist);

    List<Songs> findByRankGreaterThan(int rank);

   // List<Songs> findByRankLesserThan(int rank);

    //NOT WORKING
    @Query("{rank: {$gte: ?20}}")
    List<Songs> getSongsByRank();

    //Delete
    @Query("{title:'?0'}")
    String deleteByTitle(String title);

    @Query("{artist:'?0'}")
    void deleteByArtist(String artist);

    @Query(value = "{}", count = true)
    Long countAllDocuments();
}
