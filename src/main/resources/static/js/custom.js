// Efectos dinámicos para el frontend
document.addEventListener('DOMContentLoaded', function() {
    // Efecto de aparición gradual para las tarjetas
    const cards = document.querySelectorAll('.card-custom');
    cards.forEach((card, index) => {
        card.style.opacity = '0';
        card.style.transform = 'translateY(20px)';
        
        setTimeout(() => {
            card.style.transition = 'all 0.6s ease';
            card.style.opacity = '1';
            card.style.transform = 'translateY(0)';
        }, index * 100);
    });

    // Efecto de hover para los botones
    const buttons = document.querySelectorAll('[class*="btn-custom"]');
    buttons.forEach(button => {
        button.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-3px) scale(1.05)';
            this.style.boxShadow = '0 15px 35px rgba(0,0,0,0.2)';
        });
        
        button.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(0) scale(1)';
            this.style.boxShadow = '';
        });
    });

    // Efecto de partículas flotantes
    function createParticle() {
        const particle = document.createElement('div');
        particle.className = 'particle';
        particle.style.left = Math.random() * 100 + '%';
        particle.style.animationDelay = Math.random() * 6 + 's';
        particle.style.animationDuration = (Math.random() * 3 + 4) + 's';
        
        document.querySelector('.bg-particles').appendChild(particle);
        
        setTimeout(() => {
            particle.remove();
        }, 8000);
    }

    // Crear partículas periódicamente
    setInterval(createParticle, 1000);

    // Efecto de typing para títulos
    function typeWriter(element, text, speed = 50) {
        let i = 0;
        element.innerHTML = '';
        
        function type() {
            if (i < text.length) {
                element.innerHTML += text.charAt(i);
                i++;
                setTimeout(type, speed);
            }
        }
        
        type();
    }

    // Aplicar efecto de typing a los títulos principales
    const mainTitles = document.querySelectorAll('.main-title');
    mainTitles.forEach(title => {
        const originalText = title.textContent;
        typeWriter(title, originalText, 100);
    });

    // Efecto de contador para badges numéricos
    function animateCounter(element, target, duration = 1000) {
        const start = 0;
        const increment = target / (duration / 16);
        let current = start;
        
        const timer = setInterval(() => {
            current += increment;
            if (current >= target) {
                element.textContent = target;
                clearInterval(timer);
            } else {
                element.textContent = Math.floor(current);
            }
        }, 16);
    }

    // Aplicar contador a badges
    const badges = document.querySelectorAll('.badge');
    badges.forEach(badge => {
        const value = parseInt(badge.textContent);
        if (!isNaN(value)) {
            animateCounter(badge, value);
        }
    });

    // Efecto de ondas al hacer clic
    function createRipple(e) {
        const button = e.currentTarget;
        const circle = document.createElement('span');
        const diameter = Math.max(button.clientWidth, button.clientHeight);
        const radius = diameter / 2;
        
        circle.style.width = circle.style.height = diameter + 'px';
        circle.style.left = e.clientX - button.offsetLeft - radius + 'px';
        circle.style.top = e.clientY - button.offsetTop - radius + 'px';
        circle.classList.add('ripple');
        
        const ripple = button.getElementsByClassName('ripple')[0];
        if (ripple) {
            ripple.remove();
        }
        
        button.appendChild(circle);
        
        setTimeout(() => {
            circle.remove();
        }, 600);
    }

    // Agregar efecto de ondas a los botones
    buttons.forEach(button => {
        button.addEventListener('click', createRipple);
    });

    // Efecto de paralaje suave
    window.addEventListener('scroll', () => {
        const scrolled = window.pageYOffset;
        const particles = document.querySelectorAll('.particle');
        
        particles.forEach((particle, index) => {
            const speed = 0.5 + (index * 0.1);
            particle.style.transform = `translateY(${scrolled * speed}px)`;
        });
    });

    // Validación de formularios con efectos visuales
    const forms = document.querySelectorAll('form');
    forms.forEach(form => {
        form.addEventListener('submit', function(e) {
            const inputs = form.querySelectorAll('input[required], select[required]');
            let isValid = true;
            
            inputs.forEach(input => {
                if (!input.value.trim()) {
                    isValid = false;
                    input.style.borderColor = '#ef4444';
                    input.style.boxShadow = '0 0 0 3px rgba(239, 68, 68, 0.1)';
                    
                    setTimeout(() => {
                        input.style.borderColor = '';
                        input.style.boxShadow = '';
                    }, 3000);
                }
            });
            
            if (!isValid) {
                e.preventDefault();
                
                // Shake effect para el formulario
                form.style.animation = 'shake 0.5s';
                setTimeout(() => {
                    form.style.animation = '';
                }, 500);
            }
        });
    });
});

// Keyframes para animaciones CSS
const style = document.createElement('style');
style.textContent = `
    @keyframes shake {
        0%, 100% { transform: translateX(0); }
        10%, 30%, 50%, 70%, 90% { transform: translateX(-10px); }
        20%, 40%, 60%, 80% { transform: translateX(10px); }
    }
    
    .ripple {
        position: absolute;
        border-radius: 50%;
        background: rgba(255, 255, 255, 0.4);
        transform: scale(0);
        animation: ripple-animation 0.6s linear;
        pointer-events: none;
    }
    
    @keyframes ripple-animation {
        to {
            transform: scale(4);
            opacity: 0;
        }
    }
`;
document.head.appendChild(style);
