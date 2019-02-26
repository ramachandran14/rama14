CREATE TABLE web_address_service (
	PRIMARY KEY (id),
    `id`             BIGINT(20)     AUTO_INCREMENT,
    `street`         VARCHAR(100)   NOT NULL,
    `city`           VARCHAR(15)    NOT NULL,
    `postal_code`    INT(11)        NOT NULL
);

CREATE TABLE web_person_service (
    PRIMARY KEY (id),
    `id`             BIGINT(20)     AUTO_INCREMENT,
    `first_name`     VARCHAR(50)    NOT NULL,
    `last_name`      VARCHAR(50)    NOT NULL,
    `email`          VARCHAR(100)   UNIQUE,
    `birth_date`     DATE           NOT NULL,
    `password`       VARCHAR(20)    UNIQUE NOT NULL,
    `is_admin`       VARCHAR(10)    NOT NULL,
    `created_date`   DATETIME       NOT NULL,
    `address_id`     BIGINT(20),
    				 KEY k_web_person_service_web_address_service(`address_id`),
					 CONSTRAINT fk_web_person_service_web_address_service 
					 FOREIGN KEY (`address_id`) REFERENCES web_address_service (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
    
