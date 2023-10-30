<%-- 
    Document   : index
    Created on : Oct 12, 2023, 9:29:26 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section >
    <h1 class="text-center mt-1"> DANH MỤC TIN TỨC</h1>
    <div>
        <a href="<c:url value="/tintucs"/> " class="btn btn-info mt-1">Thêm tin tức</a>
    </div>
    <c:url value="/" var="action"/>
    <c:if test="${demTT > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                <c:forEach begin="1" end="${demTT}" var="i">
                    <c:url value="/" var="pageAction" >
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Id</th>
                <th>Tên tin tức</th>
                <th>Tóm tắt</th>
                <th>Nội dung</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tintuc}" var="t">
                <tr>
                    <td>
                        <img src="${t.hinhanh}" alt="${t.ten}" width="180"/>
                    </td>
                    <td>${t.id}</td>
                    <td>${t.ten}</td>
                    <td>${t.tomtat}</td>
                    <td>${t.noidung}</td>
                    <td>
                         <c:url value="/api/tintucs/${t.id}" var="apiXoa" />
                        <a href="<c:url value="/tintucs/${t.id}"/>" class="btn btn-success" >Cập nhật</a>
                        <button class="btn btn-danger mt-1" onclick="xoaTin('${apiXoa}') ">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

    <script src="<c:url value="/js/main.js" />"></script>
