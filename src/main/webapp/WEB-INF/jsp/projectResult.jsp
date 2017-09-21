<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 20/09/2017
  Time: 11:31
  To change this template use File | Settings | File Templates.

  scope="request"
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Project Registered</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<h3>Congratulations, the following project has been created ! </h3

<%@ include file="projectView.jsp"  %>

<%--
<p th:text="'Project id: ' + ${project.projectId}" />
<p th:text="'Project Name: ' + ${project.projectName}" />
<p th:text="'Project Industry: ' + ${project.projectIndustry}" />
<p th:text="'Project Description: ' + ${project.projectDescription}" />
<p th:text="'Project Website: ' + ${project.projectSiteLink}" />
<p th:text="'Project Expected Raise: ' + ${project.projectExpectedRaise}" />
<p th:text="'Project Amount Already Raised: ' + ${project.projectAmountRaised}" />
<p th:text="'Minimum Investment: ' + ${project.projectMinInv}" />
<p th:text="'Expected Return: ' + ${project.projectReturn}" />
<p th:text="'Previous Rounds: ' + ${project.projectPreviousRounds}" /> --%>

<a href="/project/add">Submit another project</a>

</body>
</html>
