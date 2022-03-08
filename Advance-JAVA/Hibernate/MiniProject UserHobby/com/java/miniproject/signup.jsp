<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor=" sky blue">
        <fieldset>
       <legend><b>Personal Information</b></legend>
      <form action="AdduserServlet" method="post">
              <label>FIRST NAME:</label><input type="text" name="firstName"><br>
              <br>
              <label>LAST NAME:</label><input type="text" name="lastName"><br>
              <br>
                <label>Email:</label><input type="email" name="email"><br>
              <br>
               <label>Mobile NUMBER:</label><input type="number" name="moNumber"><br>
              <br>
               <label>User Name:</label><input type="text" name="userName"><br>
              <br>      
             <label>PASSWORD:</label><input type="password" name="pwd"><br>
              <br>
               <input type="submit" value="SUBMIT">
               <input type="reset" value="RESET">
      </form>  
    </fieldset>
</body>
</html>