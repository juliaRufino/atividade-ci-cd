INSERT INTO Autor (nome, nacionalidade) VALUES
('J.K. Rowling', 'Britânica'),
('George R.R. Martin', 'Americana'),
('J.R.R. Tolkien', 'Britânica'),
('Gabriel García Márquez', 'Colombiana'),
('Haruki Murakami', 'Japonesa');

INSERT INTO Livro (titulo, descricao, data_publicacao, preco, autor_id) VALUES
('Harry Potter e a Pedra Filosofal',
 'Primeiro livro da série Harry Potter, onde o jovem Harry descobre ser um bruxo e vai para Hogwarts.',
 '1997-06-26',
 40.0,
 1),

('Harry Potter e a Câmara Secreta',
 'Segundo livro da série Harry Potter, onde Harry enfrenta novos desafios em Hogwarts, incluindo a abertura da Câmara Secreta.',
 '1998-07-02',
 45.0,
 1),

('A Game of Thrones',
 'Primeiro livro da série As Crônicas de Gelo e Fogo, onde as casas nobres dos Sete Reinos lutam pelo controle do Trono de Ferro.',
 '1996-08-06',
 50.0,
 2),

('A Clash of Kings',
 'Segundo livro da série As Crônicas de Gelo e Fogo, onde a guerra pelo Trono de Ferro se intensifica.',
 '1998-11-16',
 55.0,
 2),

('O Senhor dos Anéis: A Sociedade do Anel',
 'Primeiro livro da trilogia O Senhor dos Anéis, onde Frodo Bolseiro inicia sua jornada para destruir o Um Anel.',
 '1954-07-29',
 60.0,
 3),

('Cem Anos de Solidão',
 'Obra-prima de Gabriel García Márquez que narra a história da família Buendía na fictícia cidade de Macondo.',
 '1967-05-30',
 35.0,
 4),

('Kafka à Beira-Mar',
 'Um dos romances mais conhecidos de Haruki Murakami, que segue a história de um jovem fugitivo e um velho caçador de gatos.',
 '2002-09-12',
 30.0,
 5);