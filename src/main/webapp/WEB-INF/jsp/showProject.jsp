<%--
  Created by IntelliJ IDEA.
  User: Guillaume Gingembre
  Date: 17/09/2017
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<%-- <jsp:include page="../fragments/header.jsp" /> --%>

<div class="container">

    <%--
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if> --%>

    <h1>Project Detail</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">Project ID</label>
        <div class="col-sm-10">${project.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Project Name</label>
        <div class="col-sm-10">${project.name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Email</label>
        <div class="col-sm-10">${user.email}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Address</label>
        <div class="col-sm-10">${user.address}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Newsletter</label>
        <div class="col-sm-10">${user.newsletter}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Web Frameworks</label>
        <div class="col-sm-10">${user.framework}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Sex</label>
        <div class="col-sm-10">${user.sex}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Number</label>
        <div class="col-sm-10">${user.number}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Country</label>
        <div class="col-sm-10">${user.country}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Skill</label>
        <div class="col-sm-10">${user.skill}</div>
    </div>

</div>

<%-- <jsp:include page="../fragments/footer.jsp" /> --%>

</body>
</html>