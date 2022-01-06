<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<style>
		li {
			font-size: 1.5em;
			text-decoration: none;
		}
	</style>
</head>
<body>
	
	<ul>
		<li><a href="${pageContext.request.contextPath}/hello">/hello</a></li>
		<li><a href="${pageContext.request.contextPath}/form">/form</a></li>
		<li><a href="${pageContext.request.contextPath}/param">/param</a></li>
		<li><a href="${pageContext.request.contextPath}/member/reg">/member/reg</a></li>
		<li><a href="${pageContext.request.contextPath}/order/order">/order/order</a></li>
		<li><a href="${pageContext.request.contextPath}/cookie/make">/cookie/make</a></li>
		<li><a href="${pageContext.request.contextPath}/header/check">/header/check</a></li>
		<li><a href="${pageContext.request.contextPath}/return/test1">/return/test1</a></li>
		<li><a href="${pageContext.request.contextPath}/test">지맹근테스트</a></li>
		<li><a href="${pageContext.request.contextPath}/name/test/0">/names/test/0</a></li>
		<li><a href="${pageContext.request.contextPath}/name/cool/1">/names/cool/1</a></li>
		<li><a href="${pageContext.request.contextPath}/name/hot/2">/names/hot/2</a></li>
		<li><a href="${pageContext.request.contextPath}/mypage/mypage1">/mypage/mypage1</a></li>
		<li><a href="${pageContext.request.contextPath}/mypage/mypage2">/mypage/mypage2</a></li>
		<li><a href="${pageContext.request.contextPath}/mypage/mypage3">/mypage/mypage3</a></li>
		<li><a href="${pageContext.request.contextPath}/mypage/help">/mypage/help</a></li>
		<li><a href="${pageContext.request.contextPath}/error/null">/error/null</a></li>
	</ul>

</body>
</html>