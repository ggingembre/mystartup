<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 15/09/2017
  Time: 07:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Projects list</title>
    <link href="../../resources/theme1/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="first">
    <c:forEach var="project" items="${projects}">
            <div class="second">
                    ${project}
            </div>
    </c:forEach>
</div>

</body>
</html>
