CREATE TABLE "m_user"
(
    "id"       varchar PRIMARY KEY,
    "whatsapp" varchar(20) UNIQUE
);

CREATE TYPE "weapontype" AS ENUM (
    'sword',
    'claymore',
    'staff',
    'lance',
    'bow',
    'catalyst',
    'axe'
    );

CREATE TABLE "t_weapon"
(
    "id"           varchar PRIMARY KEY,
    "character_id" varchar,
    "name"         varchar,
    "lore"         text,
    "type"         weapontype
);

CREATE TABLE "m_race"
(
    "id"   varchar PRIMARY KEY,
    "name" varchar
);

CREATE TABLE "m_session"
(
    "id"      varchar PRIMARY KEY,
    "user_id" varchar,
    "state"   varchar
);

CREATE TABLE "m_class"
(
    "id"            varchar PRIMARY KEY,
    "name"          varchar,
    "description"   text,
    "primary_skill" varchar
);

CREATE TABLE "t_character"
(
    "id"         varchar PRIMARY KEY,
    "user_id"    varchar,
    "class_id"   varchar,
    "name"       varchar,
    "level"      int,
    "element_id" varchar,
    "race_id"    varchar
);

CREATE TABLE "t_inventory"
(
    "id"           varchar PRIMARY KEY,
    "character_id" varchar
);

CREATE TABLE "m_item"
(
    "id"          varchar PRIMARY KEY,
    "name"        varchar,
    "description" text,
    "effect"      jsonb
);

CREATE TYPE "skilltype" AS ENUM (
    'buster',
    'art',
    'quick',
    'ultimate'
    );

CREATE TABLE "t_skill"
(
    "id"           varchar PRIMARY KEY,
    "character_id" varchar,
    "name"         varchar,
    "description"  text,
    "effect"       jsonb,
    "cooldown"     int,
    "cost_type"    varchar,
    "cost"         int,
    "element_id"   varchar,
    "skill_type"   skilltype
);

CREATE TABLE "t_resources"
(
    "id"           varchar PRIMARY KEY,
    "character_id" varchar,
    "gold"         bigint,
    "experience"   bigint
);

CREATE TABLE "t_enemy"
(
    "id"            varchar PRIMARY KEY,
    "name"          varchar,
    "element_id"    varchar,
    "enemy_type_id" varchar
);

CREATE TABLE "t_enemy_type"
(
    "id"   varchar PRIMARY KEY,
    "name" varchar
);

CREATE TABLE "m_element"
(
    "id"       varchar PRIMARY KEY,
    "name"     varchar,
    "affinity" jsonb
);

CREATE TABLE "t_attributes"
(
    "id"               varchar PRIMARY KEY,
    "character_id"     varchar,
    "enemy_id"         varchar,
    "attack"           int,
    "strength"         int,
    "intelligence"     int,
    "agility"          int,
    "armor"            int,
    "magic_resistance" int,
    "health"           int,
    "mana"             int
);

CREATE TABLE "t_inventory_item"
(
    "id"           varchar PRIMARY KEY,
    "inventory_id" varchar,
    "item_id"      varchar,
    "quantity"     int
);

ALTER TABLE "m_session"
    ADD FOREIGN KEY ("user_id") REFERENCES "m_user" ("id");

ALTER TABLE "t_character"
    ADD FOREIGN KEY ("user_id") REFERENCES "m_user" ("id");

ALTER TABLE "t_character"
    ADD FOREIGN KEY ("class_id") REFERENCES "m_class" ("id");

ALTER TABLE "t_character"
    ADD FOREIGN KEY ("element_id") REFERENCES "m_element" ("id");

ALTER TABLE "t_character"
    ADD FOREIGN KEY ("race_id") REFERENCES "m_race" ("id");

ALTER TABLE "t_inventory"
    ADD FOREIGN KEY ("character_id") REFERENCES "t_character" ("id");

CREATE TABLE "m_item_t_inventory_item"
(
    "m_item_id"                varchar,
    "t_inventory_item_item_id" varchar,
    PRIMARY KEY ("m_item_id", "t_inventory_item_item_id")
);

ALTER TABLE "m_item_t_inventory_item"
    ADD FOREIGN KEY ("m_item_id") REFERENCES "m_item" ("id");

ALTER TABLE "m_item_t_inventory_item"
    ADD FOREIGN KEY ("t_inventory_item_item_id") REFERENCES "t_inventory_item" ("item_id");


CREATE TABLE "t_inventory_t_inventory_item"
(
    "t_inventory_id"                varchar,
    "t_inventory_item_inventory_id" varchar,
    PRIMARY KEY ("t_inventory_id", "t_inventory_item_inventory_id")
);

ALTER TABLE "t_inventory_t_inventory_item"
    ADD FOREIGN KEY ("t_inventory_id") REFERENCES "t_inventory" ("id");

ALTER TABLE "t_inventory_t_inventory_item"
    ADD FOREIGN KEY ("t_inventory_item_inventory_id") REFERENCES "t_inventory_item" ("inventory_id");


ALTER TABLE "t_skill"
    ADD FOREIGN KEY ("character_id") REFERENCES "t_character" ("id");

ALTER TABLE "t_skill"
    ADD FOREIGN KEY ("element_id") REFERENCES "m_element" ("id");

ALTER TABLE "t_resources"
    ADD FOREIGN KEY ("character_id") REFERENCES "t_character" ("id");

ALTER TABLE "t_enemy"
    ADD FOREIGN KEY ("element_id") REFERENCES "m_element" ("id");

ALTER TABLE "t_attributes"
    ADD FOREIGN KEY ("character_id") REFERENCES "t_character" ("id");

ALTER TABLE "t_attributes"
    ADD FOREIGN KEY ("enemy_id") REFERENCES "t_enemy" ("id");

ALTER TABLE "t_enemy"
    ADD FOREIGN KEY ("enemy_type_id") REFERENCES "t_enemy_type" ("id");

ALTER TABLE "t_weapon"
    ADD FOREIGN KEY ("character_id") REFERENCES "t_character" ("id");
