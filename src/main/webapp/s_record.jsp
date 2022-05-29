<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <html>

      <head>
        <title>Title</title>
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
        </style>
        <script src="${pageContext.request.contextPath}/Js/finduser.js"></script>
        <script src="${pageContext.request.contextPath}/Js/jquery-3.3.1.js"></script>
        <script>
          function state(state) {
            if(state=="正在维修") alert("师傅正在维修中，请耐心等待！")
            if(state=="维修成功") alert("师傅已经完成维修了，请对本次维修进行评价哦！")
           // alert("当前维修进度: " + state + "  维修师傅正在加紧维修中，请耐心等待！")
          }
        </script>
      </head>

      <body>
        <!--修改--><br><br>
        <div id="div2" align="center" style="height:130px;">
          <center>
            <h1>维修订单一览表</h1>
          </center>
          <%-- 全部维修记录 --%>
            <a class="bntup" id="id1"
              href="${pageContext.request.contextPath}/user/allinfor?userid=${userid}&p=1">全部维修</a>&nbsp;&nbsp;&nbsp;
            <a class="bntdown"
              href="${pageContext.request.contextPath}/user/infor_ing?userid=${userid}&p=1">正在维修</a>&nbsp;&nbsp;&nbsp;
            <a class="bntdown" href="${pageContext.request.contextPath}/user/infor_ok?userid=${userid}&p=1">完成维修</a>
        </div>
        <%-- 全部维修单列表 --%>
          <div align="center" id="div1">
            <c:if test="${message.flag==0}">
              <p>${message.message}</p>
            </c:if>
            <c:if test="${message.flag==1}">
              <table cellspacing="0">
                <tbody>
                  <tr style="background-color:#556270;height:50px;">
                    <th>序号</th>
                    <th>地点</th>
                    <th>设备</th>
                    <th>详细信息</th>
                    <th>图片说明</th>
                    <th>状态</th>
                    <th>填报时间</th>
                    <th>操作</th>
                    <% int i=0;int count=1;%>
                      <c:forEach items="${page.list }" var="infor">
                        <%if(count%2==0){%>
                  <tr style="background-color:aliceblue">
                    <td>${i=i+1}</td>
                    <td>${infor.place }</td>
                    <td>${infor.equip }</td>
                    <td>${infor.detail }</td>
                    <c:if test="${infor.imagepaths.size()==0}">
                      <td>该用户没有上传图片说明...</td>
                    </c:if>
                    <c:if test="${infor.imagepaths.size()!=0}">
                      <td><img src="${infor.imagepaths.get(0) }" width="100px" height="120px" alt="诶呀！图片不小心走丢了..."></td>
                    </c:if>
                    <td>${infor.state }</td>
                    <td>
                      <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${infor.createdate}" />
                    </td>
                    <td><a
                        href="${pageContext.request.contextPath}/user/infor_num?num=${infor.num}">详细查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
                        onclick="state('${infor.state}')" href="javascript:void(0)">查看进度</a></td>
                  </tr>
                  <%}%>
                    <%if(count%2==1){%>
                      <tr style="background-color:snow">
                        <td style="height:50px;">${i=i+1}</td>
                        <td>${infor.place }</td>
                        <td>${infor.equip }</td>
                        <td>${infor.detail }</td>
                        <c:if test="${infor.imagepaths.size()==0}">
                          <td>该用户没有上传图片说明...</td>
                        </c:if>
                        <c:if test="${infor.imagepaths.size()!=0}">
                          <td><img src="${infor.imagepaths.get(0) }" width="100px" height="120px" alt="诶呀！图片不小心走丢了...">
                          </td>
                        </c:if>
                        <td>${infor.state }</td>
                        <td>
                          <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${infor.createdate}" />
                        </td>
                        <td><a
                            href="${pageContext.request.contextPath}/user/infor_num?num=${infor.num}">详细查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
                            onclick="state('${infor.state}')" href="javascript:void(0)">查看进度</a></td>
                      </tr>
                      <%}%>
                        <%count++;%>
                          </c:forEach>
                </tbody>
              </table>

              <p>一共${page.pages}页;当前为${page.pageNum}页;每页${page.pageSize}条数据</p>

              <a
                href="${pageContext.request.contextPath}/user/allinfor?userid=${page.list[0].userid}&p=${page.firstPage}">第一页</a>
              <c:if test="${page.nextPage==0}">
                <a href="javascript:void(0)">下一页</a>
              </c:if>
              <c:if test="${page.nextPage!=0}">
                <a
                  href="${pageContext.request.contextPath}/user/allinfor?userid=${page.list[0].userid}&p=${page.nextPage}">下一页</a>
              </c:if>
              <c:if test="${page.prePage==0}">
                <a href="javascript:void(0)">上一页</a>
              </c:if>
              <c:if test="${page.prePage!=0}">
                <a
                  href="${pageContext.request.contextPath}/user/allinfor?userid=${page.list[0].userid}&p=${page.prePage}">上一页</a>
              </c:if>
              <a
                href="${pageContext.request.contextPath}/user/allinfor?userid=${page.list[0].userid}&p=${page.lastPage}">最后页</a>
            </c:if>
          </div>

      </body>

      </html>