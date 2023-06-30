<%@page import="morriex.context.UserContext"%>
<%@page import="morriex.Model.view.WatchListModel"%>
<%@page import="morriex.Model.view.MovieShortModel"%>

<%
    WatchListModel watch = (WatchListModel)request.getAttribute("watch");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WatchList</title>
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
        <li id="name">name: <%=watch.user.name%></li>
        <li id="nickname">nickname: <%=watch.user.nickname%></li>
    </ul>
    <h2>Watch List</h2>
    <table>
        <tr>
            <th>Movie</th>
            <th>releaseDate</th> 
            <th>director</th> 
            <th>genres</th> 
            <th>imdb Rate</th> 
            <th>rating</th> 
            <th>duration</th> 
            <th></th>
            <th></th>
        </tr>

        <% for( MovieShortModel movie : watch.watchList ) { %>
            <tr>
                <th><%=movie.name%></th>
                <th><%=movie.getFormattedDate()%></th> 
                <th><%=movie.director%></th> 
                <th><% for(String genre : movie.genres) { %>
                    <%=genre%>,
                <% } %></th> 
                <th><%=movie.imdbRate%></th> 
                <th><%=movie.rating%></th> 
                <th><%=movie.duration%></th> 
                <td><a href="/movies/<%=movie.movieId%>">Link</a></td>
                <td>        
                    <form action="" method="POST" >
                        <input id="form_action" type="hidden" name="action" value="remove">
                        <input id="form_movie_id" type="hidden" name="movie_id" value="<%=movie.movieId%>">
                        <button type="submit">Remove</button>
                    </form>
                </td>
            </tr>
        <% } %> 
    </table>
    <h2>Recommendation List</h2>
    <table>
        <tr>
            <th>Movie</th>
            <th>imdb Rate</th> 
            <th></th>
        </tr>
            <% for( MovieShortModel movie : watch.recommendations ) { %>
                <tr>
                <th><%=movie.name%></th>
                <th><%=movie.imdbRate%></th> 
                <td><a href="/movies/<%=movie.movieId%>">Link</a></td>
            </tr>
        <% } %> 
    </table>
</body>
</html>