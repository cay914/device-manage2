FROM jdk

MAINTAINER Eric
ENV LANG en_US.UTF-8

RUN mkdir -p /opt/zuul/
RUN chmod -R 777 /opt/zuul/
ADD ./zuul-0.0.1-SNAPSHOT.jar /opt/zuul/zuul-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Xms64m", "-Xmx256m", "-jar", "/opt/zuul/zuul-0.0.1-SNAPSHOT.jar"]
EXPOSE 5555
