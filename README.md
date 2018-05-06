# popular-stepik-courses

Приложение на языке Kotlin, которое выводит на экран заданное количество `N` самых популярных курсов на платформе Stepik.

## Инструкция по запуску

Основной класс -- `Main.kt`. При запуске будет предложено ввести единственное неотрицательное целое число -- количество самых популярных курсов.

При желании сборку и запуск можно осуществить из командной строки:
```
git clone https://github.com/AlexVanGogen/popular-stepik-courses.git
cd popular-stepik-courses/
gradle installDist
sh run.sh   # для повторного запуска достаточно этой команды
```

## Работа программы

После того, как пользователь ввел число `N`, на экран будет выведена информация об `N` самых популярных курсах на платформе в порядке убывания количества студентов.

Формат вывода:

```
Course title: <название курса> (<количество студентов>)
    Start date: <дата и время старта курса по московскому времени>
    Summary: <описание курса>
    Workload: <время, которое рекомендуется тратить на обучение>
    Authors:
        <автор курса>
        <автор курса>
        ...
```

Из-за особенностей API Stepik'а программа работает несколько минут (о чем она предупреждает пользователя)

### Пример работы программы (по состоянию на 6 мая, 23:00)

```
How many popular courses do you want to see?
3                                           // пользовательский ввод
Get 3 most popular courses
Please wait, this request may take a long time... (approx. 4 minutes)

Course title: Программирование на Python (99154 students)
	Start date: Tue Sep 02 16:06:26 MSK 2014
	Summary: Курс посвящен базовым понятиям и элементам языка программирования Python (операторы, числовые и строковые переменные, списки, условия и циклы). Курс является вводным и наиболее подойдет слушателям, не имеющим опыта написания программ ни на одном из языков программирования.
	Workload: 3-6 часов в неделю
	Authors:
		Bioinformatics Institute

Course title: TOEFL vocabulary (92834 students)
	Start date: Thu Jun 29 20:08:42 MSK 2017
	Summary: Adaptive problem set to check your knowledge of the most important words for the TOEFL. Join the course and try out the first prototype of the adaptive engine!
	Workload: undefined
	Authors:
		Asya Samsonova

Course title: Введение в программирование (C++) (65586 students)
	Start date: Mon Sep 07 23:06:27 MSK 2015
	Summary: Основы программирования на C++ на примере множества несложных практических задач.
	Workload: 4-5 часов на урок, начиная с третьего урока
	Authors:
		Академия Яндекса
		Высшая школа экономики (НИУ ВШЭ)

```