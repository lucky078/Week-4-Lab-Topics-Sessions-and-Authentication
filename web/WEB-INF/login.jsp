<%-- 
    Document   : login
    Created on : Sep 27, 2019, 3:51:54 PM
    Author     : 749300
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h1>Login</h1>
</head>
<body>
    <div>
        <form action="login" method="post" >
            <table>

                <tr>
                    <td>Username:</td> <td><input type="text" name="name" value="${userN}"></td>
                </tr>
                <tr>
                    <td>Password:</td> <td><input type="password" name="pass" value="${password}"></td>
                </tr> 
            </table>
            <input type="submit" name="login" value="Log in">
            ${mesgL}
        </form>
    </div>

</body>
</html>
