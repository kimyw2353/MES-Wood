<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="자재정보관리" />
</jsp:include>

<jsp:include page="../../layout/sidebar.jsp" />

<div class="container">
    <jsp:include page="../../layout/header.jsp" />

    <div id="content">
        <div class="content-header">
            <p class="title">자재발주관리</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>자재발주관리</li>
                <li>조회</li>
            </ol>
        </div>

        <div class="box box-bg">
            <form name="search_form" method="GET">
                <table class="table-input">
                    <colgroup>
                        <col width="10%">
                        <col width="20%">
                        <col width="10%">
                        <col width="20%">
                        <col width="10%">
                        <col width="10%">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>발주처</th>
                        <td>
                            <input type="text" name="" class="form-control">
                        </td>
                        <th>거래처명</th>
                        <td>
                            <input type="text" name="" class="form-control">
                        </td>
                        <th>발주일</th>
                        <td>
                            <input type="text" name="" class="form-control">
                        </td>
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
                    Total :
                    <c:if test="${orderCount eq null}">
                        0건
                    </c:if>
                    <c:if test="${orderCount > 0}">
                    ${orderCount}건
                    </c:if>
                </div>
                <div class="f-right text-right">
                    <button type="button" id="manager_input" class="btn btn-primary">
                        <i class="fa fa-pencil" aria-hidden="true"> 등록</i>
                    </button>
                    <button type="button" id="manager_delete" class="btn btn-danger">
                        <i class="fa fa-trash" aria-hidden="true"> 삭제</i>
                    </button>
                    <button type="button" id="account_excel_download" class="btn btn-success">
                        <i class="fa fa-file-excel-o" aria-hidden="true"> Excel</i>
                    </button>
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
                    <th>발주번호</th>
                    <th>발주명</th>
                    <th>거래처명</th>
                    <th>발주요청일</th>
                    <th>입고요망일</th>
                    <th>비고</th>
                </tr>
                </thead>
                <tbody>

                <c:set var="materialsOrderCount" value="${materialsOrderCount}"></c:set>
                <c:if test="${orderCount eq 0}">
                    <tr>
                        <td colspan="6" class="text-center">등록된 정보가 없습니다.</td>
                    </tr>
                </c:if>

                <c:forEach var="materialsOrdersList" items="${materialsOrdersList}">
                    <tr STYLE="text-align: center">
                        <td><input type="checkbox" name="idx[]" id="idx[]" value="${materialsOrdersList.id}"/></td>
                        <td>${materialsOrdersList.number}</td>
                        <td><a href="/materials/OrderDetail.do?id=${materialsOrdersList.id}">${materialsOrdersList.name}</a></td>
                        <td>${materialsOrdersList.accountName}</td>
                        <td>${materialsOrdersList.orderDate}</td>
                        <td>${materialsOrdersList.deadlineDate}</td>
                        <td>${materialsOrdersList.etc}</td>
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

    <jsp:include page="../../layout/footer.jsp" flush="false" />
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $("#manager_input").on("click", function () {
            $(location).attr("href", "/materials/Order/Create.do");
        });

        $("#account_excel_download").on("click", function () {
            alert("account_excel_download");
        })

        $('#manager_delete').on('click', function (e) {
            var checkValueArr = [];
            var $checkbox = $('input:checkbox[name="idx[]"]:checked');

            for (var i = 0; i < $checkbox.length; i++){
                checkValueArr.push($checkbox[i].value)
            }

            if ($checkbox.length == 0) {
                alert('선택된 항목이 없습니다.');
                return false;
            }else{
                if (confirm($checkbox.length + " 명의 정보를 삭제하시겠습니까?")){
                    $.ajax({
                        url : "/materials/Delete.do",
                        type : 'POST',
                        traditional : true,
                        data: {
                            'materialIds' : checkValueArr
                        }
                    })
                        window.location.reload();
                }
                else{
                    window.location.reload();
                }
            }

            $('input:checkbox[name="all"]').on('click', function (e){
                $('input:checkbox[name="idx[]"]').prop('checked', $(this).is(':checked'));
            });
        })
    });
</script>

<jsp:include page="../../layout/bottom.jsp" flush="false" />
