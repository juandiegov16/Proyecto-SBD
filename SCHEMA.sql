create table Ingeniero(
	RUCIng char(13) NOT NULL,
    nombreIng varchar (50) NOT NULL,
    direccionIng varchar (100) NOT NULL,
    telefono char(10) NOT NULL,
    primary key (RUCIng));
    
create table Gasto(
	idGasto varchar(30) NOT NULL, 
    tipoGasto varchar(30) NOT NULL,
    valor char(30) NOT NULL,
    fecha date NOT NULL,
    RUCIng char(13) NOT NULL,
    foreign key (RUCIng) references Ingeniero (RUCIng),
    primary key (idGasto));
    
create table Servicio(
	
    
