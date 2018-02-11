<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- URL 如果有路径问题，使用s标签URL-->
	"<s:url value='/resource/bootstrap/css/head.css'/>"
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
	 <!-- select -->
	<s:select name="user.sex" list="#{'0':'男','1':'女'}" label="性别" headerKey="" headerValue="请选择性别"></s:select>
	<s:select label="用户" name="user" list="userList" listKey="id" listValue="name" />
	
	<!-- Date -->
	<s:date format="yyyy-MM-dd" name="#dateRef.today"/>  
	<s:date name="#dateRef.today" format="hh:mm:ss" /><!-- 12 -->
	<s:date name="#dateRef.today" format="HH:mm:ss" /><!-- 24 -->
	
	<!-- iterator start -->
	<table border="1" class="sendProTable" width="720px">
		<tr class="tr_header">
   			<td colspan="9" style="vertical-align: center;"><b>&nbsp;</b></td>
  		</tr>
		<tr>
			<td rowSpan="2"  class="td_title"></td>
			<td align="center" rowSpan="2">评估指标</td>
			<td align="center" colSpan='<s:property value="content.evalLineOptInsList.size()"/>'>评估得分</td>
			<td align="center" rowSpan="2">得分小计</td>
		</tr>
		<tr>
			<s:iterator value="content.evalLineOptInsList" var="list3">
				<td>
					<s:property value="#list3.name"/>(<s:property value="#list3.score"/>分)
				</td>
			</s:iterator>
		</tr>
		
		<!-- radioIndex 单选用到的索引 -->
		<s:set var="radioIndex" value="0"></s:set>
				
		<!--evalInsList项目实例    evalLineInsList与项目实例对应的指标实例   evalLineOptInsList得分项实例-->	
		<s:iterator value="content.evalInsList" var="list1" >
			<!-- 项目类型 01选项  02文本 -->
			<s:if test='#list1.projectType=="01"'>
			<s:iterator value="#list1.evalLineInsList" var="list2" status="status2">
				<s:if test="#status2.index==0">
					<tr>
						<td align="right" nowrap class="td_title" rowSpan='<s:property value="#list1.evalLineInsList.size()"/>' >
							<s:property value="#list1.projectName"/></td>
						<td><s:property value="#list2.evalIndexName" /></td>
						<s:iterator value="content.evalLineOptInsList" var="list3">
							<td>
								<input type="radio" name='radio<s:property value="#radioIndex"/>' value='<s:property value="#list3.score"/>' />
								<s:property value="#list3.name"/>
							</td>
						</s:iterator>
						<input type="hidden" name='rId<s:property value="#radioIndex"/>' value='<s:property value="#list2.id"/>' />
						<td>0.0</td>
						<s:set var="radioIndex" value="#radioIndex+1"></s:set>
					</tr>
				</s:if>
				<s:else>
					<tr>
						<td><s:property value="#list2.evalIndexName" /></td>
						<s:iterator value="content.evalLineOptInsList" var="list3">
							<td>
								<input type="radio" name='radio<s:property value="#radioIndex"/>'  value='<s:property value="#list3.score"/>' />
								<s:property value="#list3.name"/>
							</td>
						</s:iterator>
						<input type="hidden" name='rId<s:property value="#radioIndex"/>' value='<s:property value="#list2.id"/>' />
						<td >0.0</td>
						<s:set var="radioIndex" value="#radioIndex+1"></s:set>
					</tr>
				</s:else>			
			</s:iterator>
			</s:if>	
		</s:iterator>
		<!-- textareaIndex 文本用到的索引 -->
		<s:set var="textareaIndex" value="0"></s:set>
		<!-- 项目类型 01选项  02文本 -->
		<s:iterator value="content.evalInsList" var="list1" >
			<s:if test='#list1.projectType=="02"'>
			<s:iterator value="#list1.evalLineInsList" var="list2" status="status2">
				<s:if test="#status2.index==0">
					<tr>
						<td align="right" nowrap class="td_title" rowSpan='<s:property value="#list1.evalLineInsList.size()*2"/>' >
							<s:property value="#list1.projectName"/></td>
						<td colSpan='<s:property value="content.evalLineOptInsList.size()+2"/>'><s:property value="#list2.evalIndexName" /></td>
					</tr>
					<tr>
						<td colSpan='<s:property value="content.evalLineOptInsList.size()+2"/>'>
							<textarea name='textarea<s:property value="#textareaIndex"/>' rows="3" cols="20" class="cssInput" style="height:100px; width:100%; overflow:auto;"></textarea>
							<input type="hidden" name='tId<s:property value="#textareaIndex"/>' value='<s:property value="#list2.id"/>' />
						</td>
						<s:set var="textareaIndex" value="#textareaIndex+1"></s:set>
					</tr>
				</s:if>
				<s:else>
					<tr>
						<td colSpan='<s:property value="content.evalLineOptInsList.size()+2"/>'><s:property value="#list2.evalIndexName" /></td>
					</tr>
					<tr>
						<td colSpan='<s:property value="content.evalLineOptInsList.size()+2"/>'>
							<textarea name='textarea<s:property value="#textareaIndex"/>' rows="3" cols="20" class="cssInput" style="height:100px; width:100%; overflow:auto;"></textarea>
							<input type="hidden" name='tId<s:property value="#textareaIndex"/>' value='<s:property value="#list2.id"/>' />
						</td>
						<s:set var="textareaIndex" value="#textareaIndex+1"></s:set>
					</tr>
				</s:else>			
			</s:iterator>
			</s:if>	
		</s:iterator>				
	</table>
	<!-- iterator end -->
	
	
</body>
</html>