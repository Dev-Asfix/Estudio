// Smooth scroll for navigation
document.querySelectorAll('nav ul li a').forEach(link => {
    link.addEventListener('click', event => {
        event.preventDefault();
        const section = document.querySelector(event.target.getAttribute('href'));
        section.scrollIntoView({ behavior: 'smooth' });
    });
});

// Expand all FAQs automatically on page load
document.querySelectorAll('details').forEach(detail => {
    detail.open = false;
});
