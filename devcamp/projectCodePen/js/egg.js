// dark/light favicon
const favicon = document.getElementById('favicon');

if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
  favicon.href = '../img/logo-white.png';
} else {
  favicon.href = '../img/logo-black.png';
}

// fake buttons action
function thisWorks() {
  alert('You\'ve found a secret! Get Ready!');
}

// sonic leaves logic
function theEnd() {
  const divText = document.createElement('div');
  const texto = "End.";
  let i = 0;

  divText.style.font = 'normal bold 40px/1 "Pixelify Sans"';
  divText.style.textAlign = 'left';
  divText.style.color = 'whitesmoke';
  divText.style.textShadow = '5px 5px 5px black';
  divText.style.position = 'fixed';
  divText.style.top = '70%';
  divText.style.left = '53%';
  divText.style.transform = 'translate(-50%, -50%)';
  divText.style.color = 'white';
  divText.style.zIndex = '999999';
  document.body.appendChild(divText);

// the end function
function letraALetra() {
    if (i < texto.length) {
      divText.textContent += texto.charAt(i);
      i++;
      setTimeout(letraALetra, 500);
    }
  }

  letraALetra();
}

setTimeout(() => {
  const gif = document.querySelector('.eggGif'); 
  gif.classList.add('sonicLeaves');
}, 88500);

// get ready timers and logic
const getReady = document.querySelector('.getReady');
const audio = document.querySelector('.eggAudio');
const gif = document.querySelector('.eggGif');
const scroll = document.querySelector('.scrollingFarewell');
const eggContainer = document.querySelector('.egg');
const initialMessage = document.querySelector('.initialMessage');

getReady.addEventListener('click', () => {
  initialMessage.style.display = 'none';
  eggContainer.style.display = 'grid';
  audio.currentTime = 0; 
  audio.play();
  gif.style.display = 'block';
  scroll.style.visibility = 'visible';
  scroll.style.opacity = '1';
  scroll.style.animation = 'none';
  void scroll.offsetWidth;
  scroll.style.animation = 'scrollUp 90s linear forwards';

  const input = document.getElementsByClassName('yourName')[0]; 
  const yourName = input.value.trim(); 
  const greetingSpan = document.querySelector('.greetings');

  if (yourName) { 
    const greeting = `Hey, ${yourName}, even the admon. thought they were so clever mocking me, but turns out I had the last laugh:`;
    greetingSpan.textContent = greeting;
    greetingSpan.style.visibility = 'visible';
    greetingSpan.style.font = 'normal bold 1.5rem "Pixelify Sans"'; 
    greetingSpan.style.backgroundImage = 'linear-gradient(to right, #ff5757, #ff9a3c, #ffd43b, #73e25d, #5dbbff, #857dff, #ff57cf)';
    greetingSpan.style.border = 'solid 1px whitesmoke;'
    greetingSpan.style.padding = '0.5em 0.5em';
    greetingSpan.style.webkitBackgroundClip = 'text';
    greetingSpan.style.webkitTextFillColor = 'transparent';
    greetingSpan.style.animation = 'sparkle 2s ease-in-out infinite';
    greetingSpan.style.opacity = '1';
    greetingSpan.style.transition = 'opacity 1s ease-in-out';

    setTimeout(() => {
      greetingSpan.style.animation = 'none'; 
      void greetingSpan.offsetWidth; 
      greetingSpan.style.opacity = '0';
      setTimeout(() => {
        greetingSpan.style.visibility = 'hidden';
      }, 1000);
    }, 8000);
  }

  setTimeout(theEnd, 88200); 
});


/* estrellitas! */
const itsRainingStars = document.querySelector('.itsRainingStars');
itsRainingStars.style.zIndex = '1000000';
const arrayStars = ['star1.png', 'star2.png', 'star3.png', 'star4.png', 'star5.png'];

let starsInterval;
let stopGenerating = false;

function starsShower() {
  if (stopGenerating) return;
  const star = document.createElement('div');
  star.classList.add('stars');

  const randomStar = arrayStars[Math.floor(Math.random() * arrayStars.length)];
  star.style.backgroundImage = `url('../img/${randomStar}')`;

  star.style.left = Math.random() * 100 + 'vw';
  star.style.top = Math.random() * -100 + 'px';

  const size = Math.random() * 28 + 5;
  star.style.width = `${size}px`;
  star.style.height = `${size}px`;

  star.style.opacity = Math.random() * 0.5 + 0.5;

  const fallDuration = Math.random() * 5 + 5 + 's';
  const sparkleDuration = Math.random() * 2 + 1 + 's';

  star.style.animation = `fall ${fallDuration} linear, sparkle ${sparkleDuration} ease-in-out infinite`;

  itsRainingStars.appendChild(star);

  setTimeout(() => {
    star.remove();
  }, parseFloat(fallDuration) * 1000);
}


starsInterval = setInterval(starsShower, 150);

setTimeout(() => {
  stopGenerating = true;
  clearInterval(starsInterval);
}, 87000);


// parallax bg bubbles

const bubbleContainer = document.querySelector('.egg');

function createBubble() {
  const bubble = document.createElement('div');
  bubble.classList.add('bubble');

  const size = Math.random() * 50 + 10;
  bubble.style.width = size + 'px';
  bubble.style.height = size + 'px';

  const xStart = Math.random() * 100 + '%';
  const yStart = Math.random() * 100 + '%';
  const xEnd = Math.random() * 200 - 100 + '%';
  const yEnd = Math.random() * 200 - 100 + '%';

  bubble.style.setProperty('--x-start', xStart);
  bubble.style.setProperty('--y-start', yStart);
  bubble.style.setProperty('--x-end', xEnd);
  bubble.style.setProperty('--y-end', yEnd);

  bubble.style.left = `calc(${xStart})`;
  bubble.style.top = `calc(${yStart})`;

  const duration = Math.random() * 10 + 10;
  bubble.style.animationDuration = `${duration}s`;

  bubbleContainer.appendChild(bubble);

  bubble.addEventListener('animationend', () => {
    bubble.remove();
    createBubble();
  });
}

for (let i = 0; i < 40; i++) {
  createBubble();
}
