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

            var position = '${worker.getPosition()}';
            var hiringConditionOfWorker = '${worker.getHiringConditionOfWorker()}';
            var academicRank = '${worker.getAcademicRank()}';
            var academicDegree = '${worker.getAcademicDegree()}';
            var education = '${worker.getEducation()}';

            document.getElementById('position').value = position;
            document.getElementById('hiringConditionOfWorker').value = hiringConditionOfWorker;
            document.getElementById('academicRank').value = academicRank;
            document.getElementById('academicDegree').value = academicDegree;
            document.getElementById('education').value = education;

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
<form  method="post" enctype="multipart/form-data">
<table cellpadding="20" class="classTable">
    <tr>
        <td>
            <img src="${workerImage}" class="round" width="300px" height="300px">
        </td>
        <td>
        <h2 style="margin-left: 20px">${worker.getLastname()} ${worker.getFirstname()} ${worker.getThirdname()}</h2>
        <table cellpadding="20">
            <tr>
                <td><label>Дата рождения</label></td>
                <td><input type="date" id="dateOfBirth" name="dateOfBirth" value="${dateOfBirth}"></td>
            </tr>
            <tr>
                <td><label>Номер телефона</label></td>
                <td><input class="input-field" value="${worker.getTelephone()}" name="telephone"></td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><input class="input-field" value="${worker.getEmail()}" name="email"></td>
            </tr>
            <tr>
                <td><label>Должность</label></td>
                <td>
                    <select name="position" id="position" class="select-field">
                        <option disabled>Выберите должность</option>
                        <option value="Заведующий кафедрой">Заведующий кафедрой</option>
                        <option value="Профессор">Профессор</option>
                        <option value="Доцент">Доцент</option>
                        <option value="Старший преподаватель">Старший преподаватель</option>
                        <option value="Ассистент">Ассистент</option>
                        <option value="Заведующий лабораторией">Заведующий лабораторией</option>
                        <option value="Инженер-электроник">Инженер-электроник</option>
                        <option value="Программист">Программист</option>
                        <option value="Математик">Математик</option>
                        <option value="Техник">Техник</option>
                        <option value="Лаборант">Математик</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Ставка</label></td>
                <td><input class="input-field" value="${worker.getRate()}" name="rate"></td>
            </tr>
            <tr>
                <td><label>Условие найма</label></td>
                <td>
                    <select name="hiringConditionOfWorker" id="hiringConditionOfWorker" class="select-field">
                        <option disabled>Выберите условие найма</option>
                        <option value="Штатное">Штатное</option>
                        <option value="Внешняя совместимость">Внешняя совместимость</option>
                        <option value="Внутреняя совместимость">Внутреняя совместимость</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Учебное звание</label></td>
                <td>
                    <select name="academicRank" id="academicRank" class="select-field">
                        <option disabled>Выберите учебное звание</option>
                        <option value="Профессор">Профессор</option>
                        <option value="Доцент">Доцент</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Учебная степень</label></td>
                <td>
                    <select name="academicDegree" id="academicDegree" class="select-field">
                        <option disabled>Выберите учебную степень</option>
                        <option value="Доктор технических наук (д.т.н.)">Доктор технических наук (д.т.н.)</option>
                        <option value="Доктор педагогических наук (д.пед.н.)">Доктор педагогических наук (д.пед.н.)</option>
                        <option value="Доктор физико-математических наук (д.ф.-м.н.)">Доктор физико-математических наук (д.ф.-м.н.)</option>
                        <option value="Кандидат техническких наук">Кандидат техническких наук</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Образование</label></td>
                <td>
                    <select name="education" id="education" class="select-field">
                        <option disabled>Выберите образование</option>
                        <option value="Высшее">Высшее</option>
                        <option value="Среднее">Среднее</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Дата начала работы</label></td>
                <td><input type="date" id="dateOfBeginWork" name="dateOfBeginWork" value="${dateOfBeginWork}"></td>
            </tr>
            <tr>
                <td><label>Дата начала пед стажа</label></td>
                <td><input type="date"  id="dateOfPedBeginWork" name="dateOfPedBeginWork" value="${dateOfPedBeginWork}"</td>
            </tr>
            <tr>
                <td><label>Дата окончания контракта</label></td>
                <td><input type="date" id="dateEndOfContract" name="dateEndOfContract" value="${dateEndOfContract}"></td>
            </tr>
            <tr>
                <td><label>Адрес Регистрации</label></td>
                <td><input class="input-field" id="addressRegistration" name="addressRegistration" value="${worker.getAddressRegistration()}"></td>
            </tr>
            <tr>
                <td><label>Адрес проживания</label></td>
                <td> <input class="input-field" id="addressPlaceOfResidence" name="addressPlaceOfResidence" value="${worker.getAddressPlaceOfResidence()}"></td>
            </tr>
            <tr>
                <td><label>Серия паспорта</label></td>
                <td><input class="input-field"  id="pasport" name="pasport" maxlength="4" value="${seria}"></td>
            </tr>
            <tr>
                <td><label>Номер паспорта</label></td>
                <td> <input class="input-field"  id="pasport1" name="pasport1" maxlength="6" value="${number}"></td>
            </tr>
            <tr>
                <td><label>Кем выдан</label></td>
                <td><input class="input-field"  id="pasport2" name="pasport2" maxlength="20" value="${issuing}"></td>
            </tr>
            <tr>
                <td><label>Код подразделения</label></td>
                <td><input class="input-field"  id="pasport3" name="pasport3" maxlength="7" value="${code}"></td>
            </tr>
            <tr>
                <td><label>Оканчивал магистратуру?</label></td>
                <td><input type="checkbox" id="checkMagistr" name="checkMagistr" style="zoom: 2" <#if magistr=='Да'>checked</#if>></td>
            </tr>
            <tr>
                <td><input type="file" name="image"></td>
                <td><input type="submit" value="Изменить"></td>
            </tr>
        </table>
        </td>
        <td>
            <img class="rot" src="/static/img/KNITehnolU.png" style="margin-left: 500px">
        </td>
    </tr>
</table>
</form>
