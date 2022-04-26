<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../../layout/top.jsp">
    <jsp:param name="title" value="OrderMaterial Add"/>
</jsp:include>
<div class="box box-bg">
    <div class="content-header">
        <p class="title">자재 발주 등록</p>
    </div>
    <form name="order_material_form" method="post" action="/orderMaterial/MaterialAdd.do">
        <table class="table-input xs">
            <colgroup>
                <col width="150px">
                <col width="*">
            </colgroup>
            <tbody>
            <tr>
                <td>발주id : <input type="text" name="order_id" id="order_id" value="${orderId}">
                자재id<input type="text" name="m_id" id="m_id"></td>
            </tr>
            <tr>
                <th>자재코드</th>
                <td>
                    <input type="text" name="m_code" id="m_code" class="form-control xs read-only" readonly>
                </td>
            </tr>
            <tr>
                <th>자재명</th>
                <td>
                    <input type="text" id="m_name" name="m_name" class="form-control xs" onclick="ListMaterialPopup();" readonly>
                </td>
            </tr>
            <tr>
                <th>규격</th>
                <td>
                    <input type="text" name="m_size" id="m_size" class="form-control xs read-only" readonly>
                </td>
            </tr>
            <tr>
                <th>수량</th>
                <td>
                    <input type="text" name="amount" class="form-control xs">
                </td>
            </tr>
            <tr>
                <th>단가</th>
                <td>
                    <input type="text" name="price" class="form-control xs">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="clearfix mg-top-10">
            <div class="f-right">
                <button type="submit" id="btnSubmit" class="btn btn-primary">
                    <i class="fa fa-pencil"></i>등록
                </button>
            </div>
        </div>
    </form>
</div>