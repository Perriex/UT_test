/*
 * This file was automatically generated by EvoSuite
 * Thu Jul 13 08:15:14 GMT 2023
 */

package morriex.entity;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import morriex.entity.User;
import morriex.model.UserModel;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockInstant;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class User_ESTest extends User_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      userModel0.email = "J~8{|ZK_6!";
      User user0 = new User(userModel0);
      UserModel userModel1 = user0.getModel();
      assertNotSame(userModel0, userModel1);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      userModel0.name = "";
      User user0 = new User(userModel0);
      UserModel userModel1 = user0.getModel();
      assertNotSame(userModel0, userModel1);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      user0.addToWatch((Integer) null);
      Integer integer0 = new Integer(1);
      user0.addToWatch(integer0);
      user0.removeFromWatch(integer0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      user0.setWatchlist((ArrayList<Integer>) null);
      ArrayList<Integer> arrayList0 = user0.getWatch();
      assertNull(arrayList0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      Integer integer0 = new Integer(2421);
      user0.addToWatch(integer0);
      ArrayList<Integer> arrayList0 = user0.getWatch();
      assertFalse(arrayList0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      MockDate mockDate0 = new MockDate();
      userModel0.birthDate = (Date) mockDate0;
      User user0 = new User(userModel0);
      int int0 = user0.getAge();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      Instant instant0 = MockInstant.ofEpochMilli(0L);
      Date date0 = Date.from(instant0);
      userModel0.birthDate = date0;
      User user0 = new User(userModel0);
      int int0 = user0.getAge();
      assertEquals(44, int0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      MockDate mockDate0 = new MockDate(403, 4123, 403);
      userModel0.birthDate = (Date) mockDate0;
      User user0 = new User(userModel0);
      int int0 = user0.getAge();
      assertEquals((-633), int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      userModel0.password = "";
      User user0 = new User(userModel0);
      user0.hassPass();
      Boolean boolean0 = user0.checkPassword("");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      user0.watchList = null;
      try { 
        user0.addToWatch((Integer) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      User user0 = null;
      try {
        user0 = new User((UserModel) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.User", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      Integer integer0 = new Integer((-3520));
      try { 
        user0.removeFromWatch(integer0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // MovieNotFound
         //
         verifyException("morriex.entity.User", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      Integer integer0 = new Integer(1);
      user0.addToWatch(integer0);
      user0.removeFromWatch(integer0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      user0.addToWatch((Integer) null);
      try { 
        user0.addToWatch((Integer) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // MovieAlreadyExists
         //
         verifyException("morriex.entity.User", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      ArrayList<Integer> arrayList0 = user0.getWatch();
      assertTrue(arrayList0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      user0.setWatchlist((ArrayList<Integer>) null);
      Integer integer0 = new Integer(506);
      try { 
        user0.removeFromWatch(integer0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.User", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      // Undeclared exception!
      try { 
        user0.getAge();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      Boolean boolean0 = user0.checkPassword("morriex.entity.User");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      UserModel userModel0 = new UserModel();
      User user0 = new User(userModel0);
      user0.hassPass();
      UserModel userModel1 = user0.getModel();
      assertNotSame(userModel0, userModel1);
  }
}
