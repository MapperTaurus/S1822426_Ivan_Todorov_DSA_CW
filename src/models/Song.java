/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Ivan Todorov
 */
public class Song implements Comparable<Song>{
    private final int trackID;
    private String trackTitle;
    private String artist;
    private String trackLength;
    private String composer;
    private String releaseDate;
    private String album;
    private String genre;
    
    //Initial value for ID
    private static int lastIdAllocated = 0;

 public Song () {
        this.trackID = ++lastIdAllocated;
        this.trackTitle = "TBC";
        this.artist = "TBC";
        this.trackLength = "TBC";
        this.composer = "TBC";
        this.releaseDate = "TBC";
        this.album = "TBC";
        this.genre = "TBC";
    }

    public Song(int trackID, String trackTitle, String artist, String trackLength, String composer, String releaseDate, String album, String genre) {
        this.trackID = trackID;
        this.trackTitle = trackTitle;
        this.artist = artist;
        this.trackLength = trackLength;
        this.composer = composer;
        this.releaseDate = releaseDate;
        this.album = album;
        this.genre = genre;
    }
    
    public Song(String trackTitle) {
    this.trackID = ++lastIdAllocated;
    this.trackTitle = trackTitle;
    }

    public int getTrackID() {
    return trackID;
    }
    
    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(String trackLength) {
        this.trackLength = trackLength;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static int getLastIdAllocated() {
        return lastIdAllocated;
    }

    public static void setLastIdAllocated(int lastIdAllocated) {
        Song.lastIdAllocated = lastIdAllocated;
    }
    
    public void display() {
        
        String s = this.getTrackID() + " " + this.getTrackTitle() + " " + this.getArtist() + " " + this.getTrackLength() + " " + this.getComposer() + " " + this.getReleaseDate() + " " + this.getAlbum() + " " + this.getGenre() ;
        System.out.println(s);
    }

    public String toString(){
        return "\nTrackId:"+ this.trackID 
           + "\nTitle:"+ this.trackTitle
           + "\nArtist:"+ this.artist
           + "\nTrackLength:"+ this.trackLength
           + "\nComposer:"+ this.composer
           + "\nReleaseDate:"+ this.releaseDate
           + "\nAlbum:"+ this.album
           + "\nGenre:"+ this.genre;
    }
   
    @Override
    public int compareTo(Song song) {
     return this.artist.compareTo(song.artist);
        }

}
