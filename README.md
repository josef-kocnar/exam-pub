**Cíl projektu:** Vytvořit aplikaci simulující “hospodu”, která simuluje standardní chování v reálném světě.

1.	REST API
2.	Spring framework
3.	Github
4.	Mysql 8.0
5.	Návrh MVC
6.	Využití angličtiny v db návrhu i v kódu
7.	Basic auth
    - Přihlášení pro uživatele, kteří mohou objednávat
  	- Účet výčepního, který uvidí jen statistiky


**Struktura api:**
1.	GET /users
    - Vraci vsechny objekty User s atributy:
        - Id
        - Name
        - IsActive
        - IsAdult
        - Pocket
  	
3.	GET /users/{id}
    - Vraci User s danym id a jeho objednavky:
        - Id
        - Name
        - IsActive
        - IsAdult
        - Pocket
        - Orders
            - Id
            - ProductName
            - Amount
            - Price
  	
5.	GET /drink-menu
    - Vraci napojovy listek, drinky maji tyto atributy:
        - Id
        - ProductName
        - Price
        - IsForAdult

6.	POST /buy //Validace zdali je uživatel plnoletý a zdali má dostatek financí v peněžence
    - UserId
    - ProductId
    - Price
  	
5.	GET /summary
    a.	/summary/all
    - Vraci vsechny objednavky daneho produktu/drinku pro vsechny drinky a jejich celkovy soucet:
        - Product
        - Amount
        - UnitPrice
        - SummaryPrice
    b.	/summary/product
    - Vraci vsechny objednavky daneho drinku pro kazdy drink:
        - UserId
        - Amount
        - Price
    c.	/summary/user
    - Vraci vsechny objednavky daneho uzivatele pro vsechny uzivatele:
        - UserId
        - Product
        - Price
