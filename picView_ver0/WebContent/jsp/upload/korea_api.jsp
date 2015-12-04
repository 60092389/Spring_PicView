<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<form name="korea_api" method="post" action="korea_api" > 
		<input type="text" class="search" name="search">
		<input type="submit" class="button"  value="검색">
		
		<table>
		<c:forEach var="list" items="${final_list}">
			<tr>
			<td>주소1 : ${list.addr1}</td>
			<td>주소2 : ${list.addr2}</td>
			<td>contentid : ${list.contentid}</td>
			<td>contenttypeid : ${list.contenttypeid}</td>
			<td>이미지: ${list.firstimage}</td>
			<td>제목 : ${list.title}</td>

			</tr>
		</c:forEach>
		</table>

</form>

 </body>
 
 </html>