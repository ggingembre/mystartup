<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 15/09/2017
  Time: 07:45
  To change this template use File | Settings | File Templates.

  <div class="second">
                    ${project}
            </div>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:useBean id="project" scope="request" class="ua.goit.entity.Project"/>

<html>
<head>
    <title>Projects list</title>
    <link href="../../resources/theme1/style1.css" type="text/css" rel="stylesheet">
</head>

<body>

    <c:forEach var="project" items="${projects}">
    <div class="first" style="float: left; width:27%; margin:0.5%; box-shadow: 10px 10px 5px grey; background-color: #f1f1f1">
        <table>
            <div class="second" style="height:80px" >
                    <tr>
                        <td class="tb1" style="width:30%">Project Name :</td>
                        <td class="tb1" style="width:60%">${project.projectName}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Project Industry :</td>
                        <td class="tb1" style="width:60%">${project.projectIndustry}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Description :</td>
                        <td class="tb1" style="width:60%">${project.projectDescription}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Town :</td>
                        <td class="tb1" style="width:60%">${project.projectAddress.town}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Region :</td>
                        <td class="tb1" style="width:60%">${project.projectAddress.region}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Country :</td>
                        <td class="tb1" style="width:60%">${project.projectAddress.country}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Expected Return :</td>
                        <td class="tb1" style="width:60%">${project.projectReturn}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Minimum Investment :</td>
                        <td class="tb1" style="width:60%">${project.projectMinInv}</td>
                    </tr>
                    <tr>
                        <td class="tb2" style="width:50%"> <a href="/project/${project.projectId}">Learn more about project</a> </td>
                    </tr>
            </div>
        </table>

        <br>
        <br>

    </div>

    </c:forEach>


 </body>
 </html>
