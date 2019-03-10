<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload='document.f.username.focus();'>
        <h3>Login with Username and Password</h3>
        <form name='f' action='/spring-boot-web-jsp/login' method='POST'>
            <table>
                <tr>
                    <td>User:</td>
                    <td>
                        <input type='text' name='username' value=''>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <input type='password' name='password'/>
                    </td>
                </tr>
                <tr>
                    <td colspan='2'>
                        <input name="submit" type="submit" value="Login"/>
                    </td>
                </tr>
                <input name="_csrf" type="hidden" value="b7282607-55f2-41c0-9b47-9dfd6c9fe42a" />
            </table>
        </form>
    </body>
</html>