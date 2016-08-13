
//******************************************************
/**
* 鍒濅娇鍖栫獥鍙ｆ椂锛屾牴鎹埗绐楀彛浼犵殑鍊艰缃獥鍙ｆ爣棰�*/
//******************************************************
function setTopTitle() {
	if (document.homeForm.topTitle.value != "") { 
		top.document.title = document.homeForm.topTitle.value;
	}
}

function showAlert() {
	if (document.homeForm.alertMsg.value != "") {
		alert(document.homeForm.alertMsg.value);
		document.homeForm.alertMsg.value = "";
	}
}

function openNewUrl() {
	if (document.homeForm.newUrl.value != "") {
		openUrl(document.homeForm.newUrl.value);
		document.homeForm.newUrl.value = "";
	}
}

function openUrl(urlStr) {
	window.open(urlStr, 'newWindow',
			   'toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,resizable=yes');
}

function openNewWindow() {
	if (document.homeForm.newWindow.value != "") {
	    var varOption = "toolbar=no,location=no,status=yes,menubar=no,resizable=yes,scrollbars=yes,width=" + screen.availWidth + ",height=" + screen.availHeight + ",left=0,top=0";
	    window.open(document.homeForm.newWindow.value, 'autoOpenWin', varOption);
	    document.homeForm.newWindow.value = "";
	}
}

function showConfirm() {
	if (document.homeForm.confirmMsg.value != "") {
		if (confirm(document.homeForm.confirmMsg.value)) {
    			document.homeForm.submit();
		}
		document.homeForm.confirmMsg.value = "";
	}
}


function writeCookie(str) {
	var expdate = new Date();
	SetCookie("oaDesktop", str, expdate, "/");
}

