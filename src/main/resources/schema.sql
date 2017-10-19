CREATE TABLE IF NOT EXISTS user (
  id    INT PRIMARY KEY AUTO_INCREMENT,
  name  NVARCHAR(255)  NOT NULL,
  money INT DEFAULT 0 NOT NULL
);
CREATE TABLE IF NOT EXISTS goods (
  id       BIGINT PRIMARY KEY    AUTO_INCREMENT,
  name     NVARCHAR(255) NOT NULL,
  quantity INT          NOT NULL DEFAULT 0,
  price    INT
);

CREATE TABLE IF NOT EXISTS `order` (
  id       BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id  INT ,
  goods_id BIGINT,
  quantity INT NOT NULL CHECK (quantity > 0),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (goods_id) REFERENCES goods(id)
);
