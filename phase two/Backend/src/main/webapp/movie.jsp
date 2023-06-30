<%@page import="morriex.model.view.MovieViewModel"%>
<%@page import="morriex.model.view.ActorShortModel"%>
<%@page import="morriex.model.view.CommentViewModel"%>
<%@page import="morriex.context.UserContext"%>
<%
  MovieViewModel movie = (MovieViewModel)request.getAttribute("movie");
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Movie</title>
    <style>
      li, td, th {
        padding: 5px;
      }
    </style>
  </head>
  <body>
    <a href="/">Home</a>
    <p id="email">email: <%=UserContext.email%></p>
    <ul>
      <li id="name">name: <%=movie.name%></li>
      <li id="summary">summary: <%=movie.summary%></li>
      <li id="releaseDate">releaseDate: <%=movie.getFormattedDate()%></li>
      <li id="director">director: <%=movie.director%></li>
      <li id="writers">writers: 
        <% for(String writer : movie.writers) { %>
            <%=writer%>,
        <% } %>
      </li>
      <li id="genres">genres: 
        <% for(String genre : movie.genres) { %>
            <%=genre%>,
        <% } %></li>
      <li id="imdbRate">imdb Rate: <%=movie.imdbRate%></li>
      <li id="rating">rating: <%=movie.rating%></li>
      <li id="duration">duration: <%=movie.duration%> minutes</li>
      <li id="ageLimit">ageLimit: <%=movie.ageLimit%></li>
    </ul>
    <h3>Cast</h3>
    <table>
      <tr>
        <th>name</th>
        <th>age</th>
      </tr>
      <% for(ActorShortModel cast : movie.cast) { %>
        <tr>
          <td><%=cast.name%></td>
          <td><%=cast.age%></td>
          <td><a href="/actors/<%=cast.actorId%>">Link</a></td>
        </tr>
      <% } %>
    </table>
    <br>
    <form action="" method="POST">
      <label>Rate(between 1 and 10):</label>
      <input type="number" id="quantity" name="quantity" min="1" max="10">
      <input type="hidden" id="form_action" name="action" value="rate">
      <input type="hidden" id="form_movie_id" name="movie_id" value="<%=movie.movieId%>">
      <button type="submit">rate</button>
    </form>
    <br>
    <form action="/watchlist" method="POST">
      <input id="form_action" type="hidden" name="action" value="add">
      <input type="hidden" id="form_movie_id" name="movie_id" value="<%=movie.movieId%>">
      <button type="submit">Add to WatchList</button>
    </form>
    <br />
    <table>
      <tr>
        <th>nickname</th>
        <th>comment</th>
        <th></th>
        <th></th>
      </tr>
      <% for(CommentViewModel comment : movie.comments) { %>
        <tr>
        <td><%=comment.user.nickname%></td>
        <td><%=comment.text%></td>
        <td>
          <form action="" method="POST">
            <label for=""><%=comment.like%></label>
            <input
              id="form_comment_id"
              type="hidden"
              name="comment_id"
              value="<%=comment.commentId%>"
            />
            <input type="hidden" id="form_action" name="action" value="like">
            <input type="hidden" id="form_movie_id" name="movie_id" value="<%=movie.movieId%>">
            <button type="submit">like</button>
          </form>
        </td>
        <td>
          <form action="" method="POST">
            <label for=""><%=comment.dislike%></label>
            <input
              id="form_comment_id"
              type="hidden"
              name="comment_id"
              value="<%=comment.commentId%>"
            />
            <input type="hidden" id="form_action" name="action" value="dislike">
            <input type="hidden" id="form_movie_id" name="movie_id" value="<%=movie.movieId%>">
            <button type="submit">dislike</button>
          </form>
        </td>
      </tr>
      <% } %>
    </table>
    <br><br>
    <form action="" method="POST">
      <label>Your Comment:</label>
      <input type="text" name="comment" value="">
      <input type="hidden" id="form_action" name="action" value="comment">
      <input type="hidden" id="form_movie_id" name="movie_id" value="<%=movie.movieId%>">
      <button type="submit">Add Comment</button>
    </form>
  </body>
</html>
