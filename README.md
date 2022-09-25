# Customer Management Application

Customer Management project by Mert Kondakcıoğlu.

### Build Commands:

- `mvn clean install` : Build, compile and test project
- `docker-compose up -d --build` : For Installing from docker compose file(Project and MySQL image)

## DB Info

- This project is using MySQL on database, you can install image from docker compose file. If you installed MySQL image
  then you can start its container. By the way you can download it by manual from its official site.
- When you start project, schema and tables created by Flyway script file.

```
url: jdbc:mysql://localhost:3306
port: 3306
username: root
password: 1234
```

## Project Info

### Login credentials

```
email: mertkondakcioglu@gmail.com
password: 12345678
```

- This project is using Maven and JDK17.
- If you install project image from docker compose file, then be sure MySQL running at least 30 seconds. Otherwise,
  project can not be started.
- Postman collection JSON link: https://www.getpostman.com/collections/b192d90684f6072c3b8c
- API Documentation: http://localhost:8080/swagger-ui/index.html#/
