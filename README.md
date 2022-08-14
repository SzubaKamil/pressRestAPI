# pressRestAPI
Proste REST API dla artykułów prasowych

# Uruchomienie
  - Należy utworzyć baze danych MQSQL przed pierwszym uruchomieniem z pliku - <a href="https://github.com/SzubaKamil/pressRestAPI/blob/main/databaseScript/createMySQLDatabase.txt">skrypt</a>
  - Projekt maven-a wszystkie niezbędne zależności w pliku <a href="https://github.com/SzubaKamil/pressRestAPI/blob/main/pom.xml">pom.xml</a>
  
# Technologie
  - JDK 11
  - SpringBoot 2.7.2
  - mysql-connector-java 8.0.29
  - hibernate-core 6.1.2.Final
 
# BAZA DANYCH
  Dla kolumn w tabeli article przyjęto: 
  - content - treść publikacji   - Kolumna  tekstowa o rozmiarze nie przekraczającym 16 777 215 bajtów
  - title   - tytuł publikacji       - Pole znakowe o długości max 100 znaków  
  - name    - nazwę czasopisma			 - Pole znakowe o długości max 100 znaków
  - author  - imie nazwisko          - Pole znakowe o długości max 100 znaków
  
 # ENDPOINT 
  - GET http://host/api/articles                        - zwracający wszystkie artykuły prasowe posortowane malejąco po dacie publikacji
  - GET http://host/api/articles/{id}                   - zwracający pojedynczy artykuł prasowy po id -> id przyjęto zakres zmiennej int
  - GET http://host/api/articles/content/{content}      - zwracający listę wszystkich artykułów prasowych po słowie kluczowym zawartym w treści publikacji
  - GET http://host/api/articles/title/{title}          - zwracający listę wszystkich artykułów prasowych po słowie kluczowym zawartym w tytule publikacji
  - POST http://host/api/{articles}                     - pozwalający na zapis artykułu prasowego, artykuł przekazy w JSON
  - PUT http://host/api/{articles}                      - pozwalający na aktualizacje artykułu prasowego, artykuł przekazy w JSON
  - DELETE http://host/api/{id}                         - pozwalający na aktualizacje artykułu prasowego, artykuł przekazy w JSON
    
    
 # JSON
 {"id":1,  
    "content":"content",  
    "datePublication":"yyyy-MM-dd",  
    "title":"title",  
    "name":"name",  
    "author":"author"  
 }
