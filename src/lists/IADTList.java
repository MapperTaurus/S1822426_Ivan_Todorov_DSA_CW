/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import models.Song;



public interface IADTList {


    public int length();


    public void createList();


    public void printList();

    
    public boolean insert(Song s);


    public String remove(String s);


    public boolean find(String s);
    
 
    public Object getItemAtIndex(int n);

}
