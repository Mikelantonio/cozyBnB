CREATE TABLE `reviews`(
 `id` BIGINT UNSIGNED NOT NULL,
 `rating` INT NOT NULL,
 `comment` VARCHAR(255) NOT NULL,
 primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `reservations`(
 `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
 `user_id` BIGINT UNSIGNED NOT NULL,
 `room_id` BIGINT UNSIGNED NOT NULL,
 `start_date` DATE NOT NULL,
 `end_date` DATE NOT NULL,
 `price` FLOAT NOT NULL,
 `total` FLOAT NOT NULL,
 `created_at` TIMESTAMP NOT NULL,
 `updated_at` TIMESTAMP NULL,
 primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `media`(
 `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
 `room_id` BIGINT UNSIGNED NOT NULL,
 `title` VARCHAR(255) NOT NULL,
 `file_url` VARCHAR(255) NOT NULL,
 `mime_type` VARCHAR(255) NOT NULL,
 primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `time_period`(
 `room_id` BIGINT UNSIGNED NOT NULL,
 `start_at` DATE NOT NULL,
 `finish_at` DATE NULL,
 primary key (`room_id`,`start_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `room_furnitures`(
 `room_id` BIGINT UNSIGNED NOT NULL,
 `furniture_id` INT UNSIGNED NOT NULL,
 primary key (`room_id`, `furniture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `furnitures`(
 `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
 `type` VARCHAR(255) NOT NULL,
 primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `room_types`(
 `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
 `type` VARCHAR(255) NOT NULL,
 primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `rooms`(
 `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
 `room_type` INT UNSIGNED NOT NULL,
 `description` TEXT NULL,
 `price` FLOAT NOT NULL,
 `total_occupancy` INT NOT NULL,
 `total_bedrooms` INT NOT NULL,
 `total_bathrooms` INT NOT NULL,
 `owner_id` BIGINT UNSIGNED NOT NULL,
 `created_at` TIMESTAMP NOT NULL,
 `updated_at` TIMESTAMP NULL,
 `published_at` TIMESTAMP NULL,
 primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `users`(
 `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(255) NOT NULL,
 `email` VARCHAR(255) NOT NULL,
 `email_verified_at` TIMESTAMP NULL,
 `password` VARCHAR(255) NOT NULL,
 `remember_token` VARCHAR(255) NULL,
 `created_at` TIMESTAMP NOT NULL,
 `updated_at` TIMESTAMP NULL,
 `phone_number` VARCHAR(255) NULL,
 `description` TEXT NULL,
 `profile_image_url` VARCHAR(255) NULL,
 primary key (`id`),
 unique (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `addresses`(
 `id` BIGINT UNSIGNED NOT NULL,
 `street` VARCHAR(255) NOT NULL,
 `city` VARCHAR(255) NOT NULL,
 `province` VARCHAR(255) NOT NULL,
 `zip` VARCHAR(255) NOT NULL,
 `country` VARCHAR(255) NOT NULL,
 `latitude` FLOAT NOT NULL,
 `longitude` FLOAT NOT NULL,
 primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `rooms` ADD CONSTRAINT `rooms_owner_id_foreign` FOREIGN KEY(`owner_id`) REFERENCES `users`(`id`);
ALTER TABLE `rooms` ADD CONSTRAINT `rooms_room_type_foreign` FOREIGN KEY(`room_type`) REFERENCES `room_types`(`id`);
ALTER TABLE `reservations` ADD CONSTRAINT `reservations_room_id_foreign` FOREIGN KEY(`room_id`) REFERENCES `rooms`(`id`);
ALTER TABLE `reservations` ADD CONSTRAINT `reservations_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE `media` ADD CONSTRAINT `media_room_id_foreign` FOREIGN KEY(`room_id`) REFERENCES `rooms`(`id`);

alter table addresses add constraint addresses_rooms_id_fk foreign key (id) references rooms (id) on update cascade on delete cascade;
alter table reviews add constraint reviews_reservations_id_fk foreign key (id) references reservations (id) on update cascade on delete cascade;
alter table time_period add constraint time_period_rooms_id_fk foreign key (room_id) references rooms (id) on update cascade;

alter table room_furnitures add constraint room_furnitures_furnitures_id_fk foreign key (furniture_id) references furnitures (id) on update cascade on delete cascade;
alter table room_furnitures add constraint room_furnitures_rooms_id_fk foreign key (room_id) references rooms (id) on update cascade on delete cascade;