package com.example.spotifyshuffler.songs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SongsRepository extends MongoRepository<Songs, String> {

    /*
    The first method, findItemByName, requires a parameter for the query, i.e., the field to filter the query by.
    We specify this with the annotation @Query.

    The second method uses the category field to get all the items of a particular category.
    We only want to project the field’s name and quantity in the query response, so we set those fields to 1.

     */
   /* @Query("{name:'?0'}")
    Songs findItemByName(String title);

    void deleteById(String id);
    */

    /*
    @Query("{artist:'?0'}")
    List<Songs> findSongByArtist(String artist);
     */
}
