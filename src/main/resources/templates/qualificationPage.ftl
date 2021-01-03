<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Квалификация</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <style>
        .round {
            border-radius: 100px; /* Радиус скругления */
            border: 3px solid green; /* Параметры рамки */
            box-shadow: 0 0 7px #666; /* Параметры тени */
        }

        img.rot {
            animation: 15s linear 0s normal none infinite running rot;
            -webkit-animation: 15s linear 0s normal none infinite running rot;
            width: 300px;
        }
        @keyframes rot {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }
        @-webkit-keyframes rot {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }
        .round {
            border-radius: 100px; /* Радиус скругления */
            border: 3px solid gray; /* Параметры рамки */
            box-shadow: 0 0 7px #666; /* Параметры тени */
        }

        .classTable {
            font-size: 25px;
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
            padding-top: 200px;
            padding-left: 900px;
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
                    <a class="dropdown-item" href="/addConferenceParticipants" style="font-size: 25px">Участников конферренции</a>
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

<table cellpadding="20">
    <tr>
        <td>
            <img src="/static/img/qualification.png" class="round" width="300px" height="300px">
            <table style="margin-left: 70px">
                <tr>
                    <td><button onclick="location.href='http://localhost:8080/deleteQualification/${qualification.getId()}'"><img src="/static/img/trashButton.png" height="60px" width="60px"></button></td>
                    <td><button onclick="location.href='http://localhost:8080/changeQualification/${qualification.getId()}'"><img src="/static/img/changeButton.png" height="60px" width="60px"></button></td>
                </tr>
            </table>
        </td>
        <td>
            <h2 style="margin-left: 20px">${qualification.getProgramm()}</h2>
            <table cellpadding="20" class="classTable">
                <tr>
                    <td><label>Количесто часов</label></td>
                    <td>${qualification.getCountOfHours()}</td>
                </tr>
                <tr>
                    <td><label>Дата начала</label></td>
                    <td>${qualification.getDateOfBeginShow()}</td>
                </tr>
                <tr>
                    <td><label>Дата окончания </label></td>
                    <td>${qualification.getDateOfEndShow()}</td>
                </tr>
                <tr>
                    <td><label>Организация</label></td>
                    <td>${qualification.getOrganisation()}</td>
                </tr>
                <tr>
                    <td><label>Cерия документа</label></td>
                    <td>${qualification.getSeria()}</td>
                </tr>
                <tr>
                    <td><label>Номер документа</label></td>
                    <td>${qualification.getNumber()}</td>
                </tr>
                <tr>
                    <td><label>Название документа</label></td>
                    <td>${qualification.getNameOfDocument()}</td>
                </tr>
            </table>
        </td>
        <td>
            <img class="rot" src="/static/img/KNITehnolU.png" style="margin-left: 500px">
        </td>
    </tr>
</table>
</body>