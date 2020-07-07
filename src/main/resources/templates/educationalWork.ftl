<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Учебный труд</title>
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
                    <a class="dropdown-item" href="/addWorker" style="font-size: 25px">Преподавателя</a>
                    <a class="dropdown-item" href="/addStudent" style="font-size: 25px">Cтудента</a>
                    <a class="dropdown-item" href="/addEducationalWork" style="font-size: 25px">Учебный труд</a>
                    <a class="dropdown-item" href="/addScienceWork" style="font-size: 25px">Научный труд</a>
                    <a class="dropdown-item" href="/addConference" style="font-size: 25px">Конференцию</a>
                    <a class="dropdown-item" href="/addConferenceParticipants" style="font-size: 25px">Участников конференции</a>
                    <a class="dropdown-item" href="/addIntellectualProperty" style="font-size: 25px">Интеллектуальную собственность</a>
                    <a class="dropdown-item" href="/intellectualPropertyAuthors" style="font-size: 25px">Авторов Интеллектуальной собственности</a>
                    <a class="dropdown-item" href="/addQualification" style="font-size: 25px">Квалификацию</a>
                    <a class="dropdown-item" href="/qualification" style="font-size: 25px">Повышение квалификации</a>
                    <a class="dropdown-item" href="/addCandidateWork" style="font-size: 25px">Кандидатскую | Докторскую</a>
                    <div class="dropdown-divider"></div>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: 25px">
                    Выгрузить
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/getExtractListPage" style="font-size: 25px">Преподавателей</a>
                    <a class="dropdown-item" href="/getExtractWorkListPage" style="font-size: 25px">Труды</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/getAddingsPage" style="font-size: 25px">Прочее</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/mailSender" style="font-size: 25px">Рассылка сообщений</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/getChatPage/54" style="font-size: 25px">Чат</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/signUp" style="font-size: 25px">Регистрация</a>
            </li>
        </ul>
        <a class="navbar-brand" href="#" style="font-size: 18px">${login}</a>
        <a class="navbar-brand" href="#"><img src="/img/usersImg/${userImage}" height="80px" width="80px" class="round"></a>
        <a class="nav-link" href="/logout" style="font-size: 18px">Выйти</a>
    </div>
</nav>
<!-- NAVBAR -->


<div class="form-style-2">
    <div class="form-style-2-heading"><font color="white">
            Добавьте учебную работу
        </font></div>
    <form method="post" action="/addEducationalWork">
        <br>
                    <label for="typeOfWork"><font color="white">Тип работы</font>
                        <select name="typeOfWork" id="typeOfWork" class="select-field" style="margin-left: 125px">
                            <option disabled>Выберите тип</option>
                            <option value="Методические указания">Методические указания</option>
                            <option value="Учебные пособия">Учебные пособия</option>
                            <option value="Учебники">Учебники</option>
                        </select>
                    </label>
                    <label for="nameOfWork"><font color="white">Название работы</font>
                        <input class="input-field" style="margin-left: 70px" id="nameOfWork" name="nameOfWork">
                    </label>
                    <label for="amountOfPages"><font color="white">Количество страниц</font>
                        <input class="input-field" style="margin-left: 45px" id="amountOfPages" name="amountOfPages" maxlength="5">
                    </label>
                    <label for="yearOfPublication"><font color="white">Год издания</font>
                        <input class="input-field" style="margin-left: 120px" id="yearOfPublication" name="yearOfPublication" maxlength="5">
                    </label>
                        <label for="publishing"><font color="white">Издательство</font>
                            <input class="input-field" style="margin-left: 105px" id="publishing" name="publishing">
                        </label>
                                    <input type="submit" value="Добавить">
    </form>
</div>
</body>
</html>
