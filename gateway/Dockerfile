FROM jdk

MAINTAINER Eric
ENV LANG en_US.UTF-8

RUN mkdir -p /opt/gateway/
RUN chmod -R 777 /opt/gateway/
ADD ./gateway-0.0.1-SNAPSHOT.jar /opt/gateway/gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Xms64m", "-Xmx256m", "-jar", "/opt/gateway/gateway-0.0.1-SNAPSHOT.jar"]
EXPOSE 5555
