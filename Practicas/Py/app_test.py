import unittest

class TestProducto(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.producto = Producto('localhost', 'root', 'password', 'inventario')

    def test_registrar_producto(self):
        self.producto.registrar_producto("Laptop", 1500.50, 10)
        # Aquí puedes agregar más verificaciones con consultas directas

    def test_actualizar_producto(self):
        self.producto.actualizar_producto(1, "Laptop Pro", 1700.00, 5)

    def test_eliminar_producto(self):
        self.producto.eliminar_producto(1)

    def test_consultar_producto(self):
        self.producto.consultar_producto(1)

    @classmethod
    def tearDownClass(cls):
        cls.producto.conexion.close()


if __name__ == '__main__':
    unittest.main()
