<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <c:forEach items="${studentList}" var="student">
        <p>${student.sid}&nbsp;${student.sname}</p>
    </c:forEach>
  </body>
</html>
