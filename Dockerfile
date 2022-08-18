FROM openjdk:11

COPY target/starwarsapi-1.0.0.jar starwarsapi-1.0.0.jar

ENTRYPOINT ["java","-jar","/starwarsapi-1.0.0.jar"]