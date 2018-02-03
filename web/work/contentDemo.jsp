<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ include file="/common/common.jsp"%>

<html>
<head>
<title>会议通知管理</title>
<%@include file="/common/head.jsp" %><!-- 里面有showDateDIV等-->
<%@include file="/script/document/common.jsp"%> 
<script src='<s:url value="/script/dialog/dialog.js"/>'></script>
<script type="text/javascript">
	function checkStringAsDefault() {
		var rtn = true;
		return rtn;
	}

</script>
<style type="text/css">
td{
	line-height:100%;
}
</style>
</head>
<body class="rightMainBody front-scroll-hidden" style="padding: 0; margin: 0;">
<div id="container" class="front-scroll-hidden" style="width: 100%;">
<s:form	id="formItem" name="formItem" action="save" method="post"
	validate="true" theme="simple" enctype="multipart/form-data">
<%@include file="/common/content_btns.jsp"%>
<div id="contentTable"
		class="sendMainTable level front-scroll-auto"	style="border-right: 0px; border-left: 0px; height: 600px; width: 100%;margin: 0;padding: 0;">
	<%@include file="/common/msg.jsp"%>
	<%@include file="/common/page.jsp"%>
	<div class="inner">
     <h4><span><s:property value="ptitle"/></span></h4>
		
	<table border="1" class="sendProTable" width="850px">
	
	<!-- 单行输入 -->
		<tr>
			<td class="commFont1"><font color='red'>*</font>标题</td>
			<td colspan="3">
			<s:textfield cssClass="input-cmd" theme="simple" name="content.title" id="content.title" size="95"/>
			</td>
		</tr>
	<!-- textarea -->
		<tr>
			<td class="commFont1"><font color='red'>*</font>会议内容</td>
			<td colspan="3"> 
				<textarea id="simpleContent" name="content.content" rows="4"  style="border:0; width:100%;">${content.content}</textarea>
			</td>
		</tr>
	<!-- Date -->
		<tr>
			<td class="commFont1"><font color='red'>*</font>召开日期</td>
			<td>
				<input class="Wdate inputNoBorder" style="width: 100%;" name="content.starttime" id="starttime" value="${content.starttime }"  onfocus="showDateTimeDIV();"/>
			</td>
			<td class="commFont1">通知人</td>
			<td>
				${content.draf_author}
			</td>
		</tr>

	</table>
	</div>
	</div>
</s:form></div>
</body>
<script>
//已选择的resource;
var checkedList = new Array();

jQuery(document).ready(function() {
	jQuery("#btnSave").attr("disabled", false);
	showRadio();
	adjustDocumentLayout();
});

window.onresize=function(){
	adjustDocumentLayout();
};

// 显示默认radio
function showRadio() {
}
</script>
</html> 