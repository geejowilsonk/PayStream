curl -X POST "http://localhost:8080/api/users/register" \
-d "username=johndoe" -d "password=secret" -d "role=USER"


mvn spring-boot:run


docker system prune -a



CREATE TABLE users (
id SERIAL PRIMARY KEY,
username VARCHAR(100) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(50) NOT NULL
);

