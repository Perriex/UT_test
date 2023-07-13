mvn compile
export EVOSUITE="java -jar evosuite-1.2.0.jar"

$EVOSUITE -prefix morriex.entity -target target/classes -Dsearch_budget=20