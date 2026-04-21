===================================================================================================================================================================================================================================================================================
OPIS
===================================================================================================================================================================================================================================================================================
Mahjong sky high ambition rip off w skrócie SHARP 
jest to jak nazwa mówi rip-off sky high ambition z mahjong soul.
Wszystkie assety zostały "pożyczone" z gry mahjong soul. wszystkie obrazki talizmanów (całe 244) zawdzięczam losowemu typowi z reddita, kostki typowi z gita a reszte kradłem sam z googla.
===================================================================================================================================================================================================================================================================================
INSTRUKCJA
===================================================================================================================================================================================================================================================================================
uruchamiamy gre z maina i mamy menu główne a w nim 3 guziki:
  -wyjście
  -ustawienia(rozdzielczość, fullscreen)
  -Start
po naciśnięciu start musimy znowu nacisnąć start game tym razem w innym ekranie (zawdzięczam to nieuzasadnionym problemom które rozwiązało dodanie jednego ekranu)
i mamy menu sklepu:
  lewa strona upgrade-y:
    -więcej soul kostek (extra han jak masz przy wygranej)
    -więcej otwartych czyli widzisz je w faktycznej grze
    -więcej dor (Dora jaka jest każdy widzi)
  środek:
    -5 losowej rzadkości paczek talizmanów
    -guzik refresh to wylosowania nowych paczek
    -guzik talizmany do zobacznia obecnych talizmanów:
      w menu talizmanów możemy sprzedać talizmany czy też zmieniać ich kolejność (kolejność wpływa an efekty)
    -guzik next level przechodzimy do gry
 prawa góra: licznik pieniędzy   
Gra:    
  sama góra - licznik punktów oraz % zapełnienia paska punktów
  lewa góra - wskaźniki dory
  prawa góra - menu talizmanów tym razem bez opcji sprzedania
  środek - mur kostek to te kostki dobierasz i zależnie od talizmanów itd będzie więcej otwartych, soul, zamkniętych itd.
  sam dół - twoja ręka tu są twoje kostki

  i teraz wchodzimy w świat elementów warunkowych pojawiają się jak sie coś zrobi
    -guzik switch wymienia wszystkie zaznaczone kostki
    -skip pomija faze wymieniania
    - kan guzik od kanowania
    -win guzik od wygrywania i wtedy mamy menu wygranej 
        Menu wygranej:
          -lista yaku na górze będzie lista yaku 
          - środek liczniki han fu i łącznych punktów
          - dół guzik do powrotu do gry
Gra się kończy kiedy odrzucisz swoją ostatnią kostke i zależnie od uzupełnienia licznika punktów wygrywasz i wracasz do menu sklepu i w koło albo przegrywasz.
===================================================================================================================================================================================================================================================================================
Lista Mechanik
===================================================================================================================================================================================================================================================================================
1.Prawie nieskończony gameplay. (liczba leveli jest ograniczona bo nie mogłem dać wyższego progu niż 9,223,372,036,854,775,807 bez zabawy w interpretatory stringów lub customowe zmienne a tak jest limit Long-a)
2.Jest prawie dobrze zaimplementowany yekerMeisterMKIII (autorska nazwa) czyli silnik do obliczania wszystkich tenpai i yaku w mahjongu
3.Losowe talizmany 
4.upgrady w menu sklepu
5.System Talizmanów (każdy talizman to dziecko abstrakcyjenej klasy co sprawia że dzięki polimorfiźmie moge używać ich wszystkich tak samo.
  jako że są losowe i jest ich 244 to system dynamicznie tworzy obiekty określonej klasy za pomoca cudownej linijki i 244-elementowej mapy string: klasa)
6.i zasadniczo każdy talizman to nowa mechanika
===================================================================================================================================================================================================================================================================================
Znane błędy
===================================================================================================================================================================================================================================================================================
YekerMeister nie sprawdza kompatymobilności yaku np chitoitsu a ipeikou (7 par i podwójna trójka)
YekerMeister dostaje schizofrenii i nie uznaje ręki za kompletną
Z racji ogromnej liczby 244 talizmanów nie testowałem ich tak po 20 a zatem to czy talizman działa jest praktycznie losowe.
