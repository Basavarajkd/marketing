# Marketing App

The Marketing App is a RESTful API application that provides various endpoints for retrieving and analyzing marketing data related to product transactions.


## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- RESTful API
- MySQL 
- Maven

## Prerequisites

- Java Development Kit (JDK) installed
- PostgreSQL installed and running
- Postman or any other REST API testing tool

## Getting Started

1. Clone the repository:

2. Import the project into your preferred Java IDE.

3. Configure the PostgreSQL database connection settings in the `application.properties` file.

4. Build the project using Maven:

5. Run the application:

The Marketing App should now be up and running on `http://localhost:8080`.

## API Endpoints

The following API endpoints are available:

- `GET /api/total_items`: Retrieves the total number of items sold within a specified date range and department.
- `GET /api/nth_most_total_item`: Retrieves the nth most sold item based on quantity or price within a specified date range.
- `GET /api/percentage_of_department_wise_sold_items`: Retrieves the percentage of department-wise sold items within a specified date range.
- `GET /api/monthly_sales`: Retrieves the monthly sales for a specific product in a given year.
