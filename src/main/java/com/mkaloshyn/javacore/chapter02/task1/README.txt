Задание 1

Необходимо реализовать коллекцию целых чисел, которая позволяет выполнять операции:
●	добавления
●	удаления
●	поиска элемента по значению
●	поиска элемента по индексу
●	поиска максимального элемента
●	поиска минимального элемента
●	поиска среднего арифметического всех элементов
При этом:
●	при добавлении нового элемента все элементы увеличивают своё значение на добавляемый элемент
●	при удалении - уменьшают своё значение на удаляемый элемент
Недопустим ввод в коллекцию null, символов и других значений, кроме целых чисел.
Результатом работы должен быть отдельный репозиторий github/bitbucket с README файлом, который описывает задание, сам класс и содержит инструкции по запуску приложения.


Class MyCollection - realization of collection sort of ArrayList.

Instruction:
- Create object of MyCollection class conveying array of ints into constructor.
- Apply one of the following methods to created object:

1. addElement(int element), returns: void - adding element to the tail

2. addElementIncremental(int element), returns: void  - adding element to the tail and increasing the value
of other elements by value of element added

3. addByIndexIncremental(int index, int element), returns: void - adding element to the determined position
 and increasing value of other elements by value of the element added

4. deleteByIndex(int index), returns: void - deleting element by its index

5. deleteByValue(int value), returns: void - deleting element by its value (the first matching only)

6. deleteByIndexDecremental(int index), returns: void - deleting element by its index and decreasing
value of other elements by value of the element deleted

7. deleteByValueDecremental(int value), returns: void - deleting element by its value (first matching)
 and decreasing value of other elements by value of the element deleted

8. findElementByIndex(int index), returns: Integer - finding element by its index

9. findElementByValue(int value), returns: int - finding index of element by its value (the first matching)

10. findMin(), returns: Integer - finding min value among elements

11. findMax(), returns: Integer - finding max value among elements

12. findAverage(), returns: Double - finding average among not null elements