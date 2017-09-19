<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 15/09/2017
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project Details</title>
</head>
<body>
    <table>
            <tr>
                <td>Project Name :</td>
                <td>${projectName}</td>
            </tr>
            <tr>
                <td>Project Industry :</td>
                <td>${projectIndustry}</td>
            </tr>
            <tr>
                <td>Project Address :</td>
                <td>${projectAddress}</td>
            </tr>
            <tr>
                <td>Project Description :</td>
                <td>${projectDescription}</td>
            </tr>
            <tr>
                <td>Project Website :</td>
                <td>${projectSiteLink}</td>
            </tr>
            <tr>
                <td>Project Expected Raise :</td>
                <td>${projectExpectedRaise}</td>
            </tr>
            <tr>
                <td>Amount Already Raised :</td>
                <td>${projectAmountRaised}</td>
            </tr>
            <tr>
                <td>Minimum Investment :</td>
                <td>${projectMinInv}</td>
            </tr>
            <tr>
                <td>Project Return :</td>
                <td>${projectReturn}</td>
            </tr>
            <tr>
                <td>Last Changed :</td>
                <td>${projectLastChange}</td>
            </tr>
            <tr>
                <td>Project Active?</td>
                <td>${isActive}</td>
            </tr>
        </table>
</body>
</html>
