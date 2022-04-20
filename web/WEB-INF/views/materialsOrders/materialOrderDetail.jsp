<%@ page import="com.mes.model.Accounts" %>
<%@ page import="com.mes.model.Managers" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="Account List"/>
</jsp:include>

<jsp:include page="../../layout/sidebar.jsp"/>

<div class="container">
    <jsp:include page="../../layout/header.jsp"/>

    <div id="content">
        <div class="content-header">
            <p class="title">자재발주관리</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>자재발주관리</li>
                <li>상세보기</li>
            </ol>
        </div>

        <div class="box box-bg mg-top-10">
            <form name="input_form" method="POST" action="/accounts/Detail.do">
                <table class="table-input xs">
                    <colgroup>
                        <col width="150px">
                        <col width="323px">
                        <col width="150px">
                        <col width="*">
                    </colgroup>
                    <tbody>
                    <tr>
                        <input type="hidden" id="id" name="id" value="">>
                    <tr>
                        <th>발주코드</th>
                        <td colspan="3">
                            <input type="text" name="m_number" id="m_number" class="form-control xs" value="${m_orderDetail.getNumber()}" readonly>
                        </td>
                    </tr>
                    <tr>
                        <th>발주명</th>
                        <td colspan="3">
                            <input type="text" name="m_name" id="m_name" class="form-control xs" value="${m_orderDetail.getName()}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>거래처명</th>
                        <td colspan="3">
                            <input type="text" name="account_name" id="account_name" class="form-control xs" onclick="ListMaterialOrderPopup()"
                                   value="${m_orderDetail.getAccount_name}" readonly required>
                            <input type="hidden" name="account_id" id="account_id">
                        </td>
                    </tr>
                    <tr>
                        <th>발주 금액</th>
                        <td>
                            <input type="text" name="m_price" class="form-control xs" readonly>
                        </td>
                        <th>발주 수량</th>
                        <td>
                            <input type="text" name="m_number" class="form-control xs" readonly>
                        </td>
                    </tr>
                    <tr>
                        <th>발주일</th>
                        <td colspan="3">
                            <input type="text" name="m_order" id="datepicker" class="form-control xs">
                        </td>
                    </tr>
                    <tr>
                        <th>비고</th>
                        <td colspan="3">
                            <input type="text" name="m_etc" id="m_etc" class="form-control xs">
                        </td>
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
                            <i class="fa fa-pencil" aria-hidden="true"></i>수정
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
    <jsp:include page="../../layout/footer.jsp"/>
</div>

<script type="text/javascript">
    <%--$(document).ready(function () {--%>
    <%--    $('#btnAccountManagerDelete').on('click', function () {--%>
    <%--        var $checkboxval = [];--%>

    <%--        $('input:checkbox[name="managerIdx[]"]:checked').each(function () {--%>
    <%--            $checkboxval.push($(this).val());--%>
    <%--        });--%>
    <%--        if ($checkboxval.length == 0) {--%>
    <%--            alert('선택된 항목이 없습니다')--%>
    <%--        } else {--%>
    <%--            var agree = confirm("해당 담당자를 삭제하시겠습니까?");--%>

    <%--            if (agree) {--%>
    <%--                $.post('/account/ManagerDelete.do', {--%>
    <%--                    'managerIds': $checkboxval.toString(),--%>
    <%--                    'account_id': "<%=accountsDetail.getId()%>"--%>
    <%--                }, function () {--%>
    <%--                    alert("삭제되었습니다.");--%>
    <%--                }).always(function () {--%>
    <%--                    window.location.reload();--%>
    <%--                })--%>
    <%--            }--%>
    <%--        }--%>
    <%--    });--%>

    <%--    $('input:checkbox[name="all"]').on('click', function (e) {--%>
    <%--        $('input:checkbox[name="managerIdx[]"]').prop('checked', $(this).is(':checked'));--%>
    <%--    });--%>

    <%--    $('#btnAddressSearch').on('click', function (e) {--%>
    <%--        getAddressSearch(['zipcode', 'address', 'addressDesc'], 'input_form');--%>
    <%--    });--%>
    <%--})--%>

    $(document).ready(function () {
        $("#history_back").on("click", function () {
            $(location).attr("href", "/accounts/List.do");
        });
    });

</script>

<jsp:include page="../../layout/bottom.jsp" flush="false"/>