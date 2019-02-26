CREATE TABLE address_service (
	PRIMARY KEY (id),
    `id`             BIGINT(20)     AUTO_INCREMENT,
    `street`         VARCHAR(100)   NOT NULL,
    `city`           VARCHAR(15)    NOT NULL,
    `postal_code`    INT(11)        NOT NULL
);

CREATE TABLE person_service (
    PRIMARY KEY (id),
    `id`             BIGINT(20)     AUTO_INCREMENT,
    `first_name`     VARCHAR(50)    NOT NULL,
    `last_name`      VARCHAR(50)    NOT NULL,
    `email`          VARCHAR(100)   UNIQUE,
    `birth_date`     DATE           NOT NULL,
    `created_date`   DATETIME       NOT NULL,
    `address_id`     BIGINT(20),
    				 KEY k_person_service_address_service(`address_id`),
					 CONSTRAINT fk_person_service_address_service 
					 FOREIGN KEY (`address_id`) REFERENCES address_service (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
    
