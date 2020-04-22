<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Логин</title>
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
    <div class="form-style-2">
        <#if error??>
            <script>
                alert("Некорректые данные, введите ещё раз")
            </script>
        </#if>
    <div class="form-style-2-heading">
    Кафедра АССОИ
    </div>
    <form method="post">
        <br>
        <label for="login">Логин
            <input class="input-field" style="margin-left: 60px" id="login" name="login" maxlength="20">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" style="margin-left: 50px" id="password" name="password" maxlength="20">
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me" style="zoom: 1.5">Запомнить меня</label>
        <table cellspacing="10">
            <tr>
                <td>
                    <input type="submit" value="Войти">
                </td>
                <td>
                    <input type="button" onclick="location.href='http://localhost:8080/signUp'" value="Зарегистрироваться">
                </td>
            </tr>
        </table>
    </form>
    </div>


</body>