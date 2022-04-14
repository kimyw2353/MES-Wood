<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String sessionUser = request.getParameter("SESSION_USER");
%>


<c:if test="${sessionUser}">
<script type="text/javascript">
    $(document).ready(function() {
        $('body').hide();
        alert("로그인 후 접근이 가능 합니다.");
        $(location).attr('href', '/login.do');
    });
</script>
</c:if>