CREATE SCHEMA `bdnotaspedido` DEFAULT CHARACTER SET utf8 ;
 
USE bdnotaspedido;

CREATE TABLE `bdnotaspedido`.`materia` (
  `idmateria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `carrera` VARCHAR(45) NULL,
  PRIMARY KEY (`idmateria`));

INSERT INTO `bdnotaspedido`.`materia` (`nombre`, `carrera`) VALUES ("materia 1", "carrera 1");
INSERT INTO `bdnotaspedido`.`materia` (`nombre`, `carrera`) VALUES ("materia 2", "carrera 1");
INSERT INTO `bdnotaspedido`.`materia` (`nombre`, `carrera`) VALUES ("materia 3", "carrera 1");
INSERT INTO `bdnotaspedido`.`materia` (`nombre`, `carrera`) VALUES ("materia 4", "carrera 2");
INSERT INTO `bdnotaspedido`.`materia` (`nombre`, `carrera`) VALUES ("materia 5", "carrera 2");

CREATE TABLE `bdnotaspedido`.`notapedido` (
  `idnotapedido` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `cantestudiantes` INT NOT NULL,
  `idmateria` INT NOT NULL,
  PRIMARY KEY (`idnotapedido`),
  INDEX `fk_materia_notapedido_idx` (`idmateria` ASC) VISIBLE,
  CONSTRAINT `fk_materia_notapedido`
    FOREIGN KEY (`idmateria`)
    REFERENCES `bdnotaspedido`.`materia` (`idmateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdnotaspedido`.`final` (
  `idfinal` INT NOT NULL,
  `fechaexamen` DATE NOT NULL,
  PRIMARY KEY (`idfinal`),
  CONSTRAINT `fk_notapedido_final`
    FOREIGN KEY (`idfinal`)
    REFERENCES `bdnotaspedido`.`notapedido` (`idnotapedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bdnotaspedido`.`curso` (
  `idcurso` INT NOT NULL,
  `codcurso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcurso`),
  CONSTRAINT `fk_notapedido_curso`
    FOREIGN KEY (`idcurso`)
    REFERENCES `bdnotaspedido`.`notapedido` (`idnotapedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-01", 10, 1);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-01", 11, 2);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-07", 12, 3);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-07", 13, 4);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-10", 14, 5);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-01", 100, 1);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-07", 105, 2);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-07", 110, 3);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-08", 115, 4);
INSERT INTO `bdnotaspedido`.`notapedido` (`fecha`, `cantestudiantes`, `idmateria`) VALUES("2022-03-08", 120, 5);

INSERT INTO `bdnotaspedido`.`final` (`idfinal`, `fechaexamen`) VALUES (1, "2022-05-09");
INSERT INTO `bdnotaspedido`.`final` (`idfinal`, `fechaexamen`) VALUES (2, "2022-05-09");
INSERT INTO `bdnotaspedido`.`final` (`idfinal`, `fechaexamen`) VALUES (3, "2022-05-10");
INSERT INTO `bdnotaspedido`.`final` (`idfinal`, `fechaexamen`) VALUES (4, "2022-05-10");
INSERT INTO `bdnotaspedido`.`final` (`idfinal`, `fechaexamen`) VALUES (5, "2022-05-11");

INSERT INTO `bdnotaspedido`.`curso` (`idcurso`, `codcurso`) VALUES (6, "cod-cur-1");
INSERT INTO `bdnotaspedido`.`curso` (`idcurso`, `codcurso`) VALUES (7, "cod-cur-2");
INSERT INTO `bdnotaspedido`.`curso` (`idcurso`, `codcurso`) VALUES (8, "cod-cur-3");
INSERT INTO `bdnotaspedido`.`curso` (`idcurso`, `codcurso`) VALUES (9, "cod-cur-4");
INSERT INTO `bdnotaspedido`.`curso` (`idcurso`, `codcurso`) VALUES (10, "cod-cur-5");

select * from notapedido;