FROM openjdk:11-jdk
ENV SERVER_PORT=8080
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} project-reactor-docker.jar
ENTRYPOINT ["java","-jar","/project-reactor-docker.jar"]