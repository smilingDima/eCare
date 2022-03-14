delete from role;
INSERT INTO role (id, name, level) VALUES
    (1, 'ADMIN', 1),
    (2, 'MANAGER', 2),
    (3, 'CUSTOMER', 3);

delete from user;
INSERT INTO user (id, login, password, role_id) VALUES
    (1, 'admin', '$2a$12$Q7YQFwjwHGXhJEG46bTwMuSkWOwsHySjHyPwwx96pzYZaAxoMxzIm', 1),
    (2, 'manager', '$2a$12$b7wBTUgBfNqP26Tg7n0O3.h97fzT2tgOqf60PTNAPaX2EUqK9q0re', 2),
    (3, 'customer', '$2a$12$96o6r945fLBrgCSL7aT8ded77ByZv1uyori.bgyArNS4Z5by2jP3K', 3),
    (4, 'user', '$2a$12$WJ.0yPTnIXdVwhTIjzFZcumv1t0LfqyLYaJVBsqWDE5M/pxgtUiZK', 3);