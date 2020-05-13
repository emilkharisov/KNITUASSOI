<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Учебная степень</title>
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
<#if validError??>
    <script>
        window.onload = function() {
            var arrayOfErrors = [];
            arrayOfErrors[0] = 'Ошибки:'
            var counter = 0;
            <#if nameError??>document.getElementById("name").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${nameError}' + ' - Название'</#if>
            <#if numberOfDocumentError??>document.getElementById("numberOfDocument").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${numberOfDocumentError}' + ' - № Документа'</#if>
            <#if sciencesError??>document.getElementById("sciences").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${sciencesError}' + ' - Науки'</#if>
            <#if placeError??>document.getElementById("place").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${placeError}' + ' - Место защиты'</#if>
            <#if dateError??>document.getElementById("date").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${dateError}' + ' - Дата защиты'</#if>



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
            Добавьте докторскую | кандидатскую работу
        </font></div>
    <form method="post" action="/addCandidateWork">
        <br>
                    <label for="type"><<font color="white">Тип</font>
                        <select name="type" id="type" class="select-field" style="margin-left: 125px">
                            <option disabled>Выберите тип</option>
                            <option value="Докторская">Докторская</option>
                            <option value="Кандидатская">Кандидатская</option>
                        </select>
                    </label>

                    <label for="name"><font color="white">Название</font>
                        <input class="input-field" style="margin-left: 80px" id="name" name="name">
                    </label>
                    <label for="date"><font color="white">Дата защиты</font>
                        <input type="date" style="margin-left: 50px" id="date" name="date" class="data-field">
                    </label>
                    <label for="worker-list"><font color="white">Автор</font>
                    <input list="worker-list" name="worker"  style="margin-left: 175px">
                    <datalist id="worker-list">
                        <option disabled>Выберите работника</option>
                        <#if workers ??>
                            <#list workers as worker>
                                <option value=${worker.getId()}>${worker.getLastname()} ${worker.getFirstname()} ${worker.getThirdname()} ${worker.getPosition()}</option>
                            </#list>
                        </#if>
                     </datalist>
                    </label>
                    <label for="numberOfDocument"><font color="white">№ Документа</font>
                        <input class="input-field" style="margin-left: 47px" id="numberOfDocument" name="numberOfDocument">
                    </label>
                    <label for="name"><font color="white">Науки</font>
                        <input class="input-field" style="margin-left: 120px" id="sciences" name="sciences">
                    </label>
                    <label for="specialization"><font color="white">Специализация</font>
                        <input class="input-field" style="margin-left: 30px" id="specialization" name="specialization">
                    </label>
                    <label for="place"><font color="white">Место защиты</font>
                        <input class="input-field" style="margin-left: 40px" id="place" name="place">
                    </label>
                    <input type="submit" value="Отправить">
    </form>
</div>
</body>
</html>


