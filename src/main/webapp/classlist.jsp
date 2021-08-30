<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Class list</h1>
        <ul>
            <c:forEach var="student" items="${requestScope.classlist}">
                <li>${student.name}</li>
            </c:forEach>
        </ul>
        
        <p><a href="index.jsp">To frontpage</a></p>
    </body>
</html>
