-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2024 at 09:14 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdpokemonlc`
--

-- --------------------------------------------------------

--
-- Table structure for table `caja`
--

CREATE TABLE `caja` (
  `id_caja` int(11) NOT NULL,
  `id_entrenador` int(11) NOT NULL,
  `id_pokemon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `combate`
--

CREATE TABLE `combate` (
  `id_combate` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_entrenador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `entrenador`
--

CREATE TABLE `entrenador` (
  `id_entrenador` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `pokedollar` int(11) NOT NULL,
  `pass` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `entrenador`
--

INSERT INTO `entrenador` (`id_entrenador`, `nombre`, `pokedollar`, `pass`) VALUES
(1, 'sergio', 0, '1488'),
(2, 'camino', 0, 'camino');

-- --------------------------------------------------------

--
-- Table structure for table `estado`
--

CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `estado`
--

INSERT INTO `estado` (`id_estado`, `nombre`) VALUES
(1, 'paralizado'),
(2, 'quemado'),
(3, 'envenenado'),
(4, 'gravemente envenenado'),
(5, 'dormido'),
(6, 'congelado'),
(7, 'debilitado'),
(8, 'confuso'),
(9, 'amedrentado');

-- --------------------------------------------------------

--
-- Table structure for table `mochila`
--

CREATE TABLE `mochila` (
  `id_mochila` int(11) NOT NULL,
  `id_entrenador` int(11) NOT NULL,
  `id_objeto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mochila`
--

INSERT INTO `mochila` (`id_mochila`, `id_entrenador`, `id_objeto`, `cantidad`) VALUES
(1, 1, 1, NULL),
(1, 2, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `movimiento`
--

CREATE TABLE `movimiento` (
  `id_movimiento` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `clase_movimiento` varchar(20) NOT NULL CHECK (`clase_movimiento` = 'ataque' or `clase_movimiento` = 'estado' or `clase_movimiento` = 'mejora'),
  `tipo` int(11) DEFAULT NULL,
  `potencia` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `numTurnos` int(11) DEFAULT NULL,
  `mejora` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movimiento`
--

INSERT INTO `movimiento` (`id_movimiento`, `nombre`, `clase_movimiento`, `tipo`, `potencia`, `estado`, `numTurnos`, `mejora`) VALUES
(1, 'rayo burbuja', 'ataque', 1, 65, NULL, 10, NULL),
(2, 'hidrobomba', 'ataque', 1, 110, NULL, 10, NULL),
(3, 'martillazo', 'ataque', 1, 100, NULL, 10, NULL),
(4, 'pistola agua', 'ataque', 1, 40, NULL, 10, NULL),
(5, 'pin misil', 'ataque', 2, 70, NULL, 10, NULL),
(6, 'chupavidas', 'ataque', 2, 40, NULL, 10, NULL),
(7, 'furia dragon', 'ataque', 3, 85, NULL, 10, NULL),
(8, 'impactrueno', 'ataque', 4, 40, NULL, 10, NULL),
(9, 'onda trueno', 'estado', 4, NULL, 1, 10, NULL),
(10, 'puño trueno', 'ataque', 4, 75, NULL, 10, NULL),
(11, 'trueno', 'ataque', 4, 110, NULL, 10, NULL),
(12, 'lengüetazo', 'ataque', 5, 40, NULL, 10, NULL),
(13, 'rayo confuso', 'estado', 5, NULL, 8, 10, NULL),
(14, 'tinieblas', 'ataque', 5, 80, NULL, 10, NULL),
(15, 'ascuas', 'ataque', 6, 40, NULL, 10, NULL),
(16, 'lanzallamas', 'ataque', 6, 90, NULL, 10, NULL),
(17, 'puño fuego', 'ataque', 6, 75, NULL, 10, NULL),
(18, 'llamarada', 'ataque', 6, 110, NULL, 10, NULL),
(19, 'puño hielo', 'ataque', 7, 75, NULL, 10, NULL),
(20, 'rayo aurora', 'ataque', 7, 90, NULL, 10, NULL),
(21, 'rayo hielo', 'ataque', 7, 110, NULL, 10, NULL),
(22, 'golpe karate', 'ataque', 8, 75, NULL, 10, NULL),
(23, 'patada giro', 'ataque', 8, 60, NULL, 10, NULL),
(24, 'patada salto', 'ataque', 8, 90, NULL, 10, NULL),
(25, 'placaje', 'ataque', 9, 40, NULL, 10, NULL),
(26, 'golpe cuerpo', 'ataque', 9, 75, NULL, 10, NULL),
(27, 'rizo defensa', 'mejora', 9, NULL, NULL, 10, 'defensa'),
(28, 'hiperrayo', 'ataque', 9, 90, NULL, 10, NULL),
(29, 'megapuño', 'ataque', 9, 80, NULL, 10, NULL),
(30, 'danza espada', 'mejora', 9, NULL, NULL, 10, 'ataque'),
(31, 'fuerza', 'ataque', 9, 80, NULL, 10, NULL),
(32, 'golpe cabeza', 'ataque', 9, 60, NULL, 10, NULL),
(33, 'hoja afilada', 'ataque', 10, 40, NULL, 10, NULL),
(34, 'latigo cepa', 'ataque', 10, 65, NULL, 10, NULL),
(35, 'rayo solar', 'ataque', 10, 120, NULL, 10, NULL),
(36, 'paralizador', 'estado', 10, NULL, 1, 10, NULL),
(37, 'somnifero', 'estado', 10, NULL, 5, 10, NULL),
(38, 'psicorrayo', 'ataque', 11, 70, NULL, 10, NULL),
(39, 'psiquico', 'ataque', 11, 90, NULL, 10, NULL),
(40, 'hipnosis', 'estado', 11, NULL, 8, 10, NULL),
(41, 'lanzarrocas', 'ataque', 12, 75, NULL, 10, NULL),
(42, 'avalancha', 'ataque', 12, 80, NULL, 10, NULL),
(43, 'terremoto', 'ataque', 13, 110, NULL, 10, NULL),
(44, 'huesomerang', 'ataque', 13, 75, NULL, 10, NULL),
(45, 'residuos', 'ataque', 14, 70, NULL, 10, NULL),
(46, 'polvo veneno', 'estado', 14, NULL, 3, 10, NULL),
(47, 'toxico', 'estado', 14, NULL, 4, 10, NULL),
(48, 'ataque aereo', 'ataque', 15, 75, NULL, 10, NULL),
(49, 'pico taladro', 'ataque', 15, 65, NULL, 10, NULL),
(50, 'picotazo', 'ataque', 15, 50, NULL, 10, NULL),
(72, 'Gruñido', 'estado', 9, NULL, NULL, 10, NULL),
(73, 'Derribo', 'ataque', 9, 90, NULL, 10, NULL),
(74, 'Doble patada', 'ataque', 8, 60, NULL, 10, NULL),
(75, 'Garra dragón', 'ataque', 3, 80, NULL, 10, NULL),
(76, 'Patada baja', 'ataque', 8, 60, NULL, 10, NULL),
(77, 'Vuelo', 'estado', 15, NULL, NULL, 10, NULL),
(78, 'Surf', 'estado', 1, NULL, NULL, 10, NULL),
(79, 'Cabezazo', 'ataque', 9, 70, NULL, 10, NULL),
(80, 'Foco energía', 'mejora', 11, NULL, NULL, 10, 'vitalidad'),
(81, 'Excavar', 'estado', 13, NULL, NULL, 10, NULL),
(82, 'Drenadoras', 'ataque', 4, 80, NULL, 10, NULL),
(83, 'Giro bola', 'estado', 8, 25, NULL, 10, NULL),
(84, 'Cola férrea', 'mejora', 8, NULL, NULL, 10, NULL),
(85, 'Rizo defensa', 'mejora', 10, NULL, NULL, 10, NULL),
(86, 'Danza dragón', 'estado', 3, NULL, NULL, 10, NULL),
(87, 'Golpe roca', 'ataque', 12, 50, NULL, 10, NULL),
(88, 'Lanzallamas', 'ataque', 6, 90, NULL, 10, NULL),
(89, 'Rayo hielo', 'ataque', 7, 90, NULL, 10, NULL),
(90, 'Onda trueno', 'estado', 4, NULL, NULL, 10, NULL),
(91, 'Desarme', 'estado', 9, NULL, NULL, 10, NULL),
(92, 'Bomba sónica', 'ataque', 1, 90, NULL, 10, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `movimiento_pokemon`
--

CREATE TABLE `movimiento_pokemon` (
  `id_movimiento` int(11) DEFAULT NULL,
  `id_pokemon` int(11) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `objeto`
--

CREATE TABLE `objeto` (
  `id_objeto` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `precio` int(11) DEFAULT NULL,
  `aumento` int(11) DEFAULT NULL,
  `disminucion` int(11) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `objeto`
--

INSERT INTO `objeto` (`id_objeto`, `nombre`, `precio`, `aumento`, `disminucion`, `descripcion`) VALUES
(1, 'PESA', 100, 0, 0, 'Aumenta el ataque y la defensa un 20%, pero disminuye su velocidad un 20%.'),
(2, 'PLUMA', 120, 0, 0, 'Aumenta la velocidad un 30%, pero disminuye la defensa y la defensa especial\r\nen un 20%. \r\n'),
(3, 'CHALECO', 150, 0, 0, 'Aumenta la defensa y la defensa especial un 20%, pero disminuye la\r\nvelocidad y el ataque un 15%.'),
(6, 'ETER', 250, 0, 0, 'restaura el número de movimientos en un movimiento. \r\n'),
(7, 'ANILLO ÚNICO', 500, 0, 0, 'vuelve invencible a un Pokémon durante 3 turnos. No se le puede hacer\r\ndaño, su ataque aumento *10'),
(8, 'POKÉBALL', 50, 0, 0, ' 50 pokedolares ');

-- --------------------------------------------------------

--
-- Table structure for table `pokedex`
--

CREATE TABLE `pokedex` (
  `num_pokedex` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `nivel_evolucion` int(11) DEFAULT NULL,
  `tipo` int(11) NOT NULL,
  `tipo2` int(11) DEFAULT NULL,
  `SONIDO` varchar(255) DEFAULT NULL,
  `NUM_POKEDEX_EVO` int(11) DEFAULT NULL,
  `img_front` varchar(255) DEFAULT NULL,
  `img_back` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pokedex`
--

INSERT INTO `pokedex` (`num_pokedex`, `nombre`, `nivel_evolucion`, `tipo`, `tipo2`, `SONIDO`, `NUM_POKEDEX_EVO`, `img_front`, `img_back`) VALUES
(1, 'Bulbasur', 16, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\001.wav', 2, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\1.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\1.png'),
(2, 'Ivysaur', 32, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\002.wav', 3, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\2.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\2.png'),
(3, 'Venusaur', NULL, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\003.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\3.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\3.png'),
(4, 'Charmander', 16, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\004.wav', 5, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\4.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\4.png'),
(5, 'Charmeleon', 32, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\005.wav', 6, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\5.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\5.png'),
(6, 'Charizard', NULL, 6, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\006.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\6.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\6.png'),
(7, 'Squirtle', 16, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\007.wav', 8, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\7.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\7.png'),
(8, 'Wartortle', 32, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\008.wav', 9, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\8.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\8.png'),
(9, 'Blastoise', NULL, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\009.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\9.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\9.png'),
(10, 'Caterpie', 8, 2, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\010.wav', 11, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\10.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\10.png'),
(11, 'Metapod', 12, 2, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\011.wav', 12, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\11.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\11.png'),
(12, 'Butterfly', NULL, 2, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\012.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\12.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\12.png'),
(13, 'Weedle', 8, 2, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\013.wav', 14, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\13.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\13.png'),
(14, 'Kakuna', 12, 2, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\014.wav', 15, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\14.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\14.png'),
(15, 'Beedrill', NULL, 2, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\015.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\15.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\15.png'),
(16, 'Pidgey', 17, 9, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\016.wav', 17, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\16.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\16.png'),
(17, 'Pidgeotto', 28, 9, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\017.wav', 18, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\17.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\17.png'),
(18, 'Pidgeot', NULL, 9, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\018.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\18.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\18.png'),
(19, 'Ratata', 20, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\019.wav', 20, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\19.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\19.png'),
(20, 'Raticate', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\020.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\20.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\20.png'),
(21, 'Spearow', 24, 9, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\021.wav', 22, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\21.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\21.png'),
(22, 'Fearow', NULL, 9, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\022.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\22.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\22.png'),
(23, 'Ekans', 24, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\023.wav', 24, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\23.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\23.png'),
(24, 'Arbok', NULL, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\024.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\24.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\24.png'),
(25, 'Pikachu', 28, 4, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\025.wav', 26, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\25.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\25.png'),
(26, 'Raichu', NULL, 4, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\026.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\26.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\26.png'),
(27, 'Sandshrew', 28, 13, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\027.wav', 28, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\27.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\27.png'),
(28, 'Sandslash', NULL, 13, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\028.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\28.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\28.png'),
(29, 'Nidoran', 16, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\029.wav', 30, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\29.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\29.png'),
(30, 'Nidorina', 32, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\030.wav', 31, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\30.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\30.png'),
(31, 'Nidoqueen', NULL, 14, 13, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\031.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\31.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\31.png'),
(32, 'Nidoran', 16, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\032.wav', 33, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\32.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\32.png'),
(33, 'Nidorino', 32, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\033.wav', 34, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\33.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\33.png'),
(34, 'Nidoking', NULL, 14, 13, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\034.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\34.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\34.png'),
(35, 'Clefairy', 26, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\035.wav', 36, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\35.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\35.png'),
(36, 'Clefable', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\036.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\36.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\36.png'),
(37, 'Vulpix', 30, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\037.wav', 38, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\37.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\37.png'),
(38, 'Ninetales', NULL, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\038.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\38.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\38.png'),
(39, 'Jigglypuff', 20, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\039.wav', 40, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\39.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\39.png'),
(40, 'Wigglytuff', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\040.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\40.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\40.png'),
(41, 'Zubat', 18, 14, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\041.wav', 42, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\41.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\41.png'),
(42, 'Golbat', NULL, 14, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\042.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\42.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\42.png'),
(43, 'Oddish', 16, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\043.wav', 44, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\43.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\43.png'),
(44, 'Gloom', 28, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\044.wav', 45, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\44.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\44.png'),
(45, 'Vileplume', NULL, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\045.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\45.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\45.png'),
(46, 'Paras', 22, 2, 10, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\046.wav', 47, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\46.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\46.png'),
(47, 'Parasect', NULL, 2, 10, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\047.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\47.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\47.png'),
(48, 'Venonat', 26, 2, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\048.wav', 49, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\48.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\48.png'),
(49, 'Venomoth', NULL, 2, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\049.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\49.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\49.png'),
(50, 'Diglett', 24, 13, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\050.wav', 51, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\50.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\50.png'),
(51, 'Dugtrio', NULL, 13, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\051.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\51.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\51.png'),
(52, 'Meowth', 24, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\052.wav', 53, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\55.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\55.png'),
(53, 'Persian', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\053.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\53.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\53.png'),
(54, 'Psyduck', 30, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\054.wav', 55, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\54.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\54.png'),
(55, 'Golduck', NULL, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\055.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\55.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\55.png'),
(56, 'Mankey', 20, 8, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\056.wav', 57, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\56.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\56.png'),
(57, 'Primeape', NULL, 8, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\057.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\57.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\57.png'),
(58, 'Growlithe', 28, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\058.wav', 59, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\58.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\58.png'),
(59, 'Arcanine', NULL, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\059.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\59.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\59.png'),
(60, 'Poliwag', 16, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\060.wav', 61, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\60.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\60.png'),
(61, 'Poliwhirl', 28, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\061.wav', 62, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\61.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\61.png'),
(62, 'Poliwrath', NULL, 1, 8, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\062.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\62.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\62.png'),
(63, 'Abra', 16, 11, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\063.wav', 64, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\63.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\63.png'),
(64, 'Kadabra', 32, 11, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\064.wav', 65, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\64.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\64.png'),
(65, 'Alakazam', NULL, 11, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\065.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\65.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\65.png'),
(66, 'Machop', 16, 8, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\066.wav', 67, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\66.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\66.png'),
(67, 'Machoke', 30, 8, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\067.wav', 68, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\67.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\67.png'),
(68, 'Machamp', NULL, 8, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\068.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\68.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\68.png'),
(69, 'Bellsprout', 16, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\069.wav', 70, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\69.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\69.png'),
(70, 'Weepinbel', 26, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\070.wav', 71, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\70.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\70.png'),
(71, 'Victreebel', NULL, 10, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\071.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\71.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\71.png'),
(72, 'Tentacool', 26, 1, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\072.wav', 73, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\72.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\72.png'),
(73, 'Tentacruel', NULL, 1, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\073.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\73.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\73.png'),
(74, 'Geodude', 18, 12, 13, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\074.wav', 75, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\74.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\74.png'),
(75, 'Graveler', 30, 12, 13, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\075.wav', 76, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\75.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\75.png'),
(76, 'Golem', NULL, 12, 13, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\076.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\76.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\76.png'),
(77, 'Ponyta', 30, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\077.wav', 78, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\77.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\77.png'),
(78, 'Rapidash', NULL, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\078.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\78.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\78.png'),
(79, 'Slowpoke', 28, 1, 11, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\079.wav', 80, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\79.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\79.png'),
(80, 'Slowbro', NULL, 1, 11, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\080.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\80.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\80.png'),
(81, 'Magnemite', 28, 4, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\081.wav', 82, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\81.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\81.png'),
(82, 'Magneton', NULL, 4, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\082.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\82.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\82.png'),
(83, 'Farfetch´d', NULL, 9, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\083.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\83.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\83.png'),
(84, 'Doduo', 28, 9, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\084.wav', 85, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\84.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\84.png'),
(85, 'Dodrio', NULL, 9, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\085.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\85.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\85.png'),
(86, 'Seel', 26, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\086.wav', 87, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\86.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\86.png'),
(87, 'Dewgong', NULL, 1, 7, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\087.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\87.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\87.png'),
(88, 'Grimer', 30, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\088.wav', 89, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\88.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\88.png'),
(89, 'Muk', NULL, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\089.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\89.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\89.png'),
(90, 'Shellder', 24, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\090.wav', 91, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\90.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\90.png'),
(91, 'Cloyster', NULL, 1, 7, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\091.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\91.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\91.png'),
(92, 'Gastly', 16, 5, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\092.wav', 93, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\92.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\92.png'),
(93, 'Haunter', 32, 5, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\093.wav', 94, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\93.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\93.png'),
(94, 'Gengar', NULL, 5, 14, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\094.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\94.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\94.png'),
(95, 'Onix', NULL, 12, 13, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\095.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\95.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\95.png'),
(96, 'Drowzee', 30, 11, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\096.wav', 97, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\96.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\96.png'),
(97, 'Hypno', NULL, 11, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\097.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\97.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\97.png'),
(98, 'Krabby', 28, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\098.wav', 99, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\98.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\98.png'),
(99, 'Kingler', NULL, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\099.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\99.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\99.png'),
(100, 'Voltorb', 30, 4, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\100.wav', 101, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\100.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\100.png'),
(101, 'Electrode', NULL, 4, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\101.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\101.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\101.png'),
(102, 'Exeggcute', 32, 10, 11, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\102.wav', 103, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\102.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\102.png'),
(103, 'Exeggutor', NULL, 10, 11, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\103.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\103.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\103.png'),
(104, 'Cubone', 32, 13, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\104.wav', 105, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\104.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\104.png'),
(105, 'Marowak', NULL, 13, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\105.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\105.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\105.png'),
(106, 'Hitmonlee', NULL, 8, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\106.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\106.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\106.png'),
(107, 'Hitmonchan', NULL, 8, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\107.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\107.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\107.png'),
(108, 'Lickitung', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\108.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\108.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\108.png'),
(109, 'Koffing', 28, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\109.wav', 110, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\109.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\109.png'),
(110, 'Weezing', NULL, 14, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\110.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\110.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\110.png'),
(111, 'Rhyhorn', 32, 12, 13, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\111.wav', 112, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\111.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\111.png'),
(112, 'Rhydon', NULL, 12, 13, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\112.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\112.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\112.png'),
(113, 'Chansey', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\113.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\113.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\113.png'),
(114, 'Tangela', NULL, 10, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\114.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\114.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\114.png'),
(115, 'Kangaskhan', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\115.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\115.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\115.png'),
(116, 'Horsea', 20, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\116.wav', 117, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\116.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\116.png'),
(117, 'Seadra', NULL, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\117.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\117.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\117.png'),
(118, 'Goldeen', 24, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\118.wav', 119, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\118.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\118.png'),
(119, 'Seaking', NULL, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\119.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\119.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\119.png'),
(120, 'Staryu', 30, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\120.wav', 121, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\120.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\120.png'),
(121, 'Starmie', NULL, 1, 11, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\121.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\121.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\121.png'),
(122, 'Mr.Mime', NULL, 11, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\122.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\122.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\122.png'),
(123, 'Scyther', NULL, 2, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\123.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\123.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\123.png'),
(124, 'Jynx', NULL, 7, 11, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\124.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\124.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\124.png'),
(125, 'Electabuzz', NULL, 4, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\125.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\125.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\125.png'),
(126, 'Magmar', NULL, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\126.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\126.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\126.png'),
(127, 'Pinsir', NULL, 2, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\127.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\127.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\127.png'),
(128, 'Tauros', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\128.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\128.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\128.png'),
(129, 'Magikarp', 20, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\129.wav', 130, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\129.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\129.png'),
(130, 'Gyarados', NULL, 1, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\130.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\130.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\130.png'),
(131, 'Lapras', NULL, 1, 7, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\131.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\131.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\131.png'),
(132, 'Ditto', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\132.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\132.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\132.png'),
(133, 'Eevee', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\133.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\133.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\133.png'),
(134, 'Vaporeon', NULL, 1, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\134.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\134.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\134.png'),
(135, 'Jolteon', NULL, 4, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\135.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\135.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\135.png'),
(136, 'Flareon', NULL, 6, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\136.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\136.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\136.png'),
(137, 'Porygon', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\137.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\137.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\137.png'),
(138, 'Omanyte', 32, 12, 1, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\138.wav', 139, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\138.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\138.png'),
(139, 'Omastar', NULL, 12, 1, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\139.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\139.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\139.png'),
(140, 'Kabuto', 32, 12, 1, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\140.wav', 141, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\140.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\140.png'),
(141, 'Kabutops', NULL, 12, 1, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\141.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\141.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\141.png'),
(142, 'Aerodactyl', NULL, 12, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\142.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\142.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\142.png'),
(143, 'Snorlax', NULL, 9, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\143.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\143.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\143.png'),
(144, 'Articuno', NULL, 7, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\144.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\144.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\144.png'),
(145, 'Zapdos', NULL, 4, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\145.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\145.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\145.png'),
(146, 'Moltres', NULL, 6, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\146.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\146.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\146.png'),
(147, 'Dratini', 20, 3, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\147.wav', 148, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\147.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\147.png'),
(148, 'Dragonair', 36, 3, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\148.wav', 149, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\148.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\148.png'),
(149, 'Dragonite', NULL, 3, 15, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\149.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\149.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\149.png'),
(150, 'Mewtwo', NULL, 11, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\150.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\150.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\150.png'),
(151, 'Mew', NULL, 11, NULL, 'C:\\ProyectosJava\\PokemonEclipse\\sonidos\\sonidosPokemon\\151.wav', NULL, 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritFront\\151.png', 'C:\\ProyectosJava\\PokemonEclipse\\img\\spritBack\\151.png');

-- --------------------------------------------------------

--
-- Table structure for table `pokemon`
--

CREATE TABLE `pokemon` (
  `id_pokemon` int(11) NOT NULL,
  `num_pokedex` int(11) NOT NULL,
  `id_caja` int(11) DEFAULT NULL,
  `id_entrenador` int(11) DEFAULT NULL,
  `mote` varchar(30) DEFAULT NULL,
  `sexo` tinyint(1) DEFAULT NULL,
  `nivel` int(11) NOT NULL DEFAULT 1,
  `vitalidad` int(11) NOT NULL,
  `ataque` int(11) NOT NULL,
  `ataque_especial` int(11) NOT NULL,
  `defensa` int(11) NOT NULL,
  `defensa_especial` int(11) NOT NULL,
  `velocidad` int(11) NOT NULL,
  `fertilidad` int(11) NOT NULL DEFAULT 5,
  `id_objeto` int(1) DEFAULT NULL,
  `movimiento1` int(11) NOT NULL,
  `movimiento2` int(11) DEFAULT NULL,
  `movimiento3` int(11) DEFAULT NULL,
  `movimiento4` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `experiencia` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipo`
--

CREATE TABLE `tipo` (
  `id_tipo` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tipo`
--

INSERT INTO `tipo` (`id_tipo`, `nombre`) VALUES
(1, 'AGUA'),
(2, 'BICHO'),
(3, 'DRAGON'),
(4, 'ELECTRICO'),
(5, 'FANTASMA'),
(6, 'FUEGO'),
(7, 'HIELO'),
(8, 'LUCHA'),
(9, 'NORMAL'),
(10, 'PLANTA'),
(11, 'PSIQUICO'),
(12, 'ROCA'),
(13, 'TIERRA'),
(14, 'VENENO'),
(15, 'VOLADOR');

-- --------------------------------------------------------

--
-- Table structure for table `turno`
--

CREATE TABLE `turno` (
  `id_turno` int(11) NOT NULL,
  `accion_entrenador` varchar(150) NOT NULL,
  `accion_final` varchar(150) NOT NULL,
  `id_combate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`id_caja`,`id_entrenador`),
  ADD KEY `caja_entrenador_fk` (`id_entrenador`);

--
-- Indexes for table `combate`
--
ALTER TABLE `combate`
  ADD PRIMARY KEY (`id_combate`),
  ADD KEY `id_entrenador` (`id_entrenador`);

--
-- Indexes for table `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`id_entrenador`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indexes for table `mochila`
--
ALTER TABLE `mochila`
  ADD PRIMARY KEY (`id_mochila`,`id_entrenador`),
  ADD KEY `mochila_objeto_fk` (`id_objeto`),
  ADD KEY `fk_mochila_entrenador` (`id_entrenador`);

--
-- Indexes for table `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id_movimiento`),
  ADD KEY `movimiento_tipo_fk` (`tipo`),
  ADD KEY `movimiento_estado_fk` (`estado`);

--
-- Indexes for table `objeto`
--
ALTER TABLE `objeto`
  ADD PRIMARY KEY (`id_objeto`);

--
-- Indexes for table `pokedex`
--
ALTER TABLE `pokedex`
  ADD PRIMARY KEY (`num_pokedex`),
  ADD KEY `fk_num_pokedex_evo` (`NUM_POKEDEX_EVO`);

--
-- Indexes for table `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`id_pokemon`),
  ADD KEY `pokemon_pokedex_fk` (`num_pokedex`),
  ADD KEY `pokemon_entrenador_fk` (`id_entrenador`),
  ADD KEY `pokemon_movimiento1_fk` (`movimiento1`),
  ADD KEY `pokemon_movimiento2_fk` (`movimiento2`),
  ADD KEY `pokemon_movimiento3_fk` (`movimiento3`),
  ADD KEY `pokemon_movimiento4_fk` (`movimiento4`),
  ADD KEY `pokemon_estado_fk` (`estado`),
  ADD KEY `pokemon_caja_fk` (`id_caja`),
  ADD KEY `pokemon_objeto_fk` (`id_objeto`);

--
-- Indexes for table `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indexes for table `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`id_turno`),
  ADD KEY `id_combate` (`id_combate`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `combate`
--
ALTER TABLE `combate`
  MODIFY `id_combate` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `id_entrenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id_movimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT for table `objeto`
--
ALTER TABLE `objeto`
  MODIFY `id_objeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `pokedex`
--
ALTER TABLE `pokedex`
  MODIFY `num_pokedex` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=176;

--
-- AUTO_INCREMENT for table `pokemon`
--
ALTER TABLE `pokemon`
  MODIFY `id_pokemon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tipo`
--
ALTER TABLE `tipo`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `turno`
--
ALTER TABLE `turno`
  MODIFY `id_turno` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `caja`
--
ALTER TABLE `caja`
  ADD CONSTRAINT `caja_entrenador_fk` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`);

--
-- Constraints for table `combate`
--
ALTER TABLE `combate`
  ADD CONSTRAINT `combate_ibfk_1` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`);

--
-- Constraints for table `mochila`
--
ALTER TABLE `mochila`
  ADD CONSTRAINT `fk_mochila_entrenador` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`);

--
-- Constraints for table `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_estado_fk` FOREIGN KEY (`estado`) REFERENCES `estado` (`id_estado`),
  ADD CONSTRAINT `movimiento_tipo_fk` FOREIGN KEY (`tipo`) REFERENCES `tipo` (`id_tipo`);

--
-- Constraints for table `pokemon`
--
ALTER TABLE `pokemon`
  ADD CONSTRAINT `pokemon_caja_fk` FOREIGN KEY (`id_caja`) REFERENCES `caja` (`id_caja`),
  ADD CONSTRAINT `pokemon_entrenador_fk` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`),
  ADD CONSTRAINT `pokemon_estado_fk` FOREIGN KEY (`estado`) REFERENCES `estado` (`id_estado`),
  ADD CONSTRAINT `pokemon_movimiento1_fk` FOREIGN KEY (`movimiento1`) REFERENCES `movimiento` (`id_movimiento`),
  ADD CONSTRAINT `pokemon_movimiento2_fk` FOREIGN KEY (`movimiento2`) REFERENCES `movimiento` (`id_movimiento`),
  ADD CONSTRAINT `pokemon_movimiento3_fk` FOREIGN KEY (`movimiento3`) REFERENCES `movimiento` (`id_movimiento`),
  ADD CONSTRAINT `pokemon_movimiento4_fk` FOREIGN KEY (`movimiento4`) REFERENCES `movimiento` (`id_movimiento`),
  ADD CONSTRAINT `pokemon_objeto_fk` FOREIGN KEY (`id_objeto`) REFERENCES `objeto` (`id_objeto`),
  ADD CONSTRAINT `pokemon_pokedex_fk` FOREIGN KEY (`num_pokedex`) REFERENCES `pokedex` (`num_pokedex`);

--
-- Constraints for table `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`id_combate`) REFERENCES `combate` (`id_combate`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
