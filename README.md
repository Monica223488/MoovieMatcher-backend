
# MoovieMatcher – Backend

Dit is de backend van MoovieMatcher, een webapplicatie waarmee gebruikers films kunnen ontdekken en hun favoriete films kunnen opslaan.

De backend verzorgt de registratie en authenticatie van gebruikers en het beheren van opgeslagen films.

## Technologieën

- Java
- Spring Boot
- PostgreSQL
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA

## Functionaliteiten

- Gebruikers registreren en inloggen
- Authenticatie met JWT
- Favoriete films opslaan, ophalen en verwijderen
- Gebruikersgegevens en opgeslagen films beheren in een PostgreSQL-database
- Beveiligde API-endpoints

## API-endpoints

| Methode | Endpoint | Beschrijving |
|---------|----------|--------------|
| POST | `/auth/register` | Nieuwe gebruiker registreren |
| POST | `/auth/login` | Gebruiker inloggen |
| GET | `/saved-movies` | Opgeslagen films ophalen |
| POST | `/saved-movies` | Film opslaan |
| DELETE | `/saved-movies/{id}` | Opgeslagen film verwijderen |

De endpoints voor opgeslagen films zijn beveiligd met JWT-authenticatie.

## Frontend

De frontend is ontwikkeld met React en TypeScript.

**Live website:** https://mooviematcher.nl

**Frontend repository:** [MoovieMatcher Frontend](https://github.com/Monica223488/eindopdracht-frontend)
