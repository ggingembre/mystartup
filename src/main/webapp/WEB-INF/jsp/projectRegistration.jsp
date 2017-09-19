<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 16/09/2017
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sample Form</title>
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

    <h2>Welcome, please enter your project details!</h2>
    <c:if test="${not empty message}"><div class="message green">${message}</div></c:if>

    <form:form method="POST" action="/project/add" modelAttribute="project" commandName="command">

        <label for="projectNameInput">Project Name: </label>
        <form:input path="ProjectName" id="projectNameInput" />
        <br/>

        <label for="industrySelect">Project Industy:</label>
            <form:select path="projectIndustry" id="industrySelect">
                <form:option value="">Select Project Industry: </form:option>
                <c:forEach items="${industries}" var="frequency">
                    <form:option value="${frequency}">${frequency}</form:option>
                </c:forEach>
            </form:select>
        <br/>

        <label for="projectDescriptionInput">Project Description: </label>
        <form:input path="ProjectDescription" name="projectDescriptionInput" />
        <br/>

        <label for="projectSiteLinkInput">Project Site: </label>
        <form:input path="ProjectSiteLink" name="projectSiteLinkInput" />
        <br/>

        <label for="projectExpectedRaiseInput">Expected amount to be raised: </label>
        <form:input path="ProjectExpectedRaise" name="projectExpectedRaiseInput" />
        <br/>

        <label for="projectAmountRaisedInput">Amount Already Raised: </label>
        <form:input path="ProjectAmountRaised" name="projectAmountRaisedInput" />
        <br/>

        <label for="projectMinInvInput">Minimum Investment: </label>
        <form:input path="ProjectMinInv" name="projectMinInvInput" />
        <br/>


        <label for="projectReturnInput">Project Return: </label>
        <form:input path="projectReturn" name="projectReturnInput" />
        <br/>


        <label for="projectPreviousRoundsInput">Money raised during previous rounds: </label>
        <form:input path="projectPreviousRounds" name="projectPreviousRoundsInput" />
        <br/>

        <br/>
        <input type="submit" value="Submit" />

    </form:form>
</div>

</body>
</html>
