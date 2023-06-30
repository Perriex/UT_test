mvn compile
export EVOSUITE="java -jar evosuite-1.2.0.jar"
$EVOSUITE
$EVOSUITE -class tutorial.ComplexProgram -projectCP target/classes   
mvn dependency:copy-dependencies
export CLASSPATH=target/classes:evosuite-standalone-runtime-1.2.0.jar:evosuite-tests:target/dependency/junit-4.12.jar:target/dependency/hamcrest-core-1.3.jar
javac evosuite-tests/tutorial/*.java
java org.junit.runner.JUnitCore tutorial.ComplexProgram_ESTest
$EVOSUITE -class tutorial.ComplexProgram -projectCP target/classes   
javac evosuite-tests/tutorial/*.java
java org.junit.runner.JUnitCore tutorial.ComplexProgram_ESTest
$EVOSUITE -class tutorial.ComplexProgram -projectCP target/classes -Dsearch_budget=20
javac evosuite-tests/tutorial/*.java
java org.junit.runner.JUnitCore tutorial.ComplexProgram_ESTest
