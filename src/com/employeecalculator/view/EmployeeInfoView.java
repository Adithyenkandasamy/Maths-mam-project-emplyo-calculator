package com.employeecalculator.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;

public class EmployeeInfoView {
    private TextField nameField;
    private TextField ageField;
    private TextField positionField;
    private GridPane view;

    public EmployeeInfoView() {
        nameField = new TextField();
        nameField.setPromptText("Enter name");
        
        ageField = new TextField();
        ageField.setPromptText("Enter age");
        
        positionField = new TextField();
        positionField.setPromptText("Enter position");
        
        view = new GridPane();
        view.setHgap(10);
        view.setVgap(8);
        view.setPadding(new Insets(10));
        
        view.addRow(0, new Label("Name:"), nameField);
        view.addRow(1, new Label("Age:"), ageField);
        view.addRow(2, new Label("Position:"), positionField);
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.NEVER);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        view.getColumnConstraints().addAll(col1, col2);
        
        nameField.setMaxWidth(Double.MAX_VALUE);
        ageField.setMaxWidth(Double.MAX_VALUE);
        positionField.setMaxWidth(Double.MAX_VALUE);
    }

    public GridPane getView() {
        return view;
    }

    public String getName() {
        return nameField.getText();
    }

    public int getAge() {
        try {
            return Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String getPosition() {
        return positionField.getText();
    }
}