# Тестовое задание для "Динамика"
## Как запустить?
    
## Подготовка
### - Заходим в директорию проекта
### - Создаем в папке resources файл ".env"

#### Пример файла
```sh
POSTGRES_USERNAME=Имя_пользователя
POSTGRES_PASSWORD=Пароль_пользователя
POSTGRES_HOST=Имя_хоста
POSTGRES_DATABASE=Название_базы_данных
```

## Сборка проекта
### - Заходим через консоль в директорию проекта
### - Пишем следующую команду
```sh
mvn clean package  
```

### - Появится папка target
### - Заходим в нее
### - Запускаем jar архив
```sh
java -jar .\Library-1.0-SNAPSHOT.jar
```

