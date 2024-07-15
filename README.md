# Technical Test

Full Stack Developer Role Technical Test at Compulynx
---

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (version 17 or higher)
- Maven build tool installed
- IDE (like IntelliJ IDEA or Eclipse) installed (optional but recommended)

---

## Getting Started

To get a local copy up and running follow these simple steps.

### Clone the repository

```bash
git clone https://github.com/alifeinbits/BackendTechnicalTest.git
cd BackendTechnicalTest
```

## Configure application.properties
Ensure your application.properties file is properly configured. You may need to set database connection details and other environment-specific configurations.

### Build and Run the application
You can build and run the application using Maven:

```bash
mvn clean package
java -jar target/compulynx-restapi-test-0.0.1-SNAPSHOT.jar
```
### Alternatively, you can run the application directly from your IDE:
Import the project into your IDE.
Run the main method in [CompulynxRestapiTestApplication.java](src%2Fmain%2Fjava%2Fcom%2Fcompulynx%2Finterview%2FCompulynxRestapiTestApplication.java)
Verify the application is running
Open your web browser and navigate to:
```bash
http://localhost:8080
```

# Usage
Explain how to use the endpoints provided by your application.

## Swagger API Documentation
The API documentation can be accessed using Swagger UI:
```bash
http://localhost:8080/v2/api-docs
```
Use Swagger UI to explore and test the API endpoints.


# Testing
## Using Postman Collection
Testing the API endpoints can be done using Postman. Import the provided Postman collection file [postman_collection.json](postman%2Fpostman_collection.json) inside postman directory and use it to send requests to your API endpoints.

# Contact
If you have any questions or feedback, feel free to contact me at [felixmutua01@gmail.com].


