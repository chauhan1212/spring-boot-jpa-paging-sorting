## Spring Boot Pagination, Filter, Sorting | Pageable
#### Prerequisite
```
 external mysql database running instance with application.properties configuration
```
#### application.properties:
```
spring.datasource.url= jdbc:mysql://localhost:3306/springsecurity?useSSL=false
spring.datasource.username= root
spring.datasource.password= password
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto= update
```
#### annotations used:
```
@SpringBootApplication
@Entity
@Table
@Id
@GeneratedValue
@Column
@CrossOrigin
@RestController
@RequestMapping
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PathVariable
@RequestBody
@RequestParam
```
#### Classes used:
```
JpaRepository
Pageable 
Page
Sort
```

#### Application containing jars
```sh
spring-boot-starter-data-jpa
spring-boot-starter-web
mysql-connector-java
```
#### Run Spring Boot application
```
mvn spring-boot:run
```
#### Postman Collection has attached in this project
