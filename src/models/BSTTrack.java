package models;

import java.util.*;

public class BSTTrack {

    static final char DELIMITER = ',';
    private final TreeSet<Song> index;


    public BSTTrack() {
        index = new TreeSet<>();
    }

    public void makeTree(Scanner scan) {
        String line;
        String[] temp;
        while (scan.hasNextLine()) {
                line = scan.nextLine();
                temp = line.split(Character.toString(DELIMITER));
                int id = Integer.parseInt(temp[0]);
                String title = temp[1];
                String artist = temp[2];
                String trackLength = temp[3];
                String composer = temp[4];
                String releaseDate = temp[5];
                String album = temp[6];
                String genre = temp[7];
                Song song = new Song(id,title,artist,trackLength,composer,releaseDate,album,genre);
                index.add(song);
        }
    }
    //sorted by ASC default
    public void printAll() {
        Iterator it = index.iterator();  
        while(it.hasNext())  
        {  
            System.out.println(it.next());  
        }  

    }

    //print unique artist
    public void printArtist() {
        LinkedHashSet<String> temp = new LinkedHashSet<String>();
        for (Song next : index) {
          temp.add(next.getArtist());
        }
        for (String element: temp) {
            System.out.println(element);
        }
    }

    //sort by desc
    public void printAllDesc() {
        Iterator it = index.descendingIterator();  
        while(it.hasNext())  
        {  
            System.out.println(it.next());  
        }  


    }

}