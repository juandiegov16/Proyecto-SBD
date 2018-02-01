use taller;

#Inserción de Ingeniero
insert into ingeniero values(0917947053, 'Carlos Vallejo', 'Puerto Azul', 0994755228);
    
#Inserción de Gasto
insert into gasto values(00, 'Alimentación', 16.50, '2007-01-10', 0917947053);
insert into gasto values(01, 'Alimentación', 20.50, '2007-06-10', 0917947053);
insert into gasto values(02, 'Alimentación', 13.37, '2012-01-11', 0917947053);
insert into gasto values(03, 'Alimentación', 21.12, '2008-02-15', 0917947053);



#Inserción de Cliente
insert into cliente values(0815946523, 'Xavier Game', 'The Point',  0956111324);
insert into cliente values(0992148012, 'PacificTuna', 'Km 10.5 Vía a la Costa', 3704100);
insert into cliente values(0909206724, 'Carlos Molestina', 'Entre Ríos', 2698756);
insert into cliente values(0992959754, 'Carlos Molestina', 'Circunvalación 1109 y Laureles', 238364);
insert into cliente values(0815946522, 'Pedro Picahielo', 'Ciudad Almeja', 6662087);



#Inserción de Bote
insert into bote values (156, 'Mercury', 'Tranquilizer', 8, 0815946523);
insert into bote values (157, 'Toyota', 'Trimaran', 10, 0815946522);
insert into bote values (158, 'Evinrude', 'Marine1', 9, 0992148012);
insert into bote values (159, 'Suzuki', 'Tamago', 6, 0992959754);
insert into bote values (160, 'Yamaha', 'Kaichou', 9, 0909206724);


#Inserción de FacturaServicio
insert into facturaservicio values('2007-01-10', 10, 'Instalación', 'Sin desc.', 615.64, 'Cheque', 15, 0917947053, 10, 0815946523);
insert into facturaservicio values('2007-01-10', 11, 'Reparación', 'Sin desc.', 28.19, 'Cheque', 19, 0917947053, 10, 0815946523);



#Inserción de Repuesto
insert into repuesto values(15, 20, 'Tornillo negro', 1.03, 'Raro', 10);
insert into repuesto values(19, 18, 'Tornillo gris', 1.04, 'Ocasional', 11);


#Inserción de OrdenTrabajo
insert into ordentrabajo values(10, '2007-01-05');
insert into ordentrabajo values(11, '2007-01-08');


