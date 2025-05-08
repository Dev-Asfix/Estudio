// Neon Colors
const colors = ["#3CC157", "#2AA7FF", "#FCBC0F", "#F85F36", "#FF00FF"];

const numBalls = 50;
const balls = [];

for (let i = 0; i < numBalls; i++) {
  let ball = document.createElement("div");
  ball.classList.add("ball");
  ball.style.background = colors[Math.floor(Math.random() * colors.length)];
  ball.style.left = `${Math.floor(Math.random() * 100)}vw`;
  ball.style.top = `${Math.floor(Math.random() * 100)}vh`;
  const scale = Math.random() * 1.5 + 0.3;
  ball.style.transform = `scale(${scale})`;
  const size = `${scale}em`;
  ball.style.width = size;
  ball.style.height = size;

  balls.push(ball);
  document.body.append(ball);
}

// Movimiento flotante
balls.forEach((el, i) => {
  let to = {
    x: Math.random() * (i % 2 === 0 ? -11 : 11),
    y: Math.random() * 12
  };

  el.animate(
    [
      { transform: `translate(0, 0)` },
      { transform: `translate(${to.x}rem, ${to.y}rem)` }
    ],
    {
      duration: (Math.random() + 1) * 4000,
      direction: "alternate",
      fill: "both",
      iterations: Infinity,
      easing: "ease-in-out"
    }
  );
});
