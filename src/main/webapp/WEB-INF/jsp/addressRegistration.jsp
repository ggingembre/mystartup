<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 21/09/2017
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id = "address" class = "ua.goit.entity.Address" scope = "request" />

<html>
<head>
    <title>Address Registration</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
        body { background-color: #eee;}
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
        .green { font-weight: bold; color: green; }
        .message { margin-bottom: 10px; }
        label {width:250px; display:inline-block;}
        form {line-height: 160%; }
        .hide { display: none; }
    </style>
</head>
<body>
<div id="container">

    <h2>Please enter the address associated to your business plan</h2>

    <form:form method="POST" action="/businessplan/add" modelAttribute="addressRegistration"> <%--commandName="command"--%>

        <label for="addressTownInput">Town: </label>
        <form:input path="town" id="addressTownInput" />
        <br/>

        <label for="regionSelect">Region: </label>
        <form:select path="region" id="regionSelect">
            <form:option value="">Select Region: </form:option>
            <c:forEach items="${regions}" var="frequency">
                <form:option value="${frequency}">${frequency}</form:option>
            </c:forEach>
        </form:select>
        <br/>

        <label for="countrySelect">Region: </label>
        <form:select path="country" id="countrySelect">
            <form:option value="">Select Region: </form:option>
            <c:forEach items="${countries}" var="frequency">
                <form:option value="${frequency}">${frequency}</form:option>
            </c:forEach>
        </form:select>
        <br/>

        <br/>
        <input type="submit" value="Submit" />

    </form:form>
</div>

</body>
</html>
