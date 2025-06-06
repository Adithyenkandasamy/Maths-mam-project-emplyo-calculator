# Employee Salary Calculator

A JavaFX application for calculating employee salaries with a user-friendly interface.

## Features

- **Employee Information Management**: Capture employee name, ID, and department
- **Salary Calculation**: Calculate salaries based on regular hours and overtime
- **Benefits Management**: Handle performance bonuses
- **Tax Calculation**: Automatic tax calculation based on progressive tax brackets
- **Deductions**: Calculate health insurance and retirement deductions
- **Clean, Modern UI**: Intuitive user interface with organized sections

## Project Structure

The application follows the Model-View-Controller (MVC) architecture:

- **Model**: Handles the data and business logic
  - `Employee.java`: Data model representing an employee
  - `SalaryCalculator.java`: Handles salary calculations
  - `Constants.java`: Application-wide constants

- **View**: Handles the UI components
  - `EmployeeInfoView.java`: Employee information section
  - `SalaryInfoView.java`: Salary information section
  - `BenefitsView.java`: Additional benefits section
  - `ResultsView.java`: Results display section
  - `UIFactory.java`: Factory for creating UI components with consistent styling

- **Controller**: Coordinates between models and views
  - `CalculatorController.java`: Main controller class

## How to Run

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- JavaFX SDK 11 or higher

### Method 1: Using an IDE

1. Clone or download the repository
2. Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, etc.)
3. Make sure JavaFX libraries are properly configured in your IDE
4. Run `EmployeeCalculatorApp.java` as a Java application

### Method 2: Using Maven

If you prefer to use Maven, add the following to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>17.0.2</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-maven-plugin</artifactId>
            <version>0.0.8</version>
            <configuration>
                <mainClass>com.employeecalculator.EmployeeCalculatorApp</mainClass>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Then run with:

```bash
mvn javafx:run
```

### Method 3: Using Command Line

1. Compile all Java files:
```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d out src/com/employeecalculator/*.java src/com/employeecalculator/*/*.java
```

2. Run the application:
```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp out com.employeecalculator.EmployeeCalculatorApp
```

Replace `/path/to/javafx-sdk` with the actual path to your JavaFX SDK installation.

## Usage

1. Fill in the employee information (name, ID, department)
2. Enter the salary information (hours worked, hourly rate)
3. Select overtime option if applicable
4. Add any performance bonus if applicable
5. Click "Calculate Salary" to see the results
6. Use "Clear Form" to reset all fields

## Screenshots

[Place screenshots here when available]

## Future Enhancements

- Save/load employee data to/from files
- Support for different currencies
- Print/export functionality for salary reports
- Additional benefits and deductions options
- Dark mode theme option

## License

MIT License

## Author

Maths-mam-project

"javac --module-path "C:\Users\Jinwoo\Downloads\openjfx-24.0.1_windows-x64_bin-sdk\javafx-sdk-24.0.1\lib" --add-modules javafx.controls -d ..\out com\employeecalculator\*.java com\employeecalculator\controller\*.java com\employeecalculator\model\*.java com\employeecalculator\util\*.java com\employeecalculator\view\*.java"

"java --module-path "C:\Users\Jinwoo\Downloads\openjfx-24.0.1_windows-x64_bin-sdk\javafx-sdk-24.0.1\lib" --add-modules javafx.controls -cp "..\out" com.employeecalculator.EmployeeCalculatorApp"