CREATE TABLE hero_template(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    hero_type INT,
    health_points INT,
    power INT,
    armor INT,
    rarity INT,
);

CREATE TABLE fight(
    id INT PRIMARY KEY AUTO_INCREMENT,
    attacking_hero_id INT,
    defending_hero_id INT,
    attacker_win BOOLEAN
);

CREATE TABLE player(
    id INT PRIMARY KEY AUTO_INCREMENT,
    pseudo varchar(50),
    chip_number INT,
    win_count INT
);

CREATE TABLE pack(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(50),
    price INT,
    card_number INT,
    legendary_percentage INT,
    rare_percentage INT,
    common_percentage INT
);

CREATE TABLE hero(
    id INT PRIMARY KEY AUTO_INCREMENT,
    experience_point INT,
    player_id INT,
    hero_id INT,
    level INT
);
