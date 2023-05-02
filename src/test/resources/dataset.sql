INSERT INTO tipos_identificacion (id_tipo_identificacion, descripcion) VALUES (1, 'CEDULA CIUDADANIA');
INSERT INTO tipos_identificacion (id_tipo_identificacion, descripcion) VALUES (2, 'TARJETA IDENTIDAD');
INSERT INTO tipos_identificacion (id_tipo_identificacion, descripcion) VALUES (3, 'PASAPORTE');
INSERT INTO tipos_identificacion (id_tipo_identificacion, descripcion) VALUES (4, 'PERMISO PERMANENCIA');
INSERT INTO tipos_identificacion (id_tipo_identificacion, descripcion) VALUES (5, 'TARJETA PROFESIONAL');
INSERT INTO tipos_identificacion (id_tipo_identificacion, descripcion) VALUES (6, 'REGISTRO CIVIL');
INSERT INTO tipos_identificacion (id_tipo_identificacion, descripcion) VALUES (7, 'TARJETA MILITAR');


INSERT INTO bodega (abreviacion, direccion, estado, nombre, usuario_creacion)
VALUES ('BDC', 'Calle 123', 'Activo', 'Bodega Central', 'Admin');
INSERT INTO bodega (abreviacion, direccion, estado, nombre, usuario_creacion)
VALUES ('BDS','Calle 456', 'Activo', 'Bodega Secundaria', 'Admin');
INSERT INTO bodega (abreviacion, direccion, estado, nombre, usuario_creacion)
VALUES ('BDP','Calle 745', 'Activo', 'Bodega Principal', 'Admin');
INSERT INTO bodega (abreviacion, direccion, estado, nombre, usuario_creacion)
VALUES ('BDN','Calle 712', 'Activo', 'Bodega Norte', 'Admin');
INSERT INTO bodega (abreviacion, direccion, estado, nombre, usuario_creacion)
VALUES ('BDSS','Calle 999', 'Activo', 'Bodega Sur', 'Admin');


INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Mascarilla N95', 'Caja de 20 unidades', 'Protección respiratoria', 'admin', 2);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Guantes de nitrilo', 'Caja de 100 unidades', 'Protección de manos', 'admin', 3);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Termómetro digital', 'Unidad', 'Medición de temperatura', 'admin', 2);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Jeringa descartable', 'Caja de 50 unidades', 'Administración de medicamentos', 'admin', 2);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Agua oxigenada', 'Botella de 500 ml', 'Limpieza de heridas', 'admin', 1);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Gasas estériles', 'Paquete de 10 unidades', 'Curación de heridas', 'admin', 2);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Esparadrapo', 'Rollo de 5 metros', 'Fijación de vendajes', 'admin', 2);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Tijeras quirúrgicas', 'Unidad', 'Corte de materiales médicos', 'admin', 4);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Sutura quirúrgica', 'Paquete de 10 unidades', 'Cierre de heridas', 'admin', 3);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Gasa de algodón', 'Paquete de 10 unidades', 'Limpieza de heridas', 'admin', 2);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Gel antibacterial', 'Frasco de 250 ml', 'Desinfección de manos', 'admin', 1);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Guantes de nitrilo', 'Caja de 100 unidades', 'Protección de manos', 'admin', 3);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Termómetro infrarrojo', 'Unidad', 'Medición de temperatura', 'admin', 5);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Jeringa de 1ml', 'Caja de 100 unidades', 'Inyección', 'admin', 2);
INSERT INTO insumo (estado, fecha, nombre, presentacion, tipo_insumo, usuario_creacion, vida_util)
VALUES ('Activo', '2023-04-15', 'Sutura quirúrgica', 'Caja de 12 unidades', 'Cirugía', 'admin', 3);

INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('10 mg/mL', 'activo', '2023-04-15', '2024-04-15', 'Ampolla', 'Paracetamol', 'ml', 'Admin', 'Oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('20 mg', 'activo', '2023-04-15', '2024-04-15', 'Tableta', 'Ibuprofeno', 'mg', 'Admin', 'Oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('100 mg', 'activo', '2023-04-15', '2024-04-15', 'Tableta', 'Diclofenaco', 'mg', 'Admin', 'Oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('5 mg/mL', 'activo', '2023-04-15', '2024-04-15', 'Frasco Ampolla', 'Aspirina', 'ml', 'Admin', 'Intravenosa');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('10 mg', 'activo', '2023-04-15', '2024-04-15', 'Tableta', 'Loratadina', 'mg', 'Admin', 'Oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('50 mg/mL', 'activo', '2023-04-15', '2024-04-15', 'Ampolla', 'Ranitidina', 'ml', 'Admin', 'Intravenosa');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('100 mg', 'activo', '2023-04-15', '2024-04-15', 'Tableta', 'Clorfenamina', 'mg', 'Admin', 'Oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('50 mg', 'activo', '2022-01-01', '2023-01-01', 'comprimido', 'paracetamol', 'mg', 'admin', 'oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('10 mg', 'activo', '2022-01-02', '2023-01-02', 'cápsula', 'Clonazepam', 'mg', 'admin', 'oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('1 g', 'activo', '2022-01-03', '2023-01-03', 'inyección', 'amoxicilina', 'mg', 'admin', 'intravenosa');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('100 mg', 'activo', '2022-01-04', '2023-01-04', 'jarabe', 'dextrometorfano', 'mg', 'admin', 'oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('5 mg', 'activo', '2022-01-05', '2023-01-05', 'comprimido', 'Metoclopramida', 'mg', 'admin', 'oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('20 mg', 'activo', '2022-01-06', '2023-01-06', 'cápsula', 'omeprazol', 'mg', 'admin', 'oral');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('500 mg', 'activo', '2022-01-07', '2023-01-07', 'inyección', 'cefalexina', 'mg', 'admin', 'intravenosa');
INSERT INTO medicamento (concentracion, estado, fecha, fecha_vencimiento, presentacion, principio_activo, unidad, usuario_creacion, via_administracion)
VALUES ('25 mg', 'activo', '2022-01-08', '2023-01-08', 'jarabe', 'prometazina', 'mg', 'admin', 'oral');

INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion, tipo_identificacion_id_tipo_identificacion)
VALUES ('123456789', 'proveedor1@ejemplo.com', 'Calle 1 #123', 'Proveedor Uno', 'Razón Social Uno', '3114778958', 'Admin', 1);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('987654321', 'proveedor2@ejemplo.com', 'Calle 2 #456', 'Proveedor Dos', 'Razón Social Dos', '3114778959', 'Admin', 2);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('111222333', 'proveedor3@ejemplo.com', 'Calle 3 #789', 'Proveedor Tres', 'Razón Social Tres', '3114778960', 'Admin',1);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('444555666', 'proveedor4@ejemplo.com', 'Calle 4 #012', 'Proveedor Cuatro', 'Razón Social Cuatro', '3114778991', 'Admin', 2);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('777888999', 'proveedor5@ejemplo.com', 'Calle 5 #345', 'Proveedor Cinco', 'Razón Social Cinco', '3114778961', 'Admin', 3);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('222333444', 'proveedor6@ejemplo.com', 'Calle 6 #678', 'Proveedor Seis', 'Razón Social Seis', '3114778962', 'Admin', 4);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('555666777', 'proveedor7@ejemplo.com', 'Calle 7 #901', 'Proveedor Siete', 'Razón Social Siete', '3114778977', 'Admin', 1);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('888999000', 'proveedor8@ejemplo.com', 'Calle 8 #234', 'Proveedor Ocho', 'Razón Social Ocho', '3114778998', 'Admin', 1);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('333444555', 'proveedor9@ejemplo.com', 'Calle 9 #567', 'Proveedor Nueve', 'Razón Social Nueve', '3114778914', 'Admin', 1);
INSERT INTO proveedor(numero_identificacion, correo, direccion, nombre, razon_social, telefono, usuario_creacion)
VALUES ('666777888', 'proveedor10@ejemplo.com', 'Calle 10 #890', 'Proveedor Diez', 'Razón Social Diez', '311477895812', 'Admin', 1);

INSERT INTO usuario (cedula, apellido, contrasena, email, nombre, telefono)
VALUES ('1234567890', 'Ortiz', 'password123', 'perez@gmail.com', 'Juan', '3177895223');
INSERT INTO usuario (cedula, apellido, contrasena, email, nombre, telefono)
VALUES ('2345678901', 'Ospina', 'qwerty123', 'gonzalez@yahoo.com', 'Jessica', '3177895225');
INSERT INTO usuario (cedula, apellido, contrasena, email, nombre, telefono)
VALUES ('3456789012', 'Echeverry', 'password123', 'lopez@gmail.com', 'Johana', '3177895224');
INSERT INTO usuario (cedula, apellido, contrasena, email, nombre, telefono)
VALUES ('4567890123', 'Martínez', 'qwerty123', 'martinez@hotmail.com', 'Ana', '3177895226');
INSERT INTO usuario (cedula, apellido, contrasena, email, nombre, telefono)
VALUES ('5678901234', 'Rodríguez', 'password123', 'rodriguez@gmail.com', 'Diego', '3177895227');


INSERT INTO orden_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, total, usuario_creacion, proveedor_numero_identificacion, bodega_id_bodega)
VALUES ('Positivo', '12345', '2023-04-23', 'Aprobada', '2023-04-23', 100.0, '0949788952', '123456789', 1);
INSERT INTO orden_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, total, usuario_creacion, proveedor_numero_identificacion, bodega_id_bodega)
VALUES ('Positivo', '12345', '2023-04-23', 'Aprobada', '2023-04-23', 100.0, '0949788952', '123456789', 1);
INSERT INTO orden_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, total, usuario_creacion, proveedor_numero_identificacion, bodega_id_bodega)
VALUES ('Positivo', '12345', '2023-04-23', 'Aprobada', '2023-04-23', 100.0, '0949788952', '123456789', 1);
INSERT INTO orden_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, total, usuario_creacion, proveedor_numero_identificacion, bodega_id_bodega)
VALUES ('Positivo', '12345', '2023-04-23', 'Aprobada', '2023-04-23', 100.0, '0949788952', '123456789', 1);
INSERT INTO orden_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, total, usuario_creacion, proveedor_numero_identificacion, bodega_id_bodega)
VALUES ('Positivo', '12345', '2023-04-23', 'Aprobada', '2023-04-23', 100.0, '0949788952', '123456789', 1);
INSERT INTO orden_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, total, usuario_creacion, proveedor_numero_identificacion, bodega_id_bodega)
VALUES ('Positivo', '12345', '2023-04-23', 'Aprobada', '2023-04-23', 100.0, '0949788952', '123456789', 1);

