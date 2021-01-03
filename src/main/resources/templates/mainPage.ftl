<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


    <style>
        /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
        @charset "UTF-8";
        @import url("//fonts.googleapis.com/css?family=Pacifico&text=Pure");
        @import url("//fonts.googleapis.com/css?family=Roboto:700&text=css");
        @import url("//fonts.googleapis.com/css?family=Kaushan+Script&text=!");
        body {
            min-height: 450px;
            height: 100vh;
            margin: 0;
            background: radial-gradient(circle, #0077ea, #1f4f96, #1b2949, #000000);
        }

        .stage {
            height: 300px;
            width: 500px;
            margin: auto;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            perspective: 9999px;
            transform-style: preserve-3d;
        }

        .layer {
            width: 100%;
            height: 100%;
            position: absolute;
            transform-style: preserve-3d;
            animation: ಠ_ಠ 5s infinite alternate ease-in-out -7.5s;
            animation-fill-mode: forwards;
            transform: rotateY(40deg) rotateX(33deg) translateZ(0);
        }

        .layer:after {
            font: 150px/0.65 'Pacifico', 'Kaushan Script', Futura, 'Roboto', 'Trebuchet MS', Helvetica, sans-serif;
            content: 'Кафедра\A  АССОИ\A база данных';
            white-space: pre;
            text-align: center;
            height: 100%;
            width: 100%;
            position: absolute;
            top: 50px;
            color: whitesmoke;
            letter-spacing: -2px;
            text-shadow: 4px 0 10px rgba(0, 0, 0, 0.13);
        }

        .layer:nth-child(1):after {
            transform: translateZ(0px);
        }

        .layer:nth-child(2):after {
            transform: translateZ(-1.5px);
        }

        .layer:nth-child(3):after {
            transform: translateZ(-3px);
        }

        .layer:nth-child(4):after {
            transform: translateZ(-4.5px);
        }

        .layer:nth-child(5):after {
            transform: translateZ(-6px);
        }

        .layer:nth-child(6):after {
            transform: translateZ(-7.5px);
        }

        .layer:nth-child(7):after {
            transform: translateZ(-9px);
        }

        .layer:nth-child(8):after {
            transform: translateZ(-10.5px);
        }

        .layer:nth-child(9):after {
            transform: translateZ(-12px);
        }

        .layer:nth-child(10):after {
            transform: translateZ(-13.5px);
        }

        .layer:nth-child(11):after {
            transform: translateZ(-15px);
        }

        .layer:nth-child(12):after {
            transform: translateZ(-16.5px);
        }

        .layer:nth-child(13):after {
            transform: translateZ(-18px);
        }

        .layer:nth-child(14):after {
            transform: translateZ(-19.5px);
        }

        .layer:nth-child(15):after {
            transform: translateZ(-21px);
        }

        .layer:nth-child(16):after {
            transform: translateZ(-22.5px);
        }

        .layer:nth-child(17):after {
            transform: translateZ(-24px);
        }

        .layer:nth-child(18):after {
            transform: translateZ(-25.5px);
        }

        .layer:nth-child(19):after {
            transform: translateZ(-27px);
        }

        .layer:nth-child(20):after {
            transform: translateZ(-28.5px);
        }

        .layer:nth-child(n+10):after {
            -webkit-text-stroke: 3px rgba(0, 0, 0, 0.25);
        }

        .layer:nth-child(n+11):after {
            -webkit-text-stroke: 15px dodgerblue;
            text-shadow: 6px 0 6px #00366b, 5px 5px 5px #002951, 0 6px 6px #00366b;
        }

        .layer:nth-child(n+12):after {
            -webkit-text-stroke: 15px #0077ea;
        }

        .layer:last-child:after {
            -webkit-text-stroke: 17px rgba(0, 0, 0, 0.1);
        }

        .layer:first-child:after {
            color: #fff;
            text-shadow: none;
        }

        @keyframes ಠ_ಠ {
            100% {
                transform: rotateY(-40deg) rotateX(-43deg);
            }
        }
        .round {
            border-radius: 100px; /* Радиус скругления */
            border: 3px solid gray; /* Параметры рамки */
            box-shadow: 0 0 7px #666; /* Параметры тени */
        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
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
                    <a class="dropdown-item" href="/addEducationalWorkAuthors" style="font-size: 25px">Авторов учебных трудов</a>
                    <a class="dropdown-item" href="/addScienceWork" style="font-size: 25px">Научный труд</a>
                    <a class="dropdown-item" href="/addScinceWorkAuthors" style="font-size: 25px">Авторов научных трудов</a>
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
                <a class="nav-link" href="/editMainPage" style="font-size: 25px">Редактирование</a>
            </li>
        </ul>
        <a class="navbar-brand" href="#" style="font-size: 18px">${login}</a>
        <a class="navbar-brand" href="#"><img src="/img/usersImg/${userImage}" height="80px" width="80px" class="round"></a>
        <a class="nav-link" href="/logout" style="font-size: 18px">Выйти</a>
    </div>
</nav>
<!-- NAVBAR -->
<div class="stage">
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
    <div class="layer"></div>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<br>
<h4 style="color: white" align="center">Кафедра «Автоматизированных систем сбора и обработки информации» ( АССОИ )</h4>
</body>
<footer><h6 align="center" style="color: white">Разработчик - студент группы 8171-21 Харисов Эмиль</h6></footer>
</html>