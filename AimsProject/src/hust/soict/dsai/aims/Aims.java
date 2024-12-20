package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.media.Book;

//import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
//import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.CompactDisc;
//import java.util.ArrayList;
import java.util.Scanner;


public class Aims {
    private static Cart cart = new Cart();
    private static Store store = new Store();

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    public static void updateStoreMenu(Store store, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Update Store:");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to the store");
            System.out.println("2. Remove a media from the store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1: // Add a media
                    Store.addMediaToStore(store, scanner);
                    break;
                case 2: // Remove a media
                    Store.removeMediaFromStore(store, scanner);
                    break;
                case 0: // Back
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 0-1-2.");
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Populate the store with some media for testing
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 17.50f));
        store.addMedia(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 24.99f));
        store.addMedia(new CompactDisc("Hello", "Rock", 15.34f, "Me"));
        store.addMedia(new CompactDisc("The Dark Side of the Moon", "Music", 18.75f, "Pink Floyd"));
        store.addMedia(new CompactDisc("Back in Black", "Music", 13.99f, "AC/DC"));
        store.addMedia(new Book("1984", "Dystopian", 9.99f));
        store.addMedia(new Book("To Kill a Mockingbird", "Classic", 14.99f));
        store.addMedia(new Book("The Catcher in the Rye", "Classic", 12.50f));
        new StoreScreen(store, cart);

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    handleViewStore(scanner);
                    break;
                case 2:
                    handleUpdateStore(scanner);
                    break;
                case 3:
                    handleCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void handleViewStore(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("STORE CONTENTS:");
            store.printStore();

            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    handleMediaDetails(scanner);
                    break;
                case 2:
                    System.out.print("Enter the title of the media to add to cart: ");
                    String title = scanner.nextLine();
                    Media media = store.searchMediaByTitle(title);
                    if (media != null) {
                        cart.addMedia(media);
                        System.out.println("Media added to cart.");
                    } else {
                        System.out.println("Media not found in store.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the media to play: ");
                    title = scanner.nextLine();
                    media = store.searchMediaByTitle(title);
                    if (media instanceof DigitalVideoDisc) {
                        ((DigitalVideoDisc) media).play();
                    } else {
                        System.out.println("Media is not playable.");
                    }
                    break;
                case 4:
                  //  cart.printCart();
                    handleCart(scanner);
                    //cartMenu();
                   // back = false;
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleUpdateStore(Scanner scanner) {
        System.out.println("Update store functionality is under construction.");
        updateStoreMenu(store, scanner);
        }

    private static void handleCart(Scanner scanner) {
        boolean back = false;
      // ArrayList<Media> store = new ArrayList<>();

        while (!back) {
            System.out.println("CURRENT CART:");
            cart.printCart();

            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
            case 1:
                System.out.println("Filter Options: ");
                System.out.println("1. By ID");
                System.out.println("2. By Title");
                System.out.print("Choose an option: ");
                int filterChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (filterChoice) {
                    case 1:
                        System.out.print("Enter the ID of the media: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        cart.filterById(id);
                        break;
                    case 2:
                        System.out.print("Enter the title of the media: ");
                        String filterTitle = scanner.nextLine();
                        cart.filterByTitle(filterTitle);
                        break;
                    default:
                        System.out.println("Invalid option. Returning to cart menu.");
                }
                break;

                case 2:
                    cart.sortByTitleCost();
                    cart.sortByCostTitle();
                    break;
                case 3:
                    System.out.print("Enter the title of the media to remove: ");
                    String title = scanner.nextLine();
                    
                    // Declare the media variable and assign it the result of the search
                    Media media = cart.searchByTitle(title);
                    
                    if (media != null) {
                        cart.removeMedia(media); // Remove the media if found
                        System.out.println("Media \"" + media.getTitle() + "\" removed from the cart.");
                    } else {
                        System.out.println("Media not found. No item was removed.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the title of the media to play: ");
                    title = scanner.nextLine();
                    media = cart.searchByTitle(title);
                    if (media instanceof DigitalVideoDisc) {
                        ((DigitalVideoDisc) media).play();
                    } else {
                        System.out.println("Media is not playable.");
                    }
                    break;
                case 5:
                    System.out.println("Order placed. Cart is now empty.");
                    cart.clearCart();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleMediaDetails(Scanner scanner) {
        System.out.print("Enter the title of the media to view details: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                    break;
                case 2:
                    if (media instanceof DigitalVideoDisc) {
                        ((DigitalVideoDisc) media).play();
                    } else {
                        System.out.println("Media is not playable.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Returning to store menu.");
            }
        } else {
            System.out.println("Media not found in store.");
        }
    }
    
}
