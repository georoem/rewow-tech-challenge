INSERT INTO service_type(id, name)VALUES (1, 'MEDICAL');
INSERT INTO service_type(id, name)VALUES (2, 'SPA');

INSERT INTO service(id, description, name, id_service_type)	VALUES (1, 'Cita Médica', 'Cita Medica', 1);
INSERT INTO service(id, description, name, id_service_type)	VALUES (2, 'Vacunas', 'Vacunas', 1);
INSERT INTO service(id, description, name, id_service_type)	VALUES (3, 'Desparasitación', 'Desparasitación', 1);
INSERT INTO service(id, description, name, id_service_type)	VALUES (4, 'Baño', 'Baño', 2);
INSERT INTO service(id, description, name, id_service_type)	VALUES (5, 'Corte de pelo', 'Corte de pelo', 2);