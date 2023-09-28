/*receber objetos*/
var cpf = document.getElementById("cpf");
var senha = document.getElementById("senha");
var erro = document.getElementById("erro");

/*função de login*/
function entrar(){
    if(cpf.textContent=="" || senha.textContent==""){
        erro.textContent = "os campos não podem estar em branco";
    } else{
        if(1=1){//verificar login pelo backend
            alert("não conectado ao backending ainda");
            //link para a pagina de login
        } else{
            erro.textContent = "usuario ou senha incorretos";
        }
    }
}