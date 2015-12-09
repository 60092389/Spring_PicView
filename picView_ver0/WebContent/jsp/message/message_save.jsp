<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지 보관함</title>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/picView_custom.css" rel="stylesheet">
<link href="css/message.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<jsp:include page="../layout/header.jsp"></jsp:include>
	</div>

	<div class="contents">
		<input type="button" id="message_write" class="btn btn-success"
			value="쪽지쓰기">
		<!-- 메뉴 -->
		<div id="side_menu">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="#">받은 쪽지함</a></li>
				<li><a href="#">보낸 쪽지함</a></li>
				<li class="active"><a href="#">쪽지 보관함</a></li>
			</ul>
		</div>
		<!-- 검색창 -->
		<div id="search">
			<select>
				<option>전체쪽지</option>
				<option>받은쪽지</option>
				<option>보낸쪽지</option>
				<option>보관쪽지</option>
			</select> <select>
				<option>아이디</option>
				<option>이름</option>
				<option>내용</option>
			</select> <input type="text" id="search_input" class="form-control" placeholder="쪽지검색"/> <a href=""><span id="search_icon"
				class="glyphicon glyphicon-search"></span></a>
		</div>

		<!-- 버튼 그룹 -->
		<div id="btn_group">
			<input id="remove" type="button" value="삭제" /> <input id="save"
				type="button" value="보관" /> <input id="send" type="button"
				value="답장" />
		</div>
		<!-- 쪽지 테이블 -->
		<div id="message_table">
			<table cellpadding="0" cellspacing="0" id="message"
				class="table table-bordered table-hover table-condensed">
				<colgroup>
					<col width="50">
					<col width="130">
					<col width="*">
					<col width="150">
				</colgroup>
				<thead>
					<tr>
						<th><input id="all_check" type="checkbox" /></th>
						<th>보낸사람</th>
						<th>내용</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${save_list }">
						<tr>
							<td><input type="checkbox" value="${list.msg_no }"
								class="check" name="check" /><input type="hidden"
								value="${list.msg_sender }" class="sender" name="sender" />
								<input type="hidden" value="123" name="test"/></td>
							<td>${list.msg_sender}</td>
							<td><a
								href="<c:url value="/jsp/message/message_detail/${list.msg_no }"/>">
									${list.msg_content}</a></td>
							<td><fmt:formatDate value="${list.msg_wri_date }"
									pattern="yyyy-MM-dd [HH:mm:ss]" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>