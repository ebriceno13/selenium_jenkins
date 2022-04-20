FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq
WORKDIR /usr/share/docs

ADD target/SeleniumFramework-1.0-SNAPSHOT.jar       SeleniumFramework-1.0-SNAPSHOT.jar
ADD target/SeleniumFramework-1.0-SNAPSHOT-tests.jar SeleniumFramework-1.0-SNAPSHOT-tests.jar
ADD target/libs                                     libs
ADD config.properties config.properties
ADD AccountSuite.xml    AccountSuite.xml
ADD SearchSuite.xml     SearchSuite.xml
ADD src/test/resources/testData src/test/resources/testData
ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh

ENTRYPOINT sh healthcheck.sh