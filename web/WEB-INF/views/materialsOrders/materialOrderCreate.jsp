<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="자재 등록"/>
</jsp:include>

<jsp:include page="../../layout/sidebar.jsp"/>

<div class="container">
    <jsp:include page="../../layout/header.jsp"/>

    <div id="content" style="width: 95%">
        <div class="content-header">
            <p class="title">발주 등록 하기</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>자재 관리</li>
                <li>자재발주관리</li>
                <li>등록</li>
            </ol>
        </div>

        <div class="box box-bg">
            <form name="input_form" method="POST" action="/materials/Order/Create.do">
                <div class="box box-bg mg-top-10">
                    <table class="table-input xs">
                        <colgroup>
                            <col width="200px">
                            <col width="323px">
                            <col width="200px">
                            <col width="323px">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>발주번호</th>
                            <td>
                                <input type="text" name="m_code" id="m_code" class="form-control xs">
                            </td>
                        </tr>
                        <tr>
                            <th>발주명</th>
                            <td>
                                <input type="text" name="m_name" id="m_name" class="form-control xs" required>
                            </td>
                            <th>거래처명</th>
                            <td>
                                <input type="text" name="account_name" id="account_name" class="form-control xs" onclick="ListAccountPopup()" readonly required>
                                <input type="hidden" name="account_id" id="account_id" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>발주 금액</th>
                            <td>
                                <input type="text" name="m_price">
                            </td>
                            <th>발주 수량</th>
                            <td>
                                <input type="text" name="m_number">
                            </td>
                        </tr>
                        <tr>
                            <th>발주일</th>
                            <td><input type="text" name="m_date" id="m_date" class="form-control xs"></td>
                        </tr>
                        <tr>
                            <th>비고</th>
                            <td><input type="text" name="m_etc" id="m_etc" class="form-control xs"></td>
                        </tr>
                        </tbody>
                    </table>

                    <div class="clearfix mg-top-10">
                        <div class="f-left">
                            <button type="button" id="history_back" class="btn btn-default">
                                <i class="fa fa-arrow-left" aria-hidden="true"></i>이전
                            </button>
                        </div>
                        <div class="f-right">
                            <button type="submit" class="btn btn-primary">
                                <i class="fa fa-pencil" aria-hidden="true"></i>등록
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="../../layout/footer.jsp" flush="false"/>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $("#history_back").on("click", function () {
            $(location).attr("href", "/materials/List.do");
        });
    });
</script>

<jsp:include page="../../layout/bottom.jsp" flush="false"/>
