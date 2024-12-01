document.addEventListener("DOMContentLoaded", () => {
    const mainContent = document.getElementById("main-content");
    const logoutBtn = document.getElementById("logout");
    const registerProductBtn = document.getElementById("register-product");
    const viewInventoryBtn = document.getElementById("view-inventory");
    const makeSaleBtn = document.getElementById("make-sale");

    if (!localStorage.getItem("loggedIn")) {
        window.location.href = "index.html";
    }

    logoutBtn.addEventListener("click", () => {
        localStorage.removeItem("loggedIn");
        window.location.href = "index.html";
    });

    registerProductBtn.addEventListener("click", () => {
        mainContent.innerHTML = `
            <h2>Registrar Producto</h2>
            <form id="product-form">
                <label for="product-name">Nombre:</label>
                <input type="text" id="product-name" required>
                <label for="product-price">Precio:</label>
                <input type="number" id="product-price" required>
                <label for="product-stock">Stock:</label>
                <input type="number" id="product-stock" required>
                <button type="submit">Guardar Producto</button>
            </form>
        `;
        const productForm = document.getElementById("product-form");
        productForm.addEventListener("submit", (e) => {
            e.preventDefault();
            const name = document.getElementById("product-name").value;
            const price = parseFloat(document.getElementById("product-price").value);
            const stock = parseInt(document.getElementById("product-stock").value);

            const products = JSON.parse(localStorage.getItem("products")) || [];
            products.push({ name, price, stock });
            localStorage.setItem("products", JSON.stringify(products));
            alert("Producto registrado correctamente");
        });
    });

    viewInventoryBtn.addEventListener("click", () => {
        const products = JSON.parse(localStorage.getItem("products")) || [];
        if (products.length === 0) {
            mainContent.innerHTML = "<p>No hay productos registrados</p>";
            return;
        }
        mainContent.innerHTML = `
            <h2>Inventario</h2>
            <ul>
                ${products.map(p => `
                    <li>${p.name} - Precio: $${p.price} - Stock: ${p.stock}</li>
                `).join('')}
            </ul>
        `;
    });

    makeSaleBtn.addEventListener("click", () => {
        const products = JSON.parse(localStorage.getItem("products")) || [];
        if (products.length === 0) {
            mainContent.innerHTML = "<p>No hay productos disponibles para vender</p>";
            return;
        }
        mainContent.innerHTML = `
            <h2>Realizar Venta</h2>
            <form id="sale-form">
                <label for="sale-product">Producto:</label>
                <select id="sale-product">
                    ${products.map((p, index) => `
                        <option value="${index}">${p.name} (Stock: ${p.stock})</option>
                    `).join('')}
                </select>
                <label for="sale-quantity">Cantidad:</label>
                <input type="number" id="sale-quantity" required>
                <button type="submit">Vender</button>
            </form>
        `;
        const saleForm = document.getElementById("sale-form");
        saleForm.addEventListener("submit", (e) => {
            e.preventDefault();
            const productIndex = parseInt(document.getElementById("sale-product").value);
            const quantity = parseInt(document.getElementById("sale-quantity").value);
            const products = JSON.parse(localStorage.getItem("products"));

            if (quantity > products[productIndex].stock) {
                alert("Stock insuficiente");
                return;
            }

            products[productIndex].stock -= quantity;
            localStorage.setItem("products", JSON.stringify(products));
            alert("Venta realizada correctamente");
        });
    });
});
