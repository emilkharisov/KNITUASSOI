<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
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
    <script>
        $(document).ready(function(){
            PopUpHide(7);
        });

        function PopUpShow(id){
            if (id ==1) {
                $("#popup1").show();
            }

            if (id ==2) {
                $("#popup2").show();
            }

            if (id ==3) {
                $("#popup3").show();
            }

            if (id ==4) {
                $("#popup4").show();
            }

            if (id ==5) {
                $("#popup5").show();
            }

            if (id ==6) {
                $("#popup6").show();
            }
        }
        function PopUpHide(id){

            if (id ==1) {
                $("#popup1").hide();
            }

            if (id ==2) {
                $("#popup2").hide();
            }

            if (id ==3) {
                $("#popup3").hide();
            }

            if (id ==4) {
                $("#popup4").hide();
            }

            if (id ==5) {
                $("#popup5").hide();
            }

            if (id ==6) {
                $("#popup6").hide();
            }

            if (id ==7) {
                $("#popup1").hide();
                $("#popup2").hide();
                $("#popup3").hide();
                $("#popup4").hide();
                $("#popup5").hide();
                $("#popup6").hide();
            }
        }
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
            <hr>
            <table>
                <tr><td><button style="font-size: 20px" onclick="PopUpShow(1)">Информация об образовании</button></td></tr>
                <tr><td><button style="font-size: 20px" onclick="PopUpShow(2)">Кандидатские, докторские работы</button></td></tr>
                <tr><td><button style="font-size: 20px" onclick="PopUpShow(3)">Повышения квалификации</button></td></tr>
                <tr><td><button style="font-size: 20px" onclick="PopUpShow(4)">Участие в конференциях</button></td></tr>
                <tr><td><button style="font-size: 20px" onclick="PopUpShow(5)">Научные труды</button></td></tr>
                <tr><td><button style="font-size: 20px" onclick="PopUpShow(6)">Учебные труды</button></td></tr>
            </table>
        </td>
        <td>
        <h2 style="margin-left: 20px">${worker.getLastname()} ${worker.getFirstname()} ${worker.getThirdname()}</h2>
        <table cellpadding="20" class="classTable">
            <tr>
                <td><label>Дата рождения</label></td>
                <td>${worker.getDateOfBirthShow()}</td>
            </tr>
            <tr>
                <td><label>Номер телефона</label></td>
                <td>${worker.getTelephone()}</td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td>${worker.getEmail()}</td>
            </tr>
            <tr>
                <td><label>Должность</label></td>
                <td>${worker.getPosition()}</td>
            </tr>
            <tr>
                <td><label>Ставка</label></td>
                <td>${worker.getRate()}</td>
            </tr>
            <tr>
                <td><label>Уcловие найма</label></td>
                <td>${worker.getHiringConditionOfWorker()}</td>
            </tr>
            <tr>
                <td><label>Учебное звание</label></td>
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
                <td><label>Дата начала пед стажа</label></td>
                <td>${worker.getDateOfPedBeginWorkShow()}</td>
            </tr>
            <tr>
                <td><label>Дата окончания контракта</label></td>
                <td>${worker.getDateEndOfContractShow()}</td>
            </tr>
            <tr>
                <td><label>Адрес регистрации</label></td>
                <td>${worker.getAddressRegistration()}</td>
            </tr>
            <tr>
                <td><label>Адрес проживания</label></td>
                <td>${worker.getAddressPlaceOfResidence()}</td>
            </tr>
            <tr>
                <td><label>Паспорт</label></td>
                <td>${worker.getPasport()}</td>
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
<div class="b-popup" id="popup1" style="overflow: scroll;">
    <div class="b-popup-content">
        <#if high??>
            <table style="background-color: white;font-size: 30px;border-spacing: 20px 30px;border-collapse: separate;">
                <tr>
                    <td><h2>Высшее образование</h2></td>
                </tr>
                <tr>
                    <td><label>Направление</label></td>
                    <td>${highDirection}</td>
                </tr>
                <tr>
                    <td><label>Специальность</label></td>
                    <td>${highSpec}</td>
                </tr>
                <tr>
                    <td><label>№ Документа</label></td>
                    <td>${highNumber}</td>
                </tr>
                <tr>
                    <td><label>Серия</label></td>
                    <td>${highSeria}</td>
                </tr>
                <tr>
                    <td><label>Год выдачи</label></td>
                    <td>${highYear}</td>
                </tr>
                <tr>
                    <td><label>Организация</label></td>
                    <td>${highOrganiation}</td>
                </tr>
            </table>
        </#if>
        <#if avg??>
            <table style="background-color: white;font-size: 30px">
                <tr>
                    <td><h2>СПО</h2></td>
                </tr>
                <tr>
                    <td><label>Направление</label></td>
                    <td>${avgDirection}</td>
                </tr>
                <tr>
                    <td><label>Специальность</label></td>
                    <td>${avgSpec}</td>
                </tr>
                <tr>
                    <td><label>№ Документа</label></td>
                    <td>${avgNumber}</td>
                </tr>
                <tr>
                    <td><label>Серия</label></td>
                    <td>${avgSeria}</td>
                </tr>
                <tr>
                    <td><label>Год выдачи</label></td>
                    <td>${avgYear}</td>
                </tr>
                <tr>
                    <td><label>Организация</label></td>
                    <td>${avgOrganiation}</td>
                </tr>
            </table>
        </#if>
        <#if beg??>
            <table style="background-color: white;font-size: 30px">
                <tr>
                    <td><h2>НПО</h2></td>
                </tr>
                <tr>
                    <td><label>Направление</label></td>
                    <td>${begDirection}</td>
                </tr>
                <tr>
                    <td><label>Специальность</label></td>
                    <td>${begSpec}</td>
                </tr>
                <tr>
                    <td><label>№ Документа</label></td>
                    <td>${begNumber}</td>
                </tr>
                <tr>
                    <td><label>Серия</label></td>
                    <td>${begSeria}</td>
                </tr>
                <tr>
                    <td><label>Год выдачи</label></td>
                    <td>${begYear}</td>
                </tr>
                <tr>
                    <td><label>Организация</label></td>
                    <td>${begOrganiation}</td>
                </tr>
            </table>
        </#if>
        <a href="javascript:PopUpHide(1)" class="aclass">Закрыть</a>
    </div>
