/*
 * This file was automatically generated by EvoSuite
 * Fri Jun 30 15:13:54 GMT 2023
 */

package morriex.commands;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import morriex.commands.GetAllSortedMovies;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class GetAllSortedMovies_ESTest extends GetAllSortedMovies_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      GetAllSortedMovies getAllSortedMovies0 = new GetAllSortedMovies();
      // Undeclared exception!
      try { 
        getAllSortedMovies0.handle("", "", "");
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.commands.GetAllSortedMovies", e);
      }
  }
}