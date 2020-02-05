FROM jdk

MAINTAINER Eric
ENV LANG en_US.UTF-8
 
RUN mkdir -p /opt/config-server/
RUN chmod -R 777 /opt/config-server/
ADD ./config-server-0.0.1-SNAPSHOT.jar /opt/config-server/config-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Xms64m", "-Xmx256m", "-jar", "/opt/config-server/config-server-0.0.1-SNAPSHOT.jar"]
EXPOSE 30888
