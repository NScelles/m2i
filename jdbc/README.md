# 🗄️ Java JDBC – Connexion aux Bases de Données

Ce dépôt présente les concepts fondamentaux de l’utilisation de **JDBC** (Java DataBase Connectivity) en Java, tels qu’abordés dans le cadre de la formation **Développeur Java Full Stack – M2i Formation**.

## 🎯 Objectifs pédagogiques

- Comprendre le rôle de JDBC dans la communication entre une application Java et une base de données relationnelle.
- Savoir établir une connexion avec une base de données (MySQL, PostgreSQL…).
- Exécuter des requêtes SQL (SELECT, INSERT, UPDATE, DELETE).
- Lire et manipuler les résultats avec `ResultSet`.
- Gérer les transactions avec `commit()` et `rollback()`.

---

## 🧱 Structure du module

### 🔹 Introduction aux bases de données
- Importance du stockage structuré
- Notion de SGBD (MySQL, PostgreSQL, etc.)
- Utilité de JDBC comme passerelle Java ↔ Base de données

### 🔹 Composants de l’API JDBC
- `DriverManager` : gestion des pilotes
- `Connection` : connexion active à la base
- `Statement` / `PreparedStatement` : exécution des requêtes
- `ResultSet` : lecture des résultats

### 🔹 Instructions SQL via JDBC
- `executeQuery()` pour les requêtes `SELECT`
- `executeUpdate()` pour les `INSERT`, `UPDATE`, `DELETE`
- Utilisation des instructions paramétrées avec `PreparedStatement`

### 🔹 Lecture des résultats
- Navigation avec `.next()`
- Récupération des valeurs via `getString`, `getInt`, etc.
- Défilement via `TYPE_FORWARD_ONLY`, `TYPE_SCROLL_SENSITIVE`, etc.

### 🔹 Gestion des transactions
- Exécution atomique avec `commit()`
- Retour arrière avec `rollback()`

---

## 💻 Exemples de code

- Connexion à une base de données
- Insertion d’un utilisateur avec `PreparedStatement`
- Utilisation d’un DAO (`PersonDAO`) pour séparer la logique métier
- Implémentation d’une classe `DatabaseManager` pour centraliser les connexions

---

## 📁 Organisation suggérée du dépôt

```
/src
  /demos          -> Démos de JDBC
  /exercice1      -> Exercice pour mettre en pratique les démos
  /tpbank         -> Mise en place d'une bank en console
  /utils          -> Classe d'outils

```

---

## 🧪 Technologies utilisées

- Java 21
- JDBC API
- MySQL
- Maven 
---


Merci pour votre visite ! ⭐ N’hésitez pas à explorer les autres modules Java (Spring, JPA, etc.).
