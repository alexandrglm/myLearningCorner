const favicon = document.getElementById('favicon');

    if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
        favicon.href = '../img/logo-white.png';
    } else {
        favicon.href = '../img/logo-black.png'
}

function thisWorks() {
    alert('This action works! ');
}


// ACE config method: setOption
var editorHTML = ace.edit("editorHTML");

editorHTML.setOptions({
    mode:   'ace/mode/html',
    theme:  'ace/theme/monokai',
    wrap:   true,
    useWorker:  true
});
editorHTML.insert(` <!--- Place your code here, or give a try by running this example --->
<div id="testing">
    <h1> Hello world in green</h1>
    <h1 class="testing2">Hello World in blue</h1>
    <h1> Hello world as :nth-child in yellow</h1>
</div>
<div>
    <ul><button class="testing3" onclick="action()">This button rules</button></ul>
</div>`.trim());

var editorCSS = ace.edit("editorCSS");
editorCSS.setOptions({
    mode:   'ace/mode/css',
    theme:  'ace/theme/monokai',
    wrap:   true,
    useWorker:  true
});
editorCSS.insert(`   // Test your CSS code here
#testing {
    font: normal 1rem 'Verdana', sans-serif;
    color: green;
}

#testing > .testing2 {
    color: blue;
}

#testing h1:nth-child(3) {
    font-size: 0.8rem;
    color: yellow
}`.trim());

var editorJS = ace.edit("editorJS");
editorJS.setOptions({
    mode:   'ace/mode/javascript',
    theme:  'ace/theme/monokai',
    wrap:   true,
    useWorker:  true
});
editorJS.insert(`/*
Here you can type and test your JS code
*/
function action() {
    alert("This button rules!");
}`.trim());


function runCode() {
    var html = editorHTML.getValue();
    var htmlTrimASVarNotAsMethod = html.trim()  
    var css = editorCSS.getValue();
    var js = editorJS.getValue();

    var hasHTMLStructure = /<html[\s\S]*?>|<!doctype[\s\S]*?>/i.test(htmlTrimASVarNotAsMethod);
    
    var srcdoc;
    if (hasHTMLStructure) {
        srcdoc = htmlTrimASVarNotAsMethod.replace(
            /<head[\s\S]*?>/i,
            (match) => `${match}\n<style>${css.trim()}</style>`
        ).replace(
            /<body[\s\S]*?>/i,
            (match) => `${match}\n<script>${js.trim()}<\/script>`
        );
    } else {
        srcdoc = `
        <!DOCTYPE html>
        <html>
        <head>
            <style>${css.trim()}</style>
        </head>
        <body>
            ${htmlTrimASVarNotAsMethod}
            <script>${js.trim()}<\/script>
        </body>
        </html>`;
    }

    $('#return').attr('srcdoc', srcdoc);
}
