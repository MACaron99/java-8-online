mvn clean package
# shellcheck disable=SC2181
if [ $? -eq 0 ]; then
  java -cp target/classes org.example.Handshake
else
    echo "An error occurred while compiling and building the project"
fi