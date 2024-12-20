package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public double totalCost() {
        double total = 0.0;
        for (Media item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public boolean addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full. Cannot add more items.");
            return false;
        }
        itemsOrdered.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added to the cart.");
        return true;
    }

    public boolean removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the cart.");
            return true;
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" is not in the cart.");
            return false;
        }
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        double totalCost = 0.0;

        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media item = itemsOrdered.get(i);
            System.out.printf("%d. Media - %s - %s - %s - %d: %.2f $\n",
                    i + 1,
                    item.getTitle(),
                    item.getCategory(),
                    item instanceof DigitalVideoDisc ? ((DigitalVideoDisc) item).getDirector() : "N/A",
                    item instanceof DigitalVideoDisc ? ((DigitalVideoDisc) item).getLength() : 0,
                    item.getCost());
            totalCost += item.getCost();
        }

        System.out.printf("Total cost: %.2f $\n", totalCost);
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println("Media Found:");
                System.out.printf("ID: %d, Title: %s, Category: %s, Director: %s, Length: %d, Cost: %.2f $\n",
                        item.getId(),
                        item.getTitle(),
                        item.getCategory(),
                        item instanceof DigitalVideoDisc ? ((DigitalVideoDisc) item).getDirector() : "N/A",
                        item instanceof DigitalVideoDisc ? ((DigitalVideoDisc) item).getLength() : 0,
                        item.getCost());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media with ID " + id + " found in the cart.");
        }
    }

    public Media searchByTitle(String title) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media Found:");
                System.out.printf("ID: %d, Title: %s, Category: %s, Director: %s, Length: %d, Cost: %.2f $\n",
                        item.getId(),
                        item.getTitle(),
                        item.getCategory(),
                        item instanceof DigitalVideoDisc ? ((DigitalVideoDisc) item).getDirector() : "N/A",
                        item instanceof DigitalVideoDisc ? ((DigitalVideoDisc) item).getLength() : 0,
                        item.getCost());
                found = true;
                return item;
            }
        }
        if (!found) {
            System.out.println("No media with title \"" + title + "\" found in the cart.");
        }
        return null;
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(new MediaComparatorByTitleCost());
        System.out.println("\nList of media sorted by Title Cost:");

        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(new MediaComparatorByCostTitle());
        System.out.println("\nList of media sorted by Cost Title:");

        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    public void filterById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Media Found:");
                System.out.println(media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media Found:");
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: \"" + title + "\"");
        }
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
