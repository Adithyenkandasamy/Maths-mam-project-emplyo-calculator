package com.employeecalculator.controller;

import com.employeecalculator.model.Employee;
import com.employeecalculator.model.SalaryCalculator;
import com.employeecalculator.view.BenefitsView;
import com.employeecalculator.view.EmployeeInfoView;
import com.employeecalculator.view.ResultsView;
import com.employeecalculator.view.SalaryInfoView;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.Map;

public class CalculatorController {
    private final EmployeeInfoView employeeInfoView;
    private final SalaryInfoView salaryInfoView;
    private final BenefitsView benefitsView;
    private final ResultsView resultsView;
    private final VBox view;

    public CalculatorController() {
        this.employeeInfoView = new EmployeeInfoView();
        this.salaryInfoView = new SalaryInfoView();
        this.benefitsView = new BenefitsView();
        this.resultsView = new ResultsView();
        
        this.view = new VBox(15);
        this.view.setPadding(new Insets(15));
        this.view.setStyle("-fx-background-color: #f5f5f5;");
        
        VBox.setVgrow(employeeInfoView.getView(), Priority.NEVER);
        VBox.setVgrow(salaryInfoView.getView(), Priority.NEVER);
        VBox.setVgrow(benefitsView.getView(), Priority.NEVER);
        VBox.setVgrow(resultsView.getView(), Priority.ALWAYS);
        
        this.view.getChildren().addAll(
            createSection("Employee Information", employeeInfoView.getView()),
            createSection("Salary Information", salaryInfoView.getView()),
            createSection("Benefits", benefitsView.getView()),
            createSection("Results", resultsView.getView())
        );
        
        setupEventHandlers();
    }
    
    private VBox createSection(String title, Node content) {
        VBox section = new VBox(5);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-background-color: white; -fx-border-color: #e0e0e0; -fx-border-width: 1px; -fx-border-radius: 5;");
        
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 1.1em;");
        
        section.getChildren().addAll(titleLabel, content);
        return section;
    }

    public VBox getView() {
        return view;
    }

    private void setupEventHandlers() {
        resultsView.getCalculateButton().setOnAction(e -> calculateSalary());
    }

    private void calculateSalary() {
        try {
            Employee employee = new Employee(
                employeeInfoView.getName(),
                employeeInfoView.getAge(),
                employeeInfoView.getPosition()
            );
            
            employee.setHoursWorked(salaryInfoView.getHoursWorked());
            employee.setOvertimeHours(salaryInfoView.getOvertimeHours());
            employee.setHourlyRate(salaryInfoView.getHourlyRate());
            employee.setHasBonus(benefitsView.hasBonus());
            employee.setBonusAmount(benefitsView.getBonusAmount());
            
            SalaryCalculator calculator = new SalaryCalculator();
            Map<String, String> results = calculator.calculateSalary(employee);
            
            resultsView.displayResults(results);
            
        } catch (NumberFormatException e) {
            resultsView.displayError("Invalid input. Please check your entries and try again.");
        } catch (Exception e) {
            resultsView.displayError("An error occurred: " + e.getMessage());
        }
    }
}