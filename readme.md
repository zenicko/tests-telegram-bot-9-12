# I am the readme file and will tell about this project.
___
The project is the first step studying Jenkins.

## Acknowledgement
___
[Vasenkov Stanislav](https://github.com/svasenkov)

## About home task
___
1. Взять свой код для http://demoqa.com/automation-practice-form
2. Добавить аттачи для Allure – скриншот, page source, console.log и видео
3. Cделать сборку в Jenkins
4. В качестве ответа на нужно приложить ссылку на Allure-отчет в Jenkins (с видео)

## Steps
1. Create a structure of the project: files readme.md, .gitignore and build.gradle, directories main and test. 


## What's new
### Jenkins


## Resources

[1. Problems with coding. See comment Alex in home task of `Анна Блинова`](https://qa.guru/pl/teach/control/lesson/view?id=219025037&editMode=0)

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

## Notes of Reviewer
