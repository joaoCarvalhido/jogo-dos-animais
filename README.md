# Jogo dos Animais

## Objetivo

Criar um pequeno jogo de adivinhação de animais, utilizando a biblioteca 'JOptionPane' do Java'.


## Problema

Como fazer o algoritomo saber qual animal você está pensando com base nos caracteristicas dos animais já inseridos? 

## Como foi implementado? O que eu pensei?

Bom, primeiro tive como base, a estruturação de um arquivo exemplo:

![screen](https://user-images.githubusercontent.com/57717791/77805011-b212c500-705f-11ea-862d-efc321651d19.jpg)

### Pacote dao

Após usar a mesma estruturação de arquivos, implementei o padrão DAO(Data Access Object), criando uma **Classe** e uma **Interface**:

**AnimalDAO**: Contrato definindo os métodos para serem usados;

**AnimalDAOImpl**: Classe de implementação do contrato mencionado acima, garantindo um lugar unico para acesso aos dados;

### Pacote entidade

Vendo que na estruturação original, tinha um pacote chamado "entidade", crie uma Classe **Animal** 
simulando uma uma entidade em um banco de dados relacional, contendo os atributos:

**id**;

**nome**;

**acao**;

### Pacote tela


Antes de eu implementar as regras do negócio, tive de criar uma classe **Mensagem**, pois para mim, fica mais fácil desenvolver quando
tenho algo visual para entender, portanto, criei uma classe que contém os métodos de mostrar as janelas da biblioteca "JOptionPane".

Agora vamos para a parte mais complexa do código...

### Pacote negocio

Primeiro, criei a classe **funcoes**, no qual eu usaria os métodos da classe **AnimaisDAOImplements**, juntamente com minhas 
regras de negócio. Como exemplo:

**animal padrão**, para caso todas as alternativas tivessem esgotado;

**novo animal**, mesmo que até o animal padrão não for o que o usuário está pensando, ele mesmo pode adicionar;

**incrimenta id**, quando um animal novo for inserido, o id é gerado automaticamente;

**animal anterior**, qual é a diferença do animal inserido pelo usuário, com o último animal mencionado?;

**animal posterior**, quando o jogo começar a perguntar qual animal o usuário está pensando, ele precisa mencionar as 
características do animal, mas caso não for o animal certo, algoritmo vai para o outro animal já inserido e pergunta se é 
o animal correto. Porém tenho o cuidado de garantir q o animal posterior não seja um animal ainda não inserido.

Agora para finalizar a lógica do algoritmo temos a classe:

**Pacote logica**

Nome não menos intuitivo, aqui utilizo os métodos mencionados acima para realmente fazer a mágica acontecer.

No começo fiquei em dúvida em qual maneira faria o laço de repetição do menu, mas acabei utilizando a forma recursiva
no qual ao chegar na última etapa do jogo, eu chamo o método **menuRecursivo**, e fica sempre repetindo até que o usuário
clique na opção "cancelar". Para isso criei um método chamado **naoPararMenuRecursivo**.

Agora para perguntar ao usuário se as características já inseridas batem com a característica do animal em mente, utilizo
o método **descobrirAnimal**, que recebe como parâmetro o **animalAtual**(primeiro inserido), e 
vou perguntanddo se o **animalAtual** bate com as caracteristicas , caso contrario, utilizo o método **animalPosterior**
e atualizo o objeto **animalAtual** para o próximo animal da lista, repito o procedimento até que chegue no 
limite dos animais inseridos no jogo, logo após pergunto ao usuário qual era o animal em mente 
e o porquê da sua caracteristica se diferenciar do **animalAnterior**.

Porém nem tudo é resposta negativa, caso a ação do animal bata com o animal em mente, eu apenas chamo o método
da classe **AnimalDAOImplements**,  por tudo ser objeto, facilita na hora de buscar as cararcteristicas.

## Conclusão

Nesse arquivo tentei resumir meus pensamentos e implementações do código, mas acredito que é o suficiente
para registro, e guia para caso alguém queira dar uma olhada.

Se você chegou até aqui, muito obrigado e até a próxima.


## Algumas imagens do jogo

![1](https://user-images.githubusercontent.com/57717791/77807670-53514980-7067-11ea-9f60-f36d78362450.jpg)
![2](https://user-images.githubusercontent.com/57717791/77807675-551b0d00-7067-11ea-8567-907257f5cba9.jpg)
![3](https://user-images.githubusercontent.com/57717791/77807677-55b3a380-7067-11ea-9529-cc2025bbeeca.jpg)
![4](https://user-images.githubusercontent.com/57717791/77807679-564c3a00-7067-11ea-9993-86b891a1533f.jpg)
![5](https://user-images.githubusercontent.com/57717791/77807680-56e4d080-7067-11ea-994e-f6b33f1c8ae9.jpg)
![6](https://user-images.githubusercontent.com/57717791/77807682-577d6700-7067-11ea-8640-cf7709f0541c.jpg)
![7](https://user-images.githubusercontent.com/57717791/77807683-5815fd80-7067-11ea-86b9-4aec9a8f9e56.jpg)
