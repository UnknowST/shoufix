<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <html>

      <head>
        <title>infordetail</title>
        <%--查看维修单的详细信息--%>
          <script src="${pageContext.request.contextPath}/Js/jquery-1.11.0.min.js"></script>
          <script src="${pageContext.request.contextPath}/Js/uploadimag.js"></script>
          <!--修改-->

          <style type="text/css">
            * {
              margin: 0;
              padding: 0;
            }

            .upBox {
              border: solid #556270;
              border-radius: 20px;
              background-color: #dbe6f4;
              width: 600px;
            }

            #inputBox {
              background-color: red;
              width: 101%;
              height: 40px;
              border-top-right-radius: 20px;
              border-top-left-radius: 20px;
              position: relative;
              text-align: center;
              line-height: 40px;
              overflow: hidden;
              font-size: 16px;
            }

            #inputBox input {
              width: 114%;
              height: 40px;
              opacity: 0;
              cursor: pointer;
              position: absolute;
              top: 0;
              left: -14%;

            }

            #imgBox {
              text-align: left;
            }

            .imgContainer {
              display: inline-block;
              width: 32%;
              height: 150px;
              margin-left: 1%;
              border: 1px solid #556270;
              position: relative;
              margin-top: 30px;
              box-sizing: border-box;
            }

            .imgContainer img {
              width: 100%;
              height: 150px;
              cursor: pointer;
            }

            .imgContainer p {
              position: absolute;
              bottom: -1px;
              left: 0;
              width: 100%;
              height: 30px;
              background: black;
              text-align: center;
              line-height: 30px;
              color: white;
              font-size: 16px;
              font-weight: bold;
              cursor: pointer;
              display: none;
            }

            .imgContainer:hover p {
              display: block;
            }

            #btn {
              outline: none;
              width: 100px;
              height: 30px;
              background: cornflowerblue;
              border: 1px solid cornflowerblue;
              color: white;
              cursor: pointer;
              margin-top: 30px;
              border-radius: 5px;
            }
          </style>
          <script>
            //创建一个图片路径容器
            var imgSrc = []; //图片路径
            var num = [];//记录下原本就存在并且在修改后没有被删除的图片编号
            function removeimg(i) {
              id = '#divv' + i;   //删除原本上传的图片
              $(id).remove();
              imgSrc.pop(i);
              num.pop(i);

            }

            function a1() {
              $("#tb1").css("display", "none");
              $("#div2").css("display", "block");
              var n = 1;
              <c:if test="${infor.imagepaths.size()!=0}">
                <c:forEach var="i" begin="0" end="${infor.imagepaths.size()-1}">
                  imgSrc.push("${infor.imagepaths.get(i)}");
            num.push(n);
            n++;
            </c:forEach>
              </c:if>
              for (var i = 0; i < imgSrc.length; i++) {
                $("#imgBox").append('<div id="divv' + i + '" class="imgContainer"><img  src="' + imgSrc[i] + '" onclick="imgDisplay(this)"> <p onclick="removeimg(' + i + ')" class="imgDelete">删除</p></div>')
              }

            }

            function delete1() {
              $.ajax({
                url: '${pageContext.request.contextPath}/user/delete_infor?num=' + ${ infor.num },
                type: "post",
                dataType: 'json',
                async: false,
                success: function (message) {
                  console.log(message)
                  if (message.flag == 1) {
                    alert(message.message);
                    window.history.go(-1);    //回退上一页
                  } else {
                    alert(message.message);
                  }
                }
            })
        }

            $(function () {
              $("#file").click(function () {
                if (imgSrc.length >= 5) {
                  alert("最多只能上传五张图片!")
                  return false;
                }

              })

              $("#btn2").click(function () {
                <c:if test="${infor.workerid!=null}">

                  $.ajax({
                    url: '${pageContext.request.contextPath}/user/eval',
                    data: {
                    "num":${infor.num},
                        "fenshu": $('input:radio[name="fenshu"]:checked').val(),
                        "comment": $("#comment").val(),
                        "workerid":${infor.workerid}
                    },
                    dataType: 'json',
                    type: 'post',
                    async: false,
                    success: function (message) {
                        if (message.flag == 1) {
                    alert(message.message);
                            window.history.go(0);

                        } else alert(message.message);

                    }
                })
                </c:if>

              })
            })
          </script>
      </head>

      <body>

        <div align="center">
          <c:choose>

            <%-- //////////////////////////////// 正在维修 --%>
              <%-- //////////////////////////////// 正在维修 --%>
                <%-- //////////////////////////////// 正在维修 --%>
                  <%-- //////////////////////////////// 正在维修 --%>
                    <%-- //////////////////////////////// 正在维修 --%>
                      <%-- //////////////////////////////// 正在维修 --%>
                        <c:when test="${infor.state == '正在维修'}">
                          <%-- 11 --%>
                            <br><br> <br><br>
                            <center>
                              <div class="upBox">
                                <!-- 第一行 -->
                                <div
                                  style="background-color: #556270;height: 70px;border-top-left-radius: 15px;border-top-right-radius: 15px;">
                                  <div
                                    style="float: left;font-weight: bolder;margin-top: 17px;margin-left: 18px;font-size: 30px;">
                                    订单详情
                                  </div>
                                  <div style="float: right;">
                                    <a href="javascript:returnback();"><img src="${pageContext.request.contextPath}/img/return.png"
                                        style="width:30px;height:30px;"></a>
                                    <script>
                                      function returnback() {
                                        window.history.go(-1);
                                      }
                                    </script>

                                  </div>
                                </div>
                                <!-- 第二行 -->
                                <div>
                                  <br>
                                  <div class="notice">
                                    <ul id="ul1">
                                      <table cellspacing="0" border="0">
                                        <tr>
                                          <td style="text-align:right;"><strong>报修人:<strong></td>
                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.userid}</td>
                                        </tr>
                                        <tr>
                                          <td style="text-align:right;"><strong>地点:</strong></td>
                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.floor}${infor.layer}${infor.h_number}</td>
                                        </tr>
                                        <tr>
                                          <td style="text-align:right;"><strong>故障设备:</strong></td>
                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.equip}</td>
                                        </tr>
                                        <tr>
                                          <td style="text-align:right;"><strong>故障类型:</strong></td>
                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.reason}</td>
                                        </tr>
                                        <tr>
                                          <td style="text-align:right;"><strong>填报时间:</strong></td>
                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <fmt:formatDate type="both" dateStyle="long" timeStyle="long"
                                              value="${infor.createdate}" />
                                          </td>
                                        </tr>
                                        <tr>
                                          <td style="text-align:right;"><strong>详细信息:</strong></td>
                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.detail}</td>
                                        </tr>
                                        <c:if test="${infor.imagepaths.size()==0}">
                                          <tr>
                                            <td style="text-align:right;"><strong>图片说明:</strong></td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;该用户没有上传图片说明</td>
                                          </tr>

                                        </c:if>

                                        <c:if test="${infor.imagepaths.size()!=0}">
                                          <tr>
                                            <td style="text-align:right;"><strong>图片说明:</strong></td>
                                          </tr>
                                          <tr>
                                            <td>
                                              <c:if test="${infor.imagepaths.size()<=3}">
                                                <c:forEach var="i" begin="0" end="${infor.imagepaths.size()-1}">
                                                  <img src="${infor.imagepaths.get(i)}" alt="图片不小心走丢了。。。" height="150px"
                                                    width="100px">
                                                </c:forEach>
                                            </td>
                                          </tr>
                                        </c:if>
                                        <c:if test="${infor.imagepaths.size()>3}">
                                          <c:forEach var="i" begin="0" end="2">

                                            <img src="${infor.imagepaths.get(i)}" alt="图片不小心走丢了。。。" height="150px"
                                              width="100px">

                                          </c:forEach>
                                          </td>
                                          </tr>
                                          <tr>
                                            <td>
                                              <c:forEach var="i" begin="3" end="${infor.imagepaths.size()-1}">
                                                <img src="${infor.imagepaths.get(i)}" alt="图片不小心走丢了。。。" height="150px"
                                                  width="100px">

                                              </c:forEach>
                                            </td>
                                          </tr>

                                        </c:if>

                                        </c:if>

                                        <tr>
                                          <td style="text-align:right;"><strong>维修师傅:</strong></td>
                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.workerid}</td>
                                        </tr>
                                      </table>
                                    </ul>
                                  </div>
                                </div>
                              </div>
                            </center>
                            <%-- 111 --%>

                        </c:when>
                        <%-- //////////////////////////////// 维修成功 --%>
                          <%-- //////////////////////////////// 维修成功 --%>
                            <%-- //////////////////////////////// 维修成功 --%>
                              <%-- //////////////////////////////// 维修成功 --%>
                                <%-- //////////////////////////////// 维修成功 --%>
                                  <%-- //////////////////////////////// 维修成功 --%>
                                    <c:when test="${infor.state == '维修成功'}">
                                      <%-- 11 --%>
                                        <br><br> <br><br>
                                        <center>
                                          <div class="upBox">
                                            <!-- 第一行 -->
                                            <div
                                              style="background-color: #556270;height: 70px;border-top-left-radius: 15px;border-top-right-radius: 15px;">
                                              <div
                                                style="float: left;font-weight: bolder;margin-top: 17px;margin-left: 18px;font-size: 30px;">
                                                订单详情
                                              </div>
                                              <div style="float: right;">
                                                <a href="javascript:returnback();"><img src="${pageContext.request.contextPath}/img/return.png"
                                                    style="width:30px;height:30px;"></a>
                                                <script>
                                                  function returnback() {
                                                    window.history.go(-1);
                                                  }
                                                </script>
                                              </div>

                                            </div>
                                            <!-- 第二行 -->
                                            <div>
                                              <br>

                                              <div class="notice">
                                                <ul id="ul1">
                                                  <%-- 代码33333 --%>
                                                    <%-- 代码33333 --%>
                                                      <table cellspacing="0" border="0">
                                                        <tr id="tr1">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>报修人:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.userid}</td>
                                                        </tr>
                                                        <tr id="tr2">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>地点:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.floor}${infor.layer}${infor.h_number}</td>
                                                        </tr>
                                                        <tr id="tr1">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>设备:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.equip}</td>
                                                        </tr>
                                                        <tr id="tr1">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>故障类型:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.reason}</td>
                                                        </tr>
                                                        <tr id="tr2">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>详细信息:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.detail}</td>
                                                        </tr>
                                                        <c:if test="${infor.imagepaths.size()==0}">
                                                          <tr id="tr1">
                                                            <td style="text-align:right;background-color:#cfdef3;">
                                                              <strong>图片说明:</strong>&nbsp;&nbsp;</td>
                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;该用户没有上传图片说明</td>
                                                          </tr>

                                                        </c:if>

                                                        <c:if test="${infor.imagepaths.size()!=0}">
                                                          <tr id="tr2">
                                                            <td style="text-align:right;background-color:#cfdef3;">
                                                              图片说明:&nbsp;&nbsp;</td>
                                                          </tr>
                                                          <tr id="tr1">
                                                            <td>
                                                              <c:if test="${infor.imagepaths.size()<=3}">
                                                                <c:forEach var="i" begin="0"
                                                                  end="${infor.imagepaths.size()-1}">
                                                                  <img src="${infor.imagepaths.get(i)}"
                                                                    alt="图片不小心走丢了。。。" height="150px" width="100px">
                                                                </c:forEach>
                                                            </td>
                                                          </tr>
                                                        </c:if>
                                                        <c:if test="${infor.imagepaths.size()>3}">
                                                          <c:forEach var="i" begin="0" end="2">

                                                            <img src="${infor.imagepaths.get(i)}" alt="图片不小心走丢了。。。"
                                                              height="150px" width="100px">

                                                          </c:forEach>
                                                          </td>
                                                          </tr>

                                                          <tr id="tr2">
                                                            <td>
                                                              <c:forEach var="i" begin="3"
                                                                end="${infor.imagepaths.size()-1}">
                                                                <img src="${infor.imagepaths.get(i)}" alt="图片不小心走丢了。。。"
                                                                  height="150px" width="100px">

                                                              </c:forEach>
                                                            </td>
                                                          </tr>

                                                        </c:if>

                                                        </c:if>
                                                        <tr id="tr1">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>时间:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <fmt:formatDate type="both" dateStyle="long"
                                                              timeStyle="long" value="${infor.createdate}" />
                                                          </td>
                                                        </tr>

                                                        <tr id="tr2">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>维修师傅:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.workerid}</td>
                                                        </tr>
                                                        <tr id="tr1">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>使用设备编号:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.replay.eid}</td>
                                                        </tr>
                                                        <tr id="tr2">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>使用设备数量:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.replay.numbers}</td>
                                                        </tr>
                                                        <tr id="tr1">
                                                          <td style="text-align:right;background-color:#cfdef3;">
                                                            <strong>师傅留言:</strong>&nbsp;&nbsp;</td>
                                                          <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.replay.detail}</td>
                                                        </tr>
                                                        <c:if test="${infor.evaluate==0}">
                                                          <tr id="tr2">
                                                            <td style="text-align:right;background-color:#cfdef3;">
                                                              <strong>请你为本次服务打分:</strong>&nbsp;&nbsp;</td>
                                                            <td><input type="radio" id="radio" name="fenshu" value="1">1
                                                              <input type="radio" id="radio" name="fenshu" value="2">2
                                                              <input type="radio" id="radio" name="fenshu" value="3">3
                                                              <input type="radio" id="radio" name="fenshu" value="4">4
                                                              <input type="radio" id="radio" name="fenshu" value="4">4
                                                              <input type="radio" id="radio" name="fenshu" value="6">6
                                                              <input type="radio" id="radio" name="fenshu" value="7">7
                                                              <input type="radio" id="radio" name="fenshu" value="8">8
                                                              <input type="radio" id="radio" name="fenshu" value="9">9
                                                              <input type="radio" id="radio" name="fenshu" value="10">10
                                                            </td>

                                                          </tr>
                                                          <tr id="tr1">
                                                            <td style="text-align:right;background-color:#cfdef3;">
                                                              <strong>评价:</strong>&nbsp;</td>
                                                            <td><textarea id="comment" style="margin: 0px;resize: none; width: 274px; height: 68px;"></textarea></td>
                                                          </tr>
                                                          <style>
                                                            .login-button { /* 按钮美化 */
                                                              width: 120px; /* 宽度 */
                                                              height: 40px; /* 高度 */
                                                              border-width: 0px; /* 边框宽度 */
                                                              border-radius: 3px; /* 边框半径 */
                                                              background: #1E90FF; /* 背景颜色 */
                                                              cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
                                                              outline: none; /* 不显示轮廓线 */
                                                              font-family: Microsoft YaHei; /* 设置字体 */
                                                              color: white; /* 字体颜色 */
                                                              font-size: 17px; /* 字体大小 */
                                                              margin-left: 50px;
                                                            }
                                                            .login-button:hover { /* 鼠标移入按钮范围时改变颜色 */
                                                              background: #5599FF;
                                                            }
                                                          </style>

                                                          <tr id="tr2">
                                                            <td colspan="2" align="center"><input type="button"
                                                                value="确认完成维修" id="btn2" class="login-button"></td>
                                                          </tr>
                                                        </c:if>
                                                        <c:if test="${infor.evaluate!=0}">
                                                          <tr id="tr1">
                                                            <td style="text-align:right;background-color:#cfdef3;">
                                                              <strong>得分:</strong>&nbsp;&nbsp;</td>
                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.evaluate}</td>
                                                          </tr>
                                                          <tr id="tr2">
                                                            <td style="text-align:right;background-color:#cfdef3;">
                                                              <strong>评价:</strong>&nbsp;&nbsp;</td>
                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.comment}</td>
                                                          </tr>
                                                        </c:if>
                                                      </table>
                                                </ul>
                                              </div>
                                            </div>
                                          </div>
                                        </center>
                                        <%-- 111 --%>
                                          <%-- --%>


                                    </c:when>
                                    <%-- //////////////////////////////// 维修失败 --%>
                                      <%-- //////////////////////////////// 维修失败 --%>
                                        <%-- //////////////////////////////// 维修失败 --%>
                                          <%-- //////////////////////////////// 维修失败 --%>
                                            <%-- //////////////////////////////// 维修失败 --%>
                                              <%-- //////////////////////////////// 维修失败 --%>
                                                <c:when test="${infor.state == '维修失败'}">
                                                  <%-- 11 --%>
                                                    <br><br> <br><br>
                                                    <center>
                                                      <div class="upBox">
                                                        <!-- 第一行 -->
                                                        <div
                                                          style="background-color: #556270;height: 70px;border-top-left-radius: 15px;border-top-right-radius: 15px;">
                                                          <div
                                                            style="float: left;font-weight: bolder;margin-top: 17px;margin-left: 18px;font-size: 30px;">
                                                            订单详情
                                                          </div>
                                                          <div style="float: right;">
                                                            <a href="javascript:returnback();"><img src="${pageContext.request.contextPath}/img/return.png"
                                                                style="width:30px;height:30px;"></a>
                                                            <script>
                                                              function returnback() {
                                                                window.history.go(-1);
                                                              }
                                                            </script>
                                                          </div>

                                                        </div>
                                                        <!-- 第二行 -->
                                                        <div>
                                                          <br>
                                                          <div class="notice">
                                                            <ul id="ul1">
                                                              <table cellspacing="0" border="0">
                                                                <tr>
                                                                  <td style="text-align:right;"><strong>报修人:</strong>
                                                                  </td>
                                                                  <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.userid}</td>
                                                                </tr>
                                                                <tr>
                                                                  <td style="text-align:right;"><strong>地点:</strong>
                                                                  </td>
                                                                  <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.place}</td>
                                                                </tr>
                                                                <tr>
                                                                  <td style="text-align:right;"><strong>设备:</strong>
                                                                  </td>
                                                                  <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.equip}</td>
                                                                </tr>
                                                                <tr>
                                                                  <td style="text-align:right;">详细信息：</td>
                                                                  <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.detail}</td>
                                                                </tr>
                                                                <c:if test="${infor.imagepaths.size()==0}">
                                                                  <tr style="text-align:right;">
                                                                    <td style="text-align:right;"><strong>图片说明:</strong>
                                                                    </td>
                                                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;该用户没有上传图片说明</td>
                                                                  </tr>

                                                                </c:if>

                                                                <c:if test="${infor.imagepaths.size()!=0}">
                                                                  <tr style="text-align:right;">
                                                                    <td style="text-align:right;"><strong>图片说明:</strong>
                                                                    </td>
                                                                  </tr>
                                                                  <tr>
                                                                    <td>
                                                                      <c:if test="${infor.imagepaths.size()<=3}">
                                                                        <c:forEach var="i" begin="0"
                                                                          end="${infor.imagepaths.size()-1}">
                                                                          <img src="${infor.imagepaths.get(i)}"
                                                                            alt="图片不小心走丢了。。。" height="150px"
                                                                            width="100px">
                                                                        </c:forEach>
                                                                    </td>
                                                                  </tr>
                                                                </c:if>
                                                                <c:if test="${infor.imagepaths.size()>3}">
                                                                  <c:forEach var="i" begin="0" end="2">

                                                                    <img src="${infor.imagepaths.get(i)}"
                                                                      alt="图片不小心走丢了。。。" height="150px" width="100px">

                                                                  </c:forEach>
                                                                  </td>
                                                                  </tr>
                                                                  <tr>
                                                                    <td>
                                                                      <c:forEach var="i" begin="3"
                                                                        end="${infor.imagepaths.size()-1}">
                                                                        <img src="${infor.imagepaths.get(i)}"
                                                                          alt="图片不小心走丢了。。。" height="150px"
                                                                          width="100px">

                                                                      </c:forEach>
                                                                    </td>
                                                                  </tr>

                                                                </c:if>

                                                                </c:if>
                                                                <tr>
                                                                  <td style="text-align:right;"><strong>时间:</strong>
                                                                  </td>
                                                                  <td>&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    <fmt:formatDate type="both" dateStyle="long"
                                                                      timeStyle="long" value="${infor.createdate}" />
                                                                  </td>
                                                                </tr>

                                                                <tr>
                                                                  <td style="text-align:right;"><strong>维修师傅:</strong>
                                                                  </td>
                                                                  <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.workerid}</td>
                                                                </tr>
                                                                <c:if test="${infor.replay.eid!=0}">
                                                                  <tr>
                                                                    <td style="text-align:right;">
                                                                      <strong>使用设备编号:</strong></td>
                                                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.replay.eid}</td>
                                                                  </tr>
                                                                </c:if>
                                                                <c:if test="${infor.replay.numbers!=0}">
                                                                  <tr>
                                                                    <td style="text-align:right;">
                                                                      <strong>使用设备数量:</strong></td>
                                                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.replay.numbers}
                                                                    </td>
                                                                  </tr>
                                                                </c:if>
                                                                <tr>
                                                                  <td style="text-align:right;"><strong>师傅留言:</strong>
                                                                  </td>
                                                                  <td>&nbsp;&nbsp;&nbsp;&nbsp;${infor.replay.detail}
                                                                  </td>
                                                                </tr>

                                                              </table>
                                                            </ul>
                                                          </div>
                                                        </div>
                                                      </div>
                                                    </center>
                                                    <%-- 111 --%>

                                                </c:when>
          </c:choose>

        </div>
      </body>

      </html>