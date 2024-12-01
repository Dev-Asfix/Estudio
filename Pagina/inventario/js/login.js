document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("login-form");
    const loginError = document.getElementById("login-error");

    loginForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        if (username === "admin" && password === "1234") {
            localStorage.setItem("loggedIn", "true");
            window.location.href = "dashboard.html";
        } else {
            loginError.textContent = "Usuario o contraseña incorrectos";
        }
    });
});
