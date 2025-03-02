document.addEventListener('DOMContentLoaded', () => {
    const startBtn = document.getElementById('startSimulation');
    startBtn.addEventListener('click', startSimulation);
});

function addStep(text) {
    const stepsContainer = document.getElementById('steps');
    const stepElem = document.createElement('div');
    stepElem.className = 'step';
    stepElem.textContent = text;
    stepsContainer.appendChild(stepElem);
    stepsContainer.scrollTop = stepsContainer.scrollHeight; // Autoscroll
}

function updateVarDisplay(x, hr) {
    const varX = document.querySelector('#var-x .value');
    const varHR = document.querySelector('#var-hr .value');

    varX.textContent = x;
    varHR.textContent = hr;

    // Efecto de animación al actualizar
    varX.classList.add('updated');
    varHR.classList.add('updated');

    setTimeout(() => {
        varX.classList.remove('updated');
        varHR.classList.remove('updated');
    }, 600);
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function simulatePalindrome(originalNumber) {
    const stepsContainer = document.getElementById('steps');
    stepsContainer.innerHTML = ''; // Limpiar pasos anteriores

    let x = parseInt(originalNumber, 10);
    let hr = 0;

    updateVarDisplay(x, hr);
    addStep(`Inicialización: x = ${x}, halfReversed = ${hr}`);
    await sleep(1500);

    while (x > hr) {
        let digit = x % 10;
        addStep(`Extraer dígito: ${digit} (x % 10)`);
        await sleep(1500);

        let newHR = hr * 10 + digit;
        addStep(`Actualizar halfReversed: ${hr} * 10 + ${digit} = ${newHR}`);
        hr = newHR;
        updateVarDisplay(x, hr);
        await sleep(1500);

        let newX = Math.floor(x / 10);
        addStep(`Reducir x: Math.floor(${x} / 10) = ${newX}`);
        x = newX;
        updateVarDisplay(x, hr);
        await sleep(1500);

        addStep(`Estado actual: x = ${x}, halfReversed = ${hr}`);
        await sleep(1500);
    }

    addStep(`Comparación final: x = ${x}, halfReversed = ${hr}, halfReversed/10 = ${Math.floor(hr / 10)}`);
    await sleep(1500);

    let result = (x === hr || x === Math.floor(hr / 10));
    addStep(`Resultado: ${result ? "Es palíndromo" : "No es palíndromo"}`);
}

function startSimulation() {
    const inputField = document.getElementById('inputNumber');
    const inputValue = inputField.value.trim();
    if (!inputValue || isNaN(inputValue)) {
        alert('Por favor, ingresa un número válido.');
        return;
    }
    simulatePalindrome(inputValue);
}