INSERT INTO detalle_orden_compra (tipo_actividad, cantidad_solicitada, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento, insumo_id_insumo, orden_compra_id_compra)
VALUES ('medicamento', 10, 25000.0, 250000.0, 250000.0, '1094477825', 1, null, 2);
INSERT INTO detalle_orden_compra (tipo_actividad, cantidad_solicitada, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento, insumo_id_insumo, orden_compra_id_compra)
VALUES ('medicamento', 10, 25000.0, 250000.0, 250000.0, '1094477825', 1, null, 2);
INSERT INTO detalle_orden_compra (tipo_actividad, cantidad_solicitada, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento, insumo_id_insumo, orden_compra_id_compra)
VALUES ('insumo', 1, 25000.0, 250000.0, 250000.0, '1094477825', 1, null, 3);
INSERT INTO detalle_orden_compra (tipo_actividad, cantidad_solicitada, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento, insumo_id_insumo, orden_compra_id_compra)
VALUES ('insumo', 1, 2500.0, 25000.0, 25000.0, '1094477825', 1, null, 4);
INSERT INTO detalle_orden_compra (tipo_actividad, cantidad_solicitada, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento, insumo_id_insumo, orden_compra_id_compra)
VALUES ('insumo', 1, 25000.0, 25000.0, 25000.0, '1094477825', 1, null, 5);
INSERT INTO detalle_orden_compra (tipo_actividad, cantidad_solicitada, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento, insumo_id_insumo, orden_compra_id_compra)
VALUES ('medicamento', 1, 2500.0, 2500.0, 25000.0, '1094477825', 1, null, 5);
INSERT INTO detalle_orden_compra (tipo_actividad, cantidad_solicitada, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento, insumo_id_insumo, orden_compra_id_compra)
VALUES ('insumo', 1, 2500.0, 25000.0, 2500.0, '1094477825', 1, null, 6);
INSERT INTO detalle_orden_compra (tipo_actividad, cantidad_solicitada, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento, insumo_id_insumo, orden_compra_id_compra)
VALUES ('medicamento', 1, 2500.0, 2500.0, 2500.0, '1094477825', 1, null, 7);


INSERT INTO devolucion_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, usuario_creacion, bodega_id_bodega)
VALUES ('Negativo', '9903', '2023-02-01', 'Activo', '2022-06-02', '1234567890', 1);
INSERT INTO devolucion_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, usuario_creacion, bodega_id_bodega)
VALUES ('Negativo', '9904', '2023-02-01', 'Activo', '2022-06-02', '1234567890', 2);
INSERT INTO devolucion_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, usuario_creacion, bodega_id_bodega)
VALUES ('Negativo', '9905', '2023-02-02', 'Activo', '2022-06-02', '1234567890', 1);
INSERT INTO devolucion_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, usuario_creacion, bodega_id_bodega)
VALUES ('Negativo', '9906', '2023-02-02', 'Activo', '2022-06-02', '1234567890', 2);
INSERT INTO devolucion_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, usuario_creacion, bodega_id_bodega)
VALUES ('Negativo', '9907', '2023-02-03', 'Activo', '2022-06-02', '1234567890', 3);
INSERT INTO devolucion_compra (tipo_movimiento, numero_autorizacion, fecha_autorizacion, estado, fecha, usuario_creacion, bodega_id_bodega)
VALUES ('Negativo', '9908', '2023-02-03', 'Activo', '2022-06-02', '1234567890', 1);

INSERT INTO detalle_devolucion_compra (devolucion_compra_id_devolucion_compra, tipo_actividad, cantidad, lote, fecha_vencimiento, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento)
VALUES (1, 'medicamento', 3, 'Lote 1', '2022-05-01', 10000.0, 30000.0, 30000.0, '1234567890', 1);
INSERT INTO detalle_devolucion_compra (devolucion_compra_id_devolucion_compra, tipo_actividad, cantidad, lote, fecha_vencimiento, valor_unitario, subtotal, total, usuario_creacion, insumo_id_insumo)
VALUES (1, 'insumo', 1, 'Lote 1', '2022-05-01', 10000.0, 10000.0, 10000.0, '1234567890', 1);
INSERT INTO detalle_devolucion_compra (devolucion_compra_id_devolucion_compra, tipo_actividad, cantidad, lote, fecha_vencimiento, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento)
VALUES (2, 'medicamento', 2, 'Lote 1', '2022-05-01', 10000.0, 20000.0, 20000.0, '1234567890', 2);
INSERT INTO detalle_devolucion_compra (devolucion_compra_id_devolucion_compra, tipo_actividad, cantidad, lote, fecha_vencimiento, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento)
VALUES (3, 'medicamento', 1, 'Lote 1', '2022-05-01', 10000.0, 10000.0, 30000.0, '1234567890', 2);
INSERT INTO detalle_devolucion_compra (devolucion_compra_id_devolucion_compra, tipo_actividad, cantidad, lote, fecha_vencimiento, valor_unitario, subtotal, total, usuario_creacion, insumo_id_insumo)
VALUES (4, 'insumo', 1, 'Lote 1', '2022-05-01', 10000.0, 10000.0, 10000.0, '1234567890', 1);
INSERT INTO detalle_devolucion_compra (devolucion_compra_id_devolucion_compra, tipo_actividad, cantidad, lote, fecha_vencimiento, valor_unitario, subtotal, total, usuario_creacion, insumo_id_insumo)
VALUES (5, 'insumo', 1, 'Lote 1', '2022-05-01', 10000.0, 10000.0, 10000.0, '1234567890', 3);
INSERT INTO detalle_devolucion_compra (devolucion_compra_id_devolucion_compra, tipo_actividad, cantidad, lote, fecha_vencimiento, valor_unitario, subtotal, total, usuario_creacion, medicamento_id_medicamento)
VALUES (6, 'medicamento', 1, 'Lote 1', '2022-05-01', 10000.0, 10000.0, 30000.0, '1234567890', 4);
