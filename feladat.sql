-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2024. Dec 03. 17:55
-- Kiszolgáló verziója: 10.4.32-MariaDB
-- PHP verzió: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `feladat`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `feedback`
--

INSERT INTO `feedback` (`id`, `email`, `message`, `date`) VALUES
(1, 'joci@gmail.com', 'Ez egy visszajelzés egy nem bejelentkezett felhasználótól.', '2024-12-03 17:53:38'),
(2, 'user@gmail.com', 'Ez egy visszajelzés egy bejelentkezett felhasználótól', '2024-12-03 17:54:04');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `par`
--

CREATE TABLE `par` (
  `id` int(11) NOT NULL,
  `tancid` int(11) NOT NULL,
  `ferfiid` int(11) NOT NULL,
  `noid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `par`
--

INSERT INTO `par` (`id`, `tancid`, `ferfiid`, `noid`) VALUES
(2, 2, 3, 4),
(1, 2, 11, 10),
(3, 3, 5, 4),
(52, 3, 7, 4),
(4, 4, 7, 8),
(5, 5, 9, 10),
(6, 6, 11, 12),
(7, 7, 13, 14),
(8, 8, 15, 16),
(9, 9, 17, 18),
(10, 10, 19, 20),
(11, 11, 21, 22),
(12, 12, 23, 24),
(13, 13, 25, 26),
(14, 14, 27, 28),
(15, 15, 29, 30),
(16, 16, 31, 32),
(17, 17, 33, 34),
(18, 18, 35, 36),
(19, 19, 37, 38),
(20, 20, 39, 40),
(21, 21, 41, 42),
(22, 22, 43, 44),
(23, 23, 45, 46),
(24, 24, 47, 48),
(25, 25, 49, 50),
(26, 26, 51, 52),
(27, 27, 53, 54),
(28, 28, 55, 56),
(29, 29, 57, 58),
(30, 30, 59, 60),
(31, 31, 61, 62),
(32, 32, 63, 64),
(33, 33, 65, 66),
(34, 34, 67, 68),
(35, 35, 69, 70),
(36, 36, 71, 72),
(37, 37, 73, 74),
(38, 38, 75, 76),
(39, 39, 77, 78),
(40, 40, 79, 80),
(41, 41, 81, 82),
(42, 42, 83, 84),
(43, 43, 85, 86),
(44, 44, 87, 88),
(45, 45, 89, 90),
(46, 46, 91, 92),
(47, 47, 93, 94),
(48, 48, 95, 96),
(49, 49, 97, 98),
(50, 50, 99, 100);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `tag`
--

CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `nev` varchar(255) DEFAULT NULL,
  `ferfi` double NOT NULL,
  `szulido` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `tag`
--

INSERT INTO `tag` (`id`, `nev`, `ferfi`, `szulido`) VALUES
(1, 'Nagy Péter', 0, '1985-03-13 00:00:00.000000'),
(3, 'Tóth István', 1, '1979-01-15 00:00:00.000000'),
(4, 'Szabó Éva', 0, '1995-11-03 00:00:00.000000'),
(5, 'Farkas László', 1, '1988-05-21 00:00:00.000000'),
(6, 'Kiss Anikó', 0, '1992-02-09 00:00:00.000000'),
(7, 'Varga Zoltán', 1, '1984-04-30 00:00:00.000000'),
(8, 'Mészáros Andrea', 0, '1994-06-15 00:00:00.000000'),
(9, 'Papp János', 1, '1982-09-02 00:00:00.000000'),
(10, 'Földi Viktória', 0, '1993-01-17 00:00:00.000000'),
(11, 'Horváth Tamás', 1, '1987-12-25 00:00:00.000000'),
(12, 'Lakatos Ágnes', 0, '1991-08-13 00:00:00.000000'),
(13, 'Márton Gábor', 1, '1990-02-02 00:00:00.000000'),
(14, 'Lukács Katalin', 0, '1986-04-11 00:00:00.000000'),
(15, 'Kovács Zoltán', 1, '1992-07-24 00:00:00.000000'),
(16, 'Sánta Júlia', 0, '1994-06-09 00:00:00.000000'),
(17, 'Németh Péter', 1, '1991-10-30 00:00:00.000000'),
(18, 'Varga Éva', 0, '1995-03-15 00:00:00.000000'),
(19, 'Bíró Gábor', 1, '1989-05-19 00:00:00.000000'),
(20, 'Kiss Mária', 0, '1993-01-04 00:00:00.000000'),
(21, 'Tóth László', 1, '1985-11-12 00:00:00.000000'),
(22, 'Varga Laura', 0, '1996-07-06 00:00:00.000000'),
(23, 'Juhász Péter', 1, '1983-12-28 00:00:00.000000'),
(24, 'Szőke Zsófia', 0, '1990-09-10 00:00:00.000000'),
(25, 'Bartos Gergely', 1, '1990-01-23 00:00:00.000000'),
(26, 'Kovács Ivett', 0, '1993-06-17 00:00:00.000000'),
(27, 'Czégai József', 1, '1988-05-11 00:00:00.000000'),
(28, 'Németh Klára', 0, '1995-03-08 00:00:00.000000'),
(29, 'Bánfi András', 1, '1991-04-29 00:00:00.000000'),
(30, 'Tóth Réka', 0, '1994-10-05 00:00:00.000000'),
(31, 'Szakály Miklós', 1, '1990-11-20 00:00:00.000000'),
(32, 'Szilágyi Melinda', 0, '1993-05-16 00:00:00.000000'),
(33, 'Kis Gergő', 1, '1992-01-13 00:00:00.000000'),
(34, 'Farkas Helga', 0, '1994-08-23 00:00:00.000000'),
(35, 'Tóth Balázs', 1, '1985-06-04 00:00:00.000000'),
(36, 'Varga Tímea', 0, '1996-10-11 00:00:00.000000'),
(37, 'Péter Szilárd', 1, '1990-04-21 00:00:00.000000'),
(38, 'Mihály Bernadett', 0, '1992-03-30 00:00:00.000000'),
(39, 'Bence Gábor', 1, '1989-08-17 00:00:00.000000'),
(40, 'Rácz Lilla', 0, '1993-09-12 00:00:00.000000'),
(41, 'Jakab Károly', 1, '1991-11-04 00:00:00.000000'),
(42, 'Kovács Nóra', 0, '1994-05-15 00:00:00.000000'),
(43, 'Siklós Dávid', 1, '1990-12-03 00:00:00.000000'),
(44, 'Móricz Zita', 0, '1992-09-22 00:00:00.000000'),
(45, 'Király Máté', 1, '1986-10-08 00:00:00.000000'),
(46, 'Mészáros Ágnes', 0, '1993-01-29 00:00:00.000000'),
(47, 'Kocsis László', 1, '1990-05-14 00:00:00.000000'),
(48, 'Sándor Katalin', 0, '1992-11-11 00:00:00.000000'),
(49, 'Szekeres Zoltán', 1, '1987-09-27 00:00:00.000000'),
(50, 'Tóth Júlia', 0, '1994-03-18 00:00:00.000000'),
(51, 'Pálfi Dávid', 1, '1991-12-12 00:00:00.000000'),
(52, 'Földi Zsófia', 0, '1993-04-01 00:00:00.000000'),
(53, 'Varga Krisztián', 1, '1989-07-22 00:00:00.000000'),
(54, 'Nagy Noémi', 0, '1995-10-10 00:00:00.000000'),
(55, 'Bodnár Ádám', 1, '1990-02-01 00:00:00.000000'),
(56, 'Varga Bernadett', 0, '1994-11-18 00:00:00.000000'),
(57, 'Sárközi Miklós', 1, '1992-06-25 00:00:00.000000'),
(58, 'Szilvási Erzsébet', 0, '1995-01-13 00:00:00.000000'),
(59, 'Horváth Ádám', 1, '1986-11-29 00:00:00.000000'),
(60, 'Lukács Klaudia', 0, '1993-12-09 00:00:00.000000'),
(61, 'Pásztor Tibor', 1, '1988-04-17 00:00:00.000000'),
(62, 'Bodó Enikő', 0, '1991-05-27 00:00:00.000000'),
(63, 'Fehér Dávid', 1, '1992-08-14 00:00:00.000000'),
(64, 'Varga Tünde', 0, '1995-02-05 00:00:00.000000'),
(65, 'Lázár Gábor', 1, '1989-12-02 00:00:00.000000'),
(66, 'Pintér Lilla', 0, '1994-04-22 00:00:00.000000'),
(67, 'Márkus Ferenc', 1, '1987-01-14 00:00:00.000000'),
(68, 'Szilágyi Réka', 0, '1993-08-30 00:00:00.000000'),
(69, 'Fekete Tamás', 1, '1991-03-03 00:00:00.000000'),
(70, 'Benedek Ilona', 0, '1994-12-20 00:00:00.000000'),
(71, 'Gál József', 1, '1988-07-05 00:00:00.000000'),
(72, 'Tóth Borbála', 0, '1995-09-16 00:00:00.000000'),
(73, 'Balázs Gábor', 1, '1992-11-19 00:00:00.000000'),
(74, 'Sárközi Anna', 0, '1994-05-28 00:00:00.000000'),
(75, 'Sipos Béla', 1, '1987-02-11 00:00:00.000000'),
(76, 'Pataki Katalin', 0, '1995-10-30 00:00:00.000000'),
(77, 'Pintér Zsolt', 1, '1991-06-21 00:00:00.000000'),
(78, 'Bajusz Rita', 0, '1993-07-09 00:00:00.000000'),
(79, 'Csáky Ádám', 1, '1989-10-10 00:00:00.000000'),
(80, 'Pap Zsuzsanna', 0, '1994-06-04 00:00:00.000000'),
(81, 'Fodor János', 1, '1985-05-14 00:00:00.000000'),
(82, 'Héder Dóra', 0, '1990-09-25 00:00:00.000000'),
(83, 'Kozma László', 1, '1987-06-18 00:00:00.000000'),
(84, 'Czeglédi Piroska', 0, '1991-07-02 00:00:00.000000'),
(85, 'Kovács Róbert', 1, '1984-08-09 00:00:00.000000'),
(86, 'Szöllősi Ilona', 0, '1995-04-06 00:00:00.000000'),
(87, 'Jónás Ferenc', 1, '1986-03-22 00:00:00.000000'),
(88, 'Fekete Andrea', 0, '1993-02-17 00:00:00.000000'),
(89, 'Hosszú Gábor', 1, '1990-10-03 00:00:00.000000'),
(90, 'Pintér Petra', 0, '1994-07-21 00:00:00.000000'),
(91, 'Fekete Zoltán', 1, '1987-11-25 00:00:00.000000'),
(92, 'Rózsa Ildikó', 0, '1993-03-28 00:00:00.000000'),
(93, 'Szalai Péter', 1, '1991-05-02 00:00:00.000000'),
(94, 'Csabai Zsófia', 0, '1995-08-11 00:00:00.000000'),
(95, 'Hajdú Gábor', 1, '1988-12-01 00:00:00.000000'),
(96, 'Farkas Klaudia', 0, '1994-09-13 00:00:00.000000'),
(97, 'Gulyás István', 1, '1992-10-23 00:00:00.000000'),
(98, 'Balázs Tímea', 0, '1994-12-19 00:00:00.000000'),
(99, 'Szűcs Tamás', 1, '1987-02-07 00:00:00.000000'),
(100, 'Szendrey Laura', 0, '1995-01-25 00:00:00.000000');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `tanc`
--

CREATE TABLE `tanc` (
  `id` int(11) NOT NULL,
  `datum` datetime(6) DEFAULT NULL,
  `nev` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `tanc`
--

INSERT INTO `tanc` (`id`, `datum`, `nev`) VALUES
(1, '2024-11-20 00:00:00.000000', 'Csárdás'),
(2, '2024-02-20 19:30:00.000000', 'Verbunkos'),
(3, '2024-03-25 20:00:00.000000', 'Polka'),
(4, '2024-04-10 17:45:00.000000', 'Fölszegi Tánc'),
(5, '2024-05-18 16:30:00.000000', 'Kalotaszegi Tánc'),
(6, '2024-06-22 18:15:00.000000', 'Mezőföldi Tánc'),
(7, '2024-07-14 17:00:00.000000', 'Székely Tánc'),
(8, '2024-08-05 20:30:00.000000', 'Hortobágyi Tánc'),
(9, '2024-09-30 21:00:00.000000', 'Nagyváradi Tánc'),
(10, '2024-10-13 18:45:00.000000', 'Sárközi Tánc'),
(11, '2024-11-25 20:00:00.000000', 'Jászkunsági Tánc'),
(12, '2024-12-10 19:00:00.000000', 'Bihar Tánc'),
(13, '2024-01-30 20:15:00.000000', 'Kalotaszegi Magyar Tánc'),
(14, '2024-02-28 18:00:00.000000', 'Jászsági Tánc'),
(15, '2024-03-17 21:00:00.000000', 'Tápiósági Tánc'),
(16, '2024-01-12 20:00:00.000000', 'Kecskeméti Tánc'),
(17, '2024-02-10 18:30:00.000000', 'Szegedi Tánc'),
(18, '2024-03-05 21:00:00.000000', 'Sárközi Néptánc'),
(19, '2024-04-22 19:30:00.000000', 'Nagykanizsai Tánc'),
(20, '2024-05-13 20:15:00.000000', 'Pécsi Tánc'),
(21, '2024-06-18 17:30:00.000000', 'Tápiószentmártoni Tánc'),
(22, '2024-07-02 19:00:00.000000', 'Székelyföldi Tánc'),
(23, '2024-08-25 18:45:00.000000', 'Bácskai Tánc'),
(24, '2024-09-17 20:00:00.000000', 'Rábaközi Tánc'),
(25, '2024-10-08 21:00:00.000000', 'Szatmári Tánc'),
(26, '2024-11-01 20:30:00.000000', 'Vas Megyei Tánc'),
(27, '2024-12-12 19:15:00.000000', 'Kárpátaljai Tánc'),
(28, '2024-01-17 18:00:00.000000', 'Közép-Dunántúli Tánc'),
(29, '2024-02-05 20:30:00.000000', 'Tiszántúli Tánc'),
(30, '2024-03-25 19:15:00.000000', 'Veszprémi Tánc'),
(31, '2024-04-09 17:00:00.000000', 'Felföldi Tánc'),
(32, '2024-05-14 20:00:00.000000', 'Pilis Tánc'),
(33, '2024-06-30 18:30:00.000000', 'Soproni Tánc'),
(34, '2024-07-25 19:45:00.000000', 'Baranya Tánc'),
(35, '2024-08-19 17:30:00.000000', 'Kunsági Tánc'),
(36, '2024-09-11 20:00:00.000000', 'Tótsági Tánc'),
(37, '2024-10-03 21:00:00.000000', 'Kiskunsági Tánc'),
(38, '2024-11-16 19:30:00.000000', 'Máramarosi Tánc'),
(39, '2024-12-05 20:15:00.000000', 'Nyírségi Tánc'),
(40, '2024-01-29 18:45:00.000000', 'Békési Tánc'),
(41, '2024-02-13 20:00:00.000000', 'Szilágysági Tánc'),
(42, '2024-03-30 19:30:00.000000', 'Fábiánsebestyéni Tánc'),
(43, '2024-04-17 20:30:00.000000', 'Szentendrei Tánc'),
(44, '2024-05-22 21:00:00.000000', 'Komáromi Tánc'),
(45, '2024-06-08 19:00:00.000000', 'Hajdúböszörményi Tánc'),
(46, '2024-07-13 18:00:00.000000', 'Kaposvári Tánc'),
(47, '2024-08-02 21:00:00.000000', 'Pápai Tánc'),
(48, '2024-09-24 20:15:00.000000', 'Jászberényi Tánc'),
(49, '2024-10-17 19:00:00.000000', 'Cegléd Tánc'),
(50, '2024-11-09 18:30:00.000000', 'Szentgotthárdi Tánc'),
(52, '2024-11-28 00:00:00.000000', 'Tiszakécskei Tánc');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`, `role`) VALUES
(1, 'admin@gmail.com', 'admin', '$2a$10$Ls6xZ/qZT3GNJscqE40XQ.cQbC74QBF1WUkuUnijNY9KpCPTlQzEC', 'Admin'),
(2, 'user@gmail.com', 'user', '$2a$10$aatufAE9InQle.BOaup7du7hJZRi9FH8r/CLTIad96HbsEnBNO1WG', 'User');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `par`
--
ALTER TABLE `par`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tancid` (`tancid`,`ferfiid`,`noid`),
  ADD KEY `noid` (`noid`),
  ADD KEY `ferfiid` (`ferfiid`);

--
-- A tábla indexei `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `tanc`
--
ALTER TABLE `tanc`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UK3g1j96g94xpk3lpxl2qbl985x` (`name`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `par`
--
ALTER TABLE `par`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT a táblához `tag`
--
ALTER TABLE `tag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT a táblához `tanc`
--
ALTER TABLE `tanc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT a táblához `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `par`
--
ALTER TABLE `par`
  ADD CONSTRAINT `par_ibfk_1` FOREIGN KEY (`tancid`) REFERENCES `tanc` (`id`),
  ADD CONSTRAINT `par_ibfk_3` FOREIGN KEY (`noid`) REFERENCES `tag` (`id`),
  ADD CONSTRAINT `par_ibfk_4` FOREIGN KEY (`ferfiid`) REFERENCES `tag` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
