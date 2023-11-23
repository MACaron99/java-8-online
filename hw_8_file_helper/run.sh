mvn clean package
# shellcheck disable=SC2181
if [ $? -eq 0 ]; then
  java -jar target/hw_8_file_helper.jar
else
    echo "An error occurred while compiling and building the project"
fi