<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 28/09/2017
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="project" scope="request" class="ua.goit.entity.Project"/>

<html>
<head>
    <title>Project Updated</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<p>You have successfully updated your project: </p>
    <table>
            <tr>
                <td>Project Name :</td>
                <td>${project.projectName}</td>
            </tr>
            <tr>
                <td>Project Industry :</td>
                <td>${project.projectIndustry}</td>
            </tr>
            <tr>
                <td>Town :</td>
                <td>${project.projectAddress.town}</td>
            </tr>
    <tr>
                <td>Region :</td>
                <td>${project.projectAddress.region}</td>
            </tr>
    <tr>
                <td>Country :</td>
                <td>${project.projectAddress.country}</td>
            </tr>
            <tr>
                <td>Project Description :</td>
                <td>${project.projectDescription}</td>
            </tr>
            <tr>
                <td>Project Website :</td>
                <td>${project.projectSiteLink}</td>
            </tr>
            <tr>
                <td>Project Expected Raise :</td>
                <td>${project.projectExpectedRaise}</td>
            </tr>
            <tr>
                <td>Amount Already Raised :</td>
                <td>${project.projectAmountRaised}</td>
            </tr>
            <tr>
                <td>Minimum Investment :</td>
                <td>${project.projectMinInv}</td>
            </tr>
            <tr>
                <td>Project Return :</td>
                <td>${project.projectReturn}</td>
            </tr>
            <tr>
                <td>Last Changed :</td>
                <td>${project.projectLastChange}</td>
            </tr>

</table>
<br/>

<a href="/project/add">Submit another project</a>
<a href="/project/showAll">Show all projects</a>
<a href="/project/search">Search project</a>

</body>
</html>
