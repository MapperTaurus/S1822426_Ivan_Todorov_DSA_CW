/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import models.Song;


public class trackList extends Song {

    public ADTLinkedList linkedList = new ADTLinkedList();
    static char DELIMITER = ',';

    public void addSong(Song song) {
        linkedList.insert(song);
        System.out.println("Number of songs in the tracklist: " + Count());
    }

    public int Count() {
        return linkedList.length();
    }

    public void displayAllSongs() {
        linkedList.printList();
    }

    public void displayByGenre(String genre) {
        int index = 0;
        while (index < Count()) {
            Song song = linkedList.getItemAtIndex(index);
            if (song.getGenre().equals(genre)) {
                System.out.println(song.toString());
            }
            index++;
        }

    }

    public Song findSongAtIndex(int index) {
        Song song = linkedList.getItemAtIndex(index);
        return song;
    }

    public Song findSong(int id) {
        int index = 0;
        while (index < Count()) {
            Song song = linkedList.getItemAtIndex(index);
            if (song.getTrackID() == id) {
                return song;
            }
            index++;
        }
        return null;
    }

    public Song findSongTitle(String Title) {
        int index = 0;
        while (index < Count()) {
            Song song = linkedList.getItemAtIndex(index);
            if (song.getTrackTitle().equals(Title)) {
                return song;
            }
            index++;
        }
        return null;
    }

    public Song findSongArtist(String Artist) {
        int index = 0;
        while (index < Count()) {
            Song song = linkedList.getItemAtIndex(index);
            if (song.getArtist().equals(Artist)) {
                return song;
            }
            index++;
        }
        return null;
    }

}
