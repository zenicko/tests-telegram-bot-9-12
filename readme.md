# I am the readme file and will tell about this project.
___
The project uses sending the notification to messengers and email.
The project based on [the hometask 11 "Управляем параметрами в коде и в Jenkins"](https://github.com/zenicko/tests-jenkins-params-9-11.git)

## Acknowledgements
___
[**Vasenkov Stanislav**](https://github.com/svasenkov)

## About home task
___
1. Создайте проект с любыми автотестами, либо возьмите уже созданный.
2. Создайте задачу в Jenkins
3. Зарегистрируйте бота в Telegram, создайте чат и добавьте бота в него.
4. Добавьте бота к вашему проекту.

Для выполнения домашнего задания нужно приложить скриншот из телеграм-чата 
с нотификацией о прохождении автотестов в поле ответа.

## Steps
1. Created a project by repo the hometask 11.Управляем параметрами в коде и в Jenkins
2. Update classes of the project and fixed bug.
3. Created the direction `notification' with a config file and a jar-file. 
Created the notification to telegram
4. Created the notification to slack. Set Jenkins' settings for notifications telegram and slack.

## What's new
### Jenkins
### Allure-notifications
1. Command 
```
java  \
"-DprojectName=PROJECT_NAME" \
"-Denv=ENVIRONMENT" \
"-DreportLink=BUILD_URL" \
"-Dcomm=Any comment here" \
"-Dconfig.file=notification/telegram.json" \
-jar notification/allure-notifications-3.1.2.jar
```
`java  "-DprojectName=PROJECT_NAME" "-Denv=ENVIRONMENT" "-DreportLink=BUILD_URL" "-Dcomm=Any comment here" "-Dconfig.file=notification/telegram.json" -jar notification/allure-notifications-3.1.2.jar`
### Shell
1. Check on existing of a file- 
```
cd ..
FILE=./allure-notifications-3.1.2.jar
if [ ! -f "$FILE" ]; then
   wget https://github.com/qa-guru/allure-notifications/releases/download/3.1.2/allure-notifications-3.1.2.jar
fi

```



### Gradle
### Git
## Resources
[Ссылка на репозиторий](https://github.com/qa-guru/qa_guru_9_10_jenkins/tree/notifications)
[Jenkins](https://jenkins.autotests.cloud/job/teacher-iTerkin-qa_guru_9_12_jenkins_telegram/)
Зарегистрировать бота в Telgram `@BotFather`

Узнать chat ID (вместо Your_BOTToken вставить токена вашего бота) `https://api.telegram.org/bot{secret_bot}/getUpdates`

[Repo Allure notifications](https://github.com/qa-guru/allure-notifications)
## Notes of Reviewer




