<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:useBean id="businessPlan" scope="request" class="ua.goit.entity.BusinessPlan"/>
<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 27/09/2017
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Business Plan Deleted</title>
</head>

<body>
<table>
    <tr>
        <td>
            Success! Business Plan Deleted.
        </td>
    </tr>
    <tr>
        <td class="tb2" style="width:95%"> <a href="/businessplan/search">New Search</a> </td>
    </tr>
    <tr>
        <td class="tb2" style="width:95%"> <a href="/businessplan/showAll">Show all business plans</a> </td>
    </tr>

</table>
</body>
</html>