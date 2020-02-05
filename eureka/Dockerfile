FROM jdk

MAINTAINER Eric
ENV LANG en_US.UTF-8

RUN mkdir -p /opt/eureka/
RUN chmod -R 777 /opt/eureka/
COPY ./eureka-0.0.1-SNAPSHOT.jar /opt/eureka/eureka-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Xms64m", "-Xmx256m", "-jar", "/opt/eureka/eureka-0.0.1-SNAPSHOT.jar"]
EXPOSE 30761
