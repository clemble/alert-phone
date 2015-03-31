FROM java:8-jre
MAINTAINER antono@clemble.com

EXPOSE 8080

ADD target/alert-phone-0.17.0-SNAPSHOT.jar /data/alert-phone.jar

CMD java -jar -Dspring.profiles.active=cloud /data/alert-phone.jar
