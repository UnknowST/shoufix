<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <html>

      <head>
        <title>Title</title>
        <%--正在维修的维修单--%>
          <script src="${pageContext.request.contextPath}/Js/jquery-3.3.1.js"></script>
          <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/weui.css" />
          <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/weuix.css" />
          <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
          <script src="${pageContext.request.contextPath}/Js/zepto.min.js"></script>
          <script src="${pageContext.request.contextPath}/Js/zepto.weui.js"></script>
<style>
            .bntup {
              font-family: "Montserrat", sans-serif;
              font-size: 14px;
              font-weight: 600;
              letter-spacing: 1px;
              display: inline-block;
              padding: 10px 32px;
              border-radius: 50px;
              transition: 0.5s;
              margin: 0 20px 20px 0;
              background-color: #4a8bfe;
              color: aliceblue;
              text-decoration: none;
            }

            .bntdown {
              font-family: "Montserrat", sans-serif;
              font-size: 14px;
              font-weight: 600;
              letter-spacing: 1px;
              display: inline-block;
              padding: 10px 32px;
              border-radius: 50px;
              transition: 0.5s;
              margin: 0 20px 20px 0;
              border: #4a8bfe 2px solid;
              color: #4a8bfe;
              text-decoration: none;
            }
            table{
              padding:0;
              margin:0;
              border:none;
            }
            table td{
              border:none;
            }
          </style>
      </head>

      <body>
        <!--修改--><br>
        <div id="div2" align="center" style="height:130px;">
          <center>
            <h1>全部维修单列表</h1>
          </center>
          <a class="bntup"
            href="${pageContext.request.contextPath}/worker/infor_ing?workerid=${workerid}&p=1">正在维修</a>&nbsp;&nbsp;&nbsp;
          <a class="bntdown"
            href="${pageContext.request.contextPath}/worker/infor_ok?workerid=${workerid}&p=1">完成维修</a>&nbsp;&nbsp;&nbsp;
        </div>
        <%--全部维修单--%>

          <div align="center" id="div1">
            <c:if test="${message.flag==0}">
              <p>${message.message}</p>
            </c:if>
            <c:if test="${message.flag==1}">
              <table>
                <tbody >
                  <tr style="background-color:#556270;height:50px;">
                    <th>序号</th>
                    <th>地点</th>
                    <th>设备</th>
                    <th>故障类型</th>
                    <th>详细信息</th>
                    <th>图片说明</th>
                    <th>接单时间</th>
                    <th>操作</th>
                  </tr>
                  <% int i=0;int count=1;%>
                    <c:forEach items="${page.list }" var="infor">
                      <%if(count%2==0){%>
                        <tr style="background-color:aliceblue">
                          <td>${i=i+1}</td>
                          <td>${infor.floor },${infor.layer},${infor.reason}</td>
                          <td>${infor.equip }</td>
                          <td>${infor.reason}</td>
                          <td>${infor.detail }</td>

                          <c:if test="${infor.imagepaths.size()==0}">
                            <td>该用户没有上传图片说明...</td>
                          </c:if>
                          <c:if test="${infor.imagepaths.size()!=0}">
                            <td><img src="${infor.imagepaths.get(0) }" width="100px" height="120px"
                                alt="诶呀！图片不小心走丢了..."></td>
                          </c:if>

                          <td>
                            <fmt:formatDate type="both" dateStyle="long" timeStyle="long"
                              value="${infor.distribute_time}" />
                          </td>
                          <td><a href="javascript:void(0)"
                              onclick="successinfor('${infor.num}')">完成维修</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          </td>
                        </tr>
                        <%}%>
                          <%if(count%2==1){%>
                            <tr style="background-color:snow">
                              <td>${i=i+1}</td>
                              <td>${infor.floor },${infor.layer},${infor.reason}</td>
                              <td>${infor.equip }</td>
                              <td>${infor.reason}</td>
                              <td>${infor.detail }</td>

                              <c:if test="${infor.imagepaths.size()==0}">
                                <td>该用户没有上传图片说明...</td>
                              </c:if>
                              <c:if test="${infor.imagepaths.size()!=0}">
                                <td><img src="${infor.imagepaths.get(0) }" width="100px" height="120px"
                                    alt="诶呀！图片不小心走丢了..."></td>
                              </c:if>

                              <td>
                                <fmt:formatDate type="both" dateStyle="long" timeStyle="long"
                                  value="${infor.distribute_time}" />
                              </td>
                              <td><a href="javascript:void(0)"
                                  onclick="successinfor('${infor.num}')">完成维修</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              </td>
                            </tr>
                            <%}%>
                              <%count++;%>
                    </c:forEach>
                </tbody>
              </table>

              <p>一共${page.pages}页;当前为${page.pageNum}页;每页${page.pageSize}条数据</p>

              <a
                href="${pageContext.request.contextPath}/worker/infor_ing?workerid=${workerid}&p=${page.firstPage}">第一页</a>
              <c:if test="${page.nextPage==0}">
                <a href="javascript:void(0)">下一页</a>
              </c:if>
              <c:if test="${page.nextPage!=0}">
                <a
                  href="${pageContext.request.contextPath}/worker/infor_ing?userid=${page.list[0].userid}&p=${page.nextPage}">下一页</a>
              </c:if>
              <c:if test="${page.prePage==0}">
                <a href="javascript:void(0)">上一页</a>
              </c:if>
              <c:if test="${page.prePage!=0}">
                <a
                  href="${pageContext.request.contextPath}/worker/infor_ing?userid=${page.list[0].userid}&p=${page.prePage}">上一页</a>
              </c:if>
              <a
                href="${pageContext.request.contextPath}/worker/infor_ing?userid=${workerid}&p=${page.lastPage}">最后页</a>
            </c:if>
          </div>


          <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/popup.css" />
          <!--//引入css-->




          <script>
            $(function () {
              //获取装备表的数据
              $.ajax({
                url: '${pageContext.request.contextPath}/worker/equipmentlist',
                type: 'get',
                dataType: 'json',
                async: false,
                success: function (list) {
                  kai = '<select id="eid"><option value="-1">--请选择使用的设备编号--</optin>' +
                    '<option value="0">没有使用设备</option>'
                  var zh = " "
                  var wei = '</select>'
                  for (var i = 0; i < list.length; i++) {
                    zh += '<option value="' + list[i].eid + '">' + list[i].eid + '</option>'
                  }
                  $("#td1").html(kai + zh + wei);
                }
              })
            })

            function close1() {
              document.getElementById('all_light').style.display = 'none';
              document.getElementById('contes').style.display = 'none';
            }

            function successinfor(num) {
              $.modal({
                title: "您好！",
                text: "是否使用设备",
                buttons: [
                  {
                    text: "是", onClick: function () {
                      document.getElementById('all_light').style.display = 'block';
                      document.getElementById('contes').style.display = 'block';
                    }
                  },
                  {
                    text: "否", onClick: function () {
                      $.ajax({
                        //
                        url: '${pageContext.request.contextPath}/worker/success_infor',
                        data: {
                          num: num, state: "维修成功", eid: 0,
                          numbers: 0, detail: " "
                        },
                        dataType: 'json',
                        async: false,
                        success: function (message) {
                          if (message.flag == 1) {
                            alert("确认成功！");
                            window.history.go(0);
                          } else {
                            alert(message.message);
                          }
                        }

                      })
                    }
                  },
                  { text: "取消", className: "default", onClick: function () { console.log(3) } },
                ]
              });






              $("#btn1").click(function () {
                $.ajax({
                  //
                  url: '${pageContext.request.contextPath}/worker/success_infor',
                  data: {
                    num: num, state: $("#state option:selected").text(), eid: $("#eid option:selected").val(),
                    numbers: $("#numbers").val(), detail: $("#detail").val()
                  },
                  dataType: 'json',
                  async: false,
                  success: function (message) {
                    if (message.flag == 1) {
                      alert(message.message);
                      window.history.go(0);
                    } else {
                      alert(message.message);
                    }
                  }

                })
              })
            }

          </script>
          <div4 id="contes" style="display: none">

            <div5 style="width:500px;height:40px;">

              <p align="centre">确认订单完成</p>
              <hr>
              <table>
                <tr>
                  <td><label>维修结果:</label></td>
                  <td><select id="state">
                      <option>维修成功</option>
                      <%--<option>维修失败</option>--%>
                    </select>
                  </td>
                </tr>
                <tr>
                  <td><label>使用设备编号:</label></td>
                  <td id="td1"></td>
                </tr>
                <tr>
                  <td><label>使用设备数量:</label></td>
                  <td><input type="number" id="numbers" placeholder="没有使用设备可以忽略" value="0"></td>
                </tr>
                <tr>
                  <td><label>回复信息:</label></td>
                  <td><textarea id="detail"></textarea></td>
                </tr>
                <tr>
                  <td><input type="button" id="btn1" value="确认"></td>
                  <td><input type="button" onclick="close1()" value="返回"></td>
                </tr>
              </table>
            </div5>

          </div4>
          <div6 id="all_light" style="display: none">
          </div6>





      </body>

      </html>