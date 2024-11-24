const favicon = document.getElementById('favicon');

if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
    favicon.href = '../img/logo-white.png';
} else {
    favicon.href = '../img/logo-black.png'
}

function thisWorks() {
    alert('You\'ve found a secret! Get Ready!');
}

const audio = document.querySelector('.eggAudio');
const gif = document.querySelector('.eggGif');
const scroll = document.querySelector('.scrollingFarewell');
const eggContainer = document.querySelector('.egg');
const playButton = document.querySelector('.playButton');
const initialMessage = document.querySelector('.initialMessage');

playButton.addEventListener('click', () => {
    initialMessage.style.display = 'none';
    eggContainer.style.display = 'grid';
    audio.play();
    gif.style.display = 'block';
    scroll.style.visibility = 'visible';
    scroll.style.opacity = '1';
    scroll.style.animation = 'none';
    void scroll.offsetWidth;
    scroll.style.animation = 'scrollUp 90s linear forwards';
});

/* estrellitas! */

const itsRainingStars = document.querySelector('.itsRainingStars');
const arrayStars = ['star1.png', 'star2.png', 'star3.png', 'star4.png', 'star5.png'];

function starsShower() {
    const stars = document.createElement('div');
    stars.classList.add('stars');
  
    const randomStar = arrayStars[ Math.floor(Math.random() * arrayStars.length) ];
    stars.style.backgroundImage = `url('../img/${randomStar}')`;
  
    stars.style.left = Math.random() * 100 + 'vw';
    stars.style.top = Math.random() * -100 + 'px';
  
    const size = Math.random() * 28 + 5;
    stars.style.width = `${size}px`;
    stars.style.height = `${size}px`;
  
    stars.style.opacity = Math.random() * 0.5 + 0.5;
  
    const fallDuration = Math.random() * 5 + 5 + 's';
    const sparkleDuration = Math.random() * 2 + 1 + 's';
  
    // const rotateDirection = Math.random() < 0.5 ? 1 : -1;
    // const rotateDegrees = rotateDirection * 360;
  
    stars.style.animation = `fall ${fallDuration} linear infinite, 
                            sparkle ${sparkleDuration} ease-in-out infinite, 
                            rotate ${Math.random() * 5 + 5}s linear infinite`; 
  
    itsRainingStars.appendChild(stars);
  
    setTimeout(() => {
      stars.remove();
    }, parseFloat(fallDuration) * 1000);
  }
  
  setInterval(starsShower, 200);
