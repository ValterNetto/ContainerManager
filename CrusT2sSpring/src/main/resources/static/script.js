
//  Encapsulamento 
const url = "http://localhost:8080";
const loadContainer = document.getElementById('loadingContainer');
const notFoundContainer = document.getElementById("notFoundContainer");
const errorMessage = document.getElementById("errorMessage");

getContainerData();

//Validações 
function validaContainer() {
  const tbContainer = document.getElementById("tbContainer");
  const contNumPure = document.getElementById("contnum");
  const selCont = document.getElementById("selcont").value;
  const selStat = document.getElementById("selstat").value;
  const selCat = document.getElementById("selcat").value;

  //Formatação 
  const cliente = tbContainer.value.trim();

  const contNum = contNumPure.value.toUpperCase();;

  formatacaoCont = /^[A-Z]{4}[0-9]{7}$/;
  formatacaoCliente = /^[A-Z]$/;


  //Condições
  if (cliente === null || cliente === "" || cliente.length < 3) {
    throw errorMessage.innerText = "Digite o nome corretamente";
  }
  if (selCont === null || selCont === "") {
    throw errorMessage.innerText = "Selecione o tipo de container";
  }
  if (selStat === null || selStat === "") {
    throw errorMessage.innerText = "Selecione o status de container";
  }
  if (selCat === null || selCat === "") {
    throw errorMessage.innerText = "Selecione o status de container";
  }
  if (!formatacaoCont.test(contNum)) {
    throw errorMessage.innerText = "Padrão de container incorreto";
  }

  //Passagem do DATA CONTAINER
  contModel = {
    "cliente": cliente,
    "num_container": contNum,
    "tipo": selCont,
    "status_container": selStat,
    "categoria": selCat
  }

  //----------Chamada Post
  postContainer(contModel);
}


// Método Post
async function postContainer(contModel) {
  try {
    const response = await fetch(`${url}/container`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(contModel)
    });
    if (!response.ok) {
      throw errorMessage.innerText = response.statusText;
    }

    const data = await response.json();

    appendTableContainer(data);

  } catch (error) {
    console.log(error);
  }
}


function openEditable(container) {
  const { id_container: id, cliente, num_container: num, tipo, status_container, categoria } = container;
  const row = document.getElementById(id);
  row.
  row.innerHTML = `
      <td>${cliente}</td>
      <td>${num}</td>
      <td>${tipo}</td>
      <td>${status_container}</td>
      <td>${categoria}</td>
      <td><span id="lapis" title="Editar" onclick="openEditable(${container})">✏️</span></td>
      <td><span id="lixo" title="Excluir" onclick="deleteContainer(${id})">🗑️</span></td>
    `;
}


//tipo um ecapsulamento
async function appendTableContainer(container) {
  const { id_container: id, cliente, num_container: num, tipo, status_container, categoria } = container;
  const newRow = document.createElement('tr');
  newRow.setAttribute('id', id);  //Setando ID como id_container para cada linha da tabela
  newRow.innerHTML = `
      <td> ${cliente} </td>
      <td>${num}</td>
      <td>${tipo}</td>
      <td>${status_container}</td>
      <td>${categoria}</td>
      <td><span id="lapis" title="Editar" onclick="openEditable(${id, cliente, num, tipo, status_container, categoria})">✏️</span></td>
      <td><span id="lixo" title="Excluir" onclick="deleteContainer(${id})">🗑️</span></td>
    `;                                                                                                        //chamando o método de excluir e passando o id
  document.getElementById('myTableBody').appendChild(newRow);
}

async function editContainer(id) {
  try {
    const data = {

    }
    const response = await fetch(`${url}/container`, {
      method: "PUT",
      headers: {
        "Contet-Type": "application/json"
      },
      body: JSON.stringify(data)
    });
  } catch (error) {
    throw errorMessage.innerText = error;
  }
}

async function getContainerData() {
  try {
    notFoundContainer.style.display = "none";           //css
    loadContainer.style.display = "flex";               //css
    const response = await fetch(`${url}/container`);
    if (!response.ok) {
      throw new Error('Erro ao obter os dados da API');
    }

    const data = await response.json();

    if (data.length > 0) {
      data.forEach(container => {
        appendTableContainer(container);
      });
    } else {
      notFoundContainer.style.display = "flex"
    }
  } catch (error) {
    console.error('Erro:', error);
  } finally {
    loadContainer.style.display = "none"; // Esconde a mensagem de "Buscando..."
  }
}







//
async function deleteContainer(id) {
  try {
    const data = {
      "id_container": id
    }
    const response = await fetch(`${url}/container`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    });
    if (!response.ok) {
      throw errorMessage.innerText = response.statusText;
    }
    document.getElementById(id).remove();
  }
  catch (error) {
    throw errorMessage.innerText = "Erro ao deletar";
  }
}