</div>

<div class="b-popup" id="popup2" style="overflow: scroll;">
    <div class="b-popup-content">
        <#if candidateWork??>
        <table style="background-color: white;font-size: 30px;border-spacing: 20px 30px;border-collapse: separate;">
            <#list candidateWorkList as candidateWork>
                <tr>
                    <td><h2>${candidateWork.getType()}</h2></td>
                </tr>
                <tr>
                    <td><label>Название</label></td>
                    <td>${candidateWork.getName()}</td>
                </tr>
                <tr>
                    <td><label>Дата защиты</label></td>
                    <td>${candidateWork.getDateShow()}</td>
                </tr>
                <tr>
                    <td><label>№ Документа</label></td>
                    <td>${candidateWork.getNumberOfDocument()}</td>
                </tr>
                <tr>
                    <td><label>Науки</label></td>
                    <td>${candidateWork.getSciences()}</td>
                </tr>
                <tr>
                    <td><label>Специализация</label></td>
                    <td>${candidateWork.getSpecialization()}</td>
                </tr>
                <tr>
                    <td><label>Место защиты</label></td>
                    <td>${candidateWork.getPlace()}</td>
                </tr>
            </#list>
        </table>
        </#if>
        <a href="javascript:PopUpHide(2)" class="aclass">Закрыть</a>
    </div>
</div>

<div class="b-popup" id="popup3" style="overflow: scroll;">
    <div class="b-popup-content">
        <#if qualification??>
        <table style="background-color: white;font-size: 30px;border-spacing: 20px 30px;border-collapse: separate;">
            <#list increaseQualificationList as increaseQualification>
                <tr>
                    <td><h2>${increaseQualification.getProgramm()}</h2></td>
                </tr>
                <tr>
                    <td><label>Количество часов</label></td>
                    <td>${increaseQualification.getCountOfHours()}</td>
                </tr>
                <tr>
                    <td><label>Дата начала</label></td>
                    <td>${increaseQualification.getDateOfBeginShow()}</td>
                </tr>
                <tr>
                    <td><label>Дата окончания</label></td>
                    <td>${increaseQualification.getDateOfEndShow()}</td>
                </tr>
                <tr>
                    <td><label>Организация</label></td>
                    <td>${increaseQualification.getOrganisation()}</td>
                </tr>
                <tr>
                    <td><label>Cерия документа</label></td>
                    <td>${increaseQualification.getSeria()}</td>
                </tr>
                <tr>
                    <td><label>Номер документа</label></td>
                    <td>${increaseQualification.getNameOfDocument()}</td>
                </tr>
                <tr>
                    <td><label>Название документа</label></td>
                    <td>${increaseQualification.getNameOfDocument()}</td>
                </tr>

            </#list>
        </table>
        </#if>
        <a href="javascript:PopUpHide(3)" class="aclass">Закрыть</a>
    </div>
</div>

<div class="b-popup" id="popup4" style="overflow: scroll;">
    <div class="b-popup-content">
        <#if conference??>
        <table style="background-color: white;font-size: 30px;border-spacing: 20px 30px;border-collapse: separate;">
            <#list conferenceList as conference>
                <tr>
                    <td><h2>${conference.getName()}</h2></td>
                </tr>

                <tr>
                    <td><label>Дата начала</label></td>
                    <td>${conference.getDateOfStartShow()}</td>
                </tr>
                <tr>
                    <td><label>Дата окончания</label></td>
                    <td>${conference.getDateOfEndShow()}</td>
                </tr>
                <tr>
                    <td><label>Город</label></td>
                    <td>${conference.getCity()}</td>
                </tr>
                <tr>
                    <td><label>Уровень</label></td>
                    <td>${conference.getLevel()}</td>
                </tr>
            </#list>
        </table>
        </#if>
        <a href="javascript:PopUpHide(4)" class="aclass">Закрыть</a>
    </div>
</div>

<div class="b-popup" id="popup5" style="overflow: scroll;">
    <div class="b-popup-content">
        <#if science??>
            <table style="background-color: white;font-size: 30px;border-spacing: 20px 30px;border-collapse: separate;">
                <#list scienceWorkList as scienceWork>
                    <tr>
                        <td><h2>${scienceWork.getNameOfWork()}</h2></td>
                    </tr>
                    <tr>
                        <td><label>Тип работы</label></td>
                        <td>${scienceWork.getTypeOfWork()}</td>
                    </tr>
                    <tr>
                        <td><label>Название журнала</label></td>
                        <td>${scienceWork.getNameOfJournal()}</td>
                    </tr>
                    <tr>
                        <td><label>Том</label></td>
                        <td>${scienceWork.getTom()}</td>
                    </tr>
                    <tr>
                        <td><label>Страницы</label></td>
                        <td>${scienceWork.getPages()}</td>
                    </tr>
                    <tr>
                        <td><label>Номер журнала</label></td>
                        <td>${scienceWork.getNumberOfJournal()}</td>
                    </tr>
                    <tr>
                        <td><label>Год публикации</label></td>
                        <td>${scienceWork.getYearOfPublication()}</td>
                    </tr>
                    <tr>
                        <td><label>РИНЦ</label></td>
                        <#if scienceWork.isRinc() == true>
                        <td>Да</td>
                        <#else>
                        <td>Нет</td>
                        </#if>
                    </tr>
                    <tr>
                        <td><label>SCOPUS</label></td>
                        <#if scienceWork.isScopus() == true>
                        <td>Да</td>
                        <#else>
                        <td>Нет</td>
                        </#if>
                    </tr>
                </#list>
            </table>
        </#if>
        <a href="javascript:PopUpHide(5)" class="aclass">Закрыть</a>
    </div>
</div>

<div class="b-popup" id="popup6" style="overflow: scroll;">
    <div class="b-popup-content">
        <#if educational??>
            <table style="background-color: white;font-size: 30px;border-spacing: 20px 30px;border-collapse: separate;">
                <#list educationalWorkList as educationalWork>
                    <tr>
                        <td><h2>${educationalWork.getNameOfWork()}</h2></td>
                    </tr>
                    <tr>
                        <td><label>Тип работы</label></td>
                        <td>${educationalWork.getTypeOfWork()}</td>
                    </tr>
                    <tr>
                        <td><label>Количество страниц</label></td>
                        <td>${educationalWork.getAmountOfPages()}</td>
                    </tr>
                    <tr>
                        <td><label>Год издания</label></td>
                        <td>${educationalWork.getYearOfPublication()}</td>
                    </tr>
                    <tr>
                        <td><label>Издательство</label></td>
                        <td>${educationalWork.getPublishing()}</td>
                    </tr>
                </#list>
            </table>
        </#if>
        <a href="javascript:PopUpHide(6)" class="aclass">Закрыть</a>
    </div>
</div>
</body>