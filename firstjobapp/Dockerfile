FROM eclipse-temurin:17-jre

WORKDIR /app

VOLUME /data

COPY target/firstjobapp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENV SPRING_DOCKER_COMPOSE_ENABLED=false

# Add pgAdmin environment variables (adjust values as needed)
ENV PGADMIN_DEFAULT_EMAIL=admin@example.com
ENV PGADMIN_DEFAULT_PASSWORD=adminpassword


ENTRYPOINT ["java", "-jar", "app.jar"]

