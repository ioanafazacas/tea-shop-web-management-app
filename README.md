<<<<<<< HEAD
# Tea Shop Management

## Descriere
Acest proiect este o aplicație web pentru gestionarea unei colecții de ceaiuri. Utilizatorii pot adăuga, edita, șterge și vizualiza ceaiurile disponibile. Aplicația include, de asemenea, un sistem de autentificare și autorizare pentru controlul accesului utilizatorilor.

## Tehnologii folosite
- **Java 17**
- **Spring Boot** ( Spring Security, Spring Data JPA)
- **Thymeleaf** (pentru frontend)
- **Hibernate** (pentru interacțiunea cu baza de date)
- **MySQL** (pentru stocarea datelor)
- **Lombok** (pentru reducerea boilerplate-ului în cod)
- **Bootstrap** (pentru stilizarea paginilor HTML)

## Funcționalități
- **Gestionarea utilizatorilor cu roluri diferite** (USER, ADMIN, DEVELOPER)
- **Adăugarea de ceaiuri noi** în baza de date
- **Editarea unui ceai existent** (descriere, preț, cantitate, imagine, categorie)
- **Ștergerea ceaiurilor**
- **Vizualizarea detaliilor unui ceai**
- **Vizualizarea listei de ceaiuri**

## API Endpoints
| Metodă | Endpoint        | Descriere |
|--------|---------------|-----------|
| GET    | `/teas`       | Afișează lista de ceaiuri |
| GET    | `/teas/detail?teaName={name}` | Afișează detalii despre un ceai |
| GET    | `/teas/create` | Formular pentru adăugarea unui ceai nou |
| POST   | `/teas/create` | Salvează un nou ceai |
| GET    | `/teas/edit?teaName={name}` | Formular pentru editarea unui ceai |
| POST   | `/teas/edit` | Actualizează datele unui ceai |
| POST   | `/teas/delete` | Șterge un ceai după nume |
| GET    | `/users`      | Afisare tuturor utilizatorilor cu cont|




>>>>>>> 09cf6d1 (initial commit)
