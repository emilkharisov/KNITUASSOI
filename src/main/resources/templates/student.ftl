<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Научный труд</title>
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
            Добавьте студента
        </font></div>
    <form method="post" action="/addStudent">
        <br>
            <label for="firstname"><font color="white">Имя</font>
                <input class="input-field" style="margin-left: 75px" id="firstname" name="firstname" maxlength="20">
            </label>
            <label for="lastname"><font color="white">Фамилия</font>
                <input class="input-field" style="margin-left: 75px" id="lastname" name="lastname" maxlength="20">
            </label>
            <label for="thirdname"><font color="white">Отчетсво</font>
                <input class="input-field" style="margin-left: 75px" id="thirdname" name="thirdname" maxlength="20">
            </label>
            <label for="telephone"><font color="white">Телефон</font>
                <input class="input-field" style="margin-left: 75px" id="telephone" name="telephone" maxlength="11">
            </label>
            <label for="educationLevel"><font color="white">Уровень образования</font>
                <select name="educationLevel" id="educationLevel" class="select-field">
                    <option disabled>Выберите уровень образования</option>
                    <option value="Бакалавриат">Бакалавриат</option>
                    <option value="Магистр">Магистр</option>
                </select>
            </label>
            <label for="formOfEducation"><font color="white">Форма обучения</font>
                <select name="formOfEducation" id="formOfEducation" class="select-field">
                    <option disabled>Выберите форму обучения</option>
                    <option value="Очная">Очная</option>
                    <option value="Заочная">Заочная</option>
                </select>
            </label>
            <label for="direction"><font color="white">Направление</font>
                <input class="input-field" style="margin-left: 75px" id="direction" name="direction" maxlength="5">
            </label>
            <label for="group"><font color="white">Группа</font>
                <input class="input-field" style="margin-left: 75px" id="group" name="group" maxlength="8">
            </label>
            <input type="submit" value="Отправить">
    </form>
</div>
</body>
</html>
