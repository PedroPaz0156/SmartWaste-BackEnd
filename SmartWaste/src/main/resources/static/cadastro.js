/*receber objetos*/
var nome = document.getElementById("nome");
var cpf = document.getElementById("cpf");
var email = document.getElementById("email");
var senha = document.getElementById("senha");
var confSenha = document.getElementById("confSenha");
var erro = document.getElementById("erro");

/*função de login*/
function cadastrar(){
    if(nome.textContent=="" || cpf.textContent=="" || email.textContent=="" || senha.textContent=="" || confSenha.textContent==""){    
        erro.textContent = "os campos não podem estar em branco";
    } else{
        if(senha==confSenha){

            if(1=1){//verificar cadastro pelo backend
                alert("não conectado ao backending ainda");
                //link para a pagina de login
            } else{
                erro.textContent = "não foi possivel cadastrar";
            }
        } else{
            erro.textContent = "as senhas não coincidem";
        }
    }
}