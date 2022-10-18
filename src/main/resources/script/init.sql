CREATE TABLE `seller` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,

                        `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                        `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                        `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                        `role` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,

                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO seller (name, email, password, role) VALUES ('seller1', 'seller1@test.com', '12345678', 'ROLE_USER');
INSERT INTO seller (name, email, password, role) VALUES ('seller2', 'seller2@test.com', '12345678', 'ROLE_USER');

CREATE TABLE `buyer` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,

                          `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                          `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                          `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
                          `role` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,

                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;