-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           10.3.16-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour catalogue
CREATE DATABASE IF NOT EXISTS `catalogue` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `catalogue`;

-- Listage de la structure de la table catalogue. categorie
CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(11) NOT NULL,
  `descrition` varchar(255) DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.categorie : 3 rows
DELETE FROM `categorie`;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` (`id`, `descrition`, `nom`) VALUES
	(1, 'La catégorie des CD', 'CD'),
	(2, 'La catégorie des DVD', 'DVD'),
	(3, 'La catégorie des Livres', 'LIVRE');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;

-- Listage de la structure de la table catalogue. client
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_f07ymtqaif0tbcawyb71l3one` (`email`),
  UNIQUE KEY `UK_byyr8p382xxbpeph2ra0c27eb` (`nom`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.client : 0 rows
DELETE FROM `client`;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Listage de la structure de la table catalogue. client_commande
CREATE TABLE IF NOT EXISTS `client_commande` (
  `Client_id` int(11) NOT NULL,
  `commandes_id` int(11) NOT NULL,
  UNIQUE KEY `UK_g4j7v8973emq390de7ibb1lbq` (`commandes_id`),
  KEY `FKjm28217v3gcn1gtrsbp1xoqvw` (`Client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.client_commande : 0 rows
DELETE FROM `client_commande`;
/*!40000 ALTER TABLE `client_commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_commande` ENABLE KEYS */;

-- Listage de la structure de la table catalogue. commande
CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL,
  `date_creation` datetime NOT NULL,
  `montant` float NOT NULL,
  `no_confirmation` bigint(20) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKvulim1yo1bvjsxck8kblj7mu` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.commande : 0 rows
DELETE FROM `commande`;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;

-- Listage de la structure de la table catalogue. commande_produit
CREATE TABLE IF NOT EXISTS `commande_produit` (
  `Commande_id` int(11) NOT NULL,
  `produits_id` int(11) NOT NULL,
  UNIQUE KEY `UK_adibt6hsm6extwoeirw1mn83a` (`produits_id`),
  KEY `FK1y1y9ycbessavo0j7025whnff` (`Commande_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.commande_produit : 0 rows
DELETE FROM `commande_produit`;
/*!40000 ALTER TABLE `commande_produit` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande_produit` ENABLE KEYS */;

-- Listage de la structure de la table catalogue. panier
CREATE TABLE IF NOT EXISTS `panier` (
  `id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9lv0khiw6pmsxcerkyjopi8j1` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.panier : 0 rows
DELETE FROM `panier`;
/*!40000 ALTER TABLE `panier` DISABLE KEYS */;
/*!40000 ALTER TABLE `panier` ENABLE KEYS */;

-- Listage de la structure de la table catalogue. panier_produit
CREATE TABLE IF NOT EXISTS `panier_produit` (
  `Panier_id` int(11) NOT NULL,
  `produits_id` int(11) NOT NULL,
  UNIQUE KEY `UK_tn84xcs62l4sly993ggn2trlf` (`produits_id`),
  KEY `FK8tp5jpnc5tv9keelb81af8156` (`Panier_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.panier_produit : 0 rows
DELETE FROM `panier_produit`;
/*!40000 ALTER TABLE `panier_produit` DISABLE KEYS */;
/*!40000 ALTER TABLE `panier_produit` ENABLE KEYS */;

-- Listage de la structure de la table catalogue. produit
CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL,
  `dernier_maj` datetime DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prix` float NOT NULL,
  `categorie_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKejxvy5dl65jihv1v5k6v9vqd6` (`categorie_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.produit : 6 rows
DELETE FROM `produit`;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` (`id`, `dernier_maj`, `description`, `nom`, `prix`, `categorie_id`) VALUES
	(1, NULL, 'CD 55 Jazz', 'CD55', 25, 1),
	(2, NULL, 'DVD X4 Movie The others', 'DVD X4', 12, 2),
	(3, NULL, 'Apprendre Java, C++', 'LIVRE', 50, 3),
	(4, NULL, 'Jack Brel - Ne me quitte pas', 'CD 89 - Jack Brel', 22.14, 1),
	(5, NULL, 'Catch me if you can', 'DVD Movie Action', 35.25, 2),
	(6, NULL, 'E-Services', 'Livre JAVA', 50.25, 3);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;

-- Listage de la structure de la table catalogue. produitcommande
CREATE TABLE IF NOT EXISTS `produitcommande` (
  `quantite` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `produit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `FK6enmgss1rw6dkpj425yb30rta` (`produit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Listage des données de la table catalogue.produitcommande : 0 rows
DELETE FROM `produitcommande`;
/*!40000 ALTER TABLE `produitcommande` DISABLE KEYS */;
/*!40000 ALTER TABLE `produitcommande` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
