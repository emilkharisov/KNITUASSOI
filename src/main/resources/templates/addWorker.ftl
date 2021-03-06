<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Добавить преподавателя</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <style>
        .round {
            border-radius: 100px; /* Радиус скругления */
            border: 3px solid gray; /* Параметры рамки */
            box-shadow: 0 0 7px #666; /* Параметры тени */
        }
        body {
            background-image: url("https://www.abrisburo.ru/city/kazan/kazan-32.jpg"); /* Цвет фона и путь к файлу */
            color: #fff; /* Цвет текста */
            background-size: cover;
        }
        #block {
            border: 1px solid black;
            background-color: white;

        }
    </style>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous" color="white">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script>
        function showOrHide(element, name) {
            if (name == "H" && element.checked){
                console.log( document.getElementById("highDirection").parentElement.parentElement)
                document.getElementById("highDirection").parentElement.parentElement.hidden = false;
                document.getElementById("highSpec").parentElement.parentElement.hidden = false;
                document.getElementById("highNumber").parentElement.parentElement.hidden = false;
                document.getElementById("highSeria").parentElement.parentElement.hidden = false;
                document.getElementById("highYear").parentElement.parentElement.hidden = false;
                document.getElementById("highOrganisation").parentElement.parentElement.hidden = false;
            }
            if (name == "A" && element.checked){
                console.log( document.getElementById("avDirection").parentElement.parentElement)
                document.getElementById("avDirection").parentElement.parentElement.hidden = false;
                document.getElementById("avSpec").parentElement.parentElement.hidden = false;
                document.getElementById("avNumber").parentElement.parentElement.hidden = false;
                document.getElementById("avSeria").parentElement.parentElement.hidden = false;
                document.getElementById("avYear").parentElement.parentElement.hidden = false;
                document.getElementById("avOrganisation").parentElement.parentElement.hidden = false;
            }
            if (name == "B" && element.checked){
                console.log( document.getElementById("begDirection").parentElement.parentElement)
                document.getElementById("begDirection").parentElement.parentElement.hidden = false;
                document.getElementById("begSpec").parentElement.parentElement.hidden = false;
                document.getElementById("begNumber").parentElement.parentElement.hidden = false;
                document.getElementById("begSeria").parentElement.parentElement.hidden = false;
                document.getElementById("begYear").parentElement.parentElement.hidden = false;
                document.getElementById("begOrganisation").parentElement.parentElement.hidden = false;
            }

            if (name == "H" && !element.checked){
                console.log( document.getElementById("highDirection").parentElement.parentElement)
                document.getElementById("highDirection").parentElement.parentElement.hidden = true;
                document.getElementById("highSpec").parentElement.parentElement.hidden = true;
                document.getElementById("highNumber").parentElement.parentElement.hidden = true;
                document.getElementById("highSeria").parentElement.parentElement.hidden = true;
                document.getElementById("highYear").parentElement.parentElement.hidden = true;
                document.getElementById("highOrganisation").parentElement.parentElement.hidden = true;
            }
            if (name == "A" && !element.checked){
                console.log( document.getElementById("avDirection").parentElement.parentElement)
                document.getElementById("avDirection").parentElement.parentElement.hidden = true;
                document.getElementById("avSpec").parentElement.parentElement.hidden = true;
                document.getElementById("avNumber").parentElement.parentElement.hidden = true;
                document.getElementById("avSeria").parentElement.parentElement.hidden = true;
                document.getElementById("avYear").parentElement.parentElement.hidden = true;
                document.getElementById("avOrganisation").parentElement.parentElement.hidden = true;
            }
            if (name == "B" && !element.checked){
                console.log( document.getElementById("begDirection").parentElement.parentElement)
                document.getElementById("begDirection").parentElement.parentElement.hidden = true;
                document.getElementById("begSpec").parentElement.parentElement.hidden = true;
                document.getElementById("begNumber").parentElement.parentElement.hidden = true;
                document.getElementById("begSeria").parentElement.parentElement.hidden = true;
                document.getElementById("begYear").parentElement.parentElement.hidden = true;
                document.getElementById("begOrganisation").parentElement.parentElement.hidden = true;
            }
        }
    </script>
</head>
<body>

<#if validError??>
    <script>
        window.onload = function() {
            var arrayOfErrors = [];
            arrayOfErrors[0] = 'Ошибки:'
            var counter = 0;
            <#if firstnameError??>document.getElementById("first-name").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${firstnameError}' + ' - Имя'</#if>
            <#if lastnameError??>document.getElementById("last-name").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${lastnameError}' + ' - Фамилия'</#if>
            <#if telephoneError??>document.getElementById("telephone1").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${telephoneError}' + ' - Телефон'</#if>
            <#if dateOfBeginWorkError??>document.getElementById("dateOfBeginWork").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${dateOfBeginWorkError}' + ' - Дата начала стажа'</#if>
            <#if dateEndOfContractError??>document.getElementById("dateEndOfContract").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${dateEndOfContractError}' + ' - Дата окончания контракта'</#if>
            <#if dateOfBirthError??>document.getElementById("dateOfBirth").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${dateOfBirthError}' + ' - Дата рождения'</#if>
            <#if emailError??>document.getElementById("email").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${emailError}' + ' - Email'</#if>
            <#if dateOfPedBeginWorkError??>document.getElementById("dateOfPedBeginWork").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${dateOfPedBeginWorkError}' + ' - Дата начала пед стажа'</#if>
            <#if thirdnameError??>document.getElementById("thirdname").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${thirdnameError}' + ' - Отчество'</#if>
            <#if addressRegistrationError??>document.getElementById("addressRegistration").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${addressRegistrationError}' + ' - Адрес регистрации'</#if>
            <#if addressPlaceOfResidenceError??>document.getElementById("addressPlaceOfResidence").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${addressPlaceOfResidenceError}' + ' - Адрес проживания'</#if>
            <#if pasportError??>document.getElementById("pasport").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${pasportError}' + ' - Серия'</#if>
            <#if pasport1Error??>document.getElementById("pasport1").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${pasport1Error}' + ' - Номер паспорта'</#if>
            <#if pasport3Error??>document.getElementById("pasport3").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${pasport3Error}' + ' - Код подразделения'</#if>



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

<hr>
<div class="form-style-2-heading">
    <font color="white">Добавьте преподавателя</font>
</div>
<hr>
<div class="form-style-2" id="block" align="center">
    <form method="post" enctype="multipart/form-data" action="/addWorker">
                            <label for="first-name">Имя</label>
                            <input class="input-field" id="first-name" name="firstname" maxlength="20">
                            <hr>
                            <label for="last-name">Фамилия</label>
                            <input class="input-field"  id="last-name" name="lastname" maxlength="20">
                            <hr>
                            <label for="thirdname">Отчество</label>
                            <input class="input-field"  id="thirdname" name="thirdname" maxlength="20">
                            <hr>
                            <label>Паспорт</label>
                                <input class="input-field"  id="pasport" name="pasport" maxlength="4" placeholder="Серия">
                                <input class="input-field"  id="pasport1" name="pasport1" maxlength="6" placeholder="Номер">
                                <input class="input-field"  id="pasport2" name="pasport2" placeholder="Кем выдан">
                                <input class="input-field"  id="pasport3" name="pasport3" maxlength="7" placeholder="Код подразделения">
                            <hr>
                            <label for="telephone1">Телефон</label>
                            <input class="input-field"   id="telephone1" name="telephone" maxlength="11">
                                <hr>
                            <label for="addressRegistration">Адрес регистрации</label>
                            <input class="input-field" id="addressRegistration" name="addressRegistration" maxlength="30">
                            <hr>
                            <label for="addressPlaceOfResidence">Адрес проживания</label>
                            <input class="input-field" id="addressPlaceOfResidence" name="addressPlaceOfResidence" maxlength="30">
                            <hr>
                            <label for="email">Email</label>
                            <input class="input-field" id="email" name="email" maxlength="30">
                            <hr>
                            <label for="rate">Ставка</label>
                            <input class="input-field" id="rate" name="rate">
                            <hr>
                            <label for="hiringConditionOfWorker">Условие найма</label>
                            <select name="hiringConditionOfWorker" id="hiringConditionOfWorker" class="select-field">
                                <option disabled selected>Выберите условие найма</option>
                                <option value="Штатное">Штатное</option>
                                <option value="Внешняя совместимость">Внешняя совместимость</option>
                                <option value="Внутреняя совместимость">Внутреняя совместимость</option>
                            </select>
                            <hr>
                            <label for="dateOfBeginWork">Дата начала стажа</label>
                            <input type="date" id="dateOfBeginWork" name="dateOfBeginWork" class="data-field">
                            <hr>

                            <label for="dateOfPedBeginWork">Дата начала пед стажа</label>
                            <input type="date"  id="dateOfPedBeginWork" name="dateOfPedBeginWork" class="data-field">
                            <hr>

                            <label for="education">Образование</label>
                                <select name="education" id="education" class="select-field">
                                    <option disabled selected>Выберите образование</option>
                                    <option value="Высшее">Высшее</option>
                                    <option value="Среднее">Среднее</option>
                                </select>
                            <hr>


                            <label for="position">Должность</label>
                                <select name="position" id="position" class="select-field">
                                    <option disabled selected>Выберите должность</option>
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
                             <hr>

                            <label for="academicRank">Учебное звание</label>
                                <select name="academicRank" id="academicRank" class="select-field">
                                    <option disabled selected>Выберите учебное звание</option>
                                    <option value="Профессор">Профессор</option>
                                    <option value="Доцент">Доцент</option>
                                </select>
                             <hr>

                            <label for="academicDegree">Учебная степень</label>
                                <select name="academicDegree" id="academicDegree" class="select-field">
                                    <option disabled selected>Выберите учебную степень</option>
                                    <option value="Доктор технических наук (д.т.н.)">Доктор технических наук (д.т.н.)</option>
                                    <option value="Доктор педагогических наук (д.пед.н.)">Доктор педагогических наук (д.пед.н.)</option>
                                    <option value="Доктор физико-математических наук (д.ф.-м.н.)">Доктор физико-математических наук (д.ф.-м.н.)</option>
                                    <option value="Кандидат техническких наук">Кандидат техническких наук</option>
                                </select>
                             <hr>

                            <label for="dateOfBirth">Дата рождения</label>
                             <input type="date" id="dateOfBirth" name="dateOfBirth" class="data-field">
                            <hr>


                            <label for="dateEndOfContract">Дата окончания контракта</label>
                            <input type="date" id="dateEndOfContract" name="dateEndOfContract" class="data-field">
                            <hr>

                            <table style="border-spacing: 10px;border-collapse: separate;">
                                <tr>
                                    <td><label>Магистр</label></td>
                                    <td><input type="checkbox" id="checkMagistr" name="checkMagistr" style="zoom: 4"></td>
                                </tr>
                                <tr>
                                    <td><label>Высшее образование</label></td>
                                    <td><input type="checkbox" id="checkHigh" name="checkHigh" style="zoom: 4" onclick="showOrHide(this, 'H')"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Направление" id="highDirection" name="highDirection"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Специальность" id="highSpec" name="highSpec"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Номер документа" id="highNumber" name="highNumber" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Серия документa" id="highSeria" name="highSeria" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Год выдачи" id="highYear" name="highYear" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Организация" id="highOrganisation" name="highOrganisation"></td>
                                </tr>
                                <tr>
                                    <td><label>СПО</label></td>
                                    <td><input type="checkbox" id="checkAverage" name="checkAverage" style="zoom: 4" onclick="showOrHide(this, 'A')"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Направление" id="avDirection" name="avDirection"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Специальность" id="avSpec" name="avSpec"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Номер документа" id="avNumber" name="avNumber" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Серия документa" id="avSeria" name="avSeria" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Год выдачи" id="avYear" name="avYear" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Организация" id="avOrganisation" name="avOrganisation"></td>
                                </tr>
                                <tr>
                                    <td><label>НПО</label></td>
                                    <td><input type="checkbox" id="сheckBegin" name="checkBegin" style="zoom: 4" onclick="showOrHide(this, 'B')"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Направление" id="begDirection" name="begDirection"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Специальность" id="begSpec" name="begSpec"></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Номер документа" id="begNumber" name="begNumber" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Серия документa" id="begSeria" name="begSeria" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Год выдачи" id="begYear" name="begYear" ></td>
                                </tr>
                                <tr hidden>
                                    <td><input class="input-field" placeholder="Организация" id="begOrganisation" name="begOrganisation"></td>
                                </tr>
                            </table>
                             <hr>


                            <label>Загрузите изображение</label>
                            <input type="file" name="image">
                             <hr>

                            <input type="submit" value="Добавить">
    </form>
</div>
</body>
</html>
