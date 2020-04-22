<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles2.css" rel="stylesheet" type="text/css">
    <style>
        body {
            background-image: url("https://www.abrisburo.ru/city/kazan/kazan-32.jpg"); /* Цвет фона и путь к файлу */
            color: #fff; /* Цвет текста */
            background-size: cover;
        }
    </style>

</head>
<body>
<#if validError??>
    <script>
        window.onload = function() {
            var arrayOfErrors = [];
            arrayOfErrors[0] = 'Ошибки:'
            var counter = 0;
            <#if firstnameError??>document.getElementById("firstname").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${firstnameError}' + ' - Имя'</#if>
            <#if lastnameError??>document.getElementById("lastname").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${lastnameError}' + ' - Фамилия'</#if>
            <#if loginError??>document.getElementById("login").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${loginError}' + ' - Логин'</#if>
            <#if passwordError??>document.getElementById("password").style.backgroundColor="red";counter= counter +1;arrayOfErrors[counter]='${passwordError}' + ' - Пароль'</#if>
            var message = '';
            for(var i=0; i<arrayOfErrors.length; i++){
                message = message + arrayOfErrors[i] + '\n';
            }
            alert(message);
        }
    </script>
</#if>
<div class="form-style-2">

    <div class="form-style-2-heading">
        Кафедра АССОИ
    </div>
    <form method="post" enctype="multipart/form-data">

           <label for="firstname">Имя
                <input class="input-field" style="margin-left: 60px" id="firstname" name="firstname" maxlength="20">
           </label>

        <br>

        <label for="lastname">Фамилия
            <input class="input-field" style="margin-left: 30px" id="lastname" name="lastname" maxlength="20">
        </label>

        <br>

        <label for="login">Логин
            <input class="input-field" style="margin-left: 50px" id="login" name="login" maxlength="20">
        </label>

        <br>

        <label for="password">Пароль
            <input class="input-field" type="password" style="margin-left: 40px" id="password" name="password" maxlength="20">
        </label>

        <br>

        <label for="activateKey">Ключ
            <input class="input-field" style="margin-left: 53px" id="activateKey" name="activateKey" maxlength="10">
        </label>

        <br>

        <label> Загрузите изображение
            <input type="file" name="image" style="font-size: 20px">
        </label>
        <br>
        <input type="submit" value="Зарегистрироваться">
        <#if error??>
            <script>
                alert("Неверный ключ")
            </script>
        </#if>
    </form>
</div>


</body>