<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <script src="${pageContext.request.contextPath}/Js/jquery-1.11.0.min.js"></script>
  <html>

  <head>
    <title>power</title>
    <script src="${pageContext.request.contextPath}/Js/finduser.js"></script>
    <script>

      $(function () {

        //获取状态参数、
        var num = getnum('num');

        if (num == 1) {
          alert("权限不足！");
          window.history.go(-1);
        }
        if (num == 2) {
          alert("请先登录！");
          location.href = "login.html";
        }
      })
    </script>
  </head>

  <body>

  </body>

  </html>