package com.employeecalculator;

import com.employeecalculator.controller.CalculatorController;
import com.employeecalculator.util.FormatUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class EmployeeCalculatorApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        FormatUtil.setIndianLocale();
        CalculatorController controller = new CalculatorController();
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(controller.getView());
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setStyle("-fx-background: white;");
        
        // Ensure the content can grow
        scrollPane.setPannable(true);
        
        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setTitle("Employee Salary Calculator");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(500);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}