<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 28/09/2017
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id = "businessPlan" class = "ua.goit.entity.BusinessPlan" scope = "request" />

<html>
<head>
    <title>Business Update Form</title>
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

    <h2>Please update your business plan</h2>

    <form:form method="POST" action="/businessplan/updated" modelAttribute="businessPlan" commandName="command"> <%-- --%>

        <form:hidden path="id"/>
        <form:hidden path="address.addressId"/>

        <label for="projectIdInput">Project ID: </label>
        <form:input path="projectId" id="projectIdInput" />
        <br/>

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

        <label for="ideaInput">Idea: </label>
        <form:input path="idea" name="ideaInput" />
        <br/>

        <label for="currentStateInput">Current State: </label>
        <form:input path="currentState" name="currentStateInput" />
        <br/>

        <label for="marketInput">Market: </label>
        <form:input path="market" name="marketInput" />
        <br/>

        <label for="opportunityInput">Opportunity: </label>
        <form:input path="opportunity" name="opportunityInput" />
        <br/>

        <label for="solutionInput">Solution: </label>
        <form:input path="solution" name="solutionInput" />
        <br/>

        <label for="competitionInput">Competition: </label>
        <form:input path="competition" name="competitionInput" />
        <br/>

        <label for="uspInput">Unique Selling Point: </label>
        <form:input path="usp" name="uspInput" />
        <br/>

        <label for="businessModelInput">Business Model: </label>
        <form:input path="businessModel" name="businessModelInput" />
        <br/>

        <label for="fundsUsesInput">Funds Uses: </label>
        <form:input path="fundsUses" name="fundsUsesInput" />
        <br/>

        <label for="mentorsInput">Mentors: </label>
        <form:input path="mentors" name="mentorsInput" />
        <br/>

        <label for="risksInput">Risks: </label>
        <form:input path="risks" name="risksInput" />
        <br/>

        <label for="webUrlInput">Website: </label>
        <form:input path="weburl" name="webUrlInput" />
        <br/>

        <label for="docUrlInput">Document: </label>
        <form:input path="docurl" name="docUrlInput" />
        <br/>

        <label for="businessPlanExpectedRaisedInput">Amount to be Raised: </label>
        <form:input path="businessPlanExpectedRaise" name="businessPlanExpectedRaisedInput" />
        <br/>

        <label for="businessPlanAmountRaisedInput">Amount Already Raised: </label>
        <form:input path="businessPlanAmountRaised" name="businessPlanAmountRaisedInput" />
        <br/>

        <label for="businessPlanMinInvInput">Minimum Investment: </label>
        <form:input path="businessPlanMinInv" name="businessPlanMinInvInput" />
        <br/>

        <label for="businessPlanReturnInput">Expected Return: </label>
        <form:input path="businessPlanReturn" name="businessPlanReturnInput" />
        <br/>

        <label for="financesInput">Finances Overview: </label>
        <form:input path="finances" name="financesInput" />
        <br/>

        <label for="previousRoundsInput">Previous Rounds: </label>
        <form:input path="previousRounds" name="previousRoundsInput" />
        <br/>

        <label for="collateralInput">Collateral: </label>
        <form:input path="collateral" name="collateralInput" />
        <br/>

        <br/>
        <input type="submit" value="Submit" />

    </form:form>
</div>

</body>
</html>

