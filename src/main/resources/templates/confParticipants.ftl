<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Участники конференции</title>
    <meta name="description" content="Описание страницы"/>
    <link href="/css/styles2.css" rel="stylesheet" type="text/css">
    <style>
        body {
            background-image: url("https://www.abrisburo.ru/city/kazan/kazan-32.jpg"); /* Цвет фона и путь к файлу */
            color: #fff; /* Цвет текста */
            background-size: cover;
        }
        .round {
            border-radius: 100px; /* Радиус скругления */
            border: 3px solid gray; /* Параметры рамки */
            box-shadow: 0 0 7px #666; /* Параметры тени */
        }
        .b-popup{
            width:100%;
            min-height:100%;
            background-color: rgba(0,0,0,0.5);
            overflow:hidden;
            position:fixed;
            top:0px;
        }
        .b-popup .b-popup-content{
            width:100px;
            height: 40px;
            padding-top: 500px;
            padding-left: 900px;
        }
        table {
            border-spacing: 0;
            empty-cells: hide;
        }
        td {
            padding: 10px 20px;
            text-align: center;
            border-bottom: 1px solid #F4EEE8;
            transition: all 0.5s linear;
        }
        td:first-child {
            text-align: left;
            color: #3D3511;
            font-weight: bold;
        }
        th {
            padding: 10px 20px;
            color: #3D3511;
            border-bottom: 1px solid #F4EEE8;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
        td:nth-child(even) {
            background: #F6D27E;
        }
        td:nth-child(odd) {
            background: #D1C7BF;
        }
        th:nth-child(even)  {
            background: #F6D27E;
        }
        th:nth-child(odd)  {
            background: #D1C7BF;
        }
        .round-top {
            border-top-left-radius: 5px;
        }
        .round-bottom {
            border-bottom-left-radius: 5px;
        }
        tr:hover td{
            background: #D1C7BF;
            font-weight: bold;
        }

        a.bot1{
            background:linear-gradient(to bottom, #FFFFFF, #E6E6E6) #F5F5F5 repeat-x;
            border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) #B3B3B3;
            border-radius: 4px;
            border-style: solid;
            border-width: 1px;
            box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px rgba(0, 0, 0, 0.05);
            color: #333333;
            text-decoration:none;
            display:block;
            font-size: 14px;
            width:120px;
            line-height: 20px;
            margin: 20px auto;
            padding: 4px 12px;
            text-align: center;
            text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
            vertical-align: middle;
            position: relative;
            -webkit-transition-duration: 0.3s;
            transition-duration: 0.3s;
            -webkit-transition-property: -webkit-transform;
            transition-property: transform;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
            -webkit-transform: translateZ(0);
            -ms-transform: translateZ(0);
            transform: translateZ(0);
            box-shadow: 0 0 1px rgba(0, 0, 0, 0);
        }

        button.bot1:before {
            pointer-events: none;
            position: absolute;
            z-index: -1;
            content: '';
            top: 100%;
            left: 5%;
            height: 10px;
            width: 90%;
            opacity: 0;
            background: -webkit-radial-gradient(center, ellipse, rgba(0, 0, 0, 0.35) 0%, rgba(0, 0, 0, 0) 80%);
            background: radial-gradient(ellipse at center, rgba(0, 0, 0, 0.35) 0%, rgba(0, 0, 0, 0) 80%);
            -webkit-transition-duration: 0.3s;
            transition-duration: 0.3s;
            -webkit-transition-property: -webkit-transform, opacity;
            transition-property: transform, opacity;
        }

        button.bot1:hover {
            -webkit-transform: translateY(-5px);
            -ms-transform: translateY(-5px);
            transform: translateY(-5px);
        }
        button.bot1:hover:before {
            opacity: 1;
            -webkit-transform: translateY(5px);
            -ms-transform: translateY(5px);
            transform: translateY(5px);
        }
        .aclass {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 15px;
            color: #ffffff;
            padding: 16px 26px;
            background: -moz-linear-gradient(
                    top,
                    #42aaff 0%,
                    #003366);
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#42aaff),
                    to(#003366));
            -moz-border-radius: 10px;
            -webkit-border-radius: 10px;
            border-radius: 10px;
            border: 1px solid #003366;
            -moz-box-shadow:
                    0px 1px 3px rgba(000,000,000,0.5),
                    inset 0px 0px 1px rgba(255,255,255,0.5);
            -webkit-box-shadow:
                    0px 1px 3px rgba(000,000,000,0.5),
                    inset 0px 0px 1px rgba(255,255,255,0.5);
            box-shadow:
                    0px 1px 3px rgba(000,000,000,0.5),
                    inset 0px 0px 1px rgba(255,255,255,0.5);
            text-shadow:
                    0px -1px 0px rgba(000,000,000,0.7),
                    0px 1px 0px rgba(255,255,255,0.3);
            display: inline-block;
            text-decoration: none;
        }
        .aclass:hover {
            background: -moz-linear-gradient(
                    top,
                    #42aaff 0%,
                    #0d5aa7);
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#42aaff),
                    to(#0d5aa7));
        }
        .aclass:active {
            background: -moz-linear-gradient(
                    top,
                    #003366 0%,
                    #42aaff);
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#003366),
                    to(#42aaff));
        }
    </style>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous" color="white">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script>
        $(document).ready(function(){
            PopUpHide(4);
        });
        function PopUpShow(id){
            if (id ==1) {
                $("#popup1").show();
            }
            if (id ==2) {
                $("#popup2").show();
            }
            if (id ==3) {
                $("#popup3").show();
            }
        }
        function PopUpHide(id){

            if (id ==1) {
                $("#popup1").hide();
            }
            if (id ==2) {
                $("#popup2").hide();
            }
            if (id ==3) {
                $("#popup3").hide();
            }
            if (id ==4) {
                $("#popup1").hide();
                $("#popup2").hide();
                $("#popup3").hide();
            }
        }

        function submitFunc() {

            var arr1 = document.getElementsByName("check1");
            var arr1String = "";
            var arr2 = document.getElementsByName("check2");
            var arr2String = "";
            var arr3 = document.getElementsByName("check3");
            var arr3String = "";

            for(var i=0; i<arr1.length; i++){
                if (arr1[i].checked){
                    arr1String = arr1[i].id;
                }
            }

            for(var i=0; i<arr2.length; i++){
                if (arr2[i].checked){
                    arr2String = arr2[i].id;
                }
            }

            for(var i=0; i<arr3.length; i++){
                if (arr3[i].checked){
                    arr3String = arr3[i].id;
                }
            }


            document.getElementById('conferences').value = arr1String;
            document.getElementById('workers').value = arr2String;
            document.getElementById('students').value = arr3String;

        }

        function block(element){
            var arr = document.getElementsByName(element.name);

            if (element.checked) {
                for (var i = 0; i < arr.length; i++) {
                    if (!arr[i].checked) {
                        arr[i].disabled = true;
                    }
                }
            }
            else {
                for (var i = 0; i < arr.length; i++) {
                    if (!arr[i].checked) {
                        arr[i].disabled = false;
                    }
                }
            }
        }
    </script>
</head>
<body>
<#if validError??>
    <script>
        window.onload = function() {
            alert("Некорректный ввод данных")
        }
    </script>
</#if>
<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/getMainPage"><img src="/static/img/logo.png" height="90px"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 25px">
                    Добавить
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/hello" style="font-size: 25px">Преподователя</a>
                    <a class="dropdown-item" href="/addStudent" style="font-size: 25px">Cтудента</a>
                    <a class="dropdown-item" href="/addEducationalWork" style="font-size: 25px">Учебный труд</a>
                    <a class="dropdown-item" href="/addScienceWork" style="font-size: 25px">Научный труд</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#" style="font-size: 25px">Something else here</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 25px">
                    Выгрузить
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/getExtractListPage" style="font-size: 25px">Преподователей</a>
                    <a class="dropdown-item" href="/getExtractWorkListPage" style="font-size: 25px">Труды</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#" style="font-size: 25px">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/signUp" style="font-size: 25px">Регистрация</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login" style="font-size: 25px">Логин</a>
            </li>
        </ul>
        <a class="navbar-brand" href="#" style="font-size: 18px">${login}</a>
        <a class="navbar-brand" href="#"><img src="/img/usersImg/${userImage}" height="80px" width="80px" class="round"></a>
        <a class="nav-link" href="/logout" style="font-size: 18px">Выйти</a>
    </div>
</nav>

<div class="form-style-2">
    <div class="form-style-2-heading"><font color="white">
            Добавьте участников конференции
        </font></div>

    <div class="b-container">
        <button class="bot1" onclick="PopUpShow(1)">Добавить конференцию</button>
    </div>
    <div class="b-container">
        <button class="bot1" onclick="PopUpShow(2)">Добавить преподоватей</button>
    </div>
    <div class="b-container">
        <button class="bot1" onclick="PopUpShow(3)">Добавить студентов</button>
    </div>

    <div class="b-popup" id="popup1" style="overflow: scroll;">
        <div class="b-popup-content">
            <table>
                <tr>
                    <th>Название</th>
                    <th>Дата</th>
                    <th>+</th>

                </tr>
                <#list conferences as conference>
                    <tr>
                        <td class="round-top">${conference.getName()}</td>
                        <td>${conference.getDateOfStartShow()}</td>
                        <td><input type="checkbox" name="check1" onclick="block(this)" style="zoom: 2" id="${conference.getName()}|${conference.getDateOfStartShow()}"></td>
                    </tr>
                </#list>
            </table>

            <a href="javascript:PopUpHide(1)" class="aclass">Закрыть</a>
        </div>
    </div>
    <div class="b-popup" id="popup2" style="overflow: scroll;">
        <div class="b-popup-content">
            <table>
                <tr>
                    <th>ФИО</th>
                    <th>Должность</th>
                    <th>+</th>

                </tr>
                <#list workers as worker>
                    <tr>
                        <td class="round-top">${worker.getLastname()} ${worker.getFirstname()} ${worker.getThirdname()}</td>
                        <td>${worker.getPosition()}</td>
                        <td><input type="checkbox" name="check2" onclick="block(this)" style="zoom: 2" id="${worker.getLastname()}|${worker.getFirstname()}|${worker.getThirdname()}|${worker.getPosition()}"></td>
                    </tr>
                </#list>
            </table>

            <a href="javascript:PopUpHide(2)" class="aclass">Закрыть</a>
        </div>
    </div>
    <div class="b-popup" id="popup3" style="overflow: scroll;">
        <div class="b-popup-content">
            <table>
                <tr>
                    <th>ФИО</th>
                    <th>Группа</th>
                    <th>+</th>

                </tr>
                <#list students as student>
                    <tr>
                        <td class="round-top">${student.getLastname()} ${student.getFirstname()} ${student.getThirdname()}</td>
                        <td>${student.getEducationGroup()}</td>
                        <td><input type="checkbox" name="check3" onclick="block(this)" style="zoom: 2" id="${student.getLastname()}|${student.getFirstname()}|${student.getThirdname()}|${student.getEducationGroup()}"></td>
                    </tr>
                </#list>
            </table>

            <a href="javascript:PopUpHide(3)" class="aclass">Закрыть</a>
        </div>
    </div>
    <form method="post">
        <input type="text" id="conferences" name="conferences" hidden>
        <input type="text" id="workers" name="workers" hidden>
        <input type="text" id="students" name="students" hidden>
        <hr>
        <input type="submit" onclick="submitFunc()">
    </form>
</div>
</body>
</html>