<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <html>
      <%--查看所有的用户信息--%>

        <head>
          <title>Title</title>
          <script src="${pageContext.request.contextPath}/Js/jquery-3.3.1.js"></script>
          <script>
            function button1() {
              window.location.href = '${pageContext.request.contextPath}/admin/searchuser?userid=' + $("#userid").val() + '&collage='
                + $("#collage").val() + '&phone=' + $("#phone").val() + '&p=1';
            }
            function deleteuser(num, p) {
              if (confirm("删除账号将会删除该账号附带的所有信息，是否继续？")) {
                $.ajax({
                  url: '${pageContext.request.contextPath}/admin/deleteuser',
                  data: { "num": num },
                  dataType: 'json',
                  async: false,
                  success: function (message) {
                    if (message.flag == 1) {
                      alert(message.message);
                      window.location.href = "${pageContext.request.contextPath}/admin/userlist?p=" + p;

                    } else {
                      alert(message.message)
                    }
                  }
                })

              }
              /* 是否提示已取消？？？？？ */
              //else alert("已取消。");
            }

            function resetpass(num, p) {
              $.ajax({
                url: '${pageContext.request.contextPath}/admin/resetpass',
                data: { "num": num },
                dataType: 'json',
                async: false,
                success: function (message) {
                  if (message.flag == 1) {
                    alert(message.message);
                    window.location.href = "${pageContext.request.contextPath}/admin/userlist?p=" + p;
                  } else {
                    alert(message.message)
                  }
                }
              })
            }
            $(function () {

            })
          </script>


        </head>

        <body>
          <br><br>
          <div style=" height:50px;font-weight: bolder;font-size: 40px;" align="center">用户信息一览表
            <table align="center">
              <tr>
                <td>账号:</td>
                <td><input type="text" id="userid"></td>
                <td>学院:</td>
                <td><input type="text" id="collage"></td>
                <td>电话:</td>
                <td><input type="text" id="phone"></td>
                <td> <input style="font-weight:border;font-size:17px;background-color:#CCCCCC;" type="button" id="btn1"
                    value="高级检索" onclick="button1()"></td>
              </tr>
            </table>
          </div>
          <c:if test="${message.flag==0}">

            <p align="center" style="margin-top: 100px">${message.message}</p>
          </c:if>
          <c:if test="${message.flag==1}">
            <div align="center">


              <table cellspacing="0">

                <div style=" height:50px;"></div>
                <tbody>
                  <tr style="background-color:#556270;height:50px;">
                    <th>序号</th>
                    <th>账号</th>
                    <th>学院</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>注册时间</th>
                    <th style="width:70px">操作</th>
                  </tr>
                  <% int i=0;int count=1;%>
                    <c:forEach items="${page.list }" var="user">
                      <%if(count%2==0){%>
                        <tr style="background-color:aliceblue">
                          <td>${i=i+1}</td>
                          <td style="width:80px;height:50px;">${user.userid }</td>
                          <td style="width:100px">${user.collage }</td>
                          <td style="width:60px">${user.name }</td>
                          <td style="width:20px">${user.gender }</td>
                          <td style="width:120px">${user.phone }</td>
                          <td style="width:180px">${user.mail }</td>
                          <td>
                            <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${user.createdate}" />
                          </td>
                          <td><a onclick="deleteuser(${user.num},${page.pageNum})"
                              href="javascript:void(0)">删除账号</a><br>
                            <a onclick="resetpass(${user.num},${page.pageNum})" href="javascript:void(0)">重置密码</a>
                          </td>
                        </tr>
                        <%}%>

                          <%if(count%2==1){%>
                            <tr style="background-color:snow">
                              <td>${i=i+1}</td>
                              <td>${user.userid }</td>
                              <td>${user.collage }</td>
                              <td>${user.name }</td>
                              <td>${user.gender }</td>
                              <td>${user.phone }</td>
                              <td>${user.mail }</td>
                              <td>
                                <fmt:formatDate type="both" dateStyle="long" timeStyle="long"
                                  value="${user.createdate}" />
                              </td>
                              <td><br><a onclick="deleteuser(${user.num},${page.pageNum})"
                                  href="javascript:void(0)">删除账号</a><br>
                                <a onclick="resetpass(${user.num},${page.pageNum})"
                                  href="javascript:void(0)">重置密码</a><br><br>
                              </td>
                            </tr>
                            <%}%>
                              <%count++;%>
                    </c:forEach>
                </tbody>
              </table>
              <%--1 代表是搜索到的数据 2 代表是所有的数据查询--%>
                <c:if test="${n==2}">
                  <p>一共${page.pages}页;当前为${page.pageNum}页;每页${page.pageSize}条数据</p>

                  <a href="${pageContext.request.contextPath}/admin/userlist?p=${page.firstPage}">第一页</a>
                  <c:if test="${page.prePage==0}">
                    <a href="javascript:void(0)">上一页</a>
                  </c:if>
                  <c:if test="${page.prePage!=0}">
                    <a href="${pageContext.request.contextPath}/admin/userlist?p=${page.prePage}">上一页</a>
                  </c:if>

                  <c:if test="${page.nextPage==0}">
                    <a href="javascript:void(0)">下一页</a>
                  </c:if>
                  <c:if test="${page.nextPage!=0}">
                    <a href="${pageContext.request.contextPath}/admin/userlist?p=${page.nextPage}">下一页</a>
                  </c:if>

                  <a href="${pageContext.request.contextPath}/admin/userlist?p=${page.lastPage}">最后页</a>
                </c:if>


                <c:if test="${n==1}">
                  <p>一共${page.pages}页;当前为${page.pageNum}页;每页${page.pageSize}条数据</p>

                  <a
                    href="${pageContext.request.contextPath}/admin/searchuser?userid=${user.userid}&collage=${user.collage}&phone=${user.phone}&p=${page.firstPage}">第一页</a>
                  <c:if test="${page.prePage==0}">
                    <a href="javascript:void(0)">上一页</a>
                  </c:if>
                  <c:if test="${page.prePage!=0}">
                    <a
                      href="${pageContext.request.contextPath}/admin/searchuser?userid=${user.userid}&collage=${user.collage}&phone=${user.phone}&p=${page.prePage}">上一页</a>
                  </c:if>

                  <c:if test="${page.nextPage==0}">
                    <a href="javascript:void(0)">下一页</a>
                  </c:if>
                  <c:if test="${page.nextPage!=0}">
                    <a
                      href="${pageContext.request.contextPath}/admin/searchuser?userid=${user.userid}&collage=${user.collage}&phone=${user.phone}&p=${page.nextPage}">下一页</a>
                  </c:if>

                  <a
                    href="${pageContext.request.contextPath}/admin/searchuser?userid=${user.userid}&collage=${user.collage}&phone=${user.phone}&p=${page.lastPage}">最后页</a>
                </c:if>
          </c:if>
          </div>
        </body>

      </html>