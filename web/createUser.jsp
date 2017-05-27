<%@ page import="src.mahesh.database.dbobjects.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: mahesh
  Date: 5/13/17
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
<style>
    .first {
        width: 75%;
        color: black;
        background-color: #d2ff95;
        border: 2px solid darkblue;
        padding: 0.5%;
    }
</style>

<style>
    .second {
        width: 75%;
        color: black;
        background-color: #ff8967;
        border: 2px solid darkblue;
        padding: 0.5%;
    }
</style>

<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        /*padding: 5px;*/
    }
    th {
        text-align : center;
    }
    /*table {*/
        /*border-spacing: 15px;*/
    /*}*/
</style>

<div class="first">
    <head>
        <title>Create a User</title>
    </head>
    <body style="background-color:#b1f7ff;">
    <form action="createuserhandler" method="post">
        First Name: <input type="text" name="fname"><br>
        Last Name: <input type="text" name="lname"><br>
        Middle Name: <input type="text" name="mname"><br>
        <br>
        Username: <input type="text" name="username"><br>
        <input type="submit" value="submit">
    </form>

    <%out.println("<br>" + request.getAttribute("message") + "<br>"); %>
    </body>
</div>

<div class="second">
    <head>
        <title>Get All Users</title>
    </head>
    <body style="background-color:#ff8967;">
    <form action="getallusershandler" method="get">
        <input type="submit" value="Get All Users">
        <br>
        <table>
            <tr>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Username</th>
            </tr>
            <% ArrayList<User> users = null;
            users = (ArrayList<User>) request.getAttribute("userList"); %>
            <%
                User user = null;
                if (users != null) {
                    for (int ii = 0; ii < users.size(); ii++) {
                        user = users.get(ii);
            %>
                <tr>
                    <td><%=user.getFirstName()%></td>
                    <td><%=user.getMiddleName()%></td>
                    <td><%=user.getLastName()%></td>
                    <td><%=user.getUsername()%></td>
                </tr>
                <% } %>
            <% } %>
        </table>
    </form>
    </body>
</div>

</html>
