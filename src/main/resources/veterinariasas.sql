CREATE TABLE IF NOT EXISTS dueño` (
`
  `identificacion` varchar(255) NOT NULL,
  `tipoIdDueño` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `ciudad` varchar(255) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `idPaciente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `dueño`
--

INSERT INTO `dueño` (`identificacion`, `tipoIdDueño`, `telefono`, `ciudad`, `Direccion`, `Nombre`, `idPaciente`) VALUES
('1', 'CC', '3044018165', 'Monteria', 'Calle 27 carrera 5-24', 'Andres Ortiz', 1),
('2', 'CC', '3044018165', 'Monteria', 'Calle 27 carrera 5-24', 'Andres Ortiz', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especie`
--

CREATE TABLE IF NOT EXISTS  `especie` (
  `idEspecie` int(11) NOT NULL,
  `especie` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especie`
--

INSERT INTO `especie` (`idEspecie`, `especie`) VALUES
(1, 'Perro'),
(2, 'gato');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nompaciente`
--

CREATE TABLE IF NOT EXISTS  `nompaciente` (
  `idPaciente` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `feNaMascota` date NOT NULL,
  `feRegistro` datetime NOT NULL,
  `idEspecie` int(11) DEFAULT NULL,
  `idRaza` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nompaciente`
--

INSERT INTO `nompaciente` (`idPaciente`, `nombre`, `feNaMascota`, `feRegistro`, `idEspecie`, `idRaza`) VALUES
(1, 'Orion', '2023-01-01', '2023-02-01 03:28:24', 1, 1),
(2, 'kaTI', '2023-02-23', '2023-02-01 23:24:02', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `raza`
--

CREATE TABLE IF NOT EXISTS  `raza` (
  `idRaza` int(11) NOT NULL,
  `raza` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `raza`
--

INSERT INTO `raza` (`idRaza`, `raza`) VALUES
(1, 'Labradora'),
(2, 'Lumbot');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS  `usuario` (
  `correo` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dueño`
--
ALTER TABLE `dueño`
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `especie`
--
ALTER TABLE `especie`
  ADD PRIMARY KEY (`idEspecie`);

--
-- Indices de la tabla `nompaciente`
--
ALTER TABLE `nompaciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD KEY `idEspecie` (`idEspecie`),
  ADD KEY `idRaza` (`idRaza`);

--
-- Indices de la tabla `raza`
--
ALTER TABLE `raza`
  ADD PRIMARY KEY (`idRaza`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `especie`
--
ALTER TABLE `especie`
  MODIFY `idEspecie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `nompaciente`
--
ALTER TABLE `nompaciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `raza`
--
ALTER TABLE `raza`
  MODIFY `idRaza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dueño`
--
ALTER TABLE `dueño`
  ADD CONSTRAINT `dueño_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `nompaciente` (`idPaciente`);

--
-- Filtros para la tabla `nompaciente`
--
ALTER TABLE `nompaciente`
  ADD CONSTRAINT `nompaciente_ibfk_1` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`),
  ADD CONSTRAINT `nompaciente_ibfk_2` FOREIGN KEY (`idRaza`) REFERENCES `raza` (`idRaza`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
