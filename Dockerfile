FROM n3ziniuka5/ubuntu-oracle-jdk:14.04-JDK7
MAINTAINER Oscar Gonzalez (oscar.gonzalezdedios@telefonica.com)
LABEL version="1.3.0"
LABEL description="BGP Peer"
LABEL source_url="https://github.com/telefonicaid/netphony-topology"

#install maven
RUN sudo apt-get update
RUN sudo apt-cache search maven
RUN sudo apt-get -y install maven

#copy code files
COPY . /usr/src/app

#compile
RUN mvn package -P bgp-ls-speaker assembly:single -X -f /usr/src/app/pom.xml
RUN mv /usr/src/app/target/bgp-ls-speaker-jar-with-dependencies.jar /usr/src/app/target/BGPPeer.jar
RUN cp -r /usr/src/app/src/test/resources/ /usr/src/app/examplesConf/
WORKDIR /usr/src/app/

