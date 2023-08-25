#FROM openjdk:11-jdk-slim as JAR_EXTRACT
#WORKDIR /app
#ARG JAR_FILE=*.jar
#COPY ./target/${JAR_FILE} ./app.jar
#RUN java -Djarmode=layertools -jar ./app.jar extract
#
#FROM openjdk:11-jdk-slim
#WORKDIR /application
#COPY --from=JAR_EXTRACT /app/dependencies ./
#COPY --from=JAR_EXTRACT /app/spring-boot-loader ./
#COPY --from=JAR_EXTRACT /app/snapshot-dependencies ./
#COPY --from=JAR_EXTRACT /app/application ./
#
#EXPOSE 8081
#
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

FROM openjdk:11-jre-slim

WORKDIR /app
COPY ./target/*.jar /app/doctor.jar

EXPOSE 8082

CMD ["java", "-jar", "doctor.jar"]