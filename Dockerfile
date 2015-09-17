FROM java:8-jre
MAINTAINER antono@clemble.com

EXPOSE 10003

ADD ./buildoutput/alert-phone.jar /data/alert-phone.jar

CMD java -jar -Dspring.profiles.active=cloud  -Dlogging.config=classpath:logback.cloud.xml -Dserver.port=10003 /data/alert-phone.jar
