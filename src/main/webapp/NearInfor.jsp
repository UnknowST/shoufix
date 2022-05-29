<%-- Created by IntelliJ IDEA. User: 123 Date: 2020/11/7 Time: 20:39 To change this template use File | Settings | File
  Templates. --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <html>

        <head>
          <title>Title</title>
          <%--查看近期已经完成的维修公告--%>
        </head>

        <body>
          <%--近三十天已经完成的维修记录--%>
            <!--修改--><br><br>
            <div id="div2" align="center" style="height:100px;">
              <center>
                <h1>近一月已完成的维修记录</h1>
              </center>
            </div>
            <div align="center" id="div1">
              <c:if test="${message.flag==0}">
                <p>${message.message}</p>
              </c:if>
              <c:if test="${message.flag==1}">
                <table cellspacing="0">
                  <tbody>
                    <tr style="background-color:#556270;height:50px;">
                      <th>序号</th>
                      <th>申报人账号</th>
                      <th>地点</th>
                      <th>设备</th>
                      <th>详细信息</th>
                      <%-- <th>图片说明</th>--%>
                        <th>状态</th>
                        <th>维修工人</th>
                        <th>填报时间</th>
                    </tr>
                    <% int i=0;int count=1;%>
                      <c:forEach items="${page.list }" var="infor">
                        <%if(count%2==0){%>
                          <tr style="background-color:aliceblue">
                            <td>${i=i+1}</td>
                            <td>${infor.userid}</td>
                            <td>${infor.place }</td>
                            <td>${infor.equip }</td>
                            <td>${infor.detail }</td>
                            <td>${infor.state }</td>
                            <td>${infor.workerid }</td>
                            <td>
                              <fmt:formatDate type="both" dateStyle="long" timeStyle="long"
                                value="${infor.createdate}" />
                            </td>
                          </tr>
                          <%}%>
                            <%if(count%2==1){%>
                              <tr style="background-color:snow">
                                <td>${i=i+1}</td>
                                <td style="height:50px;">${infor.userid}</td>
                                <td>${infor.place }</td>
                                <td>${infor.equip }</td>
                                <td>${infor.detail }</td>
                                <td>${infor.state }</td>
                                <td>${infor.workerid }</td>
                                <td>
                                  <fmt:formatDate type="both" dateStyle="long" timeStyle="long"
                                    value="${infor.createdate}" />
                                </td>
                              </tr>
                              <%}%>
                                <%count++;%>
                      </c:forEach>
                  </tbody>
                </table>

                <p>一共${page.pages}页;当前是${page.pageNum}页;每页${page.pageSize}条数据</p>
                <a href="${pageContext.request.contextPath}/user/infor_day30?p=${page.firstPage}">第一页</a>
                <c:if test="${page.nextPage==0}">
                  <a href="javascript:void(0)">下一页</a>
                </c:if>
                <c:if test="${page.nextPage!=0}">
                  <a href="${pageContext.request.contextPath}/user/infor_day30?p=${page.nextPage}">下一页</a>
                </c:if>
                <c:if test="${page.prePage==0}">
                  <a href="javascript:void(0)">上一页</a>
                </c:if>
                <c:if test="${page.prePage!=0}">
                  <a href="${pageContext.request.contextPath}/user/infor_day30?p=${page.prePage}">上一页</a>
                </c:if>
                <a href="${pageContext.request.contextPath}/user/infor_day30?p=${page.lastPage}">最后页</a>
              </c:if>
            </div>
        </body>

        </html>