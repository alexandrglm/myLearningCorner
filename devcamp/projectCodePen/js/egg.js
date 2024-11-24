function thisWorks() {
    alert('You\'ve found a secret! Get ready!');
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
    scroll.style.animation = 'scrollUp 93s linear forwards';
});

/* estrellitas! */

const itsRainingStars = document.querySelector('.itsRainingStars');

function starsShower() {
    const stars = document.createElement('div');
    stars.classList.add('stars');
    
    const randomStar = Math.random() < 0.5 ? 'star1.png' : 'star2.png';
    stars.style.backgroundImage = `url('../img/${randomStar}')`;

    stars.style.left = Math.random() * 100 + 'vw';
    
    const fallDuration = Math.random() * 3 + 7 + 's';
    const sparkleDuration = Math.random() * 2 + 3 + 's';
    stars.style.animationDuration = fallDuration;
    stars.style.animationDelay = Math.random() * 2 + 's';

    stars.style.animation = `fall ${fallDuration} linear infinite, sparkle ${sparkleDuration} ease-in-out infinite`;

    itsRainingStars.appendChild(stars);

    setTimeout(() => {
        stars.remove();
    }, parseFloat(fallDuration) * 1000);
}

setInterval(starsShower, 200);
