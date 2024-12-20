package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // Set up the columns for the table view
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Bind the table view to the ObservableList from the cart
        tblMedia.setItems(this.cart.getItemsOrdered());

        // Initially hide the Play and Remove buttons
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Add a listener for selection changes in the table view
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue); // Update the button bar based on the selected item
                }
            }
        });
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            // Show the filtered media based on the new value
            showFilteredMedia(newValue);
        });
    }
    void updateButtonBar(Media media) {
        // Show the Remove button
        btnRemove.setVisible(true);

        // Show or hide the Play button based on whether the media is Playable
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
        // Get the selected media from the table
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        // Remove the selected media from the cart
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed: " + media.getTitle());
        } else {
            System.out.println("No media selected for removal.");
        }
    }
    private void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            // If filter text is empty, show all items
            filteredMedia.setPredicate(media -> true);
        } else {
            // Apply filter: check if the media title or category contains the filter text (case-insensitive)
            String lowerCaseFilter = filterText.toLowerCase();
            filteredMedia.setPredicate(media -> 
                media.getTitle().toLowerCase().contains(lowerCaseFilter) ||
                media.getCategory().toLowerCase().contains(lowerCaseFilter)
            );
        }
    }


}
