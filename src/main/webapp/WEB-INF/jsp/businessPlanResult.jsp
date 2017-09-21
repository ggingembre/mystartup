<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 21/09/2017
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="businessPlanRegistrationForm" scope="request" class="ua.goit.entity.BusinessPlanRegistrationForm"/>
<html>
<head>
    <title>Business Plan Details</title>
</head>
<body>

<p>You have successfully registered the following business plan: </p>
    <table>
            <tr>
                <td>Business Plan Id :</td>
                <td>${businessPlanRegistrationForm.businessPlan.businessplan_id}</td>
            </tr>
            <tr>
                <td>Idea :</td>
                <td>${businessPlanRegistrationForm.businessPlan.idea}</td>
            </tr>
            <tr>
             <tr>
                <td>Town :</td>
                <td>${businessPlanRegistrationForm.address.town}</td>
            </tr>
            <tr>
                <td>Region :</td>
                <td>${businessPlanRegistrationForm.address.region}</td>
            </tr>
             <tr>
                <td>Country :</td>
                <td>${businessPlanRegistrationForm.address.country}</td>
            </tr>
            <tr>
                <td>Current State :</td>
                <td>${businessPlanRegistrationForm.businessPlan.currentState}</td>
            </tr>
            <tr>
                <td>Market :</td>
                <td>${businessPlanRegistrationForm.businessPlan.market}</td>
            </tr>
            <tr>
                <td>Opportunity :</td>
                <td>${businessPlanRegistrationForm.businessPlan.opportunity}</td>
            </tr>
            <tr>
                <td>Solution :</td>
                <td>${businessPlanRegistrationForm.businessPlan.solution}</td>
            </tr>
            <tr>
                <td>Competition :</td>
                <td>${businessPlanRegistrationForm.businessPlan.competition}</td>
            </tr>
            <tr>
                <td>Unique Selling Point :</td>
                <td>${businessPlanRegistrationForm.businessPlan.usp}</td>
            </tr>
            <tr>
                <td>Business Model :</td>
                <td>${businessPlanRegistrationForm.businessPlan.businessModel}</td>
            </tr>
            <tr>
                <td>Funds Uses :</td>
                <td>${businessPlanRegistrationForm.businessPlan.fundsUses}</td>
            </tr>
            <tr>
                <td>Mentors :</td>
                <td>${businessPlanRegistrationForm.businessPlan.mentors}</td>
            </tr>
            <tr>
                <td>Risks :</td>
                <td>${businessPlanRegistrationForm.businessPlan.risks}</td>
            </tr>
            <tr>
                <td>Website :</td>
                <td>${businessPlanRegistrationForm.businessPlan.weburl}</td>
            </tr>
            <tr>
                <td>Pdf Document :</td>
                <td>${businessPlanRegistrationForm.businessPlan.docurl}</td>
            </tr>
            <tr>
                <td>Expected Raise :</td>
                <td>${businessPlanRegistrationForm.businessPlan.businessPlanExpectedRaise}</td>
            </tr>
            <tr>
                <td>Amount Already Raised :</td>
                <td>${businessPlanRegistrationForm.businessPlan.businessPlanAmountRaised}</td>
            </tr>
            <tr>
                <td>Minimum Investment :</td>
                <td>${businessPlanRegistrationForm.businessPlan.businessPlanMinInv}</td>
            </tr>
            <tr>
                <td>Expected Return :</td>
                <td>${businessPlanRegistrationForm.businessPlan.businessPlanReturn}</td>
            </tr>
            <tr>
                <td>Finances Overview :</td>
                <td>${businessPlanRegistrationForm.businessPlan.finances}</td>
            </tr>
            <tr>
                <td>Collateral :</td>
                <td>${businessPlanRegistrationForm.businessPlan.collateral}</td>
            </tr>
            <tr>
                <td>Previous Rounds :</td>
                <td>${businessPlanRegistrationForm.businessPlan.previousRounds}</td>
            </tr>
            <tr>
                <td>Last Changed :</td>
                <td>${businessPlanRegistrationForm.businessPlan.businessPlanLastChange}</td>
            </tr>
        </table>

<a href="/businessplan/add">Submit another business plan</a>

</body>
</html>
