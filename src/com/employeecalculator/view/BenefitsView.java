package com.employeecalculator.view;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BenefitsView {
    private CheckBox overtimeCheckBox;
    private CheckBox bonusCheckBox;
    private TextField bonusAmountField;
    private VBox view;

    public BenefitsView() {
        overtimeCheckBox = new CheckBox("Has Overtime");
        bonusCheckBox = new CheckBox("Has Bonus");
        bonusAmountField = new TextField();
        bonusAmountField.setDisable(true);
        bonusAmountField.setPromptText("Bonus Amount");
        
        bonusCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            bonusAmountField.setDisable(!newVal);
            if (!newVal) {
                bonusAmountField.clear();
            }
        });
        
        view = new VBox(10, 
            new Label("Benefits:"),
            overtimeCheckBox,
            bonusCheckBox,
            bonusAmountField
        );
        
        view.setStyle("-fx-padding: 10;");
    }

    public VBox getView() {
        return view;
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