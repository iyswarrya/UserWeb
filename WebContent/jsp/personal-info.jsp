<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<meta charset="UTF-8">
<title>Personal Information</title>
</head>
<body>
<center><h1>Personal Info Page</h1></center>
<form:form method="post" modelAttribute="personalInfo" action="/user-web/processPersonalInfo.do">
<%-- <form action="${pageContext.request.contextPath}/user/personal" method="post"> --%>

        First Name: <input type="text" name="firstName" required><br>
        Last Name: <input type="text" name="lastName" required><br>
        Gender:<br>
		  <input type="radio" name="gender" value="Male" id="male" required>
		  <label for="male">Male</label><br>
		
		  <input type="radio" name="gender" value="Female" id="female">
		  <label for="female">Female</label><br>

        <input type="submit" value="Next">
<%--     </form> --%>
    </form:form>
</body>
</html>