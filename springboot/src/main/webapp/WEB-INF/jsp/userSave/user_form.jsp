
<%--
  Created by IntelliJ IDEA.
  User: Ishu
  Date: 26/08/2021
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <h1>User Form</h1>
    <form action="" method="post">
        <table style="with: 80%">
            <tr>
                <td>Id</td>
                <td><input type="text" name="id" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>


        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>