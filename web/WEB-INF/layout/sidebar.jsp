<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<div class="sidebar">
    <div class="brand">
        <a href="/main.do">mes solution</a>
    </div>

    <nav>
        <jsp:include page="../common/userInfo.jsp" />

        <ul>
            <li class="header">관리자 메뉴</li>
            <li><a href="javascript:void(0)"><i class="fa fa-angle-right"></i>기준정보관리</a>
                <ul>
                    <li><a href="#">코드관리</a></li>
                    <li><a href="#">코드리스트조회</a></li>
                </ul>
            </li>
            <li><a href="javascript:void(0)"><i class="fa fa-angle-right"></i>거래처관리</a>
                <ul>
                    <li><a href="/accounts/List.do">거래처정보관리</a></li>
                    <li><a href="/managers/List.do">거래처담당관리</a></li>
                </ul>
            </li>
            <li><a href="javascript:void(0)"><i class="fa fa-angle-right"></i>자재관리</a>
                <ul>
                    <li><a href="/materials/List.do">자재정보관리</a></li>
                    <li><a href="#">자재자가처리관리</a></li>
                    <li><a href="/materials/Order.do">자재발주관리</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
<div class="sidebar-bg"></div>