# I am the readme file and will tell about this project.
___
The project is the first step studying Jenkins.
Oh... It's the second step therefore this is the hometask 11! 

[See the readme file of the hometask 10](https://github.com/zenicko/tests-jenkins-9-10#i-am-the-readme-file-and-will-tell-about-this-project)

## Acknowledgements
___
[**Vasenkov Stanislav**](https://github.com/svasenkov)

## About home task
___
1. Доработать свой код:

1.1 Передать из дженкинса адрес удаленного браузера

1.2 Спрятать логин/пароль к удаленному браузеру в .properties файл, считывать его нужно в коде с owner


2. Групповое дз:

2.1 Сделать сборку в дженкинсе на код коллеги (тест должен успешно пройти)

2.2 Подготовить код, чтобы на ваши тесты коллега сделал сборку с дженкинс.
## Steps
1. Update the readme file.
2. Create the class `SystemPropertiesTests.java`. Pass parameters to a test from a command line gradle.

## What's new
### Jenkins
### Gradle
1. See all tasks
   `gradlew.bat tasks --all`


### Git
1. Remote repository
   `git remote add <shotname> <URL>`
2. Get data from a remote repository
   `git fetch <shotname>`
3. Merge a branch of a local repository with a remote repository.
   `git merge <shotname>/<a branch name of a remote repository>`
   Note: don't forget do `get checkout`.
4. 


## Resources
https://stackoverflow.com/questions/11696521/how-to-pass-arguments-from-command-line-to-gradle/58202665#58202665

task(runProgram, type: JavaExec) {

[...]

if (project.hasProperty('myargs')) {
args(myargs.split(','))
}


plugins {
id 'application'
}

mainClassName = "my.App"

public class App {
public static void main(String[] args) {
System.out.println(args);
}
}

gradlew run --args="This string will be passed into my.App#main arguments"
## Notes of Reviewer




