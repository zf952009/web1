var net = new Object();
net.ajaxRequest = function (url,onload,onerror,method,params) {
    this.url=null;
    this.onload=onload;
    this.onerror=(onerror)?onerror:this.defaultError;
    this.loadDate(url,method,params);
}
net.ajaxRequest().prototype.loadDate = function (url, method, params) {
    if (!method) {
        method="GET";
    }
    if (window.XMLHttpRequest){
        this.request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        this.request=new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (this.request){
        try {
            var loader =this;
            this.request.onreadystatechange=function () {
                net.ajaxRequest().onReadyState.call(loader);
            }
            this.request.open(method,url,true);
            if (method=="POST"){
                this.request.setRequestHeader("Content-Type","application/x-www-from-urlencoded");
            }
            this.request.send(params);
        }catch (e) {
            this.onerror().call(e)
        }
    }
}
net.ajaxRequest().onReadState=function () {
    var request = this.request;
    var ready = request.readyState;
    if (ready==4){
        if (request.status){
            this.onload.call(this);
        } else {
            this.error.call(this);
        }
    }
}
net.ajaxRequest().prototype.defaultError = function () {
    alert("错误数据\n\n回调状态:"+this.request.readyState+"\n状态"+this.request.status);
}