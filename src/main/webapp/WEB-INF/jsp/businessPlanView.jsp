<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 21/09/2017
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="businessPlan" scope="request" class="ua.goit.entity.BusinessPlan"/>
<html>
<head>
    <title>Business Plan Details</title>
</head>
<body>
    <table>
            <tr>
                <td>Idea :</td>
                <td>${businessPlan.idea}</td>
            </tr>
            <tr>
                <td>Current State :</td>
                <td>${businessPlan.currentState}</td>
            </tr>
            <tr>
                <td>Market :</td>
                <td>${businessPlan.market}</td>
            </tr>
            <tr>
                <td>Opportunity :</td>
                <td>${businessPlan.opportunity}</td>
            </tr>
            <tr>
                <td>Solution :</td>
                <td>${businessPlan.solution}</td>
            </tr>
            <tr>
                <td>Competition :</td>
                <td>${businessPlan.competition}</td>
            </tr>
            <tr>
                <td>Unique Selling Point :</td>
                <td>${businessPlan.usp}</td>
            </tr>
            <tr>
                <td>Business Model :</td>
                <td>${businessPlan.businessModel}</td>
            </tr>
            <tr>
                <td>Funds Uses :</td>
                <td>${businessPlan.fundsUses}</td>
            </tr>
            <tr>
                <td>Mentors :</td>
                <td>${businessPlan.mentors}</td>
            </tr>
            <tr>
                <td>Risks :</td>
                <td>${businessPlan.risks}</td>
            </tr>
            <tr>
                <td>Website :</td>
                <td>${businessPlan.weburl}</td>
            </tr>
            <tr>
                <td>Pdf Document :</td>
                <td>${businessPlan.docurl}</td>
            </tr>
            <tr>
                <td>Expected Raise :</td>
                <td>${businessPlan.businessPlanExpectedRaise}</td>
            </tr>
            <tr>
                <td>Amount Already Raised :</td>
                <td>${businessPlan.businessPlanAmountRaised}</td>
            </tr>
            <tr>
                <td>Minimum Investment :</td>
                <td>${businessPlan.businessPlanMinInv}</td>
            </tr>
            <tr>
                <td>Expected Return :</td>
                <td>${businessPlan.businessPlanReturn}</td>
            </tr>
            <tr>
                <td>Finances Overview :</td>
                <td>${businessPlan.finances}</td>
            </tr>
            <tr>
                <td>Collateral :</td>
                <td>${businessPlan.collateral}</td>
            </tr>
            <tr>
                <td>Previous Rounds :</td>
                <td>${businessPlan.previousRounds}</td>
            </tr>
            <tr>
                <td>Last Changed :</td>
                <td>${businessPlan.businessPlanLastChange}</td>
            </tr>
        </table>
</body>
</html>
