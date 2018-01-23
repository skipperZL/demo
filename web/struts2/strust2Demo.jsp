<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- select -->
		<!-- 
	（1）list：创建列表的可迭代数据源， 必设项（list必须有值，如果没值则必须设置headerKey, headerValue）。
		如果该列表是一个Map(key, value), 那么Map的主键将作为选项(<option>)的"value"属性, 
		而该主键对应的值作为选项的文本内容.是必须设置的选项，如果是一个List或者是一个Set，
		那么可以通过listKey和listValue指定。
	（2）headerKey：设置列表的题头主键值. 一定不能为空值! "'-1'"或"''"是正确的取值， ""是错误的取值。
	（3）headerValue：列表的题头选项值。
	（4）listKey：列表数据源中元素对象的属性, 用于获取选项的值，对应于select标签中的value。
	（5）listValue：表数据源中元素对象的属性, 用于获取选项的文本内容，对应于select标签中的option。
	（6）name：元素的名字
	 -->
	<s:select name="user.sex" list="#{'0':'男','1':'女'}" label="性别" headerKey="" headerValue="请选择性别"></s:select>
	<s:select label="用户" name="user" list="userList" listKey="id" listValue="name" />
	

</body>
</html>