/*
 * This file was automatically generated by EvoSuite
 * Fri Jun 30 15:07:06 GMT 2023
 */

package morriex.exception;

import org.junit.Test;
import static org.junit.Assert.*;
import morriex.exception.HttpException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class HttpException_ESTest extends HttpException_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      HttpException httpException0 = new HttpException();
      Integer integer0 = new Integer(0);
      httpException0.setStatus(integer0);
      Integer integer1 = httpException0.getStatus();
      assertEquals(0, (int)integer1);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      HttpException httpException0 = new HttpException();
      httpException0.setStatus((Integer) null);
      Integer integer0 = httpException0.getStatus();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      HttpException httpException0 = new HttpException();
      Integer integer0 = new Integer((-1753));
      httpException0.setStatus(integer0);
      Integer integer1 = httpException0.getStatus();
      assertEquals((-1753), (int)integer1);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      HttpException httpException0 = new HttpException();
      Integer integer0 = httpException0.getStatus();
      httpException0.setStatus(integer0);
      assertEquals(400, (int)httpException0.getStatus());
  }
}