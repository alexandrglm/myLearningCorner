function thisWorks() {
    alert('This action works!');
}

const image = document.querySelector('.exampleWithShadowBox');

image.addEventListener('mouseover', () => {
    image.src = '../img/example2.png';
});

image.addEventListener('mouseout', () => {
    image.src = '../img/lmr7a8E.png';
});

image.addEventListener('click', () => {
    alert('CodePen gives you a lightweight HTML-CSS-JS IDE!. Anyway, this a basic HTML/CSS/JS demo for a Bootcamp. Thanks.');
    
});
