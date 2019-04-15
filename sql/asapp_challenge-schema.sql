-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: asapp_challenge
-- ------------------------------------------------------

CREATE DATABASE `asapp_challenge`;
USE asapp_challenge;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `message_type` varchar(255) NOT NULL,
  `metadata` varchar(4096) DEFAULT NULL,
  `text` varchar(4096) DEFAULT NULL,
  `url` varchar(2083) DEFAULT NULL,
  `recipient_user_id` bigint(20) NOT NULL,
  `sender_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_RECIPIENT_USER_ID` (`recipient_user_id`),
  KEY `FK_SENDER_USER_ID` (`sender_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_sessions`
--

DROP TABLE IF EXISTS `user_sessions`;
CREATE TABLE `user_sessions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s53lpnfnkol367c935m8ue3fc` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

