import requests

BASE_URL = "http://127.0.0.1:5000"

def mostrar_menu():
    print("\n--- Biblioteca ---")
    print("1. Listar libros")
    print("2. Ver un libro")
    print("3. Agregar libro")
    print("4. Actualizar libro")
    print("5. Eliminar libro")
    print("0. Salir")
    return input("Seleccione una opción: ")

def listar_libros():
    response = requests.get(f"{BASE_URL}/libros")
    if response.status_code == 200:
        libros = response.json()
        print("\nID | Título | Autor | Año | Género")
        print("----------------------------------")
        for libro in libros:
            print(f"{libro['id']} | {libro['titulo']} | {libro['autor']} | {libro['ano']} | {libro['genero']}")
    else:
        print("Error al listar libros.")

def ver_libro():
    id_libro = input("Ingrese el ID del libro: ")
    response = requests.get(f"{BASE_URL}/libros/{id_libro}")
    if response.status_code == 200:
        libro = response.json()
        print(f"\nTítulo: {libro['titulo']}")
        print(f"Autor: {libro['autor']}")
        print(f"Año: {libro['ano']}")
        print(f"Género: {libro['genero']}")
    else:
        print("Libro no encontrado.")

def agregar_libro():
    titulo = input("Título: ")
    autor = input("Autor: ")
    ano = input("Año: ")
    genero = input("Género: ")
    data = {"titulo": titulo, "autor": autor, "ano": int(ano), "genero": genero}
    response = requests.post(f"{BASE_URL}/libros", json=data)
    if response.status_code == 201:
        print("Libro agregado correctamente.")
    else:
        print("Error al agregar el libro.")

def actualizar_libro():
    id_libro = input("Ingrese el ID del libro: ")
    titulo = input("Título: ")
    autor = input("Autor: ")
    ano = input("Año: ")
    genero = input("Género: ")
    data = {"titulo": titulo, "autor": autor, "ano": int(ano), "genero": genero}
    response = requests.put(f"{BASE_URL}/libros/{id_libro}", json=data)
    if response.status_code == 200:
        print("Libro actualizado correctamente.")
    else:
        print("Error al actualizar el libro.")

def eliminar_libro():
    id_libro = input("Ingrese el ID del libro: ")
    response = requests.delete(f"{BASE_URL}/libros/{id_libro}")
    if response.status_code == 200:
        print("Libro eliminado correctamente.")
    else:
        print("Error al eliminar el libro.")

def main():
    while True:
        opcion = mostrar_menu()
        if opcion == "1":
            listar_libros()
        elif opcion == "2":
            ver_libro()
        elif opcion == "3":
            agregar_libro()
        elif opcion == "4":
            actualizar_libro()
        elif opcion == "5":
            eliminar_libro()
        elif opcion == "0":
            break
        else:
            print("Opción no válida.")

if __name__ == "__main__":
    main()
