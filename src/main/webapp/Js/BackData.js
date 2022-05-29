
/*返回自系统开始使用时各个楼的报修数据*/
function backfloor() {
    var floornums=[];
    $.ajax({
        url:'../admin/backnums',
        type:'get',
        dataType:'json',
        async:false,
        success:function (data){

            floornums=data;

        }
    })
    return floornums;

}
/*返回自系统开始使用时 产生的各个设备的维修数据*/
function backequip() {
    var equipdata=[];
    $.ajax({
        url:'../admin/backequipnums',
        type:'get',
        dataType: 'json',
        async: false,
        success:function(data){
            equipdata=data;
        }
    })
    return equipdata;

}
/*返回维修支出数据*/
function equip_expend(){
    var expend=[];
    $.ajax({
        url:'../admin/backexpend',
        type:'get',
        dataType:'json',
        async:false,
        success:function (data) {
            expend=data;
        }
    })
    return expend;
}

/*返回维修师傅的评分数据*/
function workerrank() {
    var workerrank=[];
    $.ajax({
        url:'../admin/workerrank',
        type:'get',
        dataType:'json',
        async:false,
        success:function (data) {
            workerrank=data;

        }
    })
    return workerrank;
}


/*返回用户报修单数的数据排行*/
function usernum(){
    var usernum=[];
    $.ajax({
        url:'../public/user_num',
        type:'get',
        dataType:'json',
        async:false,
        success:function (data) {
            usernum=data;
        }
    })
    return usernum;
}

/*返回师傅的维修单数和平均时间*/
function worker_num(){
    var worker_num=[];
    $.ajax({
        url:'../public/w_num',
        dataType:'json',
        async:false,
        type:'get',
        success:function (data) {
            worker_num=data;
        }

    })
    return worker_num;
}
/*返回普通用户信息*/
function getuser(){
    var user=null;
    $.ajax({
        url:'../login/finduser',
        type:'get',
        dataType:'json',
        async:false,
        success:function (user1) {
            user=user1;
        }
    })

    return user;

}
/*返回维修师傅账号*/
function getworker(){
    var worker=null;
    $.ajax({
        url:'../login/findworker',
        type:'get',
        dataType:'json',
        async:false,
        success:function (worker1) {
            worker=worker1;
        }
    })
    return worker;
}


/*返回设备每月存活时间*/
function getequip_live(){
    var equip_live=null;
    $.ajax({
        url:'../public/equip_live',
        type:'get',
        dataType:'json',
        async:false,
        success:function (data) {
            equip_live=data;
        }
    })
    return equip_live;
}