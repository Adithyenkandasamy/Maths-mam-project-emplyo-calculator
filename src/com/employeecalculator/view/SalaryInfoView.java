package com.employeecalculator.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class SalaryInfoView {
    private TextField hoursWorkedField;
    private TextField hourlyRateField;
    private TextField overtimeHoursField;
    private GridPane view;

    public SalaryInfoView() {
        hoursWorkedField = new TextField();
        hoursWorkedField.setPromptText("e.g., 40.0");
        
        hourlyRateField = new TextField();
        hourlyRateField.setPromptText("e.g., 25.50");
        
        overtimeHoursField = new TextField();
        overtimeHoursField.setPromptText("e.g., 5.0");
        overtimeHoursField.setText("0.0");
        
        view = new GridPane();
        view.setHgap(10);
        view.setVgap(8);
        view.setPadding(new Insets(10));
        
        view.addRow(0, new Label("Regular Hours:"), hoursWorkedField);
        view.addRow(1, new Label("Overtime Hours:"), overtimeHoursField);
        view.addRow(2, new Label("Hourly Rate (₹):"), hourlyRateField);
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.NEVER);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        view.getColumnConstraints().addAll(col1, col2);
        
        hoursWorkedField.setMaxWidth(Double.MAX_VALUE);
        hourlyRateField.setMaxWidth(Double.MAX_VALUE);
        overtimeHoursField.setMaxWidth(Double.MAX_VALUE);
    }

    public GridPane getView() {
        return view;
    }

    public double getHoursWorked() {
        try {
            return Double.parseDouble(hoursWorkedField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public double getOvertimeHours() {
        try {
            return Double.parseDouble(overtimeHoursField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public double getHourlyRate() {
        try {
            return Double.parseDouble(hourlyRateField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}