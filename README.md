<p align="center">
  <img src="assets/logo.png" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white"/>
  <img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
</p>

## 📲 Sobre

<p align = "justify">
  Este é um projeto feito como parte de um desafio técnico proporcionado pela <a href="https://tunts.rocks/">Tunts.Rocks</a>, onde o objetivo consiste em ler uma planilha com diversos estudantes e suas respectivas faltas e notas,
  realizar os cálculos necessários dado uma série de regras pré-definidas e escrever a situação de cada aluno na planilha de forma automatizada.
</p>

## 📋 Sumário

   * [Sobre]()
   * [Sumário]()
   * [Funcionalidades]()
   * [Como Executar]()
     * [Pré-requisitos]()
     * [Executando a Aplicação]()
   * [Referências]()
   * [Autor]()

## 🧠 Funcionalidades

- [x] Leitura dos dados da planilha
- [x] Cálculo da situação e nota dos alunos
- [x] Escrita dos resultados na planilha

## 🧑‍💻 Como Executar

<p align = "justify">
  Através do Maven, foi possível criar um arquivo JAR para ser executado ao invés de rodar a aplicação diretamente na IDE, no entanto ainda são necessários alguns pré-requisitos para que a aplicação
  funcione corretamente.
</p>

### 🚀 Pré-requisitos

<p align = "justify">
  Primeiramente é necessário que se tenha a ferramenta de versionamento de códigos <b>Git</b> para que seja possível clonar o repositório através do GitHub. Para Windows é possível baixar a versão
  executável da ferramenta <a href="https://gitforwindows.org/">aqui.</a> Abaixo listo algumas formas de instalar a ferramenta em distribuições Linux através do terminal.
</p>

#### Debian/Ubuntu e Derivados

```
sudo apt install git
```

#### Arch Linux e Derivados

```
sudo pacman -S git
```

<p align = "justify">
  Além disso, deve-se instalar o Java (bem como o JDK e JRE) na máquina para executar a aplicação. <a href="https://www.oracle.com/java/technologies/downloads/#jdk21-windows">Aqui</a> se encontram as
  versões para Windows, deixarei abaixo os comandos para distribuições Linux.
</p>


#### Debian/Ubuntu e Derivados

```
sudo apt install default-jre
```
```
sudo apt install default-jdk
```

#### Arch Linux e Derivados

```
sudo pacman -S jre-openjdk
```
```
sudo pacman -S jdk-openjdk
```

### 🖳 Executando a Aplicação

<p align = "justify">
  Primeiramente é necessário clonar o repositório do projeto para a sua máquina local pelo terminal:
</p>

```
git clone https://github.com/gufernandess/devtraining_challenge.git
```
<p align = "justify">
  Dessa forma o arquivo JAR poderá ser executado com o seguinte comando:
</p>

```
java -jar devtraining_challenge/target/devtraining_challenge-1.0-SNAPSHOT-jar-with-dependencies.jar
```

<p align = "justify">
  Como a aplicação está na versão de teste, seu acesso é limitado, então provavelmente será aberto uma aba em seu navegador que irá pedir pelas credenciais que permitem o acesso a planilha.
  Para passar por esse obstáculo decidi criar uma conta de teste na Google e botá-la como usuário de teste dentro do projeto, permitindo que qualquer pessoa com as credenciais
  teste a aplicação.
</p>

<p align = "justify">
  O e-mail para teste é <b>u0484800@gmail.com</b> e a senha é <b>Bs317|{w`f\F</b>.
</p>

<p align = "justify">
  Você pode acessar a planilha clicando <a href="https://docs.google.com/spreadsheets/d/1R_Mns-PFo3uuLZVeYKrndmPPL3QOw-yKNMZ4AQW20l0/edit?usp=sharing">aqui</a>.
</p>

## 🔧 Referências

- [Google Sheets API Overview](https://developers.google.com/sheets/api/guides/concepts)
- [Java Quickstart](https://developers.google.com/sheets/api/quickstart/java)
- [𝗖𝗿𝗲𝗮𝘁𝗲, 𝗥𝗲𝗮𝗱 𝗮𝗻𝗱 𝗪𝗿𝗶𝘁𝗲 𝗚𝗼𝗼𝗴𝗹𝗲 𝗦𝗵𝗲𝗲𝘁𝘀 𝘃𝗶𝗮 𝗚𝗼𝗼𝗴𝗹𝗲 𝗦𝗵𝗲𝗲𝘁𝘀 𝗔𝗣𝗜𝘀 𝘂𝘀𝗶𝗻𝗴 𝗢𝗔𝘂𝘁𝗵 𝟮.𝟬 𝘄𝗶𝘁𝗵 𝗝𝗮𝘃𝗮+𝗠𝗮𝘃𝗲𝗻 - 𝗣𝗮𝗿𝘁 𝟮](https://www.youtube.com/watch?v=fXECiVFgf6c&t=1129s)

## ✍️ Autor

<b><i>[Gustavo Fernandes](https://github.com/gufernandess)</i>
