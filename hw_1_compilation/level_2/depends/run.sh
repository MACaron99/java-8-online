javac -sourcepath ./src -d build/classes -cp ./libs/commons-math3-3.3.jar ./src/ua/com/alevel/Value.java
java -cp build/classes/:./libs/commons-math3-3.3.jar ua.com.alevel.Value