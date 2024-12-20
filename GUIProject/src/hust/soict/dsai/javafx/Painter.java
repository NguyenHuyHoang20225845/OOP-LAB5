package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup toolGroup;

    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;

    private boolean isEraserMode = false;

    @FXML
    void penSelected(ActionEvent event) {
        isEraserMode = false;
    }

    @FXML
    void eraserSelected(ActionEvent event) {
        isEraserMode = true;
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(javafx.scene.input.MouseEvent event) {
        Color color = isEraserMode ? Color.WHITE : Color.BLACK; // White for eraser, Black for pen
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
