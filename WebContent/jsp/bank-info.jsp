<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Bank Information</title>
</head>
<body>
<center><h1>Bank Info Page</h1></center>
<form:form method="post" modelAttribute="bankInfo" action="/user-web/processBankInfo.do">
<%-- <form action="${pageContext.request.contextPath}/user/bank" method="post"> --%>
		Bank Name: <input type="text" name="bankName" required><br>
        Account Number: <input type="text" name="accountNo" required><br>
        SSN: <input type="text" name="ssn" required><br>
        <input type="submit" value="Submit">
<%--     </form> --%>
</form:form>
</body>
</html>