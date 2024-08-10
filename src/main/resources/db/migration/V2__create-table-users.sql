CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    login_user TEXT NOT NULL UNIQUE,
    password_user TEXT NOT NULL,
    role_user TEXT NOT NULL
);