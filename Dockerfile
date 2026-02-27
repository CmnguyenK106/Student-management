# ================================
# Stage 1: Build
# ================================
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml trước để cache dependencies
COPY student-management/pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code và build
COPY student-management/src ./src
RUN mvn package -DskipTests -B

# ================================
# Stage 2: Run
# ================================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy file JAR từ stage build
COPY --from=builder /app/target/*.jar app.jar

# Render inject biến môi trường qua Environment Variables trên dashboard
# DB_URL, DB_USERNAME, DB_PASSWORD sẽ được Spring Boot đọc tự động

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
