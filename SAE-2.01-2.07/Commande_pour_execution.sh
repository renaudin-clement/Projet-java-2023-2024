compile : javac -d bin src/main/java/*.java
executable : java -cp bin Executable
test : java -cp bin MainTest