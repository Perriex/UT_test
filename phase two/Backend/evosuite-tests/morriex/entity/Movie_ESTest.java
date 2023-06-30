/*
 * This file was automatically generated by EvoSuite
 * Fri Jun 30 15:01:02 GMT 2023
 */

package morriex.entity;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import morriex.entity.Comment;
import morriex.entity.Movie;
import morriex.model.CommentModel;
import morriex.model.MovieModel;
import morriex.model.view.MovieShortModel;
import morriex.model.view.MovieViewModel;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockInstant;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Movie_ESTest extends Movie_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      MockDate mockDate0 = new MockDate();
      // Undeclared exception!
      try { 
        movie0.isBetween((Date) null, mockDate0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[12];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[9];
      movieModel0.genres = movieModel0.writers;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      movie0.addRate("B'", (Integer) null);
      assertNull(movie0.getId());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      movie0.director = "";
      // Undeclared exception!
      try { 
        movie0.getShortModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.name = "(DY)wP=Ul'5k{q(";
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.getShortModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.coverImage = "s+e";
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.getModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = movieModel0.writers;
      movieModel0.director = "";
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.getModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[3];
      movieModel0.writers = stringArray0;
      movieModel0.image = "morriex.entity.Movie";
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.getModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      movie0.summary = "C|Y&6+itt3#";
      // Undeclared exception!
      try { 
        movie0.getModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      Instant instant0 = MockInstant.ofEpochSecond((-2792L), 0L);
      Date date0 = Date.from(instant0);
      movieModel0.releaseDate = date0;
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Boolean boolean0 = movie0.isReleaseDate("morriex.entity.Movie$2");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[24];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      movieModel0.genres = stringArray0;
      MockDate mockDate0 = new MockDate();
      movieModel0.releaseDate = (Date) mockDate0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Date date0 = movie0.getReleaseDate();
      assertSame(date0, mockDate0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[9];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Locale.IsoCountryCode locale_IsoCountryCode0 = Locale.IsoCountryCode.PART3;
      Set<String> set0 = Locale.getISOCountries(locale_IsoCountryCode0);
      movie0.genres = set0;
      Integer integer0 = movie0.getNumberOfSameGenres(movie0);
      assertNotNull(integer0);
      assertEquals(31, (int)integer0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      movie0.name = "!xm\"P-SrdohkSs";
      String string0 = movie0.getName();
      assertEquals("!xm\"P-SrdohkSs", string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[8];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[4];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.isInGenre((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[13];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[4];
      movieModel0.genres = movieModel0.writers;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      movie0.addRate((String) null, (Integer) null);
      try { 
        movie0.getShortModel();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[9];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[6];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.getNumberOfSameGenres(movie0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[45];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[4];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      movie0.comments = null;
      try { 
        movie0.getComment((Integer) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[9];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[6];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.addComment((Comment) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Movie movie0 = null;
      try {
        movie0 = new Movie((MovieModel) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[10];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[10];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      movie0.addRate((String) null, (Integer) null);
      // Undeclared exception!
      try { 
        movie0.getRate();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Double double0 = movie0.getRate();
      assertEquals(0.0, (double)double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Set<String> set0 = ZoneId.getAvailableZoneIds();
      movie0.genres = set0;
      Boolean boolean0 = movie0.isInGenre("Asia/Singapore");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Set<String> set0 = ZoneId.getAvailableZoneIds();
      movie0.genres = set0;
      Boolean boolean0 = movie0.isInGenre((String) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[6];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Integer integer0 = movie0.getId();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[24];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      movieModel0.genres = stringArray0;
      MockDate mockDate0 = new MockDate();
      movieModel0.releaseDate = (Date) mockDate0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Boolean boolean0 = movie0.isBetween(movieModel0.releaseDate, movieModel0.releaseDate);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      LinkedHashSet<Integer> linkedHashSet0 = new LinkedHashSet<Integer>();
      movie0.cast = (Set<Integer>) linkedHashSet0;
      MovieShortModel movieShortModel0 = movie0.getShortModel();
      assertNotNull(movieShortModel0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      LinkedHashSet<Integer> linkedHashSet0 = new LinkedHashSet<Integer>();
      movie0.cast = (Set<Integer>) linkedHashSet0;
      MovieViewModel movieViewModel0 = movie0.getModel();
      assertNotNull(movieViewModel0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[48];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[4];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.isActed((Integer) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[12];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[9];
      movieModel0.genres = movieModel0.writers;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      LinkedHashSet<Integer> linkedHashSet0 = new LinkedHashSet<Integer>();
      movie0.cast = (Set<Integer>) linkedHashSet0;
      Boolean boolean0 = movie0.isActed((Integer) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[9];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = movieModel0.writers;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Set<String> set0 = ZoneId.getAvailableZoneIds();
      movie0.genres = set0;
      // Undeclared exception!
      movie0.getNumberOfSameGenres(movie0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[13];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Set<String> set0 = ZoneId.getAvailableZoneIds();
      movie0.genres = set0;
      Movie movie1 = new Movie(movieModel0);
      Integer integer0 = movie1.getNumberOfSameGenres(movie0);
      assertNotNull(integer0);
      assertEquals(0, (int)integer0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[48];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[4];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      CommentModel commentModel0 = new CommentModel();
      Comment comment0 = new Comment(commentModel0);
      comment0.commentId = null;
      movie0.addComment(comment0);
      Comment comment1 = movie0.getComment((Integer) null);
      assertNull(comment1.getText());
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[48];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[4];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      CommentModel commentModel0 = new CommentModel();
      Comment comment0 = new Comment(commentModel0);
      movie0.addComment(comment0);
      try { 
        movie0.getComment((Integer) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // CommentNotFound
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      String string0 = movie0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[13];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[4];
      movieModel0.genres = movieModel0.writers;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      movie0.addRate((String) null, (Integer) null);
      try { 
        movie0.getModel();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[7];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Integer integer0 = movie0.getAgeLimit();
      assertNull(integer0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[48];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[4];
      movieModel0.genres = movieModel0.writers;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      CommentModel commentModel0 = new CommentModel();
      Comment comment0 = new Comment(commentModel0);
      movie0.addComment(comment0);
      // Undeclared exception!
      try { 
        movie0.getModel();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/google/gson/TypeAdapterFactory
         //
         verifyException("morriex.entity.Movie", e);
      }
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[24];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Date date0 = movie0.getReleaseDate();
      assertNull(date0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[21];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[3];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      // Undeclared exception!
      try { 
        movie0.isReleaseDate("H1SR0Zt");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Calendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      MovieModel movieModel0 = new MovieModel();
      String[] stringArray0 = new String[9];
      movieModel0.writers = stringArray0;
      Integer[] integerArray0 = new Integer[6];
      movieModel0.genres = stringArray0;
      movieModel0.cast = integerArray0;
      Movie movie0 = new Movie(movieModel0);
      Double double0 = movie0.getImdbRate();
      assertNull(double0);
  }
}