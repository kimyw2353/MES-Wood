<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty errorMessage}">
    <div class="alert alert-error">
        <button type="button" class="close"><i class="fa fa-times" aria-hidden="true"></i></button>
        ${errorMessage}
    </div>
</c:if>