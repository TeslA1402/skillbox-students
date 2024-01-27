# Students

## Описание

Учёт студентов

## Команды

| Команда    | Описание                                      |
|------------|-----------------------------------------------|
| help       | Справка по командам                           |
| add        | Добавить студента в формате  `Ivan Ivanov 25` |
| list       | Вывод списка студентов                        |
| remove     | Удаление студента по идентификатору           |
| remove-all | Удаление всех студентов                       |
| script     | Выполнение команд из файла                    |
| version    | Информация о версии                           |
| history    | История выполненных команд                    |
| clear      | Очистка консоли                               |
| stacktrace | Вывод полного stacktrace последней ошибки     |
| quit       | Выход из программы                            |

## Настройки

Настройки находятся в `src/main/resources/application.properties`

| Настройка         | Переменная окружения | Описание                                             | Значение по-умолчанию |
|-------------------|----------------------|------------------------------------------------------|-----------------------|
| app.student.init  | APP_STUDENT_INIT     | Заполнение списка студентов сгенерированными данными | false                 |
| app.student.count | APP_STUDENT_COUNT    | Количество студентов для генерации при старте        | 10                    |

## Maven

### Сборка

```shell
mvn install
```

### Запуск программы

```shell
java -jar ./target/skillbox-students-0.0.1-SNAPSHOT.jar
```

## Docker

### Сборка

```shell
docker build -t skillbox-students .
```

### Запуск программы

```shell
docker run --name students -it --rm skillbox-students
```

Запуск с переменной

```shell
docker run --name students -it --rm -e APP_STUDENT_INIT=true skillbox-students
```