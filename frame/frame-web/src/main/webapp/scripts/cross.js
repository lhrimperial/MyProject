function getData(){
    $.ajax({
        type:'get',
        url : 'http://localhost:8080/cross',
        data:{"data":"data"},
        dataType : 'jsonp',
        jsonpCallback: 'callback',
        success  : function() {
            alert("ok");
        },
        error : function(data) {
            //do something...
        }
    });
}

function callback(data){
    alert(data);
}