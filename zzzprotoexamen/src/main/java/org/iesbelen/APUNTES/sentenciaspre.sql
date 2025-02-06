-- 1. Selección básica
SELECT * FROM empleados;
-- Búsqueda: todos los registros de la tabla.

-- 2. Selección de columnas específicas
SELECT nombre, edad FROM empleados;
-- Búsqueda: sólo las columnas indicadas.

-- 3. WHERE con múltiples condiciones
SELECT *
FROM empleados
WHERE departamento = 'IT'
  AND salario > 3000;
-- Búsqueda: filtrar filas por varias condiciones.

-- 4. Funciones de agregado
SELECT MIN(salario), MAX(salario), AVG(salario), SUM(salario)
FROM empleados;
-- Búsqueda: mínimo, máximo, promedio y suma de salarios.

-- 5. GROUP BY
SELECT departamento, COUNT(*)
FROM empleados
GROUP BY departamento;
-- Búsqueda: agrupar registros por departamento y contarlos.

-- 6. HAVING
SELECT departamento, COUNT(*)
FROM empleados
GROUP BY departamento
HAVING COUNT(*) > 10;
-- Búsqueda: muestra sólo los grupos donde el recuento supere 10.

-- 7. JOIN
SELECT e.nombre, d.nombre AS depto
FROM empleados e
         JOIN departamentos d ON e.departamento_id = d.id;
-- Búsqueda: combinar datos de dos tablas relacionadas.

-- 8. Subconsulta
SELECT nombre
FROM empleados
WHERE salario > (SELECT AVG(salario) FROM empleados);
-- Búsqueda: filtrar empleados con salario por encima de la media.

-- 9. UNION
SELECT nombre FROM empleados WHERE departamento = 'IT'
UNION
SELECT nombre FROM empleados WHERE departamento = 'Ventas';
-- Búsqueda: unificar resultados de varias consultas (sin duplicados).

-- 10. ORDER BY
SELECT * FROM empleados
ORDER BY salario DESC;
-- Búsqueda: ordenar resultados de mayor a menor salario.

-- 11. DISTINCT
SELECT DISTINCT departamento
FROM empleados;
-- Búsqueda: listar departamentos únicos.

-- 12. INSERT
INSERT INTO empleados (nombre, salario)
VALUES ('Beatriz', 2500);
-- Búsqueda: insertar un nuevo registro.

-- 13. UPDATE
UPDATE empleados
SET salario = salario * 1.1
WHERE departamento = 'IT';
-- Búsqueda: actualizar registros de un departamento concreto.

-- 14. DELETE
DELETE FROM empleados
WHERE edad > 60;
-- Búsqueda: eliminar registros que cumplan la condición.

-- 15. WHERE con múltiples valores
SELECT * FROM empleados
WHERE departamento IN ('IT', 'Ventas');
-- Búsqueda: filtrar empleados de los departamentos IT y Ventas.
