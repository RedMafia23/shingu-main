CREATE TABLE IF NOT EXISTS products(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
description TEXT,
image VARCHAR(255),
category VARCHAR(255),
price DECIMAL(10, 2)
);

INSERT INTO products (name, description, image, category, price)
VALUES
('掛け布団', 'ふかふか', '/images/1.jpg', '掛け布団', 9999),
('掛け布団　花柄', 'ふっかふか', '/images/2.jpg', '掛け布団', 88888),
('掛け布団　白', 'ふっかふっか　もふもふ', '/images/3.jpg', '掛け布団', 7777),
('掛け布団　ストライプ', 'ふっかふっか　もふもふ　心地よい肌ざわり', '/images/4.jpg', '掛け布団', 6666),
('枕', '特殊な構造で横向き寝を促進し、耳や顔への圧迫を軽減します。いびき対策にも。', '/images/5.jpg', '枕', 5555),
('高さ調整　枕', 'オーダー感覚！計10ヶ所でお好みの高さにピッタリ調整！丸洗いができ、通気性と耐久性に優れたパイプ素材で快適。', '/images/6.jpg', '枕', 4990),
('マシュマロ　枕', '極細繊維の中わたと伸縮生地で、マシュマロタッチのやさしい感触。', '/images/7.jpg', '枕', 999),
('布団カバー　ピンク', 'ピンク花柄。', '/images/8.jpg', '布団カバー', 7800),
('布団カバー　cool', '冷たさ長持ち。抗菌防臭加工・制菌加工付きでいつでも清潔。', '/images/9.jpg', '布団カバー', 7777);


