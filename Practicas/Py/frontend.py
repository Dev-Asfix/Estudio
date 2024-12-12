import tkinter as tk
from tkinter import messagebox

def registrar_producto():
    nombre = entry_nombre.get()
    precio = float(entry_precio.get())
    cantidad = int(entry_cantidad.get())
    producto.registrar_producto(nombre, precio, cantidad)
    messagebox.showinfo("Éxito", "Producto registrado exitosamente")

producto = Producto('localhost', 'root', 'password', 'inventario')

root = tk.Tk()
root.title("Sistema de Inventario")

tk.Label(root, text="Nombre:").pack()
entry_nombre = tk.Entry(root)
entry_nombre.pack()

tk.Label(root, text="Precio:").pack()
entry_precio = tk.Entry(root)
entry_precio.pack()

tk.Label(root, text="Cantidad:").pack()
entry_cantidad = tk.Entry(root)
entry_cantidad.pack()

tk.Button(root, text="Registrar Producto", command=registrar_producto).pack()

root.mainloop()
