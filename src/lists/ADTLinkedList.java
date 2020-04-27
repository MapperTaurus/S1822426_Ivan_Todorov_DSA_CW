/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.LinkedList;
import models.Song;


public class ADTLinkedList implements IADTList{
    
    
     public ADTLinkedList () {
 
    }
    
    
    @Override
    public void createList() {
        this.head = 0;       // first item in the array is at position 0
        this.noOfElements = 0;     // there are no items in the list
    }


    @Override
    public void printList(  ) {
        int tmp = this.head;
        System.out.println( String.format( "Printing song list of %d songs", this.noOfElements ) );
        int count = 0;
        while ( validAccess( tmp ) ) {
            count ++;
            Song song = linkedList.get(tmp);
            System.out.println( String.format( "Song(%d):%s", count, song.getTrackTitle() ) );
            tmp --;
        }
    }

    /**
    *
    * @author [jde, added 7/12/15]
    * @version [1] - version info of a class or interface.
    * @param [String s] - string to be inserted into list.
    */
    @Override
    public boolean insert( Song s ) {
        boolean ok = true;
        int nextPosition = this.noOfElements;
        System.out.println( String.format( "Trying to insert song: %s at position %d", s, nextPosition ) );
        if ( ! arrayListFull( nextPosition ) ) {
            // add first
            linkedList.add(s);
            this.head = nextPosition;
            this.noOfElements ++;
        } else {
            // create error message
            System.out.println( "List Full - Unable to add song " + s );
            ok = false;
        }
        return ok;
    }

    @Override
    public Song getItemAtIndex(int n){
        if(validAccess(n)){
            return linkedList.get(n);
        }
        return null;
    }
    /**
    *
    * @author [jde, added 7/12/15]
    * @version [1] - version info of a class or interface.
    * @param [String searchString] - string being searched for
    * @return [return boolean] - lets user know if searchstring has been found or not
    */
    @Override
    public boolean find(String searchString) {
        int tmp = head;

        while ( validAccess( tmp ) )  {
            System.out.println( String.format( "checking Data: %s at positon %d", searchString, tmp ) );
            if ( searchString.equals( linkedList.get(tmp) ) ) return true;
            tmp --;
        }
        // if we get to here then we fell off the end of the list so not found
        return false;
    }
    /**
    *
    * @author [jde, added 7/12/15]
    * @version [1] -
    * @param [String searchString] - string being removed
    */
    @Override
    public String remove(String searchString) {
        int current = head;   // make sure we're pointing to the head node
        boolean stillSearching = true;
        while ( validAccess( current ) && stillSearching )  {
            System.out.println( "Comparing: " + searchString + " with " + linkedList.get(current) );
            if ( ! searchString.equals( linkedList.get(current) ) ) {
                //System.out.println( "Not found: " + searchString + " at " + current );
                current --;
            } else {
               /* we have found the node, now try and remove it from the list */
               //System.out.println( "Found: " + searchString + " at " + current + " List length is " + length );
               // shift all elements down one
               for ( int index = current + 1; index < this.noOfElements ; index ++ )
                   linkedList.set( index - 1, linkedList.get(index) );
               this.noOfElements --;  // update length of the list now that one element has been removed
               this.head = this.noOfElements - 1;
               current = ILLEGALARRAYINDEX; // terminates loop
               stillSearching = false;
            }
        }
        if ( stillSearching ) {
            // can't be in list
            return "Element not found in list";
        } else {
            return searchString;
        }
}

    public int length() {
        return this.noOfElements;
    }

    /**
    *
    * @author [jde]
    * @version [1] - version info of a class or interface
    */
    public String toString() {
        int tmp = this.head;
        String listString =  "";
        int count = 0;
        while ( validAccess( tmp ) ) {
            count ++;
            listString += String.format( "(%d) ==> %s", count, linkedList.get(tmp) );
            tmp ++;
        }
        return listString;
    }

/* Protected Section */
    protected int head = 0;

/* Private Section */
    private final int MAXNOOFELEMENTS = 10;    
    private int noOfElements = 0;
    private int ILLEGALARRAYINDEX = -999;   // anything outside the array subscript range

    private LinkedList<Song> linkedList = new LinkedList<Song>();

    private boolean inRange( int index, int min, int max ) {
        return ( ( min <= index ) && ( index < max ) );
    }

    private boolean validAccess( int index ) {
        return ( inRange( index, 0, this.noOfElements ) );
    }

    private boolean arrayListFull( int index ) {
        return ( ! inRange( index, 0, MAXNOOFELEMENTS ) );
    }

    private enum WhereInList { FIRST, MIDDLE, LAST };


}



