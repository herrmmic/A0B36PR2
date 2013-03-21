A0B36PR2
========

Semestrální práce do předmětu A0B36PR2

Dáma

Hra se řídí podle určitých pravidel: http://cs.wikipedia.org/wiki/D%C3%A1ma_(hra).
Protihráčem uživatele je počítač nebo druhý uživatel(reprezentovaný umělou inteligencí).
Hra bude zpracovaná graficky, kde uživatel si bude moci zvolit hru s počítačem nebo s protihráčem.
V menu si také nastaví barvu kamenů a jména hráče (hráčů). 
Hráč si muže rozehranou hru ukládát a načítat ze souboru.

Třídy: 
Form1 - Grafické prostředí, kde si uživatel zvolí typ hry a nastaví jména hrače (hráčů). 

Hra - Vytvoří šachovnici(třida Sachovnice),hráče (třída Hrac) a novou hru (nebo ji načte ze souboru). Bude kontrolovat tahy uzivatele, konec hry. 
      Umožní přesun kamene a mazaní kamene. 
      
Sachovnice - Zde se vytvori sachovnice z policek (trida Policko). Každé políčko se zde střídavě obarví.

Hrac - Každý hráč bude mít své kameny(třída Kamen), jméno, typ hráče (normální/ PC) a směr pohybu po šachovnici. 
       Hráč může přesouvat kameny a přeskakovat kameny soupeře.

PC_hrac - potomek třídy Hrac bude obsahovat funkce navíc: Kam je nejvýhodnější se posunout, vyhodnocení jaký kámen má přeskočit.

Policko - potomek třídy JButton. Bude obsahovat barvu a pozici na šachovnici.

Kamen - potomek třídy Policko. Muže se posouvat v jednom směru po diagonále.

Dama - potomek třídy Kamen. Oproti obyčejnému kameni se muže posouvat po diagonále v obou směrech.
