FROM openjdk:11-jre-slim
EXPOSE 8080
ENV TZ=Asia/Seoul
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-Xmx200m", "-jar", "-Duser.timezone=Asia/Seoul", "/app.jar"]