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