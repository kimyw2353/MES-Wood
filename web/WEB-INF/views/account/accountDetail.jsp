<%@ page import="com.mes.model.Accounts" %>
<%@ page import="com.mes.model.Managers" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="Account List"/>
</jsp:include>

<jsp:include page="../../layout/sidebar.jsp"/>

<%
    Accounts accountsDetail = (Accounts) request.getAttribute("accountsDetail");
%>

<div class="container">
    <jsp:include page="../../layout/header.jsp"/>

    <div id="content">
        <div class="content-header">
            <p class="title">거래처관리</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>거래처관리</li>
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
                        <input type="hidden" id="id" name="id" value=<%=accountsDetail.getId()%>>
                        <%--<th>구분</th>
                        <td>
                            <select id="kind" name="kind" class="form-control xs">
                                <option value="1">매입처</option>
                                <option value="2">매출처</option>
                                <option value="3">기타</option>
                            </select>
                        </td>--%>
                        <th>거래처명</th>
                        <td>
                            <input type="text" name="name" class="form-control xs"
                                   value="<%=accountsDetail.getName()%>">
                        </td>
                    </tr>
                    <tr>
                        <th>업종</th>
                        <td><input type="text" name="businessCategory" class="form-control xs"
                                   value=<%=accountsDetail.getBusinessCategory()%>></td>
                        <th>업태</th>
                        <td><input type="text" name="businessType" class="form-control xs"
                                   value=<%=accountsDetail.getBusinessType()%>></td>
                    </tr>
                    <tr>
                        <th>대표자</th>
                        <td><input type="text" name="ceo" class="form-control xs" value=<%=accountsDetail.getCeo()%>>
                        </td>
                        <th>사업자번호</th>
                        <td><input type="text" name="businessNumber" class="form-control xs"
                                   value=<%=accountsDetail.getBusinessNumber()%>></td>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td><input type="text" name="phone" class="form-control xs"
                                   value=<%=accountsDetail.getPhone()%>></td>
                        <th>팩스</th>
                        <td><input type="text" name="fax" class="form-control xs" value="<%=accountsDetail.getFax()%>">
                        </td>
                    </tr>
                    <tr>
                        <th rowspan="3">주소</th>
                        <td colspan="3">
                            <input type="text" name="zipcode" class="form-control xs w-100" placeholder="우편번호"
                                   value="<%=accountsDetail.getZipcode()%>" readonly>
                            <button type="button" id="btnAddressSearch" class="btn-xs btn-olive">
                                <i class="fa fa-address-book" aria-hidden="true"></i>주소찾기
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="address" class="form-control xs"
                                               placeholder="주소찾기를 통해 주소를 입력해 주세요."
                                               value="<%=accountsDetail.getAddress()%>" readonly></td>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="addressDesc" class="form-control xs"
                                               placeholder="상세주소를 입력해 주세요." value=<%=accountsDetail.getAddressDesc()%>>
                        </td>
                    </tr>
                    <tr>
                        <th>비고</th>
                        <td colspan="3"><textarea name="etc" id="etc" rows="5"
                                                  class="form-control xs"><%=accountsDetail.getEtc()%></textarea></td>
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

        <div class="box box-bg mg-top-10">
            <div class="content-header clearfix">
                <div class="f-left">
                    <p class="sub_title">거래처 담당자</p>
                </div>
                <div class="f-right">
                    <button type="submit" class="btn btn-xs btn-primary"
                            onclick="createManagerPopup(<%=accountsDetail.getId()%>)">등록
                    </button>
                    <button type="submit" id="btnAccountManagerDelete" name="btnAccountManagerDelete"
                            class="btn btn-xs btn-danger">삭제
                    </button>
                </div>
            </div>

            <form name="account_manager_form" method="POST" action="/account/deleteManager.do">
                <table class="table-list full">
                    <colgroup>
                        <col width="50px">
                        <col width="*">
                        <col width="150px">
                        <col width="150px">
                        <col width="200px">
                    </colgroup>
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="all"></th>
                        <th>담당자명</th>
                        <th>이메일</th>
                        <th>연락처</th>
                        <th>직급</th>
                        <th>부서</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="accountManager" items="${accountManagersList}">
                        <tr>
                            <td class="text-center"><input type="checkbox" name="managerIdx[]" value="${accountManager.id}"></td>
                            <td class="text-center">
                                <a onclick="detailManagerPopup(${accountManager.id})">${accountManager.name}</a>
                            </td>
                            <td class="text-center">${accountManager.email}</td>
                            <td class="text-center">${accountManager.phone}</td>
                            <td class="text-center">${accountManager.position}</td>
                            <td class="text-center">${accountManager.department}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <jsp:include page="../../layout/footer.jsp"/>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#btnAccountManagerDelete').on('click', function () {
            var $checkboxval = [];

            $('input:checkbox[name="managerIdx[]"]:checked').each(function () {
                $checkboxval.push($(this).val());
            });
            if ($checkboxval.length == 0) {
                alert('선택된 항목이 없습니다')
            } else {
                var agree = confirm("해당 담당자를 삭제하시겠습니까?");

                if (agree) {
                    $.post('/account/ManagerDelete.do', {
                        'managerIds': $checkboxval.toString(),
                        'account_id': "<%=accountsDetail.getId()%>"
                    }, function () {
                        alert("삭제되었습니다.");
                    }).always(function () {
                        window.location.reload();
                    })
                }
            }
        });

        $('input:checkbox[name="all"]').on('click', function (e) {
            $('input:checkbox[name="managerIdx[]"]').prop('checked', $(this).is(':checked'));
        });

        $('#btnAddressSearch').on('click', function (e) {
            getAddressSearch(['zipcode', 'address', 'addressDesc'], 'input_form');
        });
    })

    $(document).ready(function () {
        $("#history_back").on("click", function () {
            $(location).attr("href", "/accounts/List.do");
        });
    });

</script>

<jsp:include page="../../layout/bottom.jsp" flush="false"/>