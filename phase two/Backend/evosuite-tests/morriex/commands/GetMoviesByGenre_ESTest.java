/*
 * This file was automatically generated by EvoSuite
 * Fri Jun 30 15:16:49 GMT 2023
 */

package morriex.commands;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import morriex.commands.GetMoviesByGenre;
import morriex.model.urlParam.GetMoviesByGenreModel;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class GetMoviesByGenre_ESTest extends GetMoviesByGenre_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      GetMoviesByGenre getMoviesByGenre0 = new GetMoviesByGenre();
      GetMoviesByGenreModel getMoviesByGenreModel0 = new GetMoviesByGenreModel();
      // Undeclared exception!
      try { 
        getMoviesByGenre0.handle(getMoviesByGenreModel0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.commands.GetMoviesByGenre", e);
      }
  }
}
