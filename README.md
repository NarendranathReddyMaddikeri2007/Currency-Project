# Currency Project
## Structure
![uml_diagram1 drawio](https://github.com/NarendranathReddyMaddikeri2007/Currency-Project/assets/93245481/c15b5086-04bd-4629-b831-371db414bf1c)
## Implemented Concepts
  + Monitoring
  + Documentation 
    - Used Swagger UI for viewing documentation
  + HAL Explorer
  + Naming Server 
    - Implemented using Eureka Server
    - Eureka naming server is an application that holds information about all client service applications. Each microservice registers itself with the Eureka naming server.
  + Load Balancing (Client Side)
    - Implemented using Feign Client and Eureka Server
  + API Gateway
    - Implemented using Spring Cloud Gateway
    - An API gateway is a server (or L7 proxy) between a client and microservices that acts as a centralized entry point for all clients into the system. 
  + Circuit Breaker
    - Implemented using Resilience4j

## Endpoints
### Currency Conversion Service
```
http://localhost:8100/currency-conversion/from/USD/to/IND/quantity/250
```
### Currency Conversion Using Feign
```
http://localhost:8100/currency-conversion-feign/from/USD/to/IND/quantity/250
```
### Currency Exchange Service
```
http://localhost:8000/currency-exchange/from/AUS/to/IND
```  

## Ports

| Feature | Port(s) |
| ------ | ----------- |
| Spring Cloud Config Server  | 8888 |
| Currency Exchange Service | 8000, 8001, 8002 |
| Currency Conversion Service    | 8100, 8101, 8102 |
| Netflix Eureka Naming Server  | 8761 |
| Spring Cloud Gateway | 8765 |

## Dependencies
### Naming Server
+ Spring Boot Actuator
+ Netflix Eurek Client
+ Spring Dev Tools

### API Gateway
+ Spring Boot Actuator
+ Spring Cloud Gateway
+ Netflix Eureka Client
+ Zipkin
+ Spring Dev Tools

### Currency Conversion Service
+ Spring Web
+ Spring Dev Tools
+ H2 Database
+ Netflix Eureka Client
+ Feign Client

### Currency Exchange Service
+ Spring Web
+ Spring Dev Tools
+ Spring Data JPA
+ H2 Database
+ Spring Aop
+ Netflix Eureka Client


