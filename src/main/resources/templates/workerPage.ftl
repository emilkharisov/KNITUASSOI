<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Страница работника</title>
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
</body>
<table cellpadding="20">
    <input type="hidden" name="workerId" id="workerId" value="${worker.getId()}">
    <tr>
        <td>
            <img src="${workerImage}" class="round" width="300px" height="300px">
            <table style="margin-left: 70px">
                <tr>
                    <td><button onclick="location.href='http://localhost:8080/deleteWorker/${worker.getId()}'"><img src="/static/img/trashButton.png" height="60px" width="60px"></button></td>
                    <td><button onclick="location.href='http://localhost:8080/changeWorker/${worker.getId()}'"><img src="/static/img/changeButton.png" height="60px" width="60px"></button></td>
                </tr>
            </table>
        </td>
        <td>
        <h2 style="margin-left: 20px">${worker.getLastname()} ${worker.getFirstname()}</h2>
        <table cellpadding="20">
            <tr>
                <td><label>Дата рождения</label></td>
                <td>${worker.getDateOfBirthShow()}</td>
            </tr>
            <tr>
                <td><label>Номер телефона</label></td>
                <td>${worker.getTelephone()}</td>
            </tr>
            <tr>
                <td><label>Должность</label></td>
                <td>${worker.getPosition()}</td>
            </tr>
            <tr>
                <td><label>Учебно звание</label></td>
                <td>${worker.getAcademicRank()}</td>
            </tr>
            <tr>
                <td><label>Учебная степень</label></td>
                <td>${worker.getAcademicDegree()}</td>
            </tr>
            <tr>
                <td><label>Образование</label></td>
                <td>${worker.getEducation()}</td>
            </tr>
            <tr>
                <td><label>Дата начала работы</label></td>
                <td>${worker.getDateOfBeginWorkShow()}</td>
            </tr>
            <tr>
                <td><label>Дата окончания контракта</label></td>
                <td>${worker.getDateEndOfContractShow()}</td>
            </tr>
            <tr>
                <td><label>Оканчивал магистратуру?</label></td>
                <td>${magistr}</td>
            </tr>
        </table>
        </td>
        <td>
            <img class="rot" src="/static/img/KNITehnolU.png" style="margin-left: 500px">
        </td>
    </tr>
</table>