-- Consultas Básicas
Pillar el año
SELECT YEAR(fecha_columna) AS año FROM tu_tabla;
Ordenar descendiente
SELECT * from cliente order by id desc ;

-- 1. Selección de Datos
SELECT * FROM contactos;
-- Busca: Todos los registros de la tabla.

SELECT nombre, edad FROM contactos;
-- Busca: Datos específicos de columnas.

SELECT DISTINCT departamento FROM empleados;
-- Busca: Valores únicos en una columna.


-- 2. Filtrado con WHERE
SELECT * FROM empleados WHERE edad > 30;
-- Busca: Filtrar registros según condición.

SELECT * FROM contactos WHERE sexo = 'Mujer' AND edad > 25;
-- Busca: Mujeres mayores de 25 años.

SELECT * FROM contactos WHERE poblacion = 'Madrid' OR poblacion = 'Barcelona';
-- Busca: Contactos en Madrid o Barcelona.

SELECT * FROM contactos WHERE poblacion IN ('Madrid', 'Barcelona');
-- Busca: Igual que la anterior, pero con IN.

SELECT * FROM contactos WHERE edad BETWEEN 18 AND 30;
-- Busca: Contactos con edad entre 18 y 30.

SELECT * FROM contactos WHERE nombre LIKE 'A%';
-- Busca: Contactos cuyo nombre empieza por 'A'.

-- Consultas de Agregación y Agrupación


-- 3. Funciones de Agregado
SELECT COUNT(*) FROM empleados;
-- Busca: Número total de registros.

SELECT AVG(edad) FROM contactos WHERE sexo = 'Hombre';
-- Busca: Edad promedio de los hombres.

SELECT MIN(salario), MAX(salario) FROM empleados;
-- Busca: Salario mínimo y máximo.

SELECT SUM(salario) FROM empleados WHERE departamento = 'Ventas';
-- Busca: Suma de salarios en el departamento de Ventas.


-- 4. GROUP BY y HAVING
SELECT nivelAcademico, COUNT(*) FROM contactos WHERE desempleado = 1 GROUP BY nivelAcademico;
-- Busca: Número de desempleados en cada nivel académico.

SELECT departamento, COUNT(*) FROM empleados GROUP BY departamento;
-- Busca: Número de empleados por departamento.

SELECT departamento, AVG(salario) salario_medio FROM empleados GROUP BY departamento HAVING salario_medio > 2500;
-- Busca: Departamentos con salario medio mayor a 2500.

SELECT poblacion, COUNT(*) FROM contactos GROUP BY poblacion HAVING COUNT(*) >= 20 ORDER BY COUNT(*) DESC, poblacion;
-- Busca: Poblaciones con al menos 20 personas, ordenadas por número de personas.


-- Consultas con JOIN


-- 5. INNER JOIN
SELECT empleados.nombre, departamentos.nombre FROM empleados JOIN departamentos ON empleados.departamento_id = departamentos.id;
-- Busca: Nombre de empleados junto con su departamento.

SELECT empleados.nombre, departamentos.nombre FROM empleados INNER JOIN departamentos ON empleados.departamento_id = departamentos.id;
-- Busca: Igual que la anterior, con INNER JOIN.


-- 6. LEFT JOIN y RIGHT JOIN
SELECT empleados.nombre, departamentos.nombre FROM empleados LEFT JOIN departamentos ON empleados.departamento_id = departamentos.id;
-- Busca: Muestra todos los empleados, incluso si no tienen departamento.

SELECT empleados.nombre, departamentos.nombre FROM empleados RIGHT JOIN departamentos ON empleados.departamento_id = departamentos.id;
-- Busca: Muestra todos los departamentos, incluso si no tienen empleados.

-- 7. NATURAL JOIN
SELECT * FROM departamentos NATURAL JOIN empleados;
-- Busca: Une ambas tablas usando una columna en común con el mismo nombre.


-- Subconsultas


-- 8. Subconsultas en WHERE
SELECT nombre FROM empleados WHERE salario > (SELECT AVG(salario) FROM empleados);
-- Busca: Empleados con salario superior a la media.

SELECT nombre, salario FROM empleados WHERE salario = (SELECT MAX(salario) FROM empleados);
-- Busca: Empleado con el salario más alto.

SELECT nombre FROM empleados WHERE departamento_id IN (SELECT id FROM departamentos WHERE nombre = 'Ventas');
-- Busca: Empleados que trabajan en el departamento de Ventas.


-- 9. Subconsultas con EXISTS
SELECT nombre FROM empleados e WHERE EXISTS (SELECT 1 FROM pedidos p WHERE p.vendedor_id = e.id);
-- Busca: Empleados que han realizado ventas.

-- 10. Subconsultas con NOT EXISTS
SELECT nombre FROM empleados e WHERE NOT EXISTS (SELECT 1 FROM pedidos p WHERE p.vendedor_id = e.id);
-- Busca: Empleados que no han realizado ventas.


-- Consultas Avanzadas


-- 11. UNION
SELECT nombre FROM empleados WHERE departamento = 'IT' UNION SELECT nombre FROM empleados WHERE departamento = 'Ventas';
-- Busca: Lista de empleados de IT y Ventas sin duplicados.

SELECT nombre FROM empleados WHERE departamento = 'IT' UNION ALL SELECT nombre FROM empleados WHERE departamento = 'Ventas';
-- Busca: Igual que la anterior, pero permite duplicados.


-- 12. Operaciones con NULL
SELECT nombre FROM empleados WHERE comision IS NULL;
-- Busca: Empleados sin comisión.

SELECT nombre FROM empleados WHERE comision IS NOT NULL;
-- Busca: Empleados que tienen comisión.

SELECT nombre, salario + IFNULL(comision, 0) AS salario_total FROM empleados;
-- Busca: Calcula el salario total, reemplazando NULL con 0.


-- 13. ORDER BY
SELECT nombre, salario FROM empleados ORDER BY salario DESC;
-- Busca: Lista de empleados ordenados por salario de mayor a menor.

SELECT nombre, edad FROM contactos ORDER BY edad ASC, nombre DESC;
-- Busca: Ordena por edad ascendente y por nombre descendente.


-- 14. BETWEEN
SELECT * FROM empleados WHERE salario BETWEEN 2000 AND 5000;
-- Busca: Empleados con salario entre 2000 y 5000.


-- 15. IN y NOT IN
SELECT * FROM empleados WHERE departamento IN ('IT', 'Ventas');
-- Busca: Empleados de los departamentos IT o Ventas.

SELECT * FROM empleados WHERE departamento NOT IN ('IT', 'Ventas');
-- Busca: Empleados que no pertenecen a IT ni Ventas.

    
-- 16. Fechas y Cálculo de Edad
SELECT nombre, TIMESTAMPDIFF(YEAR, fechaNacimiento, CURRENT_DATE()) AS edad FROM contactos;
-- Busca: Calcula la edad de cada persona.

SELECT * FROM empleados WHERE YEAR(fecha_alta) = 2020;
-- Busca: Empleados contratados en el año 2020.

SELECT * FROM empleados WHERE fecha_alta > DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
-- Busca: Empleados contratados en el último año.
