<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<%
    String sessionName = (String) session.getAttribute("SESSION_NAME");
%>

<div class="user-info clearfix">
    <div class="user-image">
        <i class="fa fa-user-circle" aria-hidden="true"></i>
    </div>
    <div class="user-detail">
        <p><%=sessionName%> 님,</p>
        <p>오늘도 좋은하루 되세요.</p>
    </div>
</div>