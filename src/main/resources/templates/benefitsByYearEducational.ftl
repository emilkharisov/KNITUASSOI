<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Выборка</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles2.css" rel="stylesheet" type="text/css">
    <link href="/static/css/table.css" rel="stylesheet">
    <style>
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            text-align: left;
            border-collapse: separate;
            border-spacing: 15px;
            background: #ECE9E0;
            color: #656665;
            border: 16px solid #ECE9E0;
            border-radius: 20px;
        }
        th {
            font-size: 18px;
            padding: 10px;
        }
        td {
            background: #F5D7BF;
            padding: 10px;
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
    <div class="form-style-2-heading"><font color="white"></font>
        Выборка по учебным пособиям
    </div>
    <form method="post" action="/getBenefitsByYearPage">
        <label for="yearOfPublication">Введите год публикации
            <input class="input-field" id="yearOfPublication" name="yearOfPublication">
        </label>
        <input type="submit" value="Поиск">
        <br>
        <table style="margin-top: 50px" align="center" class="table">
            <tr>
                <th class="th">Название</th>
                <th class="th">Авторы</th>
                <th class="th">Страницы</th>
                <th class="th">Изадательство</th>
                <th class="th">Год издания</th>
            </tr>
            <#list works as work>
                <tr>
                    <td class="td">${work.getNameOfWork()}</td>
                    <#if work.getWorker()?? && work.getStudent()??>
                        <td class="td">${work.getWorker().getLastname()} ${work.getWorker().getFirstname()} - преподователь ${work.getStudent().getLastname()} ${work.getStudent().getLastname()} - студент</td>
                        <#elseif work.getWorker()?? && !work.getStudent()??>
                            <td class="td">${work.getWorker().getLastname()} ${work.getWorker().getFirstname()} - преподователь</td>
                        <#elseif !work.getWorker()?? && work.getStudent()??>
                            <td class="td">${work.getStudent().getLastname()} ${work.getStudent().getLastname()} - студент</td>
                        <#else>
                            <td class="td">Автор не введён</td>
                    </#if>
                    <td class="td">${work.getAmountOfPages()}</td>
                    <td class="td">${work.getPublishing()}</td>
                    <td class="td">${work.getYearOfPublication()}</td>
                </tr>
            </#list>
        </table>
    </form>
</div>
</body>
</html>
