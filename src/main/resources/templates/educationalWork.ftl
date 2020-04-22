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
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Добавить
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/hello">Преподователя</a>
                    <a class="dropdown-item" href="/addEducationalWork">Учебный труд</a>
                    <a class="dropdown-item" href="/addScienceWork">Научный труд</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Выгрузить
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/getExtractListPage">Преподователей</a>
                    <a class="dropdown-item" href="/getExtractWorkListPage">Труды</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/signUp">Регистрация</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Логин</a>
            </li>
        </ul>
        <a class="navbar-brand" href="#">${login}</a>
        <a class="navbar-brand" href="#"><img src="/img/usersImg/${userImage}" height="80px" width="80px" class="round"></a>
        <a class="nav-link" href="/logout">Выйти</a>
    </div>
</nav>
<!-- NAVBAR -->


<div class="form-style-2">
    <div class="form-style-2-heading"><font color="white">
            Добавьте учебную работу
        </font></div>
    <form method="post" action="/addEducationalWork">
        <br>
                    <label for="typeOfWork"><<font color="white">Тип работы</font>
                        <select name="typeOfWork" id="typeOfWork" class="select-field" style="margin-left: 70px">
                            <option disabled>Выберите тип</option>
                            <option value="Методические указания">Методические указания</option>
                            <option value="Учебные пособия">Учебные пособия</option>
                            <option value="Учебники">Учебники</option>
                        </select>
                    </label>
                    <label for="nameOfWork"><font color="white">Название работы</font>
                        <input class="input-field" style="margin-left: 40px" id="nameOfWork" name="nameOfWork">
                    </label>
        <label for="worker-list"><font color="white">Автор (Преподователь)</font>
            <input list="worker-list" name="worker">
            <datalist id="worker-list">
                <option disabled>Выберите работника</option>
                <#if workers ??>
                    <#list workers as worker>
                        <option value=${worker.getId()}>${worker.getLastname()} ${worker.getFirstname()} ${worker.getThirdname()} ${worker.getPosition()}</option>
                    </#list>
                </#if>
            </datalist>
        </label>
        <label for="student-list"><font color="white">Автор (Студент)</font>
            <input list="student-list" name="student">
            <datalist id="student-list">
                <option disabled>Выберите студента</option>
                <#if students ??>
                    <#list students as student>
                        <option value=${student.getId()}>${student.getLastname()} ${student.getFirstname()} ${student.getThirdname()} ${student.getEducationGroup()}</option>
                    </#list>
                </#if>
            </datalist>
        </label>
                    <label for="amountOfPages"><font color="white">Количество страниц</font>
                        <input class="input-field" style="margin-left: 25px" id="amountOfPages" name="amountOfPages" maxlength="5">
                    </label>
                    <label for="yearOfPublication"><font color="white">Год издания</font>
                        <input class="input-field" style="margin-left: 75px" id="yearOfPublication" name="yearOfPublication" maxlength="5">
                    </label>
                        <label for="publishing"><font color="white">Издательство</font>
                            <input class="input-field" style="margin-left: 65px" id="publishing" name="publishing">
                        </label>
                                    <input type="submit" value="Отправить">
    </form>
</div>
</body>
</html>
