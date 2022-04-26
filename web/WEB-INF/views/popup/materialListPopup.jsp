<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="Material List"/>
</jsp:include>

<div class="container" style="width: 100%; float: left" >
    <div id="content">
        <div class="content-header">
            <p class="title">자재정보관리</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>자재정보관리</li>
                <li>조회</li>
            </ol>
        </div>

        <div class="box box-bg">
            <form name="search_form" method="GET">
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
                            <select name="material_type" class="form-control">
                                <option value="">회원</option>
                                <option value="">회원</option>
                                <option value="">회원</option>
                                <option value="">회원</option>
                            </select>
                        </td>
                        <th>자재명</th>
                        <td><input type="text" name="material_name" class="form-control"></td>
                    </tr>
                    </tbody>
                </table>

                <div class="clearfix mg-top-10 mg-bottom-10">
                    <div class="f-right text-right">
                        <button type="submit" class="btn btn-default search_submit"><i class="fa fa-search" aria-hidden="true"></i>검색하기</button>
                    </div>
                </div>
            </form>

            <div class="clearfix mg-top-10 mg-bottom-10">
                <div class="f-left ft-bold mg-top-5">
                    Total : ${m_totalCount}건
                </div>
            </div>

            <table class="table-list full">
                <colgroup>
                    <col width="50">
                    <%--<col width="100px">--%>
                    <col width="150px">
                    <col width="300px">
                    <col width="200px">
                    <col width="200px">
                    <col width="100px">
                    <col width="100px">
                </colgroup>
                <thead>
                <tr>
                    <th><input type="checkbox" name="all"></th>
                    <%--<th>구분</th>--%>
                    <th>자재코드</th>
                    <th>자재명</th>
                    <th>거래처명</th>
                    <th>규격</th>
                    <th>비고</th>
                </tr>
                </thead>
                <tbody>

                <c:set var="materialsCount" value="${m_totalCount}"></c:set>
                <c:if test="${m_totalCount eq 0}">
                    <tr>
                        <td colspan="6" class="text-center">등록된 정보가 없습니다.</td>
                    </tr>
                </c:if>

                <c:forEach var="m" items="${materialsList}">
                    <tr STYLE="text-align: center">
                        <td><input type="checkbox" name="idx[]" id="idx[]" value="${m.id}"/></td>
                        <td id="code">${m.code}</td>
                        <td>
                            <a onclick="materialSelect(this)" id="m_name" data-value="${m.id}">
                                    ${m.name}
                            </a>
                        </td>
                        <td>${m.accountName}</td>
                        <td id="size">${m.width} x ${m.height}</td>
                        <td>${m.etc}</td>
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
    function materialSelect(m_info) {
        const id = m_info.getAttribute('data-value');
        const code = document.getElementById('code').innerText;
        const name = $(m_info).text();
        const size = document.getElementById('size').innerText;

        window.close();
        window.opener.document.getElementById('m_id').value = id;
        window.opener.document.getElementById('m_code').value = code;
        window.opener.document.getElementById('m_name').value = name;
        window.opener.document.getElementById('m_size').value = size;

    }

</script>
<%--<jsp:include page="../../layout/footer.jsp"/>--%>
<jsp:include page="../../layout/bottom.jsp" flush="false"/>