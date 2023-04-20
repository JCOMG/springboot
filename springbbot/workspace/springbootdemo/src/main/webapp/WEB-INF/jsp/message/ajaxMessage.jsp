<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Ajax Page</title>
  </head>
  <body>
    <jsp:include page="../layout/navbar.jsp"></jsp:include>
    <div class="container">
      <h1>Ajax Page</h1>
      <form id="msgForm" action="#">
        <input id="myMessage" type="text" required />
        <button id="submitBtn">送出</button>
      </form>

      <div>
        <table class="mytable" id="list_table_json">
          <thead>
            <tr>
              <th>留言內容</th>
              <th>留言時間</th>
            </tr>
          </thead>
          <tbody></tbody>
        </table>
      </div>
    </div>

    <script>
      $(document).ready(function () {
        $("#submitBtn").click(function (event) {
          event.preventDefault();
          let inputText = document.getElementById("myMessage").value;
          let dtoObject = { text: inputText };
          let dtoJsonString = JSON.stringify(dtoObject);

          //    $.ajax是傳送請求的意思，不用再寫let xhr = new XMLHttpRequest();
          $.ajax({
            url: "http://localhost:8080/my-app/api/messages/post",
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            method: "post",
            data: dtoJsonString,
            success: function (result) {
              console.log(result);

              msg_data = "<tbody>";
              $.each(result.content, function (index, value) {
                msg_data += "<tr>";
                msg_data += "<td>" + value.text + "</td>";
                msg_data += "<td>" + value.added + "</td>";
                msg_data += "</tr>";
              });
              msg_data += "</tbody>";

              let myTable = document.getElementById("list_table_json");
              myTable.getElementsByTagName("tbody")[0].innerHTML = msg_data;
            },
            error: function (err) {
              console.log(err);
            },
          });
        });
      });
    </script>
  </body>
</html>
