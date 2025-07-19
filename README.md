# JavaSort
Утилита для фильтрации входных текстовых файлов по типам данных их строк. Строка определенного типа записывается в соответствующий ее типу файл. 
## Сборка проекта (из корня надо сделать cd JavaSort)
mvn clean package
## Запуск исполняемого файла и опции
java -jar target/filterapp-1.0-SNAPSHOT.jar -o output -s input/in1.txt input/in2.txt
Выбор статистики производится опциями -s и -f соответственно.
Опция -p задает префикс имен выходных файлов.
По умолчанию файлы результатов перезаписываются. С помощью опции -a
можно задать режим добавления в существующие файлы.
## Версии Java и Maven
Java. java 24.0.1 2025-04-15
Java(TM) SE Runtime Environment (build 24.0.1+9-30)
Java HotSpot(TM) 64-Bit Server VM (build 24.0.1+9-30, mixed mode, sharing)

Maven. Apache Maven 3.9.11.
