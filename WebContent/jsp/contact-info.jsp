<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Contact Information</title>
</head>
<body>
<center><h1>Contact Info Page</h1></center>
<form:form method="post" modelAttribute="contactInfo" action="/user-web/processContactInfo.do">
<%--  <form action="${pageContext.request.contextPath}/user/contact" method="post"> --%>
        Address: <input type="text" name="address" required><br>
        City: <input type="text" name="city" required><br>
        State: <input type="text" name="state" required><br>
        Country: <input type="text" name="country" required><br>
        Phone: <input type="text" name="phone" required><br>
        <input type="submit" value="Next">
<%--     </form> --%>
    </form:form>
</body>
</html>