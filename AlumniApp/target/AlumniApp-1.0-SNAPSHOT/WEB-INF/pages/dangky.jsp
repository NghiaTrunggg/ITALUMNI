<%-- 
    Document   : dangky
    Created on : Oct 23, 2023, 10:27:44 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">ĐĂNG KÝ</h1>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<c:url value="/dangky" var="action" />
<form:form method="post" action="${action}" modelAttribute="nguoidung" enctype="multipart/form-data">
    <form:hidden path="id"/>

    <div class="mb-3 mt-3">
        <label for="username" class="form-label">Tên đăng nhập:</label>
        <form:input type="text" class="form-control" id="tendn" placeholder="Tên đăng nhập" path="tendn"/>
        <form:errors path="tendn" cssClass="text-danger" element="div"/>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Mật khẩu:</label>
        <form:input type="password" class="form-control" id="matkhau" placeholder="Enter password" path="matkhau" />
        <form:errors path="matkhau" cssClass="text-danger" element="div" />
    </div>
   
    <div class="mb-3">
        <label for="confirmPassword" class="form-label">Họ:</label>
        <form:input type="text" class="form-control" id="ho" placeholder="Enter confirm password" path="ho"/>
    </div>
    <div class="mb-3">
        <label for="confirmPassword" class="form-label">Tên:</label>
        <form:input type="text" class="form-control" id="ten" placeholder="Enter confirm password" path="ten"/>
    </div>
    <div class="mb-3">
        <label for="file" class="form-label">Hình đại diện:</label>
        <form:input type="file" class="form-control" id="file" placeholder="Enter confirm password" path="file"/>
    </div>

    <div class="form-group">
        <input type="submit" value="Đăng ký" class="btn btn-danger"/>
    </div>
</form:form>
