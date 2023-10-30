<%-- 
    Document   : tintucs
    Created on : Oct 17, 2023, 8:53:00 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info">QUẢN LÝ TIN TỨC</h1>

<c:url value="/tintucs" var="action"/>
<form:form method="post" action="${action}" modelAttribute="tintuc" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="id" />
    <form:hidden path="hinhanh" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="ten" id="ten" placeholder="Nhap ten..."/>
        <label for="ten">Tên tin tức</label>  
        <form:errors path="ten" element="div" cssClass="text-danger"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="file" />
        <label for="file">Ảnh tin tuc</label>       
    </div>
    <div class="form-floating">
        <form:textarea class="form-control" path="tomtat" id="tomtat" name="tomtat" placeholder="Tóm tắtt..." />
        <label for="tomtat">Tóm tắt</label>       
    </div>
        <div class="form-floating mt-3 " >
        <form:textarea class="form-control" path="noidung" id="noidung" name="noidung" placeholder="Nội dung..." />
        <label for="tomtat">Nội dung chính</label>       
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="danhmuctintuc" name="danhmuctintuc" path="danhmuctintucId">
            <c:forEach items="${danhmuctintuc}" var="d">
                <c:choose>
                    <c:when test="${d.id == tintuc.danhmuctintucId.id}">
                        <option value="${d.id}" selected="">${d.ten}</option>
                    </c:when>
                    <c:otherwise >
                        <option value="${d.id}" >${d.ten}</option>
                    </c:otherwise>   
                </c:choose>

            </c:forEach>
        </form:select>

        <label for="sel1" class="form-label">Danh mục tin tức</label>
    </div> 
        
    <div class="form-floating mt-1">
        <button class="btn btn-info mt-2" type="submit">
            <c:choose>
                <c:when test="${tintuc.id == null}">Thêm tin tức</c:when>
                <c:otherwise> Cập nhật tin tức</c:otherwise>
            </c:choose>           
        </button>
    </div>
    
</form:form>