function SetCookie (nameValue, valueValue) {
	var argv = SetCookie.arguments;
	var argc = SetCookie.arguments.length;
	var expires = (argc > 2) ? argv[2] : null;
	var path = (argc > 3) ? argv[3] : null;
	var domain = (argc > 4) ? argv[4] : null;
	var secure = (argc > 5) ? argv[5] : false;
	document.cookie = nameValue + "=" + escape (valueValue) +
		((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
		((path == null) ? "" : ("; path=" + path)) +
		((domain == null) ? "" : ("; domain=" + domain)) +
		((secure == true) ? "; secure" : "");
}

function printDOC() {
	var hkey_root,hkey_path,hkey_key;
	hkey_root="HKEY_CURRENT_USER";
	hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	try{
	  var RegWsh = new ActiveXObject("WScript.Shell") ;
	  hkey_key="header" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  hkey_key="footer" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  }
	 catch(e){}
	window.print();
}

function privewDOC() {
	var hkey_root,hkey_path,hkey_key;
	hkey_root="HKEY_CURRENT_USER";
	hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	try{
	  var RegWsh = new ActiveXObject("WScript.Shell") ;
	  hkey_key="header" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  hkey_key="footer" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  }
	 catch(e){}
	var obj = document.all.WebBrowser;
	
 	obj.ExecWB(7,1);
 	
}


function getFrameHeight() {
	var obj = document.all("msgFrame");
	if (obj == null || obj.style == undefined) return true;
	var formHeight = document.body.clientHeight;
	obj.style.height = formHeight - 210;
}

window.onresize = getFrameHeight

var hrefBaseValue = null;

//鍘婚櫎涓绘満鍦板潃
function removeLocationAddress(html) {
	var hostAdd = window.location.protocol + "//" + window.location.host;
	var findSite = html.indexOf(hostAdd);
	while(findSite > -1) {
		html = html.substring(0, findSite) + html.substring(findSite + hostAdd.length);
		findSite = html.indexOf(hostAdd);
	}
	return html;
}
// ==============================================




//******************************************************
/**
* 鍒犻櫎/淇敼 鏁版嵁鍓嶇殑妫�煡涓庢彁绀�*/
//******************************************************
function delConfirm( message ){
    if(message == null){
        message = "鎮ㄧ‘瀹氳鍒犻櫎鏈褰曞悧锛�;
    }
    return window.confirm(message);
}

function beforeDelete( linkElement ) {
	if(!checkSelectedData(true)){ // 鍙互閫夋嫨澶氭潯鏁版嵁
		return false;	
	}
	
	// 寰楀埌閫変腑鏁版嵁鐨剉alue鍊硷紝骞舵嫾鎺ユ垚璇锋眰鍙傛暟瀛楃涓诧紝鐒跺悗鏇挎崲鐩稿簲鐨�a>鐨刪ref鍊硷紝鍔犱笂鐩稿簲鐨刬d鍊肩殑璇锋眰鍙傛暟
	generateParamStrAndReplaceHref(linkElement, "id", getSelectedDataValues());
	
	return confirm("纭疄瑕佸垹闄ゆ暟鎹悧锛�);
}
function beforeEdit( linkElement ){
	if(!checkSelectedData(false)){ // 鍙兘閫夋嫨涓�潯鏁版嵁
		return false;	
	}
	
	// 寰楀埌閫変腑鏁版嵁鐨剉alue鍊硷紝骞舵嫾鎺ユ垚璇锋眰鍙傛暟瀛楃涓诧紝鐒跺悗鏇挎崲鐩稿簲鐨�a>鐨刪ref鍊硷紝鍔犱笂鐩稿簲鐨刬d鍊肩殑璇锋眰鍙傛暟
	generateParamStrAndReplaceHref(linkElement, "id", getSelectedDataValues());
	
	return true;
}
var beforeOpSingal = beforeEdit; // 涓�釜鍑芥暟锛屼袱涓悕绉�/* 
* 妫�煡鏄惁閫夋嫨浜嗘暟鎹�* @param bAllowSelectMultiple 甯冨皵鍨嬶紝鎸囧畾鏄惁鍏佽閫変腑澶氭潯鏁版嵁
*/
function checkSelectedData( bAllowSelectMultiple ){
	var count = $("#TableData").find("input[type=checkbox]:checked").size();
	if(count == 0){
		alert("璇烽�鎷╄鎿嶄綔鐨勬暟鎹�);
		return false;	
	}
	if(!bAllowSelectMultiple && count > 1){
		alert("姝ら」鎿嶄綔鍙兘閫夋嫨涓�潯鏁版嵁");
		return false;
	}
	return true;
}
// 杩斿洖閫変腑鐨勬暟鎹殑value鍊兼暟缁�function getSelectedDataValues(){
	var $selectedData = $("#TableData").find("input[type=checkbox]:checked");
	var valueArray = new Array();
	$selectedData.each(function(){
		valueArray.push(this.value);						
	});
	return valueArray;
}
/*
* 鏍规嵁鍙傛暟鍊兼暟缁勶紝鎷兼帴鎴愯姹傚弬鏁板瓧绗︿覆锛屽苟鏇挎崲鐩稿簲link鐨刪ref灞炴�涓烘柊鎷兼帴鐨剈rl銆�* 鎵�娇鐢ㄧ殑鍩哄湴鍧�负linkElement鎸囧畾鐨刪ref灞炴�鍊�* @param linkElement 鐩稿簲鐨�a>鍏冪礌瀵硅薄
* @param paramName 鍙傛暟鍚�* @param paramValueArrya 鍙傛暟鍊兼暟缁�*/
function generateParamStrAndReplaceHref(linkElement, paramName, paramValueArray){ 
	// 鐢熸垚鍙傛暟瀛楃涓�	var paramStr = "";
	for(var i =0; i < paramValueArray.length; i++){
		paramStr += ("&" + paramName + "=" + paramValueArray[i]);
	}
	
	// 濡傛灉url涓病鏈�?'锛屽氨鎶婄涓�釜鍙傛暟鍓嶇殑'&'鏀逛负'?'
	var linkUrl = linkElement.href;
	if(linkUrl.indexOf("?") == -1){ 
		paramStr = paramStr.replace(/^&/, "?");
	}
	
	// 鍐嶄慨鏀瑰垹闄ら摼鎺ョ殑url锛屽姞涓婅繖娈靛弬鏁�	linkElement.href = linkUrl + paramStr;
}

//******************************************************
/**
* 鍏ㄦ嫨/鍏ㄤ笉閫�鎵�湁
*/
//******************************************************
function checkAll( selectedValue ) {
	if( document.all.dataItem == null ){ // 椤甸潰涓病鏈夋暟鎹�		return; 
	}
	var count = document.all.dataItem.length; 
	if(count == null){ // 椤甸潰涓彧鏈変竴涓暟鎹椂锛坉ocument.all.dataItem灏辨槸name="dataItem"鐨勮繖涓猚heckbox瀵硅薄锛屼笉鏄暟缁勶級
		document.all.dataItem.checked = selectedValue;
	}
	else{ // 椤甸潰涓湁澶氫釜鏁版嵁鏃讹紙document.all.dataItem灏辨槸name="dataItem"鐨刢heckbox瀵硅薄鐨勬暟缁勶級
		for (var i = 0; i < count; i++) {
			document.all.dataItem[i].checked = selectedValue;
		}
	}
	
	// 璁╀笂涓嬩袱涓叏閫夋鐨勭姸鎬佷竴鑷�	document.all.selectAll[0].checked = selectedValue;
	document.all.selectAll[1].checked = selectedValue;
}


//******************************************************
/**
* 鍗曞嚮鏁版嵁琛岄�涓苟楂樹寒
* 鍦ㄩ〉闈腑鐨刢heckbox涓璁剧疆onClick="window.event.cancelBubble=true"銆傛槸甯屾湜鍦ㄥ崟鍑讳簡checkbox鍚庯紝涓嶅啀缁х画鍚戜笂瑙﹀彂浜嬩欢锛堝悜涓婁竴灞傚眰鐨勮Е鍙憃nClick浜嬩欢锛夈�鍚﹀垯灏嗚璋冪敤涓嬮潰杩欎釜鏂规硶锛屽氨浼氬彧閫変腑涓�釜鏁版嵁浜嗐�
*/
//******************************************************
var $lastCheckedTr = null;
var lastCheckedTrClassName;
function content_onclick( oTr ) {
    if(true){
        return; 
    }

    // 鍙栨秷鎵�湁宸查�涓殑checkbox锛堟暟鎹」鍜屽叏閫夋锛�	$("input[name=selectAll]").attr("checked", false);
	$("input[name=dataItem]").attr("checked", false);
	
	// 杩樺師涓婃閫変腑鐨刢heckbox琛岀殑class
	if($lastCheckedTr != null){ 
		$lastCheckedTr.attr("class", lastCheckedTrClassName);
	}
	// 鍐嶈褰曡繖娆￠�涓鐨勪俊鎭紙浠ュ涓嬫杩樺師鐢級
	$lastCheckedTr = $(oTr);
	lastCheckedTrClassName = $lastCheckedTr.attr("class");
	
	// 鍐嶉�涓綋鍓峜heckbox
    var $cb = $(oTr).find("input[type=checkbox]");
	$cb.attr("checked", true);
	
	// 鏀瑰彉褰撳墠閫変腑琛岀殑鏍峰紡锛堥珮浜級
	$lastCheckedTr.attr("class", "selectLine");
}



//******************************************************
/**
* 杈撳叆妗嗗唴鐨勬彁绀烘枃瀛楁樉绀轰笌璁剧疆
* 娉細浠ｇ爜$(inputElement).attr("showText")澶勶紝娌℃湁浣跨敤inputElement.showText銆傚洜涓哄悗鑰呭湪firefox涓嬩笉鑳借繍琛岋紝鎵�互閲囩敤jQuery妗嗘灦澶勭悊銆�*/
//******************************************************
function inputAreaClick(inputElement, showText) {
	if(showText == null){
		showText = $(inputElement).attr("showText");
	}
	if (inputElement.value == showText) {
		inputElement.value = "";
	}
	inputElement.select;
}

function inputAreaBlur(inputElement, showText) {
	if (inputElement.value == "") {
		if(showText == null){
			showText = $(inputElement).attr("showText");	
		}
		inputElement.value = showText;
	}
}

//******************************************************
/**
* 椤甸潰鍔犺浇瀹屾垚鍚庤鎵ц鐨勬搷浣�*/
//******************************************************
$(function(){
	
	// 璁╀富绐楀彛鐨則itle涓庡綋鍓嶆搷浣滅殑锛堝彸渚х殑锛夌獥鍙ｇ殑title涓�嚧
	parent.document.title = "Itcast OA - " + document.title;
	
//	// 鍦ㄦ枃鏈涓樉绀烘彁绀鸿锛屾彁绀鸿鐢�showText 灞炴�鎸囧畾
//	$("input[type=text][showText]").each(function(){
//		this.value = $(this).attr("showText");
//	});

	// 璁剧疆鎵�湁鐨勬枃鏈鍦ㄩ�涓椂锛岄�涓枃鏈涓殑鏂囨湰
	$("input[type=text]").each(function(){;
		// this.onFocus = function() { this.select(); }; // 鐢ㄨ繖琛屼唬鐮佷笉璧蜂綔鐢�?
		$(this).focus(function(){ // 鏀圭敤jQuery瀹炵幇
			this.select();
		});
	});

	// 
});


/***********************************************************************************
 *** 鍦ㄦā鎬佺獥鍙ｄ腑浣跨敤<base target="_self">锛屼笉鐒剁偣鍑昏秴閾炬帴浼氭墦寮�竴涓柊鐨処E绐楀彛銆� *** 鍦ㄦā鎬佺獥鍙ｄ腑浣跨敤window.dialogArguments鏉ヨ幏鍙栦紶閫掔殑鍙傛暟銆� ***********************************************************************************/

/**
 * 鎵撳紑鏄剧ずHTML鐨勬ā鎬佸璇濇銆傝鎵撳紑鍚庡氨浼氬缁堜繚鎸佽緭鍏ョ劍鐐广�闄ら潪瀵硅瘽妗嗚鍏抽棴锛屽惁鍒欑敤鎴锋棤娉曞垏鎹㈠埌涓荤獥鍙ｃ�
 * @param url
 */
function myShowModalDialog(url, width, height) {
    var arguments = window;

    if (!width) width = 350;
    if (!height) height = 350;
    var left = (screen.width - width) / 2;
    var top = (screen.height - height) / 2;
    var features = "" //
        // + "dialogLeft:" + left + ";"//           宸﹁竟璺�        // + "dialogTop:" + top + ";"//             涓婅繛璺�            + "dialogWidth:" + width + "px;"//   瀹藉害
            + "dialogHeight:" + height + "px;"// 楂樺害
            + "center: yes;"//                    鏄惁灞呬腑
            + "resizable: yes;"//                鏄惁鍙互鏀瑰彉澶у皬
            + "scroll: yes;"//                    褰撳唴瀹硅秴杩囩獥鍙ｅぇ灏忔椂鏄惁鏄剧ず婊氬姩鏉�            + "status: yes;"//                    鏄惁鏄剧ず鐘舵�鏍�
    window.showModalDialog(url, arguments, features);
}
/**
 * 鎵撳紑鏄剧ずHTML鐨勯潪妯℃�瀵硅瘽妗嗐�琚墦寮�悗锛岀敤鎴峰彲浠ラ殢鏈哄垏鎹㈣緭鍏ョ劍鐐广�
 * @param url
 */
function myShowModelessDialog(url, width, height) {
    var arguments = window;

    if (!width) width = 350;
    if (!height) height = 350;
    var left = (screen.width - width) / 2;
    var top = (screen.height - height) / 2;
    var features = "" //
        // + "dialogLeft:" + left + ";"//           宸﹁竟璺�        // + "dialogTop:" + top + ";"//             涓婅繛璺�            + "dialogWidth:" + width + "px;"//   瀹藉害
            + "dialogHeight:" + height + "px;"// 楂樺害
            + "center: yes;"//                    鏄惁灞呬腑
            + "resizable: yes;"//                鏄惁鍙互鏀瑰彉澶у皬
            + "scroll: yes;"//                    褰撳唴瀹硅秴杩囩獥鍙ｅぇ灏忔椂鏄惁鏄剧ず婊氬姩鏉�            + "status: yes;"//                    鏄惁鏄剧ず鐘舵�鏍�
    window.showModelessDialog(url, arguments, features);
}

/**
 * 鎵撳紑鏂扮獥鍙ｏ紝濡傛灉鎸囧畾浜嗗ぇ灏忥紝鍒欑獥鍙ｆ樉绀哄湪灞忓箷鐨勪腑澶� *
 * url        String  琚姞杞界殑HTML鏂囨。鐨�URL 鍦板潃
 * name       String  鎵撳紑鐨勭獥鍙ｇ殑鍚嶅瓧
 * width      Number  绐楀彛鐨勫搴� * height     Number  绐楀彛鐨勯珮搴� * scrollbars Boolean 鏄惁鏈夋粴鍔ㄦ潯
 */
function myOpenWindow(url, width, height, name, scrollbars) {
    var left = (screen.width - width) / 2;
    var top = (screen.height - height) / 2;

    var features = "left=" + left
            + ",top=" + top
            + ",width=" + width
            + ",height=" + height
            + ",scrollbars=" + (scrollbars ? "yes" : "no")
            + ",center=yes"
            + ",resizable=yes"
            + ",status=yes";
    var openwin = window.open(url, name, features);
    openwin.focus();
    return openwin;
}
