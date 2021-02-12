# Description
Project to cover all tasks from Microservices Architecture Intensive. Transition from monolith to containers.

## System
- Entities
    - Product
    - Order
- Security
    - Administrator: CRUD Products and Orders
    - Client: R Products, CRUD owned Orders

### Run
- Deploy
```bash
docker-compose up -d
```
- Run
```bash
./mvnw spring-boot:run
```

# TODO
- [x] Monolith
    - [x] JAR
    - [x] Docker compose
- [x] Microservices
    - [x] Multi-module POM
    - [x] JARs
    - [x] Docker compose
- [x] Externalized configurations: Spring Cloud Config
- [x] Service Discovery: Consul ~~Eureka~~
- [x] Binder: OpenFeign
- [x] Client Side Load Balancing: Spring Cloud LoadBalancer ~~Ribbon~~
- [ ] Api Gateway: Spring Cloud Gateway ~~Zuul~~
- [ ] Circuit Breaker: Hystrix
- [ ] Security: JWT, OAuth
- [ ] Distributed transactions: SAGA
- [ ] Centralized Log
- [ ] Cloud Deployment: AWS
