<%@ page import="com.mes.model.Managers" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../../layout/top.jsp">
    <jsp:param name="title" value="Account Manager Detail"/>
</jsp:include>

<%
    Managers managers = (Managers) request.getAttribute("managersDetail");
%>

<div class="box box-bg">
    <div class="content-header">
        <p class="title">거래처 담당자 수정하기</p>
    </div>

    <form name="account_manager_form" method="POST" onsubmit="return false">
        <table class="table-input xs">
            <colgroup>
                <col width="150px">
                <col width="*">
            </colgroup>
            <tbody>
            <input type="hidden" id="id" name="id" value="<%=managers.getId()%>" />
            <tr>
                <th>담당자명</th>
                <td><input type="text" id="name" name="name" class="form-control xs" value="<%=managers.getName()%>" ></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" id="email" name="email" class="form-control xs" value="<%=managers.getEmail()%>" ></td>
            </tr>
            <tr>
                <th>연락처</th>
                <td><input type="text" id="phone" name="phone" class="form-control xs" value="<%=managers.getPhone()%>"></td>
            </tr>
            <tr>
                <th>직책</th>
                <td><input type="text" id="position" name="position" class="form-control xs" value="<%=managers.getPosition()%>" ></td>
            </tr>
            <tr>
                <th>부서</th>
                <td><input type="text" id="department" name="department" class="form-control xs" value="<%=managers.getDepartment()%>"></td>
            </tr>
            </tbody>
        </table>

        <div class="clearfix mg-top-10">
            <div class="f-right">
                <button type="submit" id="btnSubmit" class="btn btn-primary">
                    <i class="fa fa-pencil"></i>수정하기
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

            $.post('/account/ManagerDetail.do?', $accountManagerForm.serialize(), function (data) {
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
                    alert("수정되었습니다.",parent.location.reload());
                    opener.parent.location.reload();
                    self.close();
                });
        });
    });
</script>

