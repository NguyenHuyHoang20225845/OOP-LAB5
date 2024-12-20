package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 50; // Maximum number of items in the store
    private ArrayList<Media> itemsInStore = new ArrayList<Media>(); // Stores all media items

    // Method to add a media item to the store
    public boolean addMedia(Media media) {
        if (itemsInStore.size() >= MAX_NUMBERS_IN_STORE) {
            System.out.println("The store is full. Cannot add more media items.");
            return false;
        }
        itemsInStore.add(media);
        System.out.println("Media item \"" + media.getTitle() + "\" has been added to the store.");
        return true;
    }

    // Method to remove a media item from the store
    public boolean removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media item \"" + media.getTitle() + "\" has been removed from the store.");
            return true;
        }
        System.out.println("Media item \"" + media.getTitle() + "\" is not found in the store.");
        return false;
    }
    
    public void printStore() {
        System.out.println("Items in Store:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.println("-----------------------------------");
    }
    
    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public static void addMediaToStore(Store store, Scanner scanner) {
        System.out.println("Choose media type to add:");
        System.out.println("1. CompactDisc");
        System.out.println("2. Book");
        System.out.println("3. DigitalVideoDisc");
        System.out.print("Enter your choice: ");
        int mediaType = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline

        switch (mediaType) {
            case 1: // Add CompactDisc
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                CompactDisc cd = new CompactDisc(title, category, cost, artist);
                store.addMedia(cd);
                System.out.println("CompactDisc added to store.");
                break;

            case 2: // Add Book
                Book book = new Book(title, category, cost);
                store.addMedia(book);
                System.out.println("Book added to store.");
                break;

            case 3: // Add DigitalVideoDisc
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                System.out.print("Enter length: ");
                int length = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);
                System.out.println("DigitalVideoDisc added to store.");
                break;

            default:
                System.out.println("Invalid media type. Please choose 1-2-3.");
        }
    }
    public static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();

        Media mediaToRemove = store.searchMediaByTitle(title);
        if (mediaToRemove != null) {
            store.removeMedia(mediaToRemove);
            System.out.println("Media removed from store.");
        } else {
            System.out.println("Media with title \"" + title + "\" not found in store.");
        }
    }

    
    public ArrayList<Media> getItemsInStore() {
        return new ArrayList<>(itemsInStore); // Return a copy to avoid external modification
    }
}
