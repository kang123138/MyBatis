<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".del").click(function() {
			// 获取员工的姓名
			var name = $(this).parents("tr:eq(0)").children("td:eq(1)").html();
			if (!window.confirm("您确定要删除" + name + "员工吗？")) {
				return false;
			}
			var href = $(this).attr("href");
			$("form:eq(0)").attr("action", href);
			$("form:eq(0)").submit();
			return false;
		});
	});
</script>
</head>
<body>

	${param.a }
	
	<!-- 写表单来执行到删除操作 -->
	<form action="" method="post">
		<input type="hidden" name="_method" value="delete">
	</form>

	<c:choose>
		<c:when test="${empty requestScope.emps }">
			<h1>没有任何员工</h1>
		</c:when>
		<c:otherwise>
			<center>
				<table border="1" cellpadding="10" cellspacing="0"
					style="text-align: center">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>邮箱</th>
						<th>工资</th>
						<th>部门</th>
						<th colspan="2">操作</th>
					</tr>
					<c:forEach items="${requestScope.emps }" var="emp">
						<tr>
							<td>${emp.id }</td>
							<td>${emp.lastName }</td>
							<td>${emp.email }</td>
							<td>${emp.salary }</td>
							<td>${emp.dept.name }</td>
							<td><a
								href="${pageContext.request.contextPath }/updateEmp/${emp.id}">编辑</a></td>
							<td><a class="del"
								href="${pageContext.request.contextPath }/deleteEmp/${emp.id}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</center>
		</c:otherwise>
	</c:choose>
	<center><a href="${pageContext.request.contextPath }/addEmp">添加员工</a></center>
</body>
</html>