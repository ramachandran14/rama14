package helper.files;

public interface QueryStatement {

    StringBuilder createQuery = new StringBuilder(" INSERT INTO address_service(street,city,postal_code) ")
            .append(" VALUES (?,?,?)                                                                     ");

    StringBuilder readQuery = new StringBuilder(" SELECT id, street, city, postal_code ")
            .append(" FROM address_service                                             ")
            .append(" WHERE id = ?                                                     ");

    StringBuilder readAllQuery = new StringBuilder(" SELECT id, street, city, postal_code ")
            .append(" FROM address_service                                                ");

    StringBuilder updateQuery = new StringBuilder(" UPDATE address_service SET street = ? , city = ?, postal_code = ? ")
            .append(" WHERE id = ?                                                                                    ");

    StringBuilder deleteQuery = new StringBuilder(" DELETE ")
            .append(" FROM address_service ")
            .append(" WHERE id = ?         ");

    StringBuilder createQueryPerson =  new StringBuilder()
            .append(" INSERT INTO person_service (first_name, last_name, email, birth_date, address_id, created_date, is_admin, password) ")
            .append(" VALUES(?,?,?,?,?,?)                                                                                                 ");

    StringBuilder readQueryPerson = new StringBuilder()
            .append(" SELECT first_name, last_name, email, address_id, birth_date, created_date ")
            .append(" FROM person_service                                                       ")
            .append(" WHERE id = ?                                                              ");

    StringBuilder readAllQueryPerson = new StringBuilder()
            .append(" SELECT id, first_name, last_name, email, birth_date,created_date, address_id ")
            .append(" FROM person_service                                                          ");

    StringBuilder updateQueryPerson =  new StringBuilder()
            .append(" UPDATE person_service                                        ")
            .append(" SET first_name = ?, last_name = ?, email = ?, birth_date = ? ")
            .append(" WHERE id = ?                                                 ");

    StringBuilder deleteQueryPerson = new StringBuilder()
            .append(" DELETE               ")
            .append(" FROM  person_service ")
            .append(" WHERE id = ?         ");

    StringBuilder nameverify = new StringBuilder()
            .append(" SELECT first_name, last_name           ")
            .append(" FROM person_service                    ")
            .append(" WHERE first_name = ? AND last_name = ? ");

    StringBuilder emailVerify = new StringBuilder()
            .append(" SELECT email        ")
            .append(" FROM person_service ")
            .append(" WHERE email = ?     ");

    StringBuilder validateCredentials = new StringBuilder()
            .append(" SELECT id               ")
            .append(" FROM web_service_person ")
            .append(" WHERE password = ?      ")
            .append(" AND email = ?           ");
}
