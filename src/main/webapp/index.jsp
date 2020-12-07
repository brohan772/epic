<%--
  Created by IntelliJ IDEA.
  User: cglas
  Date: 11/25/2020
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link href="static/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<header>
    <div id="logo">
        <h2>Logo</h2>
    </div>
    <div id="menu">
        <a href="#">About</a>
        <a href="#">Contact</a>
        <a href="#">Help</a>
    </div>
</header>
<div id="container">
    <div id="topContent">
        <div id="loginForm">
            <form action="${pageContext.request.contextPath}/LoginServlet" name="loginForm" method="post">
                <table>
                    <tr>
                        <td>
                            <label for="username">Username: </label>
                        </td>
                        <td>
                            <input type="text" name="username" id="username">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">Password: </label>
                        </td>
                        <td>
                            <input type="password" name="password" id="password">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <select name="userRole">
                                <option value="" selected="selected"> - Select Role - </option>
                                <option value="admin">Admin</option>
                                <option value="staff">Staff</option>
             EP                   <option value="student">Student</option>
                            </select>
                        </td>
                        <td>
                            <input type="submit" value="Login">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div id="bottomContent">
        <div id="output">
            <p><%= session.getAttribute("username") %></p>
        </div>
    </div>
</div>
</body>
</html>
