package hust.soict.dsai.aims.media;

import java.util.ArrayList;


public class MediaTest {
    public static void main(String[] args) {
        // Create an ArrayList of Media
        ArrayList<Media> mediaList = new ArrayList<>();

        // Add some media objects to the list
      //  ArrayList<Track> tracks = new ArrayList<>();
        mediaList.add(new CompactDisc("Back in Black", "Music", 20.0f, "AC/DC"));
        mediaList.add(new CompactDisc("Dark Side of the Moon", "Music", 25.0f, "Pink Floyd"));
        mediaList.add(new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 18.50f));
        mediaList.add(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 22.99f));
        mediaList.add(new Book("1984", "Dystopian", 9.99f));
        mediaList.add(new Book("To Kill a Mockingbird", "Classic", 14.99f));
        mediaList.add(new CompactDisc("Abbey Road", "Music", 19.99f, "The Beatles"));
        mediaList.add(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 17.99f));
        mediaList.add(new Book("Pride and Prejudice", "Romance", 7.99f));
        mediaList.add(new CompactDisc("Thriller", "Music", 30.0f, "Michael Jackson")); // Duplicate title with higher cost

        
        // Iterate through the list and print out the information of each media
        System.out.println("\nList of media:");
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
        mediaList.sort(new MediaComparatorByTitleCost());
        System.out.println("\nList of media sorted by Title Cost:");

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
        
        mediaList.sort(new MediaComparatorByCostTitle());
        System.out.println("\nList of media sorted by Cost Title:");

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
   
   
}
