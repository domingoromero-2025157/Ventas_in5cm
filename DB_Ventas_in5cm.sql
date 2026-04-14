drop database if exists db_ventas_in5cm;
create database db_ventas_in5cm;
use db_ventas_in5cm;

-- ================= clientes =================
create table clientes (
    dpi_cliente int auto_increment primary key,
    nombre_cliente varchar(50) not null,
    apellido_cliente varchar(50) not null,
    direccion varchar(100) not null,
    estado int not null
);

-- ================= usuarios =================
create table usuarios (
    codigo_usuario int auto_increment primary key,
    username varchar(45) not null,
    password varchar(45) not null,
    email varchar(60) not null,
    rol varchar(45) not null,
    estado int not null
);

-- ================= productos =================
create table productos (
    codigo_producto int auto_increment primary key,
    nombre_producto varchar(60) not null,
    precio decimal(10,2) not null,
    stock int not null,
    estado int not null
);

-- ================= ventas =================
create table ventas (
    codigo_venta int auto_increment primary key,
    fecha_venta date not null,
    total decimal(10,2) not null,
    estado int not null,
    dpi_cliente int,
    codigo_usuario int,
    foreign key (dpi_cliente) references clientes(dpi_cliente),
    foreign key (codigo_usuario) references usuarios(codigo_usuario)
);

-- ================= detalle venta =================
create table detalle_venta (
    codigo_detalle int auto_increment primary key,
    cantidad int not null,
    precio_unitario decimal(10,2) not null,
    subtotal decimal(10,2) not null,
    codigo_producto int,
    codigo_venta int,
    foreign key (codigo_producto) references productos(codigo_producto),
    foreign key (codigo_venta) references ventas(codigo_venta)
);

-- ================= procedimientos =================
delimiter //

-- ===== clientes =====
create procedure sp_crear_cliente(
    in p_nombre varchar(50),
    in p_apellido varchar(50),
    in p_direccion varchar(100),
    in p_estado int
)
begin
    insert into clientes(nombre_cliente, apellido_cliente, direccion, estado)
    values(p_nombre, p_apellido, p_direccion, p_estado);
end //

create procedure sp_leer_cliente(in p_id int)
begin
    select * from clientes where dpi_cliente = p_id;
end //

create procedure sp_actualizar_cliente(
    in p_id int,
    in p_nombre varchar(50),
    in p_apellido varchar(50),
    in p_direccion varchar(100),
    in p_estado int
)
begin
    update clientes
    set nombre_cliente = p_nombre,
        apellido_cliente = p_apellido,
        direccion = p_direccion,
        estado = p_estado
    where dpi_cliente = p_id;
end //

create procedure sp_eliminar_cliente(in p_id int)
begin
    delete from clientes where dpi_cliente = p_id;
end //

-- ===== usuarios =====
create procedure sp_crear_usuario(
    in p_username varchar(45),
    in p_password varchar(45),
    in p_email varchar(60),
    in p_rol varchar(45),
    in p_estado int
)
begin
    insert into usuarios(username, password, email, rol, estado)
    values(p_username, p_password, p_email, p_rol, p_estado);
end //

create procedure sp_leer_usuario(in p_id int)
begin
    select * from usuarios where codigo_usuario = p_id;
end //

create procedure sp_actualizar_usuario(
    in p_id int,
    in p_username varchar(45),
    in p_password varchar(45),
    in p_email varchar(60),
    in p_rol varchar(45),
    in p_estado int
)
begin
    update usuarios
    set username = p_username,
        password = p_password,
        email = p_email,
        rol = p_rol,
        estado = p_estado
    where codigo_usuario = p_id;
end //

create procedure sp_eliminar_usuario(in p_id int)
begin
    delete from usuarios where codigo_usuario = p_id;
end //

-- ===== productos =====
create procedure sp_crear_producto(
    in p_nombre varchar(60),
    in p_precio decimal(10,2),
    in p_stock int,
    in p_estado int
)
begin
    insert into productos(nombre_producto, precio, stock, estado)
    values(p_nombre, p_precio, p_stock, p_estado);
end //

create procedure sp_leer_producto(in p_id int)
begin
    select * from productos where codigo_producto = p_id;
end //

create procedure sp_actualizar_producto(
    in p_id int,
    in p_nombre varchar(60),
    in p_precio decimal(10,2),
    in p_stock int,
    in p_estado int
)
begin
    update productos
    set nombre_producto = p_nombre,
        precio = p_precio,
        stock = p_stock,
        estado = p_estado
    where codigo_producto = p_id;
end //

create procedure sp_eliminar_producto(in p_id int)
begin
    delete from productos where codigo_producto = p_id;
end //

-- ===== ventas =====
create procedure sp_crear_venta(
    in p_fecha date,
    in p_total decimal(10,2),
    in p_estado int,
    in p_dpi_cliente int,
    in p_codigo_usuario int
)
begin
    insert into ventas(fecha_venta, total, estado, dpi_cliente, codigo_usuario)
    values(p_fecha, p_total, p_estado, p_dpi_cliente, p_codigo_usuario);
end //

create procedure sp_leer_venta(in p_id int)
begin
    select * from ventas where codigo_venta = p_id;
end //

create procedure sp_actualizar_venta(
    in p_id int,
    in p_fecha date,
    in p_total decimal(10,2),
    in p_estado int,
    in p_dpi_cliente int,
    in p_codigo_usuario int
)
begin
    update ventas
    set fecha_venta = p_fecha,
        total = p_total,
        estado = p_estado,
        dpi_cliente = p_dpi_cliente,
        codigo_usuario = p_codigo_usuario
    where codigo_venta = p_id;
end //

create procedure sp_eliminar_venta(in p_id int)
begin
    delete from ventas where codigo_venta = p_id;
end //

-- ===== detalle venta =====
create procedure sp_crear_detalle(
    in p_cantidad int,
    in p_precio decimal(10,2),
    in p_subtotal decimal(10,2),
    in p_producto int,
    in p_venta int
)
begin
    insert into detalle_venta(cantidad, precio_unitario, subtotal, codigo_producto, codigo_venta)
    values(p_cantidad, p_precio, p_subtotal, p_producto, p_venta);
end //

create procedure sp_leer_detalle(in p_id int)
begin
    select * from detalle_venta where codigo_detalle = p_id;
end //

create procedure sp_actualizar_detalle(
    in p_id int,
    in p_cantidad int,
    in p_precio decimal(10,2),
    in p_subtotal decimal(10,2),
    in p_producto int,
    in p_venta int
)
begin
    update detalle_venta
    set cantidad = p_cantidad,
        precio_unitario = p_precio,
        subtotal = p_subtotal,
        codigo_producto = p_producto,
        codigo_venta = p_venta
    where codigo_detalle = p_id;
end //

create procedure sp_eliminar_detalle(in p_id int)
begin
    delete from detalle_venta where codigo_detalle = p_id;
end //

delimiter ;

ALTER TABLE usuarios MODIFY password VARCHAR(100);
DELETE FROM usuarios WHERE codigo_usuario > 0;