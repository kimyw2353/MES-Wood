<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layout/top.jsp">
    <jsp:param name="title" value="Login" />
    <jsp:param name="stylesheet" value="/css/login.css" />
    <jsp:param name="wrapperClass" value="panel-login-bg" />
</jsp:include>

<div class="panel-login">

    <jsp:include page="../common/alert.jsp" />

    <div class="panel-login-top">
        <%--<h1>mes solution</h1>--%>
        <img style="width: 100%; height: 90px;" src="../../images/image.jpg">
    </div>

    <div class="panel-login-middle">
        <form method="post" action="/login.do">
            <div class="form-group">
                <label>아이디</label>
                <input type="text" name="user_id" class="form-control" placeholder="아이디를 입력해 주세요.">
            </div>

            <div class="form-group">
                <label>비밀번호</label>
                <input type="password" name="password" class="form-control" placeholder="비밀번호를 입력해 주세요.">
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-block btn-primary">로그인</button>
            </div>

            <div class="form-group">
                <ul style="text-align: center">
                    <li><a href="/register.do">회원 가입</a></li>
                </ul>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../layout/bottom.jsp" flush="false" />