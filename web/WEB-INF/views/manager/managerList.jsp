<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../layout/top.jsp">
    <jsp:param name="title" value="ManagerList" />
</jsp:include>

<jsp:include page="../../layout/sidebar.jsp" />

<div class="container">
    <jsp:include page="../../layout/header.jsp" />

    <div id="content">
        <div class="content-header">
            <p class="title">거래처담당관리</p>
            <ol class="breadcrumb">
                <li><i class="fa fa-home" aria-hidden="true"></i></li>
                <li>거래처담당관리</li>
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
                            <select name="account_type" class="form-control">
                                <option value="">회원</option>
                                <option value="">회원</option>
                                <option value="">회원</option>
                                <option value="">회원</option>
                            </select>
                        </td>
                        <th>매니저 명</th>
                        <td><input type="text" name="account_name" class="form-control"></td>
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
                    Total : ${managerTotalCount}건
                </div>
                <div class="f-right text-right">
                    <button type="button" id="manager_input" class="btn btn-primary"><i class="fa fa-pencil" aria-hidden="true"></i> 등록</button>
                    <button type="button" id="account_excel_download" class="btn btn-success"><i class="fa fa-file-excel-o" aria-hidden="true"></i> Excel <button>
                    <button type="button" id="manager_delete" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> 삭제 </button>
                </div>
            </div>

            <table class="table-list full">
                <colgroup>
                    <col width="50">
                    <%--<col width="100px">--%>
                    <col width="100px">
                    <col width="100px">
                    <col width="50px">
                    <col width="50px">
                    <col width="50px">
                    <col width="50px">
                </colgroup>
                <thead>
                <tr>
                    <th><input type="checkbox" name="all"></th>
                    <%--<th>구분</th>--%>
                    <th>담당자명</th>
                    <th>거래처명</th>
                    <th>이메일</th>
                    <th>번호</th>
                    <th>직책</th>
                    <th>부서</th>
                </tr>
                </thead>
                <tbody>

                <c:set var="managerTotalCount" value="${managerTotalCount}"></c:set>
                <c:if test="${managerTotalCount eq 0}">
                    <tr>
                        <td colspan="6" class="text-center">등록된 정보가 없습니다.</td>
                    </tr>
                </c:if>

                <c:forEach var="managersList" items="${managersList}">
                    <tr STYLE="text-align: center">
                        <td><input type="checkbox" name="idx[]" id="idx[]" value="${managersList.id}"/></td>
                        <td><a href="/managers/Detail.do?id=${managersList.id}">${managersList.name}</a></td>
                        <td>${managersList.accountName}</td>
                        <td>${managersList.email}</td>
                        <td>${managersList.phone}</td>
                        <td>${managersList.position}</td>
                        <td>${managersList.department}</td>
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
            $(location).attr("href", "/managers/Create.do");
        });

        $("#account_excel_download").on("click", function () {
            alert("account_excel_download");
        })

        $('#manager_delete').on('click', function (e) {
            var checkValueArr = new Array();
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
                        url : "/managers/Delete.do",
                        type : 'POST',
                        traditional : true,
                        data: {
                            'managerIds' : checkValueArr
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
