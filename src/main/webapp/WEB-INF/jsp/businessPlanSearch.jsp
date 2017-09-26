<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 26/09/2017
  Time: 07:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id = "businessPlanRegistrationForm" class = "ua.goit.entity.BusinessPlanRegistrationForm" scope = "request" />
<html>
<head>
    <title>Business Plan Search</title>
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

    <h2>Please enter your search criteria</h2>

    <form:form method="POST" action="/businessplan/search" modelAttribute="businessPlanSearch"> <%--commandName="command"--%>

        <label for="addressTownInput">Town: </label>
        <form:input path="address.town" id="addressTownInput" />
        <br/>

        <label for="regionSelect">Region: </label>
        <form:select path="address.region" id="regionSelect">
            <form:option value="">Select Region: </form:option>
            <c:forEach items="${regions}" var="frequency">
                <form:option value="${frequency}">${frequency}</form:option>
            </c:forEach>
        </form:select>
        <br/>

        <label for="countrySelect">Country: </label>
        <form:select path="address.country" id="countrySelect">
            <form:option value="">Select Country: </form:option>
            <c:forEach items="${countries}" var="frequency">
                <form:option value="${frequency}">${frequency}</form:option>
            </c:forEach>
        </form:select>
        <br/>

        <%--
        <label for="industrySelect">Project Industy:</label>
        <form:select path="project.projectIndustry" id="industrySelect">
            <form:option value="">Select Project Industry: </form:option>
            <c:forEach items="${industries}" var="frequency">
                <form:option value="${frequency}">${frequency}</form:option>
            </c:forEach>
        </form:select>
        <br/> --%>

        <label for="businessPlanExpectedRaiseInput">Expected amount to be raised (Min) </label>
        <form:input path="businessPlan.businessPlanExpectedRaise" name="businessPlanExpectedRaiseInput" />
        <br/>

        <label for="businessPlanMinInvInput">Minimum Investment (Max) </label>
        <form:input path="businessPlan.businessPlanMinInv" name="businessPlanMinInvInput" />
        <br/>

        <label for="businessPlanReturnInput">Project Return (Min) </label>
        <form:input path="businessPlan.businessPlanReturn" name="businessPlanReturnInput" />
        <br/>
        <br/>
        <input type="submit" value="Search" />

    </form:form>
</div>

</body>
</html>


