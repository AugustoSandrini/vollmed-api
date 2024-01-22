# Clinic Management System API

## Description

The Clinic Management System API has been developed to provide an efficient and centralized solution for the management of a medical clinic. With this API, it is possible to perform operations related to patients, doctors, appointments, and relevant information for the clinic's operation.

## Technologies Used

The project was developed using the following technologies:

- **Java**: Object-oriented programming language widely used for enterprise application development.

- **Spring Boot**: Framework that simplifies Java application development, offering minimal configuration and facilitating the creation of RESTful APIs.

- **MySQL**: Relational database management system, used to store the system's data.

- **Flyway**: Database versioning tool that simplifies migration and versioning of the database schema.

## Features

The Clinic Management System API offers the following features:

1. **Patient Registration**: Allows the inclusion, updating, removal, and consultation of patient information.

2. **Doctor Registration**: Enables complete management of doctor information, including addition, editing, deletion, and querying.

3. **Appointment Scheduling**: Provides resources for scheduling appointments, querying appointments, and canceling scheduled appointments.

## Usage Instructions

### Prerequisites

- Java 8 or higher installed
- MySQL installed and configured
- Maven installed

### Database Configuration

1. Create a database in MySQL for the project.
2. Configure the database properties in the `application.properties` file.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```
## Running the Project

1. Clone the project repository:

```bash
    git clone https://github.com/AugustoSandrini/vollmed-api
```

2. Navigate to the project directory:

```bash
    cd vollmed-api
```

3. Run the project using Maven:

```bash
    mvn spring-boot:run
```
The API will be available at http://localhost:8080.

## Contribuitions

- Contributions are welcome! If you encounter any issues or have suggestions for improvements, feel free to create an issue or submit a pull request.

## License

- This project is licensed under the MIT License.