const favicon = document.getElementById('favicon');

if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
    favicon.href = '../img/logo-white.png';
} else {
    favicon.href = '../img/logo-black.png'
}

function thisWorks() {
    alert('This action works! ');
}

var editorHTML = ace.edit("editorHTML");
editorHTML.setTheme("ace/theme/monokai");
editorHTML.session.setMode("ace/mode/html");

var editorCSS = ace.edit("editorCSS");
editorCSS.setTheme("ace/theme/monokai");
editorCSS.session.setMode("ace/mode/css");

var editorJS = ace.edit("editorJS");
editorJS.setTheme("ace/theme/monokai");
editorJS.session.setMode("ace/mode/javascript");

const OutputLogic = document.getElementById('output');
const ConsoleLogic = document.getElementById('console');

const consoleLogic = console.log;
console.log = function(...args) {
    ConsoleLogic.textContent += args.join(' ') + '\n';
    consoleLogic(...args);
}

try {
    const htmlCode = editorHTML.getValue();
    const cssCode = editorCSS.getValue();
    const jsCode = editorJS.getValue();

    const iframe = document.createElement('iframe');
    document.body.appendChild(iframe); 
    iframe.contentWindow.document.open();
    iframe.contentWindow.document.write(` 1 
        <!DOCTYPE html>
        <html>
        <head>
          <style>${cssCode}</style>
        </head>
        <body>
          ${htmlCode}
          <script>${jsCode}</script>
        </body>
        </html>
    `);
    iframe.contentWindow.document.close();

    setTimeout(() => {
        OutputLogic.innerHTML = iframe.contentWindow.document.body.innerHTML;
    }, 1000); 
} catch (error) {
    console.error(error);
} finally {
    console.log = consoleLogic;
}
