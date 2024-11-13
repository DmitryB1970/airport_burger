## Мини проект "Бургерная в аэропорту Шереметьево"

Перед нами стоит задача проверить работу бургерной.  
Любой пассажир в аэропорту может прийти, заказать еду, подождать и получить свой заказ.  
Ресторан состоит из официанта, кухни и платежного терминала.  
Официант умеет делать 2 действия:  
-Брать заказ у клиента и передавать запрос на кухню.  
-Отдавать с кухни готовую еду.  

Кухня умеет готовить еду - передается тип еды, а на выход сама еда.  
Кухня готовит на газу, поэтому без газа они готовить не могут.  

Платежный терминал умеет принимать оплату за заказ:  
-принимает в себя тип блюда, которое хотят оплатить  
-валюту в которой клиент хочет оплатить  
После оплаты возвращает чек.  

Терминал не принимает Мозамбикские доллары.  
Если указаны доллары, то ходит в банк и получает курс по ним (но это происходит очень долго).  

Ну и сам ресторан умеет принимать заказ и отдавать заказ.  

Раньше в ресторане готовили фуагра, но сменился повар, он готовить фуагра не умеет.
В меню фуагра осталось, поэтому в ресторане должны сообщить что приготовить такое блюдо не могут.


Наша задача написать тесты и проверить, что бургерная работает так, как мы ожидаем.  
Задачи:
1. Подключить библиотеку junit-jupiter-api и mockito-core


2. Написать тесты, которые проверяют работу кухни:  
   Ситуация №1: Был запрошен на приготовление бургер, кухня успешно приготовила бургер (бургер появился на столе готовой еды)  
   Ситуация №2: Был запрошен на приготовление бургер, на кухне выключили газ, вылетела ошибка KitchenHasNoGasException  
   Ситуация №3: Была запрошена на приготовление фуагра, вылетела ошибка UnsupportedDishTypeException


3. Написать тесты, которые проверяют работу официанта:  
   При каждодневной проверке нужно чтобы мы не заставляли реально готовить кухню (дорого просто так еду готовить!), поэтому кухня должна быть фальшивая.    
   Ситуация №1: Был запрошен бургер, официант принял заказ  
   Ситуация №2: Была запрошена фуагра, официант не принял заказ


4. Написать тесты, которые проверяют работу терминала оплаты:  
   Ситуация №1: На оплату поступил бургер, оплата в рублях. Вернулся чек с оплатой в котором указано: 300 рублей, валюта - рубль, товар - бургер.  
   Ситуация №2: На оплату поступил бургер, оплата в мозамбикских долларах, вылетела ошибка NotAcceptedCurrencyException  


5. Приехал владелец бизнеса и попросил показать работу всего ресторана. Тут уже придется кормить его по настоящему! Написать тесты, которые проверяют работу всего ресторана:  
   Ситуация №1: клиент захотел купить бургер за рубли. Заказал бургер, получил чек(300 руб, бургер, рубли), подошел за заказом, получил бургер. Проверить чек, проверить блюдо(что это именно бургер!).


6. Пришла проверка из санэпидемстанции, хочет проверить качество еды. Написать тесты, которые проверяют работу ресторана, но никакой оплаты от санэпидемстанции мы конечно же не дождемся, поэтому настоящий терминал оплаты не должен работать:  
   Ситуация №1: клиент захотел купить ребра за рубли. Заказал ребра, получил чек(700 руб, ребра, рубли), подошел за заказом, получил ребра.


7. Пришла проверка из налоговой, хочет посмотреть на то, что все заказы проходят через терминал (вдруг скрыли какие то заказы от налоговой). Необходимо написать тесты, которые проверяют работу ресторана, но кухня и официант на самом деле работать не будут, только терминал. При этом в налоговой попросили не делать запросы в банк на расчет валюты (сказали поставить 1 у.е.):  
   Ситуация №1: клиент захотел купить ребра за рубли. Заказал ребра, получил чек(сумма - 700, тип заказа - ребра, валюта - рубли).  
   Ситуация №2: клиент захотел купить картошку за доллары. Заказал картошку, получил чек(1, картошка, доллар)  
   Ситуация №3: клиент захотел купить бургер за мозамбикские доллары. Заказал бургер, получил чек(1, бургер, мозамбикский доллар)


   Внимание!!!  
   7.1. Для того чтобы написать тесты на 7 пункт, потребуется чтобы фальшивый официант всегда выдавал true при приеме заказа. Используй Mockito.any() для аргументов в методе заказа у официанта при создании заглушки.  
   7.2. Для того, чтобы заменять результаты у spy объекта, нужно пользоваться конструкцией Mockito.doReturn([что возвращаем]).when(у кого вызываем).[метод]  


