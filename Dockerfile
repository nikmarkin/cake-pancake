ARG VERSION=19

FROM openjdk:${VERSION}-jdk

COPY . /src
WORKDIR /src
RUN ./gradlew --no-daemon build



COPY /build/libs/cake-pancake-1.0-SNAPSHOT.jar /bin/runner/run.jar
WORKDIR /bin/runner

CMD ["java","-jar","run.jar"]