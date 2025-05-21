package com.employeecalculator.view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.util.Map;

public class ResultsView {
    private final CheckBox overtimeCheckBox;
    private final CheckBox bonusCheckBox;
    private final TextField bonusAmountField;
    private final VBox view;
    private final Button calculateButton;
    private final Label resultLabel;
    private final Label errorLabel;

    public ResultsView() {
        this.overtimeCheckBox = new CheckBox("Has Overtime");
        this.bonusCheckBox = new CheckBox("Has Bonus");
        this.bonusAmountField = new TextField();
        this.bonusAmountField.setDisable(true);
        this.bonusAmountField.setPromptText("Bonus Amount");
        
        this.bonusCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            this.bonusAmountField.setDisable(!newVal);
            if (!newVal) {
                this.bonusAmountField.clear();
            }
        });
        
        this.calculateButton = new Button("Calculate");
        this.resultLabel = new Label();
        this.resultLabel.setWrapText(true);
        
        this.errorLabel = new Label();
        this.errorLabel.setStyle("-fx-text-fill: red;");
        this.errorLabel.setWrapText(true);
        
        this.view = new VBox(10, 
            new Label("Benefits:"),
            this.overtimeCheckBox,
            this.bonusCheckBox,
            this.bonusAmountField,
            this.calculateButton,
            this.resultLabel,
            this.errorLabel
        );
        
        this.view.setPadding(new Insets(10));
    }

    public VBox getView() {
        return view;
    }

    public Button getCalculateButton() {
        return calculateButton;
    }
    
    public void displayResults(Map<String, String> results) {
        errorLabel.setText("");
        StringBuilder resultText = new StringBuilder();
        results.forEach((key, value) -> {
            resultText.append(String.format("%s: %s%n", key, value));
        });
        resultLabel.setText(resultText.toString());
    }
    
    public void displayError(String message) {
        errorLabel.setText(message);
    }
    
    public boolean hasOvertime() {
        return overtimeCheckBox.isSelected();
    }

    public boolean hasBonus() {
        return bonusCheckBox.isSelected();
    }

    public double getBonusAmount() {
        try {
            return Double.parseDouble(bonusAmountField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}