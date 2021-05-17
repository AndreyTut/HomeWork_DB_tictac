create table player
(
    id       integer not null,
    name     varchar not null,
    email    varchar,
    password varchar,
    primary key (id)
);

create table game
(
    id           integer not null,
    field_width  integer not null,
    field_height integer not null,
    steps_to_win integer not null,
    timestamp    timestamp
);

create table gamesession
(
    id        integer not null,
    player_id integer not null,
    game_id   integer not null,
    result    integer not null,
    foreign key (player_id) references player (id),
    foreign key (game_id) references game (id)
);

