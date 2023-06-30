/*
 * This file was automatically generated by EvoSuite
 * Fri Jun 30 15:02:07 GMT 2023
 */

package morriex.entity;

import org.junit.Test;
import static org.junit.Assert.*;
import morriex.entity.Rating;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Rating_ESTest extends Rating_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Integer integer0 = new Integer((-239));
      Rating rating0 = new Rating("", integer0);
      rating0.userEmail = "";
      rating0.userEmail = null;
      String string0 = rating0.getUserEmail();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Integer integer0 = new Integer(1863);
      Rating rating0 = new Rating("PVIZo ", integer0);
      String string0 = rating0.getUserEmail();
      assertEquals("PVIZo ", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Integer integer0 = new Integer((-239));
      Rating rating0 = new Rating("", integer0);
      rating0.rate = integer0;
      rating0.rate = rating0.rate;
      Integer integer1 = new Integer(0);
      rating0.rate = integer1;
      Integer integer2 = rating0.getRate();
      assertFalse(integer2.equals((Object)integer0));
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Integer integer0 = new Integer(1863);
      Rating rating0 = new Rating("PVIZo ", integer0);
      Integer integer1 = rating0.getRate();
      assertEquals(1863, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Rating rating0 = new Rating("", (Integer) null);
      Integer integer0 = rating0.getRate();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Integer integer0 = new Integer((-239));
      Rating rating0 = new Rating("", integer0);
      Integer integer1 = rating0.getRate();
      assertEquals((-239), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Rating rating0 = new Rating("", (Integer) null);
      String string0 = rating0.getUserEmail();
      assertEquals("", string0);
  }
}
