# E-commerce Test Automation Framework

## Overview
This is a Java-based test automation framework built using Selenium WebDriver for testing e-commerce website functionality. The framework follows the Page Object Model (POM) design pattern and is integrated with TestNG for test execution and reporting.

## Tech Stack
- Java 22
- Selenium WebDriver 4.25
- TestNG 7.10.2
- Maven
- WebDriverManager 5.9.2
- Apache POI 5.2.3

## Project Structure
```
ecommerce-automation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── ecommerce/
│   │               ├── pages/
│   │               │   ├── HomePage.java
│   │               │   ├── ProductPage.java
│   │               │   └── CartPage.java
│   │               └── utils/
│   │                   └── ExcelUtils.java
│   │
│   ├── test/
│      ├── java/
│      │   └── com/
│      │       └── ecommerce/
│      │           └── tests/
│      │               └── TestCases.java
│      └── resources/
│          └── products.xlsx
│  
│  
│       
│
├── screenshots/
├── test-output/
├── pom.xml
├── testng.xml
└── README.md
```

## Prerequisites
1. Java Development Kit (JDK) 22 or higher
2. Maven
3. Git
4. Chrome/Firefox browser
5. IDE (Eclipse)

## Setup Instructions


### 2. IDE Setup

#### For Eclipse:
1. Go to File → Import
2. Select "Existing Maven Projects"
3. Browse to the cloned project directory
4. Click Finish

### 3. Install Dependencies
```bash
mvn clean install
```

## Test Data Setup
1. Navigate to `src/test/resources/`
2. Open `testData.xlsx`
3. Add your test data in the following format:

| product | brand  | 
|---------|--------|
| Laptop  | Hp   | 
| Phone   | Samsung| 

## Running Tests

### Using Maven
```bash
# Run all tests
mvn clean test

# Run specific test class
mvn clean test -Dtest=ProductSearchTest

# Run with specific TestNG XML file
mvn clean test -DsuiteXmlFile=testng.xml
```


### Using IDE
1. Right-click on `testng.xml`
2. Select "Run 'testng.xml'"

## Framework Features

### 1. Page Object Model
- Separate classes for each webpage
- Encapsulated locators and methods
- Reusable page components

### 2. Test Data Management
- Excel-driven testing using Apache POI

- Easy test data maintenance

### 3. Reporting
- Screenshot capture on Success

### 4. Wait Strategies
- Implicit waits
- Explicit waits
- Custom wait conditions

### 5. Utilities
- Screenshot capture
- Excel data reader
- Common helper methods

## CI/CD Integration


### Jenkins Integration
1. Create new Jenkins Pipeline job
2. Configure Git repository
3. Add Jenkinsfile:
```groovy
pipeline {
    agent any
    tools {
        maven 'Maven '
        jdk 'JDK 22'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'index.html',
                    reportName: 'Test Report'
                ])
            }
        }
    }
}
```

## Best Practices
1. Follow Page Object Model design pattern
2. Use meaningful names for methods and variables
3. Maintain test data in external files
4. Implement proper wait strategies
5. Add comments for complex logic
6. Keep tests independent
7. Use assertion messages
8. Capture screenshots for failures
9. Implement proper exception handling
10. Regular code reviews

## Troubleshooting
1. **Tests fail to start:**
   - Verify WebDriver setup
   - Check browser compatibility
   - Ensure correct dependencies

2. **Element not found errors:**
   - Review locators
   - Check wait conditions
   - Verify page load

3. **Data provider issues:**
   - Check Excel file path
   - Verify data format
   - Review TestNG configuration

## Contributing
1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create Pull Request

## License
This project is licensed under the MIT License - see the LICENSE file for details
