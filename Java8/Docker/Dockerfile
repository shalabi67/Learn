FROM openjdk:latest
ENV JAR=first-docker-1.0-SNAPSHOT.jar
ENV DEST=/usr/src/$JAR
#COPY target/$JAR /usr/src/$JAR
COPY target/$JAR $DEST


#both will work
#CMD java -cp /usr/src/$JAR com.docker.training.Application
CMD java -cp $DEST com.docker.training.Application


#will work
#ENTRYPOINT ["java", "-cp", "/usr/src/first-docker-1.0-SNAPSHOT.jar", "com.docker.training.Application"]


#will not work
#CMD [$DEST, com.docker.training.Application]
#ENTRYPOINT ["java", "-cp"]