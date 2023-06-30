<%@page import="morriex.Model.view.MovieListModel"%>
<%@page import="morriex.Model.view.MovieShortModel"%>
<%@page import="morriex.Model.view.ActorShortModel"%>
<%@page import="morriex.context.UserContext"%>

<%
    MovieListModel movies = (MovieListModel)request.getAttribute("movies");
    String term = (String)request.getAttribute("search");
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Movies</title>
    <style>
      li,
      td,
      th {
        padding: 5px;
      }
    </style>
  </head>
  <body>
    <a href="/">Home</a>
    <p id="email">email: <%=UserContext.email%></p>
    <br /><br />
    <form action="" method="POST">
      <label>Search: <%=term%></label>
      <input type="text" name="search" value="" />
      <button type="submit" name="action" value="search">Search</button>
      <button type="submit" name="action" value="clear">Clear Search</button>
    </form>
    <br /><br />
    <form action="" method="POST">
      <label>Sort By:</label>
      <button type="submit" name="action" value="sort_by_imdb">
        imdb Rate
      </button>
      <button type="submit" name="action" value="sort_by_date">
        releaseDate
      </button>
    </form>
    <br />
    <table>
      <tr>
        <th>name</th>
        <th>summary</th>
        <th>releaseDate</th>
        <th>director</th>
        <th>writers</th>
        <th>genres</th>
        <th>cast</th>
        <th>imdb Rate</th>
        <th>rating</th>
        <th>duration</th>
        <th>ageLimit</th>
        <th>Links</th>
      </tr>
      <% for(MovieShortModel movie : movies.moviesList) { %>
      <tr>
        <td><%=movie.name%></td>
        <td><%=movie.summary%></td>
        <td><%=movie.getFormattedDate()%></td>
        <td><%=movie.director%></td>
        <td>
          <% for(String writer : movie.writers) { %> <%=writer%>, <% }
          %>
        </td>
        <td>
          <% for(String genre : movie.genres) { %>
          <%=genre%>, <% } %>
        </td>
        <td>
          <% for(ActorShortModel actor : movie.cast) { %> <%=actor.name%>, <% } %>
        </td>
        <td><%=movie.imdbRate%></td>
        <td><%=movie.rating%></td>
        <td><%=movie.duration%></td>
        <td><%=movie.ageLimit%></td>
        <td>
          <a href="/movies/<%=movie.movieId%>">Link</a>
        </td>
      </tr>
      <% } %>
    </table>
  </body>
</html>
