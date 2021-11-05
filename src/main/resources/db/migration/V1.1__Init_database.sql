CREATE TABLE rps.games
(
    id       VARCHAR NOT NULL PRIMARY KEY,
    user_id  VARCHAR NOT NULL,
    wins     INTEGER NOT NULL,
    losses   INTEGER NOT NULL,
    draws    INTEGER NOT NULL
);
