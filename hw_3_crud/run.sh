mvn clean package
# shellcheck disable=SC2181
if [ $? -eq 0 ]; then
  java -jar target/hw_3_crud.jar
else
    echo "An error occurred while compiling and building the project"
fi