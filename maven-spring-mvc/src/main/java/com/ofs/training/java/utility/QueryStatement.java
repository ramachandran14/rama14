package com.ofs.training.java.utility;

public interface QueryStatement {

        StringBuilder createQuery = new StringBuilder()
                .append(" INSERT INTO address_service(street       ")
                .append("                           , city         ")
                .append("                           , postal_code) ")
                .append(" VALUES (?,?,?)                           ");

        StringBuilder readQuery = new StringBuilder()
                .append(" SELECT   id          ")
                .append("        , street      ")
                .append("        , city        ")
                .append("        , postal_code ")
                .append(" FROM address_service ")
                .append(" WHERE id = ?         ");

        StringBuilder readAllQuery = new StringBuilder()
                .append(" SELECT id            ")
                .append("      , street        ")
                .append("      , city          ")
                .append("      , postal_code   ")
                .append(" FROM address_service ");

        StringBuilder updateQuery = new StringBuilder()
                .append("   UPDATE address_service SET street = ?")
                .append(" , city = ?                             ")
                .append(" , postal_code = ?                      ")
                .append("   WHERE id = ?                         ");

        StringBuilder deleteQuery = new StringBuilder()
                .append(" DELETE               ")
                .append(" FROM address_service ")
                .append(" WHERE id = ?         ");

        StringBuilder createQueryPerson =  new StringBuilder()
                .append("   INSERT INTO person_service (first_name  ")
                .append(" , last_name                               ")
                .append(" , email                                   ")
                .append(" , birth_date                              ")
                .append(" , address_id                              ")
                .append(" , created_date)                           ")
                .append("   VALUES(?,?,?,?,?,?)                     ");

        StringBuilder readQueryPerson = new StringBuilder()
                .append("  SELECT first_name   ")
                .append(", last_name           ")
                .append(", email               ")
                .append(", address_id          ")
                .append(", birth_date          ")
                .append(", created_date        ")
                .append("  FROM person_service ")
                .append("  WHERE id = ?        ");

        StringBuilder readAllQueryPerson = new StringBuilder()
                .append("  SELECT id           ")
                .append(", first_name          ")
                .append(", last_name           ")
                .append(", email               ")
                .append(", birth_date          ")
                .append(", created_date        ")
                .append(", address_id          ")
                .append("  FROM person_service ");

        StringBuilder updateQueryPerson =  new StringBuilder()
                .append("  UPDATE person_service ")
                .append("  SET first_name = ?    ")
                .append(", last_name = ?         ")
                .append(", email = ?             ")
                .append(", birth_date = ?        ")
                .append("  WHERE id = ?          ");

        StringBuilder deleteQueryPerson = new StringBuilder()
                .append(" DELETE               ")
                .append(" FROM  person_service ")
                .append(" WHERE id = ?         ");

        StringBuilder nameverify = new StringBuilder()
                .append(" SELECT first_name                      ")
                .append(", last_name                             ")
                .append(" FROM person_service                    ")
                .append(" WHERE first_name = ? AND last_name = ? ");

        StringBuilder emailVerify = new StringBuilder()
                .append(" SELECT email        ")
                .append(" FROM person_service ")
                .append(" WHERE email = ?     ");
}

