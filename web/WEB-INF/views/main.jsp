<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../layout/top.jsp">
    <jsp:param name="title" value="Main" />
</jsp:include>

<jsp:include page="../common/loginCheck.jsp" />

<jsp:include page="../layout/sidebar.jsp" />

<div class="container">
    <jsp:include page="../layout/header.jsp" />

    <div id="content">
        <div class="content-header">
            <p class="title">소개</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>교육관리</li>
                <li>교육신청정보</li>
            </ol>
        </div>

        <div class="box box-bg">
            <p>위하여, 것은 청춘은 굳세게 것이다. 투명하되 것은 같은 눈이 청춘의 인간에 풍부하게 이것이다. 힘차게 듣기만 심장의 길지 소담스러운 인간은 우리의 못할 군영과 있는가? 위하여, 듣기만 이상 두손을 피가 것은 청춘에서만 같이 피다. 사랑의 무엇을 따뜻한 같지 대중을 있는 쓸쓸하랴? 그러므로 이상은 자신과 풀이 사랑의 심장은 사막이다. 때에, 되려니와, 거선의 같지 구하기 고동을 없는 말이다. 주는 거친 노래하며 사막이다. 사라지지 열락의 석가는 때문이다.</p>
        </div>
    </div>

    <jsp:include page="../layout/footer.jsp" flush="false" />
</div>

<jsp:include page="../layout/bottom.jsp" flush="false" />
