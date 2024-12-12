import mysql.connector
from mysql.connector import Error


class Producto:
    def __init__(self, host, user, password, database):
        self.conexion = None
        try:
            self.conexion = mysql.connector.connect(
                host='localhost',      # Comillas para cadenas de texto
                user='root',           # Usuario de MySQL
                password='admin',      # Contraseña de MySQL
                database='inventaio',     # Nombre de la base de datos (está bien como está)
                port=3307   
            )
            if self.conexion.is_connected():
                print("Conexión a la base de datos exitosa")
        except Error as e:
            print(f"Error al conectar a la base de datos: {e}")

    def registrar_producto(self, nombre, precio, cantidad):
        try:
            cursor = self.conexion.cursor()
            cursor.callproc('registrar_producto', [nombre, precio, cantidad])
            self.conexion.commit()
            print("Producto registrado exitosamente")
        except Error as e:
            print(f"Error al registrar producto: {e}")

    def actualizar_producto(self, id_producto, nombre, precio, cantidad):
        try:
            cursor = self.conexion.cursor()
            cursor.callproc('actualizar_producto', [id_producto, nombre, precio, cantidad])
            self.conexion.commit()
            print("Producto actualizado exitosamente")
        except Error as e:
            print(f"Error al actualizar producto: {e}")

    def eliminar_producto(self, id_producto):
        try:
            cursor = self.conexion.cursor()
            cursor.callproc('eliminar_producto', [id_producto])
            self.conexion.commit()
            print("Producto eliminado exitosamente")
        except Error as e:
            print(f"Error al eliminar producto: {e}")

    def consultar_producto(self, id_producto):
        try:
            cursor = self.conexion.cursor()
            cursor.callproc('consultar_producto', [id_producto])
            for result in cursor.stored_results():
                print(result.fetchall())
        except Error as e:
            print(f"Error al consultar producto: {e}")
