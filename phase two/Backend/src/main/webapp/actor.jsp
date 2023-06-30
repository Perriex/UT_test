<%@page import="morriex.Model.view.ActorViewModel"%>
<%@page import="morriex.context.UserContext"%>

<%
    ActorViewModel actor = (ActorViewModel)request.getAttribute("actor");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Actor</title>
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
        <li id="name">name: <%=actor.name%></li>
        <li id="birthDate">birthDate: <%=actor.getFormattedDate()%></li>
        <li id="nationality">nationality: <%=actor.nationality%></li>
        <li id="tma">Total movies acted in: <%=actor.movies.length%></li>
    </ul>
    <table>
        <tr>
            <th>Movie</th>
            <th>imdb Rate</th> 
            <th>rating</th> 
            <th>page</th> 
        </tr>
        <% for(int i = 0; i < actor.movies.length; i+=1) { %>
            <tr>
                <td><%=actor.movies[i].name%></td>
                <td><%=actor.movies[i].imdbRate%></td> 
                <td><%=actor.movies[i].rating%></td> 
                <td><a href="/movies/<%=actor.movies[i].movieId%>">Link</a></td>
            </tr>
        <% } %>
    </table>
</body>
</html>