# Spring Boot Application (comparison)
This Spring Boot application integrates with Kafka and Redis to demonstrate messaging and data comparison functionality.

## Prerequisites
* Java 17
* Maven
* Docker (for Kafka and Redis)


## Getting Started and setting Up Kafka and Redis
1. Clone this repository:
    ```bash
    git clone https://github.com/gisellykds/comparison-test.git
    cd comparison-test
2. Start the Kafka, Zookeeper, and Redis containers using Docker Compose:
    ```bash
    docker-compose up -d
3. Insert sample data into Redis by running the following commands in your terminal:
    ```bash
    docker exec -it redis-container redis-cli
    set 123 '{"amount":100.05,"metadata":{"a":1,"b":2}}'
    set 124 '{"amount":150.75,"metadata":{"a":10,"b":20}}'
    set 125 '{"amount":1010.00,"metadata":{"a":20,"b":30}}'
    set 126 '{"amount":15.5,"metadata":{"a":30,"b":40}}'

## Running the Spring Boot Application
To start the Spring Boot application, follow these steps:

* Open a terminal and navigate to the root directory of your Spring Boot application.
Run the following command to build and run the application:
    ```bash
    mvn package
    java -jar target/comparison-test.jar

## Health Checks using Spring Actuator
* With the Spring Boot application running, navigate to the following URL in your web browser:
    ```bash
    http://localhost:8080/actuator/health
This endpoint provides information about the health status of the application and its dependencies.

## Testing the API

### Option 1: Using OpenAPI
* After starting the Spring Boot application, open your web browser and go to:
    ```bash
    http://localhost:8080/swagger-ui/index.htm
This will open the Swagger UI documentation, allowing you to test the API /transactions endpoint interactively.

### Option 2: Using Kafka Topic
* In the terminal, navigate to the docker directory:
    ```bash
    cd docker
* Use the following command to produce messages to the topic1 Kafka topic:
    ```bash
    cat messages.json | docker exec -i docker-kafka-1 kafka-console-producer --topic topic1 --bootstrap-server localhost:9092
### Verifying Result Comparison
* To check if the result comparisons were successfully published to topic2, run the following command:
    ```bash
    docker exec -it docker-kafka-1 kafka-console-consumer --topic topic2 --from-beginning --bootstrap-server localhost:9092

## Application Rules
The application listens to topic1, compares the received amount with the corresponding value in Redis, and publishes the result to topic2.

* If the amount stored and the amount received are equal, the result sent to topic2 will be "EQUAL".
* If the amounts are not equal, the result sent to topic2 will be "NOT_EQUAL".
* If the stored amount is not present, the result sent to topic2 will be "KEY_NOT_FOUND".
