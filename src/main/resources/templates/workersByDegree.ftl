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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script></head>
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
    <div class="form-style-2-heading"><font color="white"></font>
            Выборка преподавателей по учебной степени
    </div>
    <form method="post" action="/selectByAcademicDegree">
        <label for="academicDegree"><font color="white">Учебная степень</font>
            <select name="academicDegree" id="academicDegree" class="select-field" style="margin-left: -165px">
                <option disabled>Выберите учебную степень</option>
                <option value="Доктор технических наук (д.т.н.)">Доктор технических наук (д.т.н.)</option>
                <option value="Доктор педагогических наук (д.пед.н.)">Доктор педагогических наук (д.пед.н.)</option>
                <option value="Доктор физико-математических наук (д.ф.-м.н.)">Доктор физико-математических наук (д.ф.-м.н.)</option>
                <option value="Кандидат техническких наук">Кандидат техническких наук</option>
            </select>
        </label>
        <input type="submit" value="Вывести преподавателей">
        <br>
        <table style="margin-top: 50px" align="center" class="table">
            <tr>
                <th class="th">Имя</th>
                <th class="th">Фамилия</th>
                <th class="th">Телефон</th>
                <th class="th">Дата Рождения</th>
                <th class="th">Должность</th>
                <th class="th">Учебная степень</th>
            </tr>
                <#list workers as worker>
                    <tr>
                        <td class="td">${worker.getFirstname()}</td>
                        <td class="td">${worker.getLastname()}</td>
                        <td class="td">${worker.getTelephone()}</td>
                        <td class="td">${worker.getDateOfBirth()}</td>
                        <td class="td">${worker.getPosition()}</td>
                        <td class="td">${worker.getAcademicDegree()}</td>
                    </tr>
                </#list>
        </table>
    </form>
</div>
</body>
</html>
