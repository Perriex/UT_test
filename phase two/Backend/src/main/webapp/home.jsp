<%@page import="morriex.context.UserContext"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <ul>
        <li id="email">email: <%=UserContext.email%></li>
        <li>
            <a href="/movies">Movies</a>
        </li>
        <li>
            <a href="/watchlist">Watch List</a>
        </li>
        <li>
            <a href="/logout">Log Out</a>
        </li>
    </ul>
</body>
</html>