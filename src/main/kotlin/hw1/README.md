# Описание
Дан интерфейс 
```
interface TestRunner { fun runTest(steps: T, test: () -> Unit) }. 
```
Класс, передаваемый в steps, содержит методы before*/after*, которые задают предусловия/чистят данные перед/после теста.
Напишите свою реализацию интерфейса TestRunner, а именно:
* Создайте класс реализующий интерфейс
    Внутри класса переопределите метод runTest
    Внутри этого метода необходимо сначала вызвать методы с before* из steps, далее прогнать тест (запустить передаваемую функцию test), и после вызвать методы с after* из steps.
    Вызовы before* и after* нужно обернуть в лог/печать в консоль.
    Проверьте работоспобоность написанного кода (можно в методе main).