/**
 * 
 */
function myWindowOpen() {
	var height = window.screen.availHeight / 2;
	var width = window.screen.availWidth / 3;
	var url = contextPath + "/portal/user/LineUserList.action";
    //获得窗口的垂直位置 
    var top = (window.screen.availHeight - 30 - height) / 2; 
    //获得窗口的水平位置 
    var left = (window.screen.availWidth - 10 - width) / 2; 
	var mywindow = window.open(url,'', "top=" + top + ",left=" + left + ",width="
					+ width + ",height=" + height
					+ ",menubar=no,scrollbars=no,toolbar=no,status=no,location=no");
}

/**************************************时间格式化处理************************************/
function dateFtt(fmt,date)   
{ //author: meizz   
  var o = {   
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
} 

//去所有空格   
String.prototype.trimAll = function() {
	return this.replace(/(^\s*)|(\s*)|(\s*$)/g, "");
};