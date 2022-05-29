 /* 主函数：控制主题内容的变化 */
 function showpage(page){
     for( var i=0;i<=32;i++){
         if(page==i)document.getElementById("div"+i).style.display="block";
         else document.getElementById("div"+i).style.display="none";

     }

}
/* 最简单的方法：每一行都取一个值，判断当前状态  */

/* 控制注册的小点内容的显示与隐藏 */
function showRe(){

  var Re=document.getElementById("GN1.1").style.display;
  if(Re=='none'){
    document.getElementById("GN1.1").style.display="block";
    document.getElementById("GN1.2").style.display="block";
    document.getElementById("GN1.3").style.display="block";
    document.getElementById("NULL1").style.display="none";
    document.getElementById("NULL2").style.display="none";
    document.getElementById("NULL3").style.display="none";

  }
  else {
    document.getElementById("GN1.1").style.display="none";
    document.getElementById("GN1.2").style.display="none";
    document.getElementById("GN1.3").style.display="none";
    document.getElementById("NULL1").style.display="block";
    document.getElementById("NULL2").style.display="block";
    document.getElementById("NULL3").style.display="block";
  }
}
/* 控制登陆的小点内容的显示与隐藏 */
function showLo(){
  var Lo=document.getElementById("GN2.1").style.display;
  if(Lo=='none'){
    document.getElementById("GN2.1").style.display="block";
    document.getElementById("GN2.2").style.display="block";
    document.getElementById("GN2.3").style.display="block";
    document.getElementById("NULL1").style.display="none";
    document.getElementById("NULL2").style.display="none";
    document.getElementById("NULL3").style.display="none";
  }
  else {
    document.getElementById("GN2.1").style.display="none";
    document.getElementById("GN2.2").style.display="none";
    document.getElementById("GN2.3").style.display="none";
    document.getElementById("NULL1").style.display="block";
    document.getElementById("NULL2").style.display="block";
    document.getElementById("NULL3").style.display="block";
  }

}
/* 控制用户的小点内容的显示与隐藏 */
function showUser(){
  var User=document.getElementById("GN3.1").style.display;
  if(User=='none'){
    document.getElementById("GN3.1").style.display="block";
    document.getElementById("GN3.2").style.display="block";
    document.getElementById("GN3.3").style.display="block";
    document.getElementById("GN3.4").style.display="block";
    document.getElementById("GN3.5").style.display="block";
    document.getElementById("GN3.6").style.display="block";
    document.getElementById("NULL1").style.display="none";
    document.getElementById("NULL2").style.display="none";
    document.getElementById("NULL3").style.display="none";
    document.getElementById("NULL4").style.display="none";
    document.getElementById("NULL5").style.display="none";
    document.getElementById("NULL6").style.display="none";
  }else{
    document.getElementById("GN3.1").style.display="none";
    document.getElementById("GN3.2").style.display="none";
    document.getElementById("GN3.3").style.display="none";
    document.getElementById("GN3.4").style.display="none";
    document.getElementById("GN3.5").style.display="none";
    document.getElementById("GN3.6").style.display="none";
    document.getElementById("NULL1").style.display="block";
    document.getElementById("NULL2").style.display="block";
    document.getElementById("NULL3").style.display="block";
    document.getElementById("NULL4").style.display="block";
    document.getElementById("NULL5").style.display="block";
    document.getElementById("NULL6").style.display="block";
  }
}
/* 控制工人的小点内容的显示与隐藏 */
function showWorker(){
  var Worker=document.getElementById("GN4.1").style.display;
  if(Worker=='none'){
    document.getElementById("GN4.1").style.display="block";
    document.getElementById("GN4.2").style.display="block";
    document.getElementById("GN4.3").style.display="block";
    document.getElementById("GN4.4").style.display="block";
    document.getElementById("GN4.5").style.display="block";
    document.getElementById("NULL1").style.display="none";
    document.getElementById("NULL2").style.display="none";
    document.getElementById("NULL3").style.display="none";
    document.getElementById("NULL4").style.display="none";
    document.getElementById("NULL5").style.display="none";
  }else{
    document.getElementById("GN4.1").style.display="none";
    document.getElementById("GN4.2").style.display="none";
    document.getElementById("GN4.3").style.display="none";
    document.getElementById("GN4.4").style.display="none";
    document.getElementById("GN4.5").style.display="none";
    document.getElementById("NULL1").style.display="block";
    document.getElementById("NULL2").style.display="block";
    document.getElementById("NULL3").style.display="block";
    document.getElementById("NULL4").style.display="block";
    document.getElementById("NULL5").style.display="block";
  }

}
/* 控制管理员的小点内容的显示与隐藏 */
function showAdmin(){
    /* 在内部取值判断 */
  var Admin=document.getElementById("GN5.1").style.display;
  var list=document.getElementById("GN5.1.1").style.display;
  var user=document.getElementById("GN5.2.1").style.display;
  if(Admin=='none'){
    document.getElementById("GN5.1").style.display="block";
    document.getElementById("GN5.2").style.display="block";
    document.getElementById("GN5.3").style.display="block";
    document.getElementById("GN5.4").style.display="block";
    document.getElementById("GN5.5").style.display="block";
    document.getElementById("NULL1").style.display="none";
    document.getElementById("NULL2").style.display="none";
    document.getElementById("NULL3").style.display="none";
    document.getElementById("NULL4").style.display="none";
    document.getElementById("NULL5").style.display="none";
  }else{
    document.getElementById("GN5.1").style.display="none";
    document.getElementById("GN5.2").style.display="none";
    document.getElementById("GN5.3").style.display="none";
    document.getElementById("GN5.4").style.display="none";
    document.getElementById("GN5.5").style.display="none";
    document.getElementById("NULL1").style.display="block";
    document.getElementById("NULL2").style.display="block";
    document.getElementById("NULL3").style.display="block";
    document.getElementById("NULL4").style.display="block";
    document.getElementById("NULL5").style.display="block";
  }
}
/* 控制管理员的小点内容的显示与隐藏 */
/* 这里还有管理员内部小功能的分支 */
 function Adminshowlist(){
    var list=document.getElementById("GN5.1.1").style.display;
    if(list=='none'){
        document.getElementById("GN5.1.1").style.display="block";
        document.getElementById("GN5.1.2").style.display="block";
        document.getElementById("GN5.1.3").style.display="block";
        document.getElementById("NULL6").style.display="none";
        document.getElementById("NULL7").style.display="none";
        document.getElementById("NULL8").style.display="none";
    }
    else{
        document.getElementById("GN5.1.1").style.display="none";
        document.getElementById("GN5.1.2").style.display="none";
        document.getElementById("GN5.1.3").style.display="none";
        document.getElementById("NULL6").style.display="block";
        document.getElementById("NULL7").style.display="block";
        document.getElementById("NULL8").style.display="block";
    } 
}
 function Adminshowuser(){
    var user=document.getElementById("GN5.2.1").style.display;
    if(user=='none'){
        document.getElementById("GN5.2.1").style.display="block";
        document.getElementById("GN5.2.2").style.display="block";
        document.getElementById("GN5.2.3").style.display="block";
        document.getElementById("GN5.2.4").style.display="block";
        document.getElementById("NULL6").style.display="none";
        document.getElementById("NULL7").style.display="none";
        document.getElementById("NULL8").style.display="none";
        document.getElementById("NULL9").style.display="none";
    }
    else{
        document.getElementById("GN5.2.1").style.display="none";
        document.getElementById("GN5.2.2").style.display="none";
        document.getElementById("GN5.2.3").style.display="none";
        document.getElementById("GN5.2.4").style.display="none";
        document.getElementById("NULL6").style.display="block";
        document.getElementById("NULL7").style.display="block";
        document.getElementById("NULL8").style.display="block";
        document.getElementById("NULL9").style.display="block";
    }
     
}


/* 控制其他的小点内容的显示与隐藏 */
function showOther(){
  var Other=document.getElementById("GN6.1").style.display;
  if(Other=='none'){
    document.getElementById("GN6.1").style.display="block";
    document.getElementById("GN6.2").style.display="block";
    document.getElementById("GN6.3").style.display="block";
    document.getElementById("GN6.4").style.display="block";
    document.getElementById("GN6.5").style.display="block";
    document.getElementById("NULL1").style.display="none";
    document.getElementById("NULL2").style.display="none";
    document.getElementById("NULL3").style.display="none";
    document.getElementById("NULL4").style.display="none";
    document.getElementById("NULL5").style.display="none";
  }else{
    document.getElementById("GN6.1").style.display="none";
    document.getElementById("GN6.2").style.display="none";
    document.getElementById("GN6.3").style.display="none";
    document.getElementById("GN6.4").style.display="none";
    document.getElementById("GN6.5").style.display="none";
    document.getElementById("NULL1").style.display="block";
    document.getElementById("NULL2").style.display="block";
    document.getElementById("NULL3").style.display="block";
    document.getElementById("NULL4").style.display="block";
    document.getElementById("NULL5").style.display="block";
  }
}

