<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 15/09/2017
  Time: 07:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:useBean id="businessPlan" scope="request" class="ua.goit.entity.BusinessPlan"/>

<html>
<head>
    <title>Business Plans list</title>
</head>
<body>

    <c:forEach var="businessPlan" items="${businessPlans}">
        <div class="first" style="float: left; width:27%; margin:0.5%; box-shadow: 10px 10px 5px grey; background-color: #f1f1f1">
        <table>
            <div class="second" style="height:80px" >
                    <tr>
                        <td class="tb1" style="width:30%">Idea :</td>
                        <td class="tb1" style="width:60%">${businessPlan.idea}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Current State :</td>
                        <td>${businessPlan.currentState}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Unique Selling Point :</td>
                        <td>${businessPlan.usp}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Website :</td>
                        <td>${businessPlan.weburl}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Pdf Document :</td>
                        <td class="tb1" style="width:60%">${businessPlan.docurl}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Expected Raise :</td>
                        <td class="tb1" style="width:60%">${businessPlan.businessPlanExpectedRaise}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Amount Already Raised :</td>
                        <td class="tb1" style="width:60%">${businessPlan.businessPlanAmountRaised}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Minimum Investment :</td>
                        <td class="tb1" style="width:60%">${businessPlan.businessPlanMinInv}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Expected Return :</td>
                        <td class="tb1" style="width:60%">${businessPlan.businessPlanReturn}</td>
                    </tr>
                    <tr>
                        <td class="tb1" style="width:30%">Last Changed :</td>
                        <td class="tb1" style="width:60%">${businessPlan.businessPlanLastChange}</td>
                    </tr>
                <tr>
                    <td class="tb2" style="width:50%"> <a href="/businessplan/${businessPlan.id}">Learn more about it</a> </td>
                </tr>
            </div>
                </table>
            <br>
            <br>
        </div>
    </c:forEach>

</body>
</html>
