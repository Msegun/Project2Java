[![Build Status](https://travis-ci.com/TestowanieJAVA2017-2018Gr2/projekt2-Msegun.svg?token=Sx7JteW932SkMFhDodrt&branch=master)](https://travis-ci.com/TestowanieJAVA2017-2018Gr2/projekt2-Msegun)

[![BCH compliance](https://bettercodehub.com/edge/badge/Msegun/Project2Java?branch=master)](https://bettercodehub.com/)


[![Maintainability](https://api.codeclimate.com/v1/badges/5ccd11e6a6436092112b/maintainability)](https://codeclimate.com/github/Msegun/Project2Java/maintainability)


# Testowanie aplikacji JAVA 2017-2018
## Projekt 2 (Maven, JUnit oraz atrapy) 

-----------------------
### REGUŁY GRY

1. Wybieramy **jedno** z poniższych zadań. Zadania różnią się poziomem trudności i są inaczej punkto-
wane. 

2. Każdy projekt ma być wykonany przy użyciu narzędzia Maven! Projekt **nie powinien zawierać pliku jar oraz folderu
target**.

3. Przesyłanie projektu będzie odbywało się przy pomocy utworzenia Issue w swoim repozytorium. Utworzenie Issue wiąże się z oddanym projektem. Wszelkie zmiany po Issue będą obcinane.

**TERMIN: 07.05.2018**

- **Spóźnienia** z terminem będą wiązały się z **mniejszą ilością punktów**.
- **Maksymalny deadline** to **11.05.2018** i wtedy obowiązuje **50%** punktów z projektu. A więc dzień zwłoki oznacza obniżenie progu o **10%**. Po tym terminie projekty liczone są na **0%**!
- Projekt, w którym nie będzie wykonywało się polecenie **mvn test** będzie liczony na **0%**!
- Ponadto pod ocenę będzie brany styl projektu: jak zapisane są testy i jak sprawdzane są asercje.
- Testy powinny wykorzystywać wiele różnych asercji (a nie tylko assertEquals)!
- Ponadto po sprawdzeniu projektu należy go obronić: będą to krótkie pytania i ewentualne drobne
zmiany w kodzie podane przez prowadzącego!

-----------------------

**Projekt 1** (12 pkt)

W pliku **Device.java** znajduje się interfejs panelu sterującego odtwarzaczem MP3. Utwórz
klasę wypełniając metody z interfejsu i przetestuj działanie odtwarzacza MP3. Przykładowa klasa
testująca znajduje się w pliku **DeviceTest.java**.
Pod ocenę będą brane pod uwagę następujące elementy:
- (0.5 pkt) Kompilacja i uruchomienie bezbłędne projektu + konfiguracja TravisCi.
- (1 pkt) Uwzględnienie wymagań interfejsu.
- (3 pkt) Przypadki testowe (uwzględniające wyjątki).
- (2 pkt) Przetestowanie przy użyciu ręcznie stworzonych atrap (co najmniej 5 testów)
- (2 pkt) Przetestowanie przy użyciu Mockito (co najmniej 5 testów).
- (2 pkt) Przetestowanie przy użyciu EasyMock (co najmniej 5 testów).
- (0.5 pkt) Pokrycie kodu (w przypadku ręcznie stworzonych atrap).
- (1 pkt) Styl kodu.

Ponadto, jako punkty dodatkowe będą brane następujące elementy: 
- (1 pkt) Użycie różnych rodzaji atrap.
- (1 pkt) Wynik z portalu BetterCodeHub.
- (2 pkt) Inne technologie dotyczące atrap, nie pokazywane na zajęciach (co najmniej po 5 testów każda z nich).
- (1 pkt) Integracja repozytorium z dowolnym serwisem.
- (1 pkt) Użycie JUnit5.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za podpunkt od obowiązkowej
punktacji zadania!)
- Historia projektu w repozytorium.
- Różnorodne asercje (co najmniej 5 różnych).
- Struktura projektu.

-----------------

**Projekt 2** (14 pkt)

Przetestuj przy użyciu atrap klasę, która wygląda następująco: 

```
public class UserServiceImpl{
  private UserDAO userDAO;
  privare Security secuirty;
  
  public void assignPassword(User user) throws Exception {
    String passwordMD5 = security.md5(user.getPassword());
    user.setPassword(passwordMD5);
    userDAO.updateUser(user);
  }
  
  public UserServiceImpl(UserDAO dao, Security security){
    this.UserDAO = dao;
    this.security = security;
  }
  
}
```

Pod ocenę będą brane pod uwagę następujące elementy:
- (0.5 pkt) Kompilacja i uruchomienie bezbłędne projektu + konfiguracja TravisCi.
- (1 pkt) Uwzględnienie wymagań interfejsu.
- (4 pkt) Przypadki testowe (uwzględniające wyjątki).
- (3 pkt) Przetestowanie przy użyciu ręcznie stworzonych atrap (co najmniej 7 testów)
- (2 pkt) Przetestowanie przy użyciu Mockito (co najmniej 7 testów).
- (2 pkt) Przetestowanie przy użyciu EasyMock (co najmniej 7 testów).
- (0.5 pkt) Pokrycie kodu (w przypadku ręcznie stworzonych atrap).
- (1 pkt) Styl kodu.

Ponadto, jako punkty dodatkowe będą brane następujące elementy: 
- (1 pkt) Użycie różnych rodzaji atrap.
- (1 pkt) Wynik z portalu BetterCodeHub.
- (2 pkt) Inne technologie dotyczące atrap, nie pokazywane na zajęciach (co najmniej po 5 testów każda z nich).
- (1 pkt) Integracja repozytorium z dowolnym serwisem.
- (1 pkt) Użycie JUnit5.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za podpunkt od obowiązkowej
punktacji zadania!)
- Historia projektu w repozytorium.
- Różnorodne asercje (co najmniej 5 różnych).
- Struktura projektu.

-----------------

**Projekt 3** (16 pkt)

Jesteś deweloperem piszącym fragment (bardzo uproszczonej) aplikacji (tutaj klasy **Messenger**) wysyłającej komunikaty do serwera. Twoja klasa korzysta z implementacji interfejsu **MessageService**. Zadaniem twojej aplikacji (uwaga: często spotykane w praktyce) jest m.in. ukrywanie statusów oraz wyjątków generowanych przez wykorzystywane komponenty takie jak **MessageService**. Zgodnie z życzeniem klienta twoja metoda odpowiedzialna za wysyłanie komunikatów ma zwracać liczby:
- 0 gdy powodzenie
- 1 gdy występują problemy z wysłaniem
- 2 gdy adres serwera lub komunikat jest niewłaściwie zbudowany
Klasa **Messenger** powinna też dostarczać metodę do testowania połączenia z serwerem zwracającym
liczby:
- 0 w przypadku sukcesu
- 1 w przeciwnym przypadku
Szkielet systemu jest zaimplementowany w pliku **messenger.zip**.
Dokończ klasę **Messenger**, a następnie przy użyciu poznawanych technologii przeprowadź testy
jednostkowe w tzw. izolacji (czyli bez gotowej implementacji **MessageService**)

Pod ocenę będą brane pod uwagę następujące elementy:
- (0.5 pkt) Kompilacja i uruchomienie bezbłędne projektu + konfiguracja TravisCi.
- (2 pkt) Uwzględnienie powyższych wymagań.
- (3 pkt) Przypadki testowe (uwzględniające wyjątki).
- (3 pkt) Przetestowanie przy użyciu ręcznie stworzonych atrap (co najmniej 6 testów, różnych od pozostałych)
- (3 pkt) Przetestowanie przy użyciu Mockito (co najmniej 6 testów, różnych od pozostałych).
- (3 pkt) Przetestowanie przy użyciu EasyMock (co najmniej 6 testów, różnych od pozostałych).
- (0.5 pkt) Pokrycie kodu (w przypadku ręcznie stworzonych atrap).
- (1 pkt) Styl kodu.

Ponadto, jako punkty dodatkowe będą brane następujące elementy: 
- (1 pkt) Użycie różnych rodzaji atrap.
- (1 pkt) Wynik z portalu BetterCodeHub.
- (2 pkt) Inne technologie dotyczące atrap, nie pokazywane na zajęciach (co najmniej po 5 testów każda z nich).
- (1 pkt) Integracja repozytorium z dowolnym serwisem.
- (1 pkt) Użycie JUnit5.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za podpunkt od obowiązkowej
punktacji zadania!)
- Historia projektu w repozytorium.
- Różnorodne asercje (co najmniej 5 różnych).
- Struktura projektu.

--------------------------------------------------

**Projekt 4** (20 pkt)

Rozważmy grę w kółko i krzyżyk (lub czwórki czy statki) z poprzedniego projektu. Teraz dodajmy do tej gry bazę **MongoDB** z użyciem **Jongo** (patrz przykład wykorzystany w atrapach) Dopiszmy do
niej odpowiednie wymagania:
- Dodaj opcję umożliwiającą zapisanie posunięcia z numerem kolejki, pozycjami na planszy/mapie oraz ewentualnie symbol gracza (w przypadku gier).
- Zapisuj każdy ruch w bazie danych i zapewnij to, że utworzenie nowej sesji spowoduje usunięcie
starszych danych.

Pod ocenę będą brane pod uwagę następujące elementy:
- (0.5 pkt) Kompilacja i uruchomienie bezbłędne projektu + konfiguracja TravisCi.
- (3 pkt) Uwzględnienie powyższych wymagań.
- (5 pkt) Przypadki testowe (uwzględniające wyjątki).
- (4 pkt) Przetestowanie przy użyciu ręcznie stworzonych atrap (co najmniej 8 testów, różnych od pozostałych)
- (3 pkt) Przetestowanie przy użyciu Mockito (co najmniej 8 testów, różnych od pozostałych).
- (3 pkt) Przetestowanie przy użyciu EasyMock (co najmniej 8 testów, różnych od pozostałych).
- (0.5 pkt) Pokrycie kodu (w przypadku ręcznie stworzonych atrap).
- (1 pkt) Styl kodu.

Ponadto, jako punkty dodatkowe będą brane następujące elementy: 
- (1 pkt) Użycie różnych rodzaji atrap.
- (1 pkt) Wynik z portalu BetterCodeHub.
- (2 pkt) Inne technologie dotyczące atrap, nie pokazywane na zajęciach (co najmniej po 5 testów każda z nich).
- (1 pkt) Integracja repozytorium z dowolnym serwisem.
- (1 pkt) Użycie JUnit5.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za podpunkt od obowiązkowej
punktacji zadania!)
- Historia projektu w repozytorium.
- Różnorodne asercje (co najmniej 5 różnych).
- Struktura projektu.

--------------------------------------------

**Projekt 5** (22 pkt)

Przetestuj system rezerwacji z poprzedniego projektu, zakładając, że wszystko odbywa się w jakimś systemie bazodanowym. Na przykład mogą się zdarzyć następujące sytuacje: 

- Wyświetlenie wszystkich rezerwacji danego użytkownika.
- Wyświetlenie możliwych wolnych miejsc do dokonania rezerwacji.
- Rezerwacja poprzez nazwę użytkownika.
- Logowanie użytkownika
- I wiele wiele innych

Pod ocenę będą brane pod uwagę następujące elementy:
- (0.5 pkt) Kompilacja i uruchomienie bezbłędne projektu + konfiguracja TravisCi.
- (4 pkt) Uwzględnienie powyższych wymagań.
- (6 pkt) Przypadki testowe (uwzględniające wyjątki).
- (4 pkt) Przetestowanie przy użyciu ręcznie stworzonych atrap (co najmniej 8 testów, różnych od pozostałych)
- (3 pkt) Przetestowanie przy użyciu Mockito (co najmniej 8 testów, różnych od pozostałych).
- (3 pkt) Przetestowanie przy użyciu EasyMock (co najmniej 8 testów, różnych od pozostałych).
- (0.5 pkt) Pokrycie kodu (w przypadku ręcznie stworzonych atrap).
- (1 pkt) Styl kodu.

Ponadto, jako punkty dodatkowe będą brane następujące elementy: 
- (1 pkt) Użycie różnych rodzaji atrap.
- (1 pkt) Wynik z portalu BetterCodeHub.
- (2 pkt) Inne technologie dotyczące atrap, nie pokazywane na zajęciach (co najmniej po 5 testów każda z nich).
- (1 pkt) Integracja repozytorium z dowolnym serwisem.
- (1 pkt) Użycie JUnit5.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za podpunkt od obowiązkowej
punktacji zadania!)
- Historia projektu w repozytorium.
- Różnorodne asercje (co najmniej 5 różnych).
- Struktura projektu.


-------------------------------------------

**Projekt 6** (25 pkt)

Rozważmy bardzo uproszczoną aplikacje w sklepie internetowym, która jest opisana danym diagramem związków encji:
![Diagram ERD](https://inf.ug.edu.pl/~mmiotk/Dydaktyka/2016-2017/TAJAVA2016-2017/ERD.png)

Dane do bazy mają być przechowywane w jakimś systemie bazodanowym. Zaimplementuj odpowiednie metody tej aplikacji i przetestuj ją uwzględniając wymagania zawarte w diagramie używając atrap.

Pod ocenę będą brane pod uwagę następujące elementy:
- (0.5 pkt) Kompilacja i uruchomienie bezbłędne projektu + konfiguracja TravisCi.
- (4 pkt) Uwzględnienie powyższych wymagań.
- (6 pkt) Przypadki testowe (uwzględniające wyjątki).
- (5 pkt) Przetestowanie przy użyciu ręcznie stworzonych atrap (co najmniej 10 testów, różnych od pozostałych)
- (4 pkt) Przetestowanie przy użyciu Mockito (co najmniej 10 testów, różnych od pozostałych).
- (4 pkt) Przetestowanie przy użyciu EasyMock (co najmniej 10 testów, różnych od pozostałych).
- (0.5 pkt) Pokrycie kodu (w przypadku ręcznie stworzonych atrap).
- (1 pkt) Styl kodu.

Ponadto, jako punkty dodatkowe będą brane następujące elementy: 
- (1 pkt) Użycie różnych rodzaji atrap.
- (1 pkt) Wynik z portalu BetterCodeHub.
- (2 pkt) Inne technologie dotyczące atrap, nie pokazywane na zajęciach (co najmniej po 5 testów każda z nich).
- (1 pkt) Integracja repozytorium z dowolnym serwisem.
- (1 pkt) Użycie JUnit5.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za podpunkt od obowiązkowej
punktacji zadania!)
- Historia projektu w repozytorium.
- Różnorodne asercje (co najmniej 5 różnych).
- Struktura projektu.

