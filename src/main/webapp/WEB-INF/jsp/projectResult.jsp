<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 20/09/2017
  Time: 11:31
  To change this template use File | Settings | File Templates.

  scope="request"
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="projectRegistrationForm" scope="request" class="ua.goit.entity.ProjectRegistrationForm"/>

<html>
<head>
    <title>Project Registered</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<p>You have successfully registered the following project: </p>
    <table>
                <tr>
                    <td>Project Name :</td>
                    <td>${projectRegistrationForm.project.projectName}</td>
                </tr>
                <tr>
                    <td>Project Industry :</td>
                    <td>${projectRegistrationForm.project.projectIndustry}</td>
                </tr>
                <tr>
                    <td>Town :</td>
                    <td>${projectRegistrationForm.address.town}</td>
                </tr>
                <tr>
                    <td>Region :</td>
                    <td>${projectRegistrationForm.address.region}</td>
                </tr>
                <tr>
                    <td>Country :</td>
                    <td>${projectRegistrationForm.address.country}</td>
                </tr>
                <tr>
                    <td>Project Description :</td>
                    <td>${projectRegistrationForm.project.projectDescription}</td>
                </tr>
                <tr>
                    <td>Project Website :</td>
                    <td>${projectRegistrationForm.project.projectSiteLink}</td>
                </tr>
                <tr>
                    <td>Project Expected Raise :</td>
                    <td>${projectRegistrationForm.project.projectExpectedRaise}</td>
                </tr>
                <tr>
                    <td>Amount Already Raised :</td>
                    <td>${projectRegistrationForm.project.projectAmountRaised}</td>
                </tr>
                <tr>
                    <td>Minimum Investment :</td>
                    <td>${projectRegistrationForm.project.projectMinInv}</td>
                </tr>
                <tr>
                    <td>Project Return :</td>
                    <td>${projectRegistrationForm.project.projectReturn}</td>
                </tr>
                <tr>
                    <td>Last Changed :</td>
                    <td>${projectRegistrationForm.project.projectLastChange}</td>
                </tr>

    </table>
<br/>

<a href="/project/add">Submit another project</a>

</body>
</html>
