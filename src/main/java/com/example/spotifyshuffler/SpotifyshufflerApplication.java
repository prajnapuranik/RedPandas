package com.example.spotifyshuffler;

import com.example.spotifyshuffler.Controller.SongsController;
import com.example.spotifyshuffler.Model.Songs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
public class SpotifyshufflerApplication {

	public static void main(String[] args) {
		SongsController c = new SongsController();
		SpringApplication.run(SpotifyshufflerApplication.class, args);
		Scanner scan = new Scanner(System.in);
		printMenu(c, scan);



	}
	public static Songs createSong(String[] list){
		Songs s = new Songs(list[0],Integer.parseInt(list[1]), list[2], list[3], list[4], list[5], Double.parseDouble(list[6]));
		return s;
	}

	public static void printMenu(SongsController c, Scanner scan){
		System.out.println("what do you want to do? \n" +
				"find all song ; Enter: 1 \n" +
				"find songs by title; Enter: 2 title\n" +
				"find songs by artist; Enter: 3 artist\n" +
				"find songs by Region; Enter: 4 region\n" +
				"find song Count by artist; Enter: 5 artist\n" +
				"find song rank greater than; Enter: 6 rank\n" +
				"find song by rank; Enter: 7 rank\n" +
				"get total count; Enter: 8 \n" +
				"get all songs in date; Enter: 9 date\n" +
				"check song exists; Enter: 10 title\n" +
				"get most popular; Enter: 11\n" +
				"add song; Enter: 12 title, rank, date, artist, region, chart, streams\n" +
				"update song artist; Enter: 13 title, rank, date, artist, region, chart, streams\n" +
				"update song title; Enter: 14date\n" +
				"update song region; Enter: 15date\n" +
				"update song region; Enter: 16date\n" +
				"delete song by artist; Enter: 17date\n" +
				"delete song by title; Enter: 18date\n" +
				"exit; Enter: 19"

		);

		String enter = scan.next();
		String[] list = enter.split(" ");
		String nums;
		String[] rest;
		if(list.length > 1){
			nums = list[0];
			rest = Arrays.copyOfRange(list, 1, list.length);
		}else{
			nums = enter;
			rest = null;
		}
		int num = Integer.parseInt(nums);
		switch(num) {
			case 1:
				System.out.println(c.getSongs());
				break;
			case 2:
				System.out.println(c.getSongsByTitle(rest[0]));
				break;
			case 3:
				System.out.println(c.getSongsByArtist(rest[0]));
				break;
			case 4:
				System.out.println(c.getSongsByRegion(rest[0]));
				break;
			case 5:
				System.out.println(c.getSongsCountByArtist(rest[0]));
				break;
			case 6:
				System.out.println(c.findSongRankGreaterThan(Integer.parseInt(rest[0])));
				break;
			case 7:
				System.out.println(c.getSongsByRank(Integer.parseInt(rest[0])));
				break;
			case 8:
				System.out.println(c.getSongsCount());
				break;
			case 9:
				System.out.println(c.getSongsDate(rest[0]));
				break;
			case 10:
				c.checkSongExists(rest[0]);
				break;
			case 11:
				System.out.println(c.getMostPopular());
				break;
			case 12:

				c.addSong(createSong(rest));
				break;
			case 13:
				c.updateSongArtist(createSong(rest));
				break;
			case 14:
				c.updateSongTitle(createSong(rest));
				break;
			case 15:
				c.updateSongRegion(createSong(rest));
				break;
			case 16:
				c.updateSongChart(createSong(rest));
				break;
			case 17:
				c.deleteSongByArtist(rest[0]);
				break;
			case 18:
				c.deleteSongByTitle(rest[0]);
				break;
			case 19:

				exit(0);
				break;
			default:
				System.out.println("invalid input");

				// code block
		}
		printMenu(c, scan);
	}

}
