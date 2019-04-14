CREATE TABLE IF NOT EXISTS "user" (
  person_id       BIGSERIAL PRIMARY KEY NOT NULL,
  first_name      VARCHAR(255)          NOT NULL,
  last_name       VARCHAR(255)          NOT NULL,
  nick_name       VARCHAR(255),
  email           VARCHAR(100)          NOT NULL,
  password_hash   VARCHAR(255),
  username        VARCHAR(255)          NOT NULL,
  phone           VARCHAR(255),
  home_location   VARCHAR(255)          NOT NULL,
  home_address    VARCHAR(255)          NOT NULL,
  status          INT                   NOT NULL DEFAULT 0,
  active          BOOLEAN                        DEFAULT FALSE,
  date_created    TIMESTAMP             NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_modified   TIMESTAMP,
  role            INT                   NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "route" (
  route_id           BIGSERIAL PRIMARY KEY    NOT NULL,
  author_id          BIGINT                   NOT NULL,
  title              VARCHAR(255)             NOT NULL,
  token              VARCHAR(255),
  description        TEXT                    DEFAULT NULL,
  type               INT  DEFAULT 0          NOT NULL,
  distance           INT  DEFAULT 0          NOT NULL,
  path               TEXT                    NOT NULL,
  status             INT                     DEFAULT 0,
  date_created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  date_modified      TIMESTAMP,
  start_date         TIMESTAMP,
  end_date           TIMESTAMP,
  completed          BOOLEAN                  DEFAULT FALSE,
  deletable          BOOLEAN DEFAULT TRUE     NOT NULL,
  sharebale          BOOLEAN DEFAULT FALSE    NOT NULL

);

CREATE TABLE IF NOT EXISTS "user_route" (
  id        BIGSERIAL PRIMARY KEY NOT NULL,
  person_id BIGINT,
  route_id  BIGINT,
  glider_id BIGINT
);

CREATE TABLE IF NOT EXISTS "user_relationship" (
  id                 BIGSERIAL PRIMARY KEY NOT NULL,
  relating_person_id BIGINT,
  related_person_id  BIGINT,
  relation_status    INTEGER DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "team" (
  team_id  BIGSERIAL PRIMARY KEY NOT NULL,
  title    VARCHAR(255),
  owner_id BIGINT,
  points   BIGINT
);

CREATE TABLE IF NOT EXISTS "route_group" (
  id  BIGSERIAL PRIMARY KEY NOT NULL,
  team_id   BIGINT,
  route_id  BIGINT,
  person_id BIGINT
);

CREATE TABLE IF NOT EXISTS "team_relationship" (
  id        BIGSERIAL PRIMARY KEY NOT NULL,
  team_id   BIGINT,
  person_id BIGINT,
  route_id  BIGINT
);

CREATE TABLE IF NOT EXISTS "user_settings" (
  id              BIGSERIAL PRIMARY KEY NOT NULL,
  person_id       BIGINT,
  imperial_metric BOOLEAN DEFAULT FALSE,
  picture_url     VARCHAR(255),
  glider_id       INT                   NOT NULL
);

CREATE TABLE IF NOT EXISTS "scoreboard" (
  id        BIGSERIAL PRIMARY KEY NOT NULL,
  person_id BIGINT,
  points    BIGINT,
  title     INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "glider" (
  glider_id     BIGSERIAL PRIMARY KEY NOT NULL,
  model         VARCHAR(255),
  engine        VARCHAR(100),
  hp            VARCHAR(32),
  tank          INT,
  wing_ratio    VARCHAR(32),
  max_speed     INT
);

-- insert the administrator and pilot
INSERT INTO "user" (
    first_name, last_name, nick_name, email, username, phone,
    home_location, home_address, status, active, role)
VALUES
('Roman', 'Dobrynin', 'romario', 'roman.dobrynin@gmail.com', 'romario',
 '56997943', '{"lat": "-23.1212", "lng": "123.3343"}',
 'Tallinn, Estonia', 1, true, 1),
('Roman1', 'Dobrynin1', 'romario1', 'roman@trueapp.co', 'romario1',
 '56997943', '{"lat": "-13.1212", "lng": "133.3343"}',
 'Tallinn, Estonia', 1, true, 0)
ON CONFLICT (person_id) DO NOTHING;


-- insert the initial route
INSERT INTO "route" (
    route_id, author_id, title, token, description, path)
VALUES
       (-1, -2, 'Dummy Route', 'j7Swb44N1paseVjIl6f9Np', 'Brighton test route',
        '{"id":7,"label":"Brighton","waypoints":[["-0.5827863333133223","50.85059121477579"],["-0.3208472057818028","50.8523488456899"],["-0.10095930429324085","50.89851576205294"],["0.027770019765341658","50.89224795991751"]],"token":"j7Swb44N1paseVjIl6f9Np","person_id":"-1","polyline":"ewjuHlypB_Jcdr@q_Hi}i@df@qcX"}'),
       (-2, -2, 'London Route', 'j7Swb44N1paseVjIl6f9Np', 'London test route',
        '{"id":8,"label":"London","waypoints":[["-0.5827863333133223","50.85059121477579"],["-0.3208472057818028","50.8523488456899"],["-0.10095930429324085","50.89851576205294"],["0.027770019765341658","50.89224795991751"]],"token":"j7Swb44N1paseVjIl6f9Np","person_id":"-2","polyline":"ewjuHlypB_Jcdr@q_Hi}i@df@qcX"}')
ON CONFLICT (route_id) DO NOTHING;


-- insert the initial user route
INSERT INTO "user_route" (
    person_id, route_id, glider_id)
VALUES
       (-1, -1, 1),
       (-2, -1, 2),
       (-2, -2, 2)
ON CONFLICT (id) DO NOTHING;


-- insert the initial Para Glider
INSERT INTO "glider" (
    model, engine, hp, tank ,wing_ratio,  max_speed)
VALUES
       ('Oxy 5.0', 'MZ 34', '27.5 HP', '15', '8:1', '30'),
       ('Glider 1.0', 'MX 30', '20 HP', '12', '6:1', '24')
ON CONFLICT (glider_id) DO NOTHING;

