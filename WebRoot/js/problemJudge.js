
var radio_innerHTML = function(obj, class_radio) {
    
    var class_radio1 = document.getElementsByClassName(class_radio);
    document.getElementById("id").innerHTML = i
    document.getElementById("title").innerHTML = obj.title[0].problem
    class_radio1[0].nextElementSibling.innerHTML = obj.title[0].choose_1
    class_radio1[1].nextElementSibling.innerHTML = obj.title[0].choose_2
    class_radio1[2].nextElementSibling.innerHTML = obj.title[0].choose_3
    class_radio1[3].nextElementSibling.innerHTML = obj.title[0].choose_4
    
    questionID++;
    i++;
}
var loding = function(str1,id,class_radio,count){
    var i=1;
    if(id<=count){  //设置总共5题
  var urlorigin=str1+id
  post(urlorigin,class_radio)
   }else{
     var sores = TRUE_COUNT*20   //计算最后总分
     var str = "你的最终成绩为："
        $("#login").click(function(){
    
        $("#result1").text(str+sores)        
    })
   }

}
var judge = function(class_radio) {
    var class_radio1 = document.getElementsByClassName(class_radio);
    for (var i = 0; i < class_radio1.length; i++) {
        var a = ["A", "B", "C", "D"]
        if (class_radio1[i].checked && a[i] == obj.title[0].answer) {
            TRUE_COUNT++;
         document.getElementById("answer").innerHTML ="恭喜你答对了，正确答案是："+ obj.title[0].answer+"<br /><br />"   
        }else if(class_radio1[i].checked && a[i] != obj.title[0].answer){
            document.getElementById("answer").innerHTML ="很遗憾答错了，上一题正确是答案："+ obj.title[0].answer+"<br /><br />"
        }
    }
    loding(str1, questionID, class_radio,count);

}
var post = function(urlorigin, class_radio) {
    $.ajax({
        type : "get",
        url : urlorigin,
        success : function(data) {
            var str = '{"title":' + data + "}"
            obj = eval("(" + str + ")")
            radio_innerHTML(obj, class_radio)

        } 
    })
}