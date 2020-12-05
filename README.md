Для запуска тестов необходимо:
1) Запустить контейнер с БД, выполнив в корневой директории проекта docker-compose up
2) Запустить jar-ник с приложением, выполнив java -jar .\artifacts\app-deadline.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app -P:jdbc.user=app -P:jdbc.password=9mREsvXDs9Gk89Ef

Важно:
Если вы запускаете тесты в новой сессии (когда заного запускаете jar-ник) необходимо удалять папку data.
