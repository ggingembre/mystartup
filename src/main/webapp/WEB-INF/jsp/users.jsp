<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.08.2017
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Users list</title>
</head>
<body>
<table>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
               ${user}
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
