<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="거래처 등록"/>
</jsp:include>

<jsp:include page="../../layout/sidebar.jsp"/>

<div class="container">
    <jsp:include page="../../layout/header.jsp"/>

    <div id="content" style="width: 95%">
        <div class="content-header">
            <p class="title">거래처 등록하기</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>거래처관리</li>
                <li>등록</li>
            </ol>
        </div>

        <div class="box box-bg">
            <form name="input_form" method="POST" action="/accounts/Create.do">
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
                            <%--<th>구분</th>
                            <td>
                                &lt;%&ndash;                            <input type="text" name="kind" id="kind" class="form-control xs">&ndash;%&gt;
                                <select name="kind" class="form-control xs">
                                    <option value="1">매입처</option>
                                    <option value="2">매출처</option>
                                    <option value="3">기타</option>
                                </select>
                            </td>--%>
                            <th>거래처명</th>
                            <td>
                                <input type="text" name="name" id="name" class="form-control xs">
                            </td>
                        </tr>
                        <tr>
                            <th>업종</th>
                            <td><input type="text" name="businessType" id="businessType" class="form-control xs"></td>
                            <th>업태</th>
                            <td><input type="text" name="businessCategory" id="businessCategory"
                                       class="form-control xs"></td>
                        </tr>
                        <tr>
                            <th>대표자</th>
                            <td><input type="text" name="ceo" id="ceo" class="form-control xs"></td>
                            <th>사업자번호</th>
                            <td><input type="text" name="businessNumber" id="businessNumber" class="form-control xs">
                            </td>
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td><input type="text" name="phone" id="phone" class="form-control xs"></td>
                            <th>팩스</th>
                            <td><input type="text" name="fax" id="fax" class="form-control xs"></td>
                        </tr>
                        <tr>
                            <th rowspan="3">주소</th>
                            <td colspan="3">
                                <input type="text" name="zipcode" id="zipcode" class="form-control xs w-100"
                                       placeholder="우편번호" readonly>
                                <button type="button" id="btnAddressSearch" class="btn-xs btn-olive">
                                    <i class="fa fa-address-book" aria-hidden="true"></i>주소찾기
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3"><input type="text" name="address" id="address" class="form-control xs"
                                                   placeholder="주소찾기를 통해 주소를 입력해 주세요." readonly></td>
                        </tr>
                        <tr>
                            <td colspan="3"><input type="text" name="addressDesc" id="addressDesc"
                                                   class="form-control xs" placeholder="상세주소를 입력해 주세요."></td>
                        </tr>
                        <tr>
                            <th>비고</th>
                            <td colspan="3"><textarea name="etc" id="etc" rows="5" class="form-control xs"></textarea>
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
            $(location).attr("href", "/accounts/List.do");
        });
    });
</script>

<jsp:include page="../../layout/bottom.jsp" flush="false"/>
