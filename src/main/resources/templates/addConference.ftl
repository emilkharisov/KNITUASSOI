<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Добавить конференцию</title>
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
    </style>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous" color="white">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>

<#if validError??>
    <script>
        window.onload = function() {
            var arrayOfErrors = [];
            arrayOfErrors[0] = 'Ошибки:'
            var counter = 0;
            <#if nameError??>document.getElementById("name").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${nameError}' + ' - Название'</#if>
            <#if dateOfStartError??>document.getElementById("dateOfStart").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${dateOfStartError}' + ' - Дата начала'</#if>
            <#if dateOfEndError??>document.getElementById("dateOfEnd").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${dateOfEndError}' + ' - Дата окончания'</#if>
            <#if cityError??>document.getElementById("city").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${cityError}' + ' - Город'</#if>


            var message = '';
            for(var i=0; i<arrayOfErrors.length; i++){
                message = message + arrayOfErrors[i] + '\n';
            }
            alert(message);
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
            Добавьте конференцию
        </font></div>
    <form method="post" action="/addConference">
        <br>
        <label for="name"><font color="white">Название</font>
            <input class="input-field" style="margin-left: 75px" id="name" name="name" maxlength="20">
        </label>
        <label for="dateOfStart"><font color="white">Дата начала</font>
            <input type="date"   style="margin-left: 47px" id="dateOfStart" name="dateOfStart" class="data-field">
        </label>
        <label for="dateOfEnd"><font color="white">Дата окончания</font>
            <input type="date"  style="margin-left: 15px" id="dateOfEnd" name="dateOfEnd" class="data-field">
        </label>
        <label for="city"><font color="white">Город</font>
            <input class="input-field" style="margin-left: 107px" id="city" name="city" maxlength="20">
        </label>
        <label for="level"><font color="white">Уровень</font>
            <select name="level"  style="margin-left: 85px" id="level" class="select-field">
                <option disabled>Выберите уровень</option>
                <option value="Международный">Международный</option>
                <option value="Всероссийсий">Всероссийсий</option>
                <option value="Региональный">Региональный</option>
                <option value="Городской">Городской</option>
                <option value="Вузовский">Вузовский</option>
            </select>
        </label>

        <input type="submit" value="Создать">
    </form>
</div>
</body>
</html>