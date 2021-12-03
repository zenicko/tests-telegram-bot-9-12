# I am the readme file and will tell about this project.
___
The project is the first step studying Jenkins.


## Acknowledgements
___
[**Vasenkov Stanislav**](https://github.com/svasenkov)

[**Artem Eroshenko**](https://github.com/eroshenkoam) 

[**Dmitrii Tuchs**](https://github.com/dtuchs)

[**Alexei Vinogradov**](https://github.com/vinogradoff)

## About home task
___
1. Взять свой код для http://demoqa.com/automation-practice-form
2. Добавить аттачи для Allure – скриншот, page source, console.log и видео
3. Cделать сборку в Jenkins
4. В качестве ответа на нужно приложить ссылку на Allure-отчет в Jenkins (с видео)

## Steps
1. Create a structure of the project: files readme.md, .gitignore and build.gradle, directories main and test. 
2. Set dependencies JUnit5, Selenide and Allure Report in build.gradle. Checked sets by test class `ExTests`.
3. Include the code testing of the form from [demoqa.com](https://demoqa.com/automation-practice-form). Make some srceenshots.
4. Create methods of logging.
5. Change build.gradle, add ex-logging.
6. Add using selenoid.
7. Change method upload file in the form
8. Change version of selenide from 5.25 to 5.24. Unwork uploadFromClasspath. 

## What's new
### Jenkins


## Resources

[1. Problems with view of russian letters in a console. 
See Alex' comment in hometask of `Анна Блинова`](https://qa.guru/pl/teach/control/lesson/view?id=219025037&editMode=0)

**Or here)**

Alex
Добрый вечер.
Скорее всего, у Вас проблемы с кодировкой. Как лечится:

Что нужно сделать, чтобы не было проблем с кодировкой UTF-8 и отображением непонятных символов:
1) В IDE в верхней панели меню нажать Help → Edit Custom VP Options и добавить в конец текста две строчки:
-Dconsole.encoding=UTF-8
-Dfile.encoding=UTF-8
2) Далее в IDE зайти в меню File → Settings → Editor → File Encodings:
в верхних двух полях должно стоять UTF-8, в самой нижней with NO BOM → Далее сохранить изменения. (скрин данного меню закреплен)
3) В файл build.gradle после блока с репозиторием добавить блок:
compileJava {
options.encoding = 'UTF-8'
}
compileTestJava {
options.encoding = 'UTF-8'
}
P.s. Строка и блок кода "compileJava" относится к коду и выводу в терминал из папки main->Java , а блок кода "compileTestJava" к коду test->Java
4) Обновить градл после внесенных изменений.
5)Перезапустить IDE (полностью выйти из нее и зайти заново)
Всё, теперь можно запускать код, должно всё корректно отображаться ) 

[2. Get Allure Gradle Plugun](https://plugins.gradle.org/plugin/io.qameta.allure)
`id "io.qameta.allure" version "2.9.6"`

[3. Docs Allure](https://docs.qameta.io/allure-report/frameworks/java/junit5)



https://gitter.im/allure-framework/allure-core?at=5b728c33937eee242315c1f2

@Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
public static byte[] getPageSource() {
return getPageSourceBytes();
}

public static byte[] getPageSourcetBytes() {
return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
}

lifeCycle.addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh-mm-ss")),
"image/png", "png", takeScreenShot());

## Notes of Reviewer




