mvn clean package
# shellcheck disable=SC2046
kill -9 $(lsof -t -i:8080)
rm -rf ./apache-tomcat-10.1.15/webapps/*
cp ./target/hw_12_servlet_crud.war ./apache-tomcat-10.1.15/webapps/
sh ./apache-tomcat-10.1.15/bin/startup.sh
open http://localhost:8080/hw_12_servlet_crud/main
