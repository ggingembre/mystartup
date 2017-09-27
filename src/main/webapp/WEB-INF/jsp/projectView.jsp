<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 15/09/2017
  Time: 23:01
  To change this template use File | Settings | File Templates.
  <jsp:useBean id = "project" class = "ua.goit.entity.Project" scope = "session" />
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:useBean id="project" scope="request" class="ua.goit.entity.Project"/>
<html>
<head>
    <title>Project Details</title>
</head>
<body>
<p>Project Details:</p>
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
                <td>Project Address :</td>
                <td>${project.projectAddress}</td>
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

    <tr>
        <td class="tb2" style="width:50%"> <a href="<c:url value="/project/${project.projectId}/delete" />">Delete</a> </td>
    </tr>

    <tr>
        <td class="tb2" style="width:50%"> <a href="<c:url value="/project/${project.projectId}/update" />">Edit</a> </td>
    </tr>
        </table>
</body>
</html>
