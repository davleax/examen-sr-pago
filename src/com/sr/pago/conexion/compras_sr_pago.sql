-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-03-2021 a las 10:00:20
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `compras_sr_pago`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `lastName` varchar(200) NOT NULL,
  `cardNumber` varchar(200) NOT NULL,
  `expirationDateYear` varchar(200) NOT NULL,
  `expirationDateMonth` varchar(200) NOT NULL,
  `gasType` varchar(200) NOT NULL,
  `amount` varchar(200) NOT NULL,
  `gasStation` varchar(200) NOT NULL,
  `sellerName` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id`, `email`, `name`, `lastName`, `cardNumber`, `expirationDateYear`, `expirationDateMonth`, `gasType`, `amount`, `gasStation`, `sellerName`) VALUES
('1', 'info@srpago.com', 'Juan', 'Perez', '4242424242424242', '2020', '12', '1', '350', '587fbd68edfe99480a072f15', 'Pedro Perez'),
('5273edd7-45ce-4085-aea6-e55a3494b267', 'info@srpago.com', 'Juan', 'Perez', '4242424242424242', '2020', '12', '1', '350.0', '587fbd68edfe99480a072f77', 'Pedro Perez'),
('76190b76-8809-4a4e-9fe6-aef0a0a1afc8', 'info@srpago.com', 'Alejo', 'Trujillo', '4242424242424242', '2020', '12', '1', '350.0', '587fbd68edfe99480a072f77', 'Pedro Perez');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
