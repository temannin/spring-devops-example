# Spring DevOps Example

A demonstration Spring Boot application showcasing modern DevOps practices and CI/CD workflows.

## 🚀 Overview

This project serves as a practical example of implementing DevOps best practices in a Spring Boot application. It demonstrates various aspects of modern software development lifecycle including automated testing, code coverage, continuous integration, and deployment workflows.

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.5.6**
- **Maven** - Build and dependency management
- **JaCoCo** - Code coverage reporting
- **GitHub Actions** - CI/CD pipeline
- **JUnit 5** - Unit testing framework

## 📋 Features

### DevOps Practices Demonstrated

- ✅ **Automated Testing** - Unit tests with JUnit 5
- ✅ **Code Coverage** - JaCoCo integration for coverage reporting
- ✅ **CI/CD Pipeline** - GitHub Actions workflow
- ✅ **Dependency Management** - Maven with Spring Boot starter
- ✅ **Code Quality** - Automated testing and coverage gates
- ✅ **Artifact Management** - Coverage reports as workflow artifacts
- ✅ **Pull Request Integration** - Automated coverage comments

### Application Features

- Simple Spring Boot REST application
- Health check endpoint
- Configurable application properties
- Embedded Tomcat server

## 🏗️ Project Structure

```
spring-devops-example/
├── .github/
│   └── workflows/
│       └── coverage.yml          # CI/CD pipeline with coverage
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │       └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/demo/
│               └── DemoApplicationTests.java
├── pom.xml                       # Maven configuration with JaCoCo
├── mvnw                          # Maven wrapper
└── README.md                     # This file
```

## 🚦 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)

### Running the Application

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd spring-devops-example
   ```

2. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   Or using Maven directly:
   ```bash
   mvn spring-boot:run
   ```

3. **Access the application**
   - Application will be available at: `http://localhost:8080`
   - Health check: `http://localhost:8080/actuator/health`

### Running Tests

```bash
# Run all tests
./mvnw test

# Run tests with coverage report
./mvnw clean test jacoco:report

# View coverage report
open target/site/jacoco/index.html
```

## 🔄 CI/CD Pipeline

The project includes a comprehensive GitHub Actions workflow (`.github/workflows/coverage.yml`) that demonstrates:

### Pipeline Features

- **Automated Testing** - Runs on every push and pull request
- **Code Coverage** - Generates JaCoCo coverage reports
- **Multi-Environment** - Supports multiple branches (main, develop)
- **Caching** - Maven dependencies cached for faster builds
- **Artifacts** - Coverage reports saved as workflow artifacts
- **PR Integration** - Automatic coverage comments on pull requests
- **GitHub Pages** - Coverage reports published to GitHub Pages

### Workflow Triggers

- Push to `main` or `develop` branches
- Pull requests targeting `main` or `develop` branches

### Coverage Integration

- **JaCoCo Reports** - HTML and XML coverage reports
- **Codecov Integration** - Optional integration with Codecov service
- **Coverage Thresholds** - Configurable minimum coverage requirements
- **PR Comments** - Automatic coverage summary in pull request comments

## 📊 Code Coverage

The project uses JaCoCo for code coverage reporting:

- **Coverage Collection** - Automatic during test execution
- **Report Generation** - HTML and XML reports in `target/site/jacoco/`
- **CI Integration** - Coverage reports generated in GitHub Actions
- **Artifact Storage** - Reports available as workflow artifacts

### Viewing Coverage Reports

1. **Local Development**
   ```bash
   ./mvnw clean test jacoco:report
   open target/site/jacoco/index.html
   ```

2. **CI/CD Pipeline**
   - Check workflow artifacts in GitHub Actions
   - View coverage comments on pull requests
   - Access GitHub Pages coverage reports (if enabled)

## 🔧 Configuration

### Application Properties

The application can be configured via `src/main/resources/application.properties`:

```properties
# Server configuration
server.port=8080

# Actuator endpoints
management.endpoints.web.exposure.include=health,info
management.endpoint.health.show-details=always
```

### JaCoCo Configuration

JaCoCo is configured in `pom.xml` with:
- Agent preparation during test execution
- Report generation after tests complete
- Configurable coverage thresholds (optional)

## 🧪 Testing

### Test Structure

- **Unit Tests** - Located in `src/test/java/`
- **Test Configuration** - Spring Boot test configuration
- **Coverage Collection** - Automatic with JaCoCo integration

### Running Tests

```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=DemoApplicationTests

# Run tests with coverage
./mvnw clean test jacoco:report
```

## 🚀 Deployment

### Local Development

```bash
# Run with Maven
./mvnw spring-boot:run

# Build and run JAR
./mvnw clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

### Production Considerations

- Configure appropriate logging levels
- Set up monitoring and health checks
- Configure external databases if needed
- Set up proper security configurations

## 📚 DevOps Best Practices Demonstrated

1. **Infrastructure as Code** - GitHub Actions workflows
2. **Automated Testing** - CI/CD pipeline with test execution
3. **Code Quality** - Coverage reporting and quality gates
4. **Version Control** - Git-based workflow with branching strategy
5. **Build Automation** - Maven-based build process
6. **Artifact Management** - Coverage reports and build artifacts
7. **Monitoring** - Health checks and application metrics
8. **Documentation** - Comprehensive README and inline documentation

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

The CI/CD pipeline will automatically:
- Run tests
- Generate coverage reports
- Comment on the PR with coverage information

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- JaCoCo team for code coverage tools
- GitHub for Actions and CI/CD platform
- Maven community for build tools

---

**Note**: This is a demonstration project showcasing DevOps practices. For production use, consider additional security, monitoring, and deployment configurations.
