-- ============================================================
-- BANCO DE DADOS: bdaula01
-- AULA 01 - MySQL
-- ============================================================


-- ============================================================
-- 1. CRIAÇÃO DO BANCO DE DADOS
-- ============================================================

CREATE DATABASE bdaula01;

SHOW DATABASES;

USE bdaula01;


-- ============================================================
-- 2. TABELA: PESSOA
-- ============================================================

CREATE TABLE pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    idioma VARCHAR(50) NOT NULL
);

SHOW TABLES;

DESC pessoa;


-- ============================================================
-- 3. INSERÇÃO DE DADOS - PESSOA
-- ============================================================

INSERT INTO pessoa (nome, sexo, idioma)
VALUES
    ('Ricardo', 'M', 'Português'),
    ('Vinicius', 'M', 'Alemão'),
    ('Zorzi', 'M', 'Inglês'),
    ('João', 'M', 'Inglês'),
    ('Pedro', 'M', 'Grego'),
    ('Camille', 'F', 'Catalão'),
    ('João', 'M', 'Francês');


-- Visualização dos dados
SELECT * FROM pessoa;


-- ============================================================
-- 4. TABELA: ALUNOS
-- ============================================================

CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    curso VARCHAR(50) NOT NULL
);

SHOW TABLES;

DESC alunos;


-- ============================================================
-- 5. INSERÇÃO DE DADOS - ALUNOS
-- ============================================================

INSERT INTO alunos (nome, idade, curso)
VALUES
    ('João', 20, 'Sistemas de Informação'),
    ('Pedro', 23, 'Ciência da Computação'),
    ('Camille', 24, 'Sistemas de Informação'),
    ('João Canha', 20, 'Ciência da Computação'),
    ('Zorzi', 20, 'Sistemas de Informação'),
    ('Vinícius', 24, 'Ciência da Computação');


-- Visualização dos dados
SELECT * FROM alunos;


-- ============================================================
-- 6. TABELA: PROFESSORES
-- ============================================================

CREATE TABLE professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT,
    disciplina VARCHAR(50) NOT NULL
);

SHOW TABLES;

DESC professores;


-- ============================================================
-- 7. INSERÇÃO DE DADOS - PROFESSORES
-- ============================================================

INSERT INTO professores (nome, idade, disciplina)
VALUES
    ('Ricardo', 40, 'Laboratório de Desenvolvimento de Software'),
    ('Zamberlan', 52, 'Pesquisa e Ordenação'),
    ('Ana', 55, 'Experiência do Usuário');


-- Visualização dos dados
SELECT * FROM professores;


-- ============================================================
-- 8. TABELA: MATRICULAS
-- ============================================================

CREATE TABLE matriculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_professor INT NOT NULL,
    data_matricula DATE NOT NULL,

    CONSTRAINT fk_aluno
        FOREIGN KEY (id_aluno)
        REFERENCES alunos(id),

    CONSTRAINT fk_professor
        FOREIGN KEY (id_professor)
        REFERENCES professores(id)
);

SHOW TABLES;

DESC matriculas;


-- ============================================================
-- 9. INSERÇÃO DE DADOS - MATRICULAS
-- ============================================================

INSERT INTO matriculas (id_aluno, id_professor, data_matricula)
VALUES
    (1, 1, '2025-01-15'),
    (3, 1, '2026-09-23'),
    (5, 2, '2024-08-27'),
    (4, 2, '2025-02-20');


-- Visualização dos dados
SELECT * FROM matriculas;


-- ============================================================
-- FIM DO SCRIPT
-- ============================================================
