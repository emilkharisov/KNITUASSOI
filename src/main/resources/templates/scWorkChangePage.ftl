<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Редактирование научной работы</title>
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
        .classTable {
            font-size: 25px;
        }
    </style>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous" color="white">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){

            var typeOfWork = '${work.getTypeOfWork()}';
            document.getElementById('typeOfWork').value = typeOfWork;

            var yearOfPublication = '${work.getYearOfPublication()}';
            var newYearOfPublication = yearOfPublication.toString().replaceAll(" ", "");

            document.getElementById('yearOfPublication').value = newYearOfPublication;

        });
    </script>
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

</body>
<form  method="post">
    <table cellpadding="20" class="classTable">
        <tr>
            <td>
                <table cellpadding="20">
                    <tr>
                        <td>
                            <label>Название</label>
                        </td>
                        <td>
                            <input class="input-field" id="nameOfWork" name="nameOfWork" value="${work.getNameOfWork()}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Тип работы</label>
                        </td>
                        <td>
                            <select name="typeOfWork" id="typeOfWork" class="select-field">
                                <option disabled selected>Выберите тип</option>
                                <option value="Програмный продукт">Программный продукт</option>
                                <option value="Патенты">Патенты</option>
                                <option value="Монографии">Монографии</option>
                                <option value="Статьи">Статьи</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Название журнала</label>
                        </td>
                        <td>
                            <input class="input-field" id="nameOfJournal" name="nameOfJournal" value="${work.getNameOfJournal()}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Номер журнала</label>
                        </td>
                        <td>
                            <input class="input-field" id="numberOfJournal" name="numberOfJournal" value="${work.getNumberOfJournal()}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Том</label>
                        </td>
                        <td>
                            <input class="input-field" id="tom" name="tom" maxlength="5" value="${work.getTom()}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Страницы</label>
                        </td>
                        <td>
                            <input class="input-field" id="pages" name="pages" maxlength="5" value="${work.getPages()}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Год публикации</label>
                        </td>
                        <td>
                            <input class="input-field" id="yearOfPublication" name="yearOfPublication" maxlength="5" value="${work.getYearOfPublication()}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>РИНЦ</label>
                        </td>
                        <td>
                            <#if work.isRinc()>
                                <input type="checkbox" id="rinc" name="rinc"  style="zoom: 1.5" checked>
                            <#else>
                                <input type="checkbox" id="rinc" name="rinc"  style="zoom: 1.5">
                            </#if>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>SCOPUS</label>
                        </td>
                        <td>
                            <#if work.isScopus()>
                                <input type="checkbox" id="scopus" name="scopus"  style="zoom: 1.5" checked>
                            <#else>
                                <input type="checkbox" id="scopus" name="scopus"  style="zoom: 1.5">
                            </#if>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Изменить"></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>

