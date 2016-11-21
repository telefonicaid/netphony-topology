FROM openjdk:8-jre

COPY target/topology-*-shaded.jar /opt/tads/topology.jar
COPY target/*.xml /opt/tads/

WORKDIR /opt/tads

EXPOSE 179 8088

ENTRYPOINT ["java", "-Dlog4j.configurationFile=log4j2.xml", "-jar", "topology.jar"]
