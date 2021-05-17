create table player
(
    id       identity not null,
    name     varchar not null,
    email    varchar,
    password varchar,
    primary key (id)
);

create table game
(
    id           identity not null,
    field_width  integer not null,
    field_height integer not null,
    steps_to_win integer not null,
    timestamp    timestamp,
    primary key (id)
);

create table gamesession
(
    id           identity not null,
    player_id integer not null,
    game_id   integer not null,
    result    integer not null,
    primary key (id)
--     primary key (player_id, game_id),
--     foreign key (player_id) references player (id),
--     foreign key (game_id) references game (id)
);

