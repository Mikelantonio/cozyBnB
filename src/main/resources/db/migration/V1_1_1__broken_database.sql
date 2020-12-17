#filename V1_1_1__broken_database.sql
CREATE TABLE `room_furnitures`(
                                  `room_id` BIGINT UNSIGNED NOT NULL,
                                  `furniture_id` INT UNSIGNED NOT NULL,
                                  primary key (`room_id`, `furniture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
