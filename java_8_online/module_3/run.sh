mvn clean package
# shellcheck disable=SC2181
if [ $? -eq 0 ]; then
  java -jar target/module_3.jar
else
    echo "An error occurred while compiling and building the project"
fi