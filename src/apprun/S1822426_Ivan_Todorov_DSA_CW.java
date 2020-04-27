/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apprun;

import models.BSTTrack;
import models.Song;
import lists.trackList;
import java.util.*;
import java.io.File;
import java.io.IOException;
import helpers.InputHelper;
import java.io.FileNotFoundException;

/**
 *
 * @author Ivan Todorov
 */
public class S1822426_Ivan_Todorov_DSA_CW {

    static char DELIMITER = ',';

    trackList trackList = new trackList();

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        S1822426_Ivan_Todorov_DSA_CW s1822426_Ivan_Todorov_DSA_CW = new S1822426_Ivan_Todorov_DSA_CW();
    //  s1822426_Ivan_Todorov_DSA_CW.testHarness1();
        s1822426_Ivan_Todorov_DSA_CW.testHarness2();
        s1822426_Ivan_Todorov_DSA_CW.run();
    }

    
    /** 
     * Tests the default constructor for Song and all of its getters
     */
    private static void testHarness1() {
        System.out.println("Test Harness\n=====================\n\n");
        Song song = new Song();
        System.out.println("ID: " + song.getTrackID());
        System.out.println("Track Title: " + song.getTrackTitle());
        System.out.println("Artist: " + song.getArtist());
        System.out.println("Track Length: " + song.getTrackLength());
        System.out.println("Composer: " + song.getComposer());
        System.out.println("Release Date: " + song.getReleaseDate());
        System.out.println("Album: " + song.getAlbum());
        System.out.println("Genre: " + song.getGenre());
    }
    
    /**
     * Adds 5 example songs to the Tracklist
     */
    private void testHarness2() {
        Song song1 = new Song(1,"Last Summer Whisper","Anri","302","Anri","05.04.1982","Heaven Beach","Pop");
        Song song2 = new Song(2,"March of the Dogs","Sum 41","189","Sum 41","24.07.2007","Underclass Hero","Punk Rock");
        Song song3 = new Song(3,"Andromeda","Gorillaz","242","Gorillaz","18.06.2017","Humanz","Electronica");
        Song song4 = new Song(4,"Plastic Love","Mariya Takeuchi","447","Mariya Takeuchi","13.02.2001","Variety","Pop");
        Song song5 = new Song(5,"The Jester","Sum 41","148","Sum 41","24.07.2007","Underclass Hero","Punk Rock");
        trackList.addSong(song1);
        trackList.addSong(song2);
        trackList.addSong(song3);
        trackList.addSong(song4);
        trackList.addSong(song5);
    }  
    
    /**
     * Shows the menu options [A-Q]
     */
        private void run() {
        boolean finished = false;
        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A':
                    addSong();
                    break;
                case 'B':
                    findSongById();
                    break;
                case 'C':
                    findSongByTitle();
                    break;
                case 'D':
                    findSongByArtist();
                    break;
                case 'E':
                    findSongByGenre();
                    break;
                case 'F':
                    trackList.displayAllSongs();
                    break;                    
                case 'Q':
                    finished = true;
            }
        } while (!finished);
    }
            
    /**
     * Shows the menu options [A-Q]
     */
        private char displayMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add a Song");
        System.out.print("\tB. Display a song");
        System.out.print("\tC. Search for a specific song by Title");
        System.out.print("\tD. Search for a specific song by Artist");
        System.out.print("\tE. Display all songs for a given genre in the list");
        System.out.print("\tF. Display all songs in the list");
        System.out.print("\tQ. Quit\n");
        return inputHelper.readCharacter("Enter choice", "ABCDEFQ");
    }

    /**
     * Adds a song to the Tracklist
     */
        public void addSong() {
        System.out.format("\033[32m%s\033[0m%n", "Add new song");
        System.out.format("\033[32m%s\033[0m%n", "==============");
        InputHelper inputHelper = new InputHelper();
        boolean validSong = false;
        Song requiredSong = null;
        do {
            int trackID = inputHelper.readInt("Enter Song Id");
            requiredSong = trackList.findSong(trackID);
            if (requiredSong == null) {
                validSong = true;
                String trackTitle = inputHelper.readString("Enter Song Title");
                String artist = inputHelper.readString("Enter Artist Name");
                String trackLength = inputHelper.readString("Enter Track Length");
                String composer = inputHelper.readString("Enter Composer Name");
                String releaseDate = inputHelper.readString("Enter Release Date");
                String album = inputHelper.readString("Enter Album Name");
                String genre = inputHelper.readString("Enter Genre");
                Song song = new Song(trackID, trackTitle, artist, trackLength, composer, releaseDate, album, genre);
                trackList.addSong(song);
                System.out.println(song);
                System.out.format("\033[32m%s\033[0m%n", "New Song Successfully added!");
            }
        } while (!validSong);
    }
        
    /**
     * Displays a song specified by ID in an appropriate way
     */
    public void findSongID() {
        InputHelper inputHelper = new InputHelper();
        Song requiredSong = null;
        int trackID = inputHelper.readInt("Enter Song Id");
        requiredSong = trackList.findSong(trackID);
        if (requiredSong != null) {
            System.out.println(requiredSong.toString());
        } else {
            System.out.println("Song does not exist, please try again with different ID");
        }
    }

    /**
     * Searches for a specific song by Song Title
     */
    public Song findSongTitle() throws FileNotFoundException {
        InputHelper inputHelper = new InputHelper();
        File file = new File("ExternalData.txt");
        Scanner scanner = new Scanner(file);
        String artist = inputHelper.readString("Enter Artist");
        Song songType = null;
        songType = trackList.findSongArtist(artist);
        BSTTrack BSTTrack = new BSTTrack();
        BSTTrack.makeTree(scanner);
        BSTTrack.printArtist();
        return null;
    }
   
    /**
     * Searches for a specific song by ID
     */
    private void findSongById() {
        InputHelper inputHelper = new InputHelper();
        Song requiredSong = null;
        int trackID = inputHelper.readInt("Enter Song Id");
        requiredSong = trackList.findSong(trackID);
        if (requiredSong != null) {
            System.out.println(requiredSong.toString());
        } else {
            System.out.println("Song does not exist, please try again with a different ID");
        }
    }
  
    /**
     * Searches for a specific song by Title
     */
    private void findSongByTitle() {
        InputHelper inputHelper = new InputHelper();
        Song requiredSong = null;
        String trackTitle = inputHelper.readString("Enter Song Title");
        requiredSong = trackList.findSongTitle(trackTitle);
        if (requiredSong != null) {
            System.out.println(requiredSong.toString());
        } else {
            System.out.println("Song does not exist, please try again with a different Title");
        }
    }
    
    /**
     * Searches for a specific song by Artist name
     */
    private void findSongByArtist() {
        InputHelper inputHelper = new InputHelper();
        Song requiredSong = null;
        String trackArtist = inputHelper.readString("Enter Song Artist");
        requiredSong = trackList.findSongArtist(trackArtist);
        if (requiredSong != null) {
            System.out.println(requiredSong.toString());
        } else {
            System.out.println("Song does not exist, please try again with a different Artist");
        }
    }
    
    /**
     * Searches for a specific song by Genre
     */
    private void findSongByGenre() {
        InputHelper inputHelper = new InputHelper();
        String trackGenre = inputHelper.readString("Enter Song Genre");
        trackList.displayByGenre(trackGenre);
    }
}
