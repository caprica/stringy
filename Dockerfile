FROM openjdk:11-jdk
LABEL maintainer="mark.lee@capricasoftware.co.uk"
ARG GROUP=stringy
ARG USER=stringy
RUN groupadd ${GROUP} && useradd -g ${GROUP} -s /bin/sh ${USER}
USER stringy:stringy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} stringy.jar
ENTRYPOINT ["java", "-jar", "stringy.jar"]
