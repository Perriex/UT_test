mvn compile
export EVOSUITE="java -jar evosuite-1.2.0.jar"


$EVOSUITE -class morriex.entity.Actor -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.entity.Comment -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.entity.Movie -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.entity.Rating -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.entity.User -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.entity.Vote -projectCP target/classes -Dsearch_budget=25

$EVOSUITE -class morriex.exception.ActorNotFound -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.AgeLimitError -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.CommentNotFound -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.HttpException -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.InvalidCommand -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.InvalidRateScore -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.InvalidVoteValue -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.MovieAlreadyExists -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.MovieNotFound -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.exception.UserNotFound -projectCP target/classes -Dsearch_budget=25


$EVOSUITE -class morriex.commands.AddToWatchList -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.Command -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.GetActorById -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.GetAllSortedMovies -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.GetMovieById -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.GetMovieList -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.GetMovies -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.GetMoviesByGenre -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.GetMoviesListBySearch -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.GetWatchList -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.RateMovie -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.RemoveFromWatchList -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.SearchMoviesByReleaseDate -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.SortMovies -projectCP target/classes -Dsearch_budget=25
$EVOSUITE -class morriex.commands.VoteComment -projectCP target/classes -Dsearch_budget=25


mvn dependency:copy-dependencies
export CLASSPATH=target/classes:evosuite-standalone-runtime-1.2.0.jar:evosuite-tests:target/dependency/junit-4.13.jar:target/dependency/hamcrest-core-1.3.jar
javac evosuite-tests/morriex/*/*.java


java org.junit.runner.JUnitCore morriex.entity.Actor_ESTest
java org.junit.runner.JUnitCore morriex.entity.Comment_ESTest
java org.junit.runner.JUnitCore morriex.entity.Movie_ESTest
java org.junit.runner.JUnitCore morriex.entity.Rating_ESTest
java org.junit.runner.JUnitCore morriex.entity.User_ESTest
java org.junit.runner.JUnitCore morriex.entity.Vote_ESTest


java org.junit.runner.JUnitCore morriex.exception.ActorNotFound_ESTest
java org.junit.runner.JUnitCore morriex.exception.AgeLimitError_ESTest
java org.junit.runner.JUnitCore morriex.exception.CommentNotFound_ESTest
java org.junit.runner.JUnitCore morriex.exception.HttpException_ESTest
java org.junit.runner.JUnitCore morriex.exception.InvalidCommand_ESTest
java org.junit.runner.JUnitCore morriex.exception.InvalidRateScore_ESTest
java org.junit.runner.JUnitCore morriex.exception.InvalidVoteValue_ESTest
java org.junit.runner.JUnitCore morriex.exception.MovieAlreadyExists_ESTest
java org.junit.runner.JUnitCore morriex.exception.MovieNotFound_ESTest
java org.junit.runner.JUnitCore morriex.exception.UserNotFound_ESTest



java org.junit.runner.JUnitCore morriex.commands.AddToWatchList_ESTest
java org.junit.runner.JUnitCore morriex.commands.Command_ESTest
java org.junit.runner.JUnitCore morriex.commands.GetActorById_ESTest
java org.junit.runner.JUnitCore morriex.commands.GetAllSortedMovies_ESTest
java org.junit.runner.JUnitCore morriex.commands.GetMovieById_ESTest
java org.junit.runner.JUnitCore morriex.commands.GetMovieList_ESTest
java org.junit.runner.JUnitCore morriex.commands.GetMovies_ESTest
java org.junit.runner.JUnitCore morriex.commands.GetMoviesByGenre_ESTest
java org.junit.runner.JUnitCore morriex.commands.GetMoviesListBySearch_ESTest
java org.junit.runner.JUnitCore morriex.commands.RateMovie_ESTest
java org.junit.runner.JUnitCore morriex.commands.RemoveFromWatchList_ESTest
java org.junit.runner.JUnitCore morriex.commands.SearchMoviesByReleaseDate_ESTest
java org.junit.runner.JUnitCore morriex.commands.SortMovies_ESTest
java org.junit.runner.JUnitCore morriex.commands.VoteComment_ESTest
