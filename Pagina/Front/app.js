const baseURL = "http://localhost:8080/medicos";

// Registrar Médico
const form = document.getElementById('medico-form');
form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const medicoData = {
        nombre: document.getElementById('nombre').value,
        email: document.getElementById('email').value,
        documento: document.getElementById('documento').value,
        telefono: document.getElementById('telefono').value,
        especialidad: document.getElementById('especialidad').value,
        direccion: {
            calle: document.getElementById('calle').value,
            distrito: document.getElementById('distrito').value,
            ciudad: document.getElementById('ciudad').value,
            numero: document.getElementById('numero').value,
            complemento: document.getElementById('complemento').value
        }
    };

    await fetch(baseURL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(medicoData)
    });

    alert("Médico Registrado");
    fetchMedicos();
});

// Listar Médicos
async function fetchMedicos() {
    const response = await fetch(`${baseURL}?size=5`);
    const data = await response.json();

    const medicosList = document.getElementById('medicos-list');
    medicosList.innerHTML = '';
    data.content.forEach(medico => {
        const div = document.createElement('div');
        div.classList.add('col-md-4');
        div.innerHTML = `
            <div class="medico-card">
                <h5>${medico.nombre}</h5>
                <p><strong>Email:</strong> ${medico.email}</p>
                <p><strong>Especialidad:</strong> ${medico.especialidad}</p>
                <button onclick="deleteMedico(${medico.id})">Eliminar</button>
            </div>
        `;
        medicosList.appendChild(div);
    });
}

// Eliminar Médico
async function deleteMedico(id) {
    await fetch(`${baseURL}/${id}`, { method: "DELETE" });
    alert("Médico eliminado.");
    fetchMedicos();
}

// Inicializar la lista de médicos
fetchMedicos();
