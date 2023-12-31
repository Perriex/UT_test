/*
 * This file was automatically generated by EvoSuite
 * Thu Jul 13 08:15:55 GMT 2023
 */

package morriex.entity;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import morriex.entity.Actor;
import morriex.model.ActorModel;
import morriex.model.view.ActorShortModel;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Actor_ESTest extends Actor_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ActorModel actorModel0 = new ActorModel();
      Actor actor0 = new Actor(actorModel0);
      actor0.image = "D";
      // Undeclared exception!
      try { 
        actor0.getModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Actor", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ActorModel actorModel0 = new ActorModel();
      actorModel0.name = "";
      Actor actor0 = new Actor(actorModel0);
      // Undeclared exception!
      try { 
        actor0.getModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Actor", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ActorModel actorModel0 = new ActorModel();
      Actor actor0 = new Actor(actorModel0);
      actor0.image = "D";
      ActorShortModel actorShortModel0 = actor0.getShortModel();
      assertNotNull(actorShortModel0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ActorModel actorModel0 = new ActorModel();
      actorModel0.name = "";
      Actor actor0 = new Actor(actorModel0);
      ActorShortModel actorShortModel0 = actor0.getShortModel();
      assertNotNull(actorShortModel0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Actor actor0 = null;
      try {
        actor0 = new Actor((ActorModel) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Actor", e);
      }
  }
}
