FROM tomcat

COPY /target/root.war /usr/local/tomcat/webapps/
COPY src/main/webapp/script/init.sql /docker-entrypoint-initdb.d/
#RUN cp src/main/webapp/script/init.sql /docker-entrypoint-initdb.d