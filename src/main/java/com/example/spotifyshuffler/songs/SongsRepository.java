package com.example.spotifyshuffler.songs;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SongsRepository extends MongoRepository<Songs, ObjectId> {

        /*
    The first method, findItemByName, requires a parameter for the query, i.e., the field to filter the query by.
    We specify this with the annotation @Query.

    The second method uses the category field to get all the items of a particular category.
    We only want to project the field’s name and quantity in the query response, so we set those fields to 1.
    */

    //Read operations
    @Query("{title:'?0'}")
    List<Songs>  findByTitle(String title);

    @Query("{artist:'?0'}")
    List<Songs> findByArtist(String artist);

    @Query("{rank:'?0'}")
    List<Songs> findByRank(String rank);

    @Query("{region:'?0'}")
    List<Songs> findByRegion(String region);

    @Query("{streams:'?0'}")
    List<Songs> findByStreams(Double streams);

    @Query("{rank: {$gte: ?20}}")
    List<Songs> getSongsByRank();

    /*
    @Query("{streams:'?0'}")
    List<Songs> findMost(int streams);
    */

    //Delete
    @Query("{title:'?0'}")
    String deleteByTitle(String title);

}
