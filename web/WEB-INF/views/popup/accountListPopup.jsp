<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="account List"/>
</jsp:include>

<div class="container" style="width: 100%; float: left" >
    <%--<jsp:include page="../../layout/header.jsp"/>--%>

    <div id="content">
        <div class="content-header">
            <p class="title">거래처 목록</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home"></i></li>
            </ol>
        </div>

        <div class="box box-bg">
            <form name="search_form" method="GET" action="/managers/List.do">
                <input type="hidden" name="page">
                <table class="table-input">
                    <colgroup>
                        <col width="15%">
                        <col width="35%">
                        <col width="15%">
                        <col width="*">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>구분</th>
                        <td>
                            <select name="account_type" class="form-control">
                                <option value="">회원</option>
                                <option value="">회원</option>
                                <option value="">회원</option>
                                <option value="">회원</option>
                            </select>
                        </td>
                        <th>거래처</th>
                        <td><input type="text" name="account_name" class="form-control"></td>
                    </tr>
                    </tbody>
                </table>

                <div class="mg-top-10 mg-bottom-10 text-right">
                    <button type="submit" class="btn btn-default search_submit"><i class="fa fa-search"></i>검색하기
                    </button>
                </div>

                <div class="clearfix mg-bottom-10">
                    <div class="f-left ft-bold mg-top-5">
                        Total : ${accountsTotalCount} 건
                    </div>
                </div>
            </form>

            <table class="table-list full">
                <colgroup>


                    <col width="*">
                </colgroup>
                <thead>
                <tr>
                    <%--<th>구분</th>--%>
                    <th>거래처명</th>
                    <th>대표자</th>
                    <th>대표번호</th>
                    <th>비고</th>
                </tr>
                </thead>
                <tbody>
                <!-- <tr>
                    <td colspan="6" class="text-center">등록된 내용이 없습니다.</td>
                </tr> -->

                <c:forEach var="accountsList" items="${accountsList}">
                    <tr style="text-align: center">
                        <%--<td>${accountsList.kind }</td>--%>
                        <td>
                            <a onclick="accountSelect(this)" id="account_name" data-value= "${accountsList.id}">
                                    ${accountsList.name}
                            </a>
                        </td>
                        <td>${accountsList.ceo }</td>
                        <td>${accountsList.phone }</td>
                        <td>${accountsList.etc }</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

            <div class="pagination">
                <a href="javascript:void(0)">«</a>
                <a href="javascript:void(0)">1</a>
                <a href="javascript:void(0)" class="active">2</a>
                <a href="javascript:void(0)">3</a>
                <a href="javascript:void(0)">4</a>
                <a href="javascript:void(0)">5</a>
                <a href="javascript:void(0)">6</a>
                <a href="javascript:void(0)">7</a>
                <a href="javascript:void(0)">8</a>
                <a href="javascript:void(0)">9</a>
                <a href="javascript:void(0)">»</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        settingDatepicker(['start_date', 'end_date'], 'search_form');

        var $search_form = $('form[name="search_form"]');
        $search_form.on('click', function () {
            $search_form.find('input[name="page"]').val(0);
        });
        moveToLastPage(${accountPaging.finalPageNo});
    });

    function pagination(page) {
        $('form[name="search_form"]').find('input[name="page"]').val(page);
        $('form[name="search_form"]').attr('action', 'accountListPopup.do');
        $('form[name="search_form"]').submit();
    }

    function accountSelect(accountInfo) {
        window.close();
        window.opener.document.getElementById('account_name').value = $(accountInfo).text();//클릭한 거래처명 부모창의 거래처명에 저장
        window.opener.document.getElementById('account_id').value = accountInfo.getAttribute('data-value');//클릭한 거래처명이 갖고있는 value(account_id) 부모창 히든태그에 저장
    }

</script>
<%--<jsp:include page="../../layout/footer.jsp"/>--%>
<jsp:include page="../../layout/bottom.jsp" flush="false"/>