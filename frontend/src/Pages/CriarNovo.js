import react from 'react';
import styled from 'styled-components';
import Navbar from '../Components/Navbar';
import { useState, useEffect } from 'react';
import axios from 'axios';
import api from '../api';


const CriarNovo = styled.div`
    width: 100%;
    height: 90vh;
    display: flex;
    align-items: center;
    justify-content: center;

    form {
        width: 40%;
        height: 90%;
        box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;
        display: flex;
        flex-flow: column;
        align-items: center;
        justify-content: center;
        
        h1 {
            margin-top: 10px;
        }

        input {
            width: 60%;
            margin-top: 2%;
            padding: 2%;
            outline: none;
            border: 1px solid transparent;
            background-color: #C1C1C1;
            border-radius: 2px;
        }

        input:focus {
            border: 1px solid #0B3B86;
        }

        button {
            outline: none;
            border: 2px solid #0B3B86;
            padding: .6rem;
            width: 30%;
            margin-top: 3%;
            font-size: 1.2rem;
            font-weight: bold;
        }

        select {
            padding: 1rem;
            width: 60%;
            margin-top: 3%;
        }
    }
`;

function CriarUmNovo() {

    const [listTipos, SetListTipos] = useState([]);

    const [estoqueList, SetEstoqueList] = useState([]);

    const [nome, setNome] = useState("");

    const [fornecedor, setFornecedor] = useState("");

    const [qtt, setQtt] = useState();

    const [precoCompra, setPrecoCompra] = useState();

    const [precoVenda, setPrecoVenda] = useState();

    const [tipo, setTipo] = useState([]);

    const [estoque, setEstoque] = useState([]);

    function handleSubmit(event) {
        const ctt = {
            nome: nome,
            fornecedor: fornecedor,
            quantidade: qtt,
            precoCompra: precoCompra,
            precoVenda: precoVenda,
            tipoProduto: {
                tipoId: tipo.id,
                nome: tipo.nome
            },
            estoque: {
                estoqueId: estoque.id,
                noma: estoque.nome
            }
        }

        axios.post(`http://localhost:8080/produto`, ctt)
        .then(
            alert("novo produto adicionado - sucesso")
        )
    }

    useEffect(() => {
        async function ListaTiposProduto() {
            const response1 = await api.get('/tipoproduto')
            SetListTipos(response1.data);
            console.log(listTipos);
        }
        ListaTiposProduto();
    }, [])

    useEffect(() => {
        async function ListaEstoques() {
            const response2 = await api.get('/estoque')
            SetEstoqueList(response2.data);
            console.log(estoqueList);
        }
        ListaEstoques();
    }, [])

    const listarTipos = 
        listTipos.map(lt => {
            return(<option key={lt.tipoId} value={lt.tipoIp}>{lt.nome}</option>)
        })

    const listarEstoques = 
        estoqueList.map(el => {
            return(<option key={el.tipoId} value={el.tipoIp}>{el.nome}</option>)
        })
    

    return(
        <>
            <Navbar />
            <CriarNovo>
                <form onSubmit={handleSubmit}>
                    <h1>Criar Novo</h1>
                    <input placeholder="Nome" name='nome' type={'text'} onChange={(e) => setNome(e.target.value)}/>
                    <input placeholder="Fornecedor" name='fornecedor' type={'text'} onChange={(e) => setFornecedor(e.target.value)}/>
                    <input placeholder="Quantidade" name='quantidade' type={'number'} onChange={(e) => setQtt(e.target.value)}/>
                    <input placeholder="Valor bruto" name='preco bruto' type={'number'} onChange={(e) => setPrecoCompra(e.target.value)}/>
                    <input placeholder="Valor revenda" name='preco revenda' type={'number'} onChange={(e) => setPrecoVenda(e.target.value)}/>
                    <select defaultValue={'DEFAULT'} name='tipo de produto' value={tipo} onChange={(e) => setTipo(e.target.value)}>
                        <option selected="selected" value="default">Tipo de Produto</option>
                        {listarTipos}
                    </select>
                    <select defaultValue={'DEFAULT'} name='estoque' value={estoque} onChange={(e) => setEstoque(e.target.value)}>
                        <option selected="selected" value="default">Estoque</option>
                        {listarEstoques}
                    </select>
                    <button type='submit' onClick={() => handleSubmit()}>Criar</button>
                </form>
            </CriarNovo>
        </>
    )
}

export default CriarUmNovo;