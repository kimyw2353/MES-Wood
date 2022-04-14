<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="거래처담당 등록"/>
</jsp:include>

<jsp:include page="../../layout/sidebar.jsp"/>

<div class="container">
    <jsp:include page="../../layout/header.jsp"/>

    <div id="content" style="width: 95%">
        <div class="content-header">
            <p class="title">거래처 담당 등록하기</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>거래처관리</li>
                <li>거래처 담당 관리</li>
                <li>등록</li>
            </ol>
        </div>

        <div class="box box-bg">
            <form name="input_form" method="POST" action="/managers/Create.do">
                <div class="box box-bg mg-top-10">
                    <table class="table-input xs">
                        <colgroup>
                            <col width="150px">
                            <col width="323px">
                            <col width="150px">
                            <col width="*">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>담당자명</th>
                            <td>
                                <input type="text" name="m_name" id="m_name" class="form-control xs">
                            </td>
                        </tr>
                        <tr>
                            <th>거래처명</th>
                            <td>
                                <input type="text" name="account_name" id="account_name" class="form-control xs" onclick="ListAccountPopup()" readonly>
                                <input type="hidden" name="account_id" id="account_id" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td><input type="text" name="m_email" id="m_email" class="form-control xs"></td>
                            <th>전화번호</th>
                            <td><input type="text" name="m_phone" id="m_phone" class="form-control xs"></td>
                        </tr>
                        <tr>
                            <th>직책</th>
                            <td><input type="text" name="m_position" id="m_position" class="form-control xs"></td>
                            <th>부서</th>
                            <td><input type="text" name="m_department" id="m_department" class="form-control xs"></td>
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
            $(location).attr("href", "/managers/List.do");
        });
    });
</script>

<jsp:include page="../../layout/bottom.jsp" flush="false"/>
