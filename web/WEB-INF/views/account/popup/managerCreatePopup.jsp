<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../../layout/top.jsp">
    <jsp:param name="title" value="Account List"/>
</jsp:include>

<%
    String accountId = request.getParameter("accountId");
    System.out.println("팝업창 거래처 아이디 : " + accountId);
%>

<div class="box box-bg">
    <div class="content-header">
        <p class="title">거래처 담당자 등록하기</p>
    </div>

    <form name="account_manager_form" method="POST" onsubmit="return false">
        <table class="table-input xs">
            <colgroup>
                <col width="150px">
                <col width="*">
            </colgroup>
            <tbody>
            <input type="hidden" name="accountId" value="<%=accountId%>" />
            <tr>
                <th>담당자명</th>
                <td><input type="text" id="m_name" name="m_name" class="form-control xs" ></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" id="m_email" name="m_email" class="form-control xs" ></td>
            </tr>
            <tr>
                <th>연락처</th>
                <td><input type="text" id="m_phone" name="m_phone" class="form-control xs" ></td>
            </tr>
            <tr>
                <th>직책</th>
                <td><input type="text" id="m_position" name="m_position" class="form-control xs" ></td>
            </tr>
            <tr>
                <th>부서</th>
                <td><input type="text" id="m_department" name="m_department" class="form-control xs" ></td>
            </tr>
            </tbody>
        </table>

        <div class="clearfix mg-top-10">
            <div class="f-right">
                <button type="submit" id="btnSubmit" class="btn btn-primary">
                    <i class="fa fa-pencil"></i>등록하기
                </button>
            </div>
        </div>
    </form>
</div>


<body/>
<div/>

<script type="text/javascript">
    $(document).ready(function () {
        var $accountManagerForm = $('form[name="account_manager_form"]');

        $accountManagerForm.on('submit', function (e) {
            $('#btnSubmit').attr('disabled', true);

            $.post('/account/ManagerCreate.do?', $accountManagerForm.serialize(), function (data) {
                /*  if (data.result) {
                      self.close();
                  }*/

            })
                .done(function () {
                    alert("success");
                })
                /*.fail(function(){
                    alert("error");
                })*/
                .always(function() {
                    $('#btnSubmit').attr('disabled', false);
                    alert("등록되었습니다.",parent.location.reload());
                    opener.parent.location.reload();
                    self.close();
                });
        });
    });
</script>

