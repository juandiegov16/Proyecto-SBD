Integrantes :

DANNY RIOS 
HAROLD YEPEZ
JUAN DIEGO VALLEJO

Como ejecutar el programa:

1. Antes de ejecutar el programa debe estar el archivo taller_re.sql en el workbrench.
2. A continuacion dentro del programa en la clase "consultaCliente" y "consultaBote" debera cambiar la conexion  DENTRO DE LOS METODOS CONEXION ya que tiene como usuario "root" y clave "danny"
3. Ejecute el programa, apareceran una ventana principal la cual contiene dos botones para consultar cliente como bote, elija cualquiera de ellas.
4. Al estar en la ventana de consulta, de click en el boton REFRESCAR, este boton indicara en consola si el programa a tenido una conexion exitosa con la base de datos.
5. Luego, si está dentro de consultar cliente, digite la cedula del cliente, esta la puede observar en la consola, una vez realizado de click en CONSULTAR. 
Automáticamente el programa mostrará la informacion respectiva del cliente (nombre, direccion, telefono).
6. La ventana consulta bote tiene la misa funcionalidad que la anterior solamente en estecaso debera ingresar el serial que tambien se mostrara en consola, para evitar
el cambio de ventana a workbrench.(por cuestiones de tiempo decidimos hacerlo de esta forma).
7. Las ventanas de añadir y borrar tienen la misma logica que las anteriores.


NOTA : Asegurese de limpiar y construir el proyecto.
NOTA 2: Antes de ejecutar, utilizar la opción "Resolver Problemas de Proyecto"
 y localizar el archivo llamado "mysql-connector-java-5.1.45-bin.jar"
 en la carpeta ProyectoBaseDeDatos.
