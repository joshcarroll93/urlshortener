FROM openjdk:15
ADD target/url-shortener-application.jar url-shortener-application.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "url-shortener-application.jar"]