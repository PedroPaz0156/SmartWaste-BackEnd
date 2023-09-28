/* Receber objetos */
var menu = document.getElementById("menu");
var mnAddPnt = document.getElementById("adicionar");
var mnDelPnt = document.getElementById("remover");
var mnEditPnt = document.getElementById("editar");
var mnGrrRltr = document.getElementById("relatorio");
var listaPnts = document.getElementById("listaPontos");
var sair = document.getElementById("sair");

function abrirMenu(){
    menu.style.display = "block";
}

function fecharMenu(){
    menu.style.display = "none";
}

function abrirAddPnt(){
    mnAddPnt.style.display = "block";
}

function fecharAddPnt(){
    mnAddPnt.style.display = "none";
}

function abrirEditPnt(){
    mnEditPnt.style.display = "block";
}

function fecharEditPnt(){
    mnEditPnt.style.display = "none";
}

function abrirDelPnt(){
    mnDelPnt.style.display = "block";
}

function fecharDelPnt(){
    mnDelPnt.style.display = "none";
}

function abrirGerarRelatorio(){
    mnGrrRltr.style.display = "block";
}

function fecharGerarRelatorio(){
    mnGrrRltr.style.display = "none";
}

function abrirListaPnts(){
    listaPnts.style.display = "block";
}

function fecharListaPnts(){
    listaPnts.style.display = "none";
}

function abrirSair(){
    menu.style.display = "block";
}

function fecharSair(){
    menu.style.display = "none";
}