# Description
Project to cover all tasks from Microservices Architecture Intensive. Transition from monolith to containers.

### System
- Entities
    - Product
    - Order
- Security
    - Administrator: CRUD Products and Orders
    - Client: R Products, CRUD owned Orders

### Run
```bash
mvn clean package
```
```bash
docker-compose up -d
```

# Documentation
### Externalized configuration: Sprint Cloud Config
  All clients must be configured via `bootstrap.properties` since configs are loaded during an early stage.
  ```bash
  spring.cloud.config.discovery.enabled=true
  spring.cloud.config.discovery.serviceId=${CONFIG_NAME}
  spring.cloud.config.fail-fast=true
  ```

  When `spring.profiles.active=native` configuration files are loaded from `/resources/config` folder and matched to `spring.application.name`.
### Service Discovery: Consul
  Works fine out of the box, and does not require a separate project `image: consul`.
  Requires `spring-cloud-starter-consul-discovery` dependency included in all clients.
  All clients must have `spring.cloud.consul.host=${DISCOVERY_NAME}` set in `bootstrap.properties`.
  All clients must have `spring.application.name=${NAME}` set to work correctly out of the box (this applies to all Spring Cloud libraries).
### Binder: OpenFeign
  Requires `spring-cloud-starter-openfeign` dependency and `@EnableFeignClients` included in all clients.
  To work effectively requires Service Discovery and Load Balancer.
    - Otherwise requires an explicit path to the server provided into `@FeignClient`
### Client Side Load Balancing: Spring Cloud LoadBalancer
  Included through Consul Discovery and Gateway, and probably all major Spring Cloud components.
    - Ribbon implementation has to be explicitly excluded since it's also included in Consul Discovery package and is used by default.
    - Services that depend on some kind of load balancer need to have `Ribbon` explicitly disabled (also affects tests):
      * `spring.cloud.loadbalancer.ribbon.enabled=false`
      * exclude `spring-cloud-netflix-ribbon`
### Api Gateway: Spring Cloud Gateway
  Routes aren't picked up when set via Config Server.
  Pattern matching is wired, you can't set `**/` at beginning to filter anything before. Full path is required.
### Circuit Breaker: Resilience4J
  Requires `spring-cloud-starter-circuitbreaker-reactor-resilience4j` and `resilience4j-circuitbreaker`
  Couldn't understand how to use default auto-configuration. But at least I understand something about it, and documentation is better.
### ~~Circuit Breaker: Hystrix~~
  Requires `spring-cloud-starter-netflix-hystrix`.
  Hystrix autoconfigures in `Greenwich` but doesn't in `Hoxton`
    * Requires at least a default config provided by `Customizer<...CircuitBreakerFactory>` bean.
  Be careful, won't work if `Ribbon` dependency is on classpath, even when it is disabled in properties.

# TODO
### Current
- [ ] Test. Worked and then stopped.
### Features
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
- [x] Api Gateway: Spring Cloud Gateway ~~Zuul~~
- [ ] Circuit Breaker: Resilience4J ~~Hystrix~~
- [ ] Centralized Log: ELK
- [ ] Security: JWT, OAuth
- [ ] Distributed transactions: SAGA
- [ ] Cloud Deployment: AWS
- [ ] Testing: Testconteiners
