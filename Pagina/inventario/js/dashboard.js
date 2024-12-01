document.addEventListener("DOMContentLoaded", () => {
    const contentArea = document.getElementById("content-area");
    const links = {
        dashboard: document.getElementById("dashboard-link"),
        products: document.getElementById("products-link"),
        sales: document.getElementById("sales-link"),
        reports: document.getElementById("reports-link"),
        logout: document.getElementById("logout-link"),
    };

    const loadContent = (content) => {
        contentArea.innerHTML = content;
    };

    links.dashboard.addEventListener("click", () => {
        loadContent("<h2>Bienvenido al Dashboard</h2><p>Aquí encontrarás estadísticas generales.</p>");
    });

    links.products.addEventListener("click", () => {
        loadContent("<h2>Gestión de Productos</h2><p>Aquí puedes agregar, editar o eliminar productos.</p>");
    });

    links.sales.addEventListener("click", () => {
        loadContent("<h2>Gestión de Ventas</h2><p>Registra tus ventas aquí.</p>");
    });

    links.reports.addEventListener("click", () => {
        loadContent("<h2>Reportes</h2><canvas id='salesChart'></canvas>");
        renderSalesChart();
    });

    links.logout.addEventListener("click", () => {
        localStorage.removeItem("loggedIn");
        window.location.href = "index.html";
    });

    const renderSalesChart = () => {
        const ctx = document.getElementById("salesChart").getContext("2d");
        new Chart(ctx, {
            type: "bar",
            data: {
                labels: ["Enero", "Febrero", "Marzo", "Abril"],
                datasets: [{
                    label: "Ventas",
                    data: [10, 20, 15, 25],
                    backgroundColor: "rgba(0, 123, 255, 0.5)"
                }]
            }
        });
    };
});
