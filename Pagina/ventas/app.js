document.addEventListener("DOMContentLoaded", () => {
    // Chart.js initialization
    const ctx = document.getElementById("salesChart").getContext("2d");
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Producto A', 'Producto B', 'Producto C'],
            datasets: [{
                label: 'Ventas ($)',
                data: [500, 300, 200],
                backgroundColor: ['#1abc9c', '#3498db', '#e74c3c'],
            }]
        },
        options: {
            responsive: true,
        }
    });

    // Register Product
    const registerForm = document.getElementById("registerProductForm");
    registerForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const name = document.getElementById("productName").value;
        const price = document.getElementById("productPrice").value;
        const stock = document.getElementById("productStock").value;
        alert(`Producto registrado: ${name}, Precio: ${price}, Stock: ${stock}`);
    });

    // Sell Product
    const sellForm = document.getElementById("sellProductForm");
    sellForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const product = document.getElementById("productSelect").value;
        const quantity = document.getElementById("sellQuantity").value;
        alert(`Venta realizada: ${product}, Cantidad: ${quantity}`);
    });
});
