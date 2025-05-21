package com.employeecalculator.view;

import com.employeecalculator.model.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Factory class for creating UI components with consistent styling.
 */
public class UIFactory {
    
    /**
     * Creates a styled header with title and subtitle
     * @param title Main title text
     * @param subtitle Subtitle text
     * @return Styled HBox containing the header
     */
    public static HBox createHeader(String title, String subtitle) {
        HBox headerBox = new HBox(10);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(15));
        headerBox.setStyle("-fx-border-color: #cccccc; -fx-border-width: 0 0 1 0;");
        
        Text titleText = new Text(title);
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleText.setFill(Color.valueOf(Constants.PRIMARY_TEXT_COLOR));
        
        Text subtitleText = new Text(subtitle);
        subtitleText.setFont(Font.font("Arial", 14));
        subtitleText.setFill(Color.valueOf("#666666"));
        
        headerBox.getChildren().addAll(titleText, subtitleText);
        return headerBox;
    }
    
    /**
     * Creates a styled button with given text and width
     * @param text Button text
     * @param isPrimary Whether this is a primary button
     * @param width Button width (use -1 for auto width)
     * @return Styled Button
     */
    public static Button createButton(String text, boolean isPrimary, double width) {
        Button button = new Button(text);
        
        if (width > 0) {
            button.setPrefWidth(width);
        }
        button.setPrefHeight(40);
        
        if (isPrimary) {
            button.setStyle(Constants.PRIMARY_BUTTON_STYLE);
        } else {
            button.setStyle(Constants.SECONDARY_BUTTON_STYLE);
        }
        
        return button;
    }
    
    /**
     * Creates a titled section with a grid layout
     * @param title Section title
     * @param content The content to include in the section
     * @return TitledPane containing the content
     */
    public static TitledPane createSection(String title, GridPane content) {
        content.setVgap(10);
        content.setHgap(15);
        content.setPadding(new Insets(20));
        
        TitledPane section = new TitledPane(title, content);
        section.setCollapsible(false);
        return section;
    }
    
    /**
     * Creates a standard label
     * @param text Label text
     * @return Styled Label
     */
    public static Label createLabel(String text) {
        Label label = new Label(text);
        return label;
    }
    
    /**
     * Creates a numeric text field with validation
     * @param promptText Field prompt text
     * @return TextField that only accepts numeric input
     */
    public static TextField createNumericField(String promptText) {
        TextField field = new TextField();
        field.setPromptText(promptText);
        
        // Add validation to ensure only numeric values are entered
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(Constants.NUMERIC_PATTERN)) {
                field.setText(oldValue);
            }
        });
        
        return field;
    }
    
    /**
     * Creates a standard text field
     * @param promptText Field prompt text
     * @return Styled TextField
     */
    public static TextField createTextField(String promptText) {
        TextField field = new TextField();
        field.setPromptText(promptText);
        return field;
    }
    
    /**
     * Creates an alert dialog
     * @param type Alert type
     * @param title Alert title
     * @param message Alert message
     * @return Configured Alert dialog
     */
    public static Alert createAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        return alert;
    }
}