FROM adoptopenjdk/openjdk11-openj9:jre-11.0.11_9_openj9-0.26.0-debianslim as builder

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

RUN java -Djarmode=layertools -jar app.jar extract

FROM adoptopenjdk/openjdk11-openj9:jre-11.0.11_9_openj9-0.26.0-debianslim
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./

RUN addgroup --system spring-group && adduser --system --ingroup spring-group spring-user
USER spring-user

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]