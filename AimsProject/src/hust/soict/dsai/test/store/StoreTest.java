package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Creating some DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 89, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        // Adding DVDs to the store
        System.out.println("Adding DVDs to the store:");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Displaying DVDs in the store
      

        // Removing a DVD from the store
        System.out.println("\nRemoving a DVD from the store:");
        store.removeDVD(dvd2);

        // Displaying DVDs in the store after removal
        

        // Attempting to remove a DVD not in the store
        System.out.println("\nTrying to remove a DVD not in the store:");
        store.removeDVD(dvd2);
    }
}
