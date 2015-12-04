<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
            function selectText() {
                var selectionText = "";
                if (document.getSelection) {
                    selectionText = document.getSelection();
                } else if (document.selection) {
                    selectionText = document.selection.createRange().text;
                }
                return selectionText;
            }
            
            document.onmouseup = function() {
                document.getElementById("console").innerHTML = selectText();
            }
        </script>
</head>
<body>
<p>abcdefghijklmnopqrstuvwxyz</p>
        <p>마우스로 드래그해서 선택한 글 나오기</p>
        <div id="console"></div>
</body>
</html>