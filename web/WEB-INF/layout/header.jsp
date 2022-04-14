<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header>
    <div class="top_menu">
        <div class="f-right">
            <button type="button" class="btn-sm btn-default" onclick="location.href='/logout.do'">
                <i class="fa fa-sign-out"></i>로그아웃
            </button>
        </div>
    </div>
</header>

<c:if test="${not empty errorMessage}">
    <div class="alert alert-error">
        <button type="button" class="close"><i class="fa fa-times" aria-hidden="false"></i></button>
            ${errorMessage}
    </div>
</c:if>
<c:if test="${not empty successMessage}">
    <div class="alert alert-success">
        <button type="button" class="close"><i class="fa fa-times" aria-hidden="true"></i></button>
            ${successMessage}
    </div>
</c:if>