# E-Commerce Sample Microservice Project by Spring Boot 
 
![E-commerceDesgin](https://github.com/ygtyzccc/e-commerce-sample-microservice/assets/78899194/1c3e896c-23b1-4b7e-bf70-7ffb9f69e147)

 
 ## Feature

 * Create Products
 * Create Orders
 * Check Inventory for the given product before placing an order
 * Send notification to customer when an order is placed (Because it is a sample project, It is just implemented, not applied the business logic.)
 
 ## Technologies
 
 * Spring Boot 2.7.8
 * Jdk 15+
 * Spring Cloud
 * Apache Kafka
 * MongoDb
 * PostgreSql
 
 ## How to run the application using Docker

1. Run `mvn clean package -DskipTests` to build the applications and create the docker image locally.
2. Run `docker-compose up -d` to start the applications.

## How to run the application without Docker


1. Run `mvn clean verify -DskipTests` by going inside each folder to build the applications.
2. After that run `mvn spring-boot:run` by going inside each folder to start the applications.

