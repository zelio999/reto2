-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-03-2019 a las 11:21:28
-- Versión del servidor: 5.7.21
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `marketplace`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria`
--

DROP TABLE IF EXISTS `auditoria`;
CREATE TABLE IF NOT EXISTS `auditoria` (
  `idAuditoria` bigint(20) NOT NULL,
  `idUsuario` bigint(20) NOT NULL,
  `transaccion` varchar(100) DEFAULT NULL,
  `modulo` varchar(100) DEFAULT NULL,
  `ipTransaccion` varchar(45) DEFAULT NULL,
  `fechaTransaccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAuditoria`),
  KEY `fk_Auditoria_Usuario1_idx` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE IF NOT EXISTS `estado` (
  `idEstado` int(11) NOT NULL,
  `nombreEstado` varchar(50) DEFAULT NULL,
  `tabla` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`idEstado`, `nombreEstado`, `tabla`) VALUES
(1, 'Activo', 1),
(2, 'Inactivo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `idFactura` bigint(20) NOT NULL AUTO_INCREMENT,
  `idVendedor` bigint(20) NOT NULL,
  `idComprador` bigint(20) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `fechaGeneracion` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fk_Factura_Comprador_idx` (`idVendedor`),
  KEY `fk_Factura_Vendedor_idx` (`idComprador`),
  KEY `fk_Factura_Estado1_idx` (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturaproducto`
--

DROP TABLE IF EXISTS `facturaproducto`;
CREATE TABLE IF NOT EXISTS `facturaproducto` (
  `Factura_idFactura` bigint(20) NOT NULL,
  `Producto_idProducto` bigint(20) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`Factura_idFactura`,`Producto_idProducto`),
  KEY `fk_Factura_has_Producto_Producto1_idx` (`Producto_idProducto`),
  KEY `fk_Factura_has_Producto_Factura1_idx` (`Factura_idFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

DROP TABLE IF EXISTS `pago`;
CREATE TABLE IF NOT EXISTS `pago` (
  `idPago` bigint(20) NOT NULL AUTO_INCREMENT,
  `idFactura` bigint(20) NOT NULL,
  `idTipoPago` int(11) NOT NULL,
  `ipPago` varchar(20) DEFAULT NULL,
  `valorPago` decimal(10,0) DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_Pago_Factura1_idx` (`idFactura`),
  KEY `fk_Pago_TipoPago1_idx` (`idTipoPago`),
  KEY `fk_Pago_Estado1_idx` (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

DROP TABLE IF EXISTS `permiso`;
CREATE TABLE IF NOT EXISTS `permiso` (
  `idPermiso` varchar(9) NOT NULL,
  `nombrePermiso` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `permiso`
--

INSERT INTO `permiso` (`idPermiso`, `nombrePermiso`) VALUES
('000001001', 'Consultar Lista Admin'),
('000001002', 'Agregar Admin'),
('000001003', 'Modificar Admin'),
('000001004', 'Buscar Admin'),
('000001005', 'Deshabilitar Admin'),
('000002001', 'Consultar Lista Vendedor'),
('000002002', 'Agregar Vendedor'),
('000002003', 'Modificar Vendedor'),
('000002004', 'Buscar Vendedor'),
('000002005', 'Deshabilitar Vendedor'),
('000003001', 'Consultar Lista Comprador'),
('000003002', 'Agregar Comprador'),
('000003003', 'Modificar Comprador'),
('000003004', 'Buscar Comprador'),
('000003005', 'Deshabilitar Comprador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(100) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `fechaCreacion` timestamp NULL DEFAULT NULL,
  `idTipoProducto` varchar(12) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_Producto_TipoProducto1_idx` (`idTipoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombreRol`) VALUES
(1, 'Administrador'),
(2, 'Vendedor'),
(3, 'Comprador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rolpermiso`
--

DROP TABLE IF EXISTS `rolpermiso`;
CREATE TABLE IF NOT EXISTS `rolpermiso` (
  `idPermiso` varchar(9) NOT NULL,
  `idRol` int(11) NOT NULL,
  PRIMARY KEY (`idPermiso`,`idRol`),
  KEY `fk_Permiso_has_Rol_Rol1_idx` (`idRol`),
  KEY `fk_Permiso_has_Rol_Permiso1_idx` (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rolpermiso`
--

INSERT INTO `rolpermiso` (`idPermiso`, `idRol`) VALUES
('000001001', 1),
('000001002', 1),
('000001003', 1),
('000001004', 1),
('000001005', 1),
('000002001', 2),
('000002002', 2),
('000002003', 2),
('000002004', 2),
('000002005', 2),
('000003001', 3),
('000003002', 3),
('000003003', 3),
('000003004', 3),
('000003005', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rolusuario`
--

DROP TABLE IF EXISTS `rolusuario`;
CREATE TABLE IF NOT EXISTS `rolusuario` (
  `idRol` int(11) NOT NULL,
  `idUsuario` bigint(20) NOT NULL,
  `login` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`idRol`,`idUsuario`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `fk_Rol_has_Usuario_Usuario1_idx` (`idUsuario`),
  KEY `fk_Rol_has_Usuario_Rol1_idx` (`idRol`),
  KEY `fk_RolUsuario_Estado1_idx` (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rolusuario`
--

INSERT INTO `rolusuario` (`idRol`, `idUsuario`, `login`, `contrasena`, `idEstado`) VALUES
(2, 1, 'michael', '0acf4539a14b3aa27deeb4cbdf6e989f', 1),
(2, 3, 'aiden', 'baaf2d2a11c58b3c85014894efd9b2b0', 1),
(2, 6, 'angel', 'f4f068e71e0d87bf0ad51e6214ab84e9', 1),
(2, 9, 'chuck', '4f2155e69aea499c87d1850ab8a8e183', 1),
(2, 10, 'carol', 'a9a0198010a6073db96434f6cc5f22a8', 1),
(3, 2, 'julia', 'c2e285cb33cecdbeb83d2189e983a8c0', 1),
(3, 5, 'evelynn', '088d2ae0c0a47933bd8a9d0e3b2e37d9', 1),
(3, 7, 'meredith', 'e22d0ccac500fc266e031e510689e0fa', 1),
(3, 11, 'gabriel', '647431b5ca55b04fdf3c2fce31ef1915', 1),
(3, 15, 'leslie', '21bb5bb51758eab175d4d640334abba0', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
CREATE TABLE IF NOT EXISTS `tipodocumento` (
  `idTipoDocumento` int(11) NOT NULL,
  `nombreTipoDocumento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`idTipoDocumento`, `nombreTipoDocumento`) VALUES
(1, 'Cedula de Ciudadania'),
(2, 'Tarjeta de Identidad'),
(3, 'Pasaporte'),
(4, 'Cedula de Extranjeria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopago`
--

DROP TABLE IF EXISTS `tipopago`;
CREATE TABLE IF NOT EXISTS `tipopago` (
  `idTipoPago` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTipoPago` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idTipoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoproducto`
--

DROP TABLE IF EXISTS `tipoproducto`;
CREATE TABLE IF NOT EXISTS `tipoproducto` (
  `idTipoProducto` varchar(12) NOT NULL,
  `nombreTipoProducto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idTipoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `idTipoDocumento` int(11) NOT NULL,
  `cedula` int(11) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `genero` varchar(11) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `nroTarjeta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  KEY `fk_Usuario_TipoDocumento1_idx` (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `idTipoDocumento`, `cedula`, `nombres`, `apellidos`, `email`, `telefono`, `celular`, `fechaNacimiento`, `genero`, `direccion`, `nroTarjeta`) VALUES
(1, 1, 60989526, 'Michael', 'Taylor', 'Michael_Taylor1531096528@iatim.tech', '3-734-360-8800', '3-151-216-6738', '1979-04-01', 'Male', 'Chesterfield  Walk', '98031463977959'),
(2, 1, 99478848, 'Julia', 'Dyson', 'Julia_Dyson794014511@brety.org', '3-534-442-4524', '1-237-713-3257', '1987-03-02', 'Female', 'Bempton   Pass', '12121250987368'),
(3, 3, 10448610, 'Aiden', 'Hudson', 'Aiden_Hudson886409799@ovock.tech', '3-872-871-6503', '7-775-005-1035', '2006-12-05', 'Male', 'Linden Tunnel', '83351099917403'),
(4, 1, 40305183, 'Sebastian', 'Allington', 'Sebastian_Allington1004868048@joiniaa.com', '8-613-243-8235', '6-368-356-1333', '2005-02-05', 'Male', 'Mariner  Boulevard', '55301785827624'),
(5, 2, 45476579, 'Evelynn', 'Reid', 'Evelynn_Reid1806766133@bulaffy.com', '3-208-266-4337', '0-532-105-7204', '1985-07-03', 'Female', 'Belgrave  Vale', '76801065587396'),
(6, 1, 86689072, 'Angel', 'Villiger', 'Angel_Villiger597098201@irrepsy.com', '1-118-357-2848', '4-505-488-7234', '1955-02-04', 'Female', 'Bales  Hill', '97561949329745'),
(7, 3, 75036430, 'Meredith', 'Weatcroft', 'Meredith_Weatcroft283317407@deons.tech', '0-872-713-5108', '8-640-806-0756', '1967-08-05', 'Female', 'Collins  Rue', '12091590358355'),
(8, 1, 87523091, 'Rocco', 'Ulyatt', 'Rocco_Ulyatt935103587@deons.tech', '5-886-422-5142', '7-466-242-5258', '1995-07-04', 'Male', 'Chestnut  Way', '94931616438396'),
(9, 2, 13406001, 'Chuck', 'Kirby', 'Chuck_Kirby1767169760@hourpy.biz', '2-821-602-6571', '0-251-145-2264', '2010-03-12', 'Male', 'Antrobus   Route', '48801679571041'),
(10, 1, 73151674, 'Carol', 'Moore', 'Carol_Moore2079618895@irrepsy.com', '2-531-258-4508', '3-437-506-0014', '1962-04-11', 'Female', 'Viscount   Way', '63701587751303'),
(11, 1, 65237541, 'Gabriel', 'Lynn', 'Gabriel_Lynn1764905001@womeona.net', '1-214-570-8026', '8-526-726-3171', '1982-01-09', 'Male', 'Abbots   Vale', '45011020502247'),
(12, 3, 78692760, 'Scarlett', 'Robertson', 'Scarlett_Robertson1926374287@brety.org', '7-313-187-6027', '3-651-560-7645', '1978-08-08', 'Female', 'Cavendish Vale', '3161808066570'),
(13, 1, 9559666, 'Ryan', 'Vincent', 'Ryan_Vincent66783151@supunk.biz', '0-552-816-7638', '1-748-112-8555', '1997-02-09', 'Male', 'Ellerman   Route', '16321763527273'),
(14, 3, 23409606, 'Nate', 'Quinnell', 'Nate_Quinnell388430187@twipet.com', '5-270-774-0138', '7-351-473-7268', '1996-03-11', 'Male', 'Bigland  Avenue', '48021423936470'),
(15, 1, 66942330, 'Leslie', 'Saunders', 'Leslie_Saunders1470017562@gompie.com', '6-774-710-4608', '1-453-856-5042', '1968-03-09', 'Female', 'Carlisle  Lane', '50021086461543');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `auditoria`
--
ALTER TABLE `auditoria`
  ADD CONSTRAINT `fk_Auditoria_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_Factura_Comprador` FOREIGN KEY (`idComprador`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Factura_Estado1` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Factura_Vendedor` FOREIGN KEY (`idVendedor`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `facturaproducto`
--
ALTER TABLE `facturaproducto`
  ADD CONSTRAINT `fk_Factura_has_Producto_Factura1` FOREIGN KEY (`Factura_idFactura`) REFERENCES `factura` (`idFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Factura_has_Producto_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `fk_Pago_Estado1` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Pago_Factura1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Pago_TipoPago1` FOREIGN KEY (`idTipoPago`) REFERENCES `tipopago` (`idTipoPago`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_Producto_TipoProducto1` FOREIGN KEY (`idTipoProducto`) REFERENCES `tipoproducto` (`idTipoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `rolpermiso`
--
ALTER TABLE `rolpermiso`
  ADD CONSTRAINT `fk_Permiso_has_Rol_Permiso1` FOREIGN KEY (`idPermiso`) REFERENCES `permiso` (`idPermiso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Permiso_has_Rol_Rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `rolusuario`
--
ALTER TABLE `rolusuario`
  ADD CONSTRAINT `fk_RolUsuario_Estado1` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`idEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Rol_has_Usuario_Rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Rol_has_Usuario_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_TipoDocumento1` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`idTipoDocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
