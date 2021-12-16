import React from 'react';
import Navbar from '../Components/Navbar';
import api from '../api';
import styled from 'styled-components';
import { useEffect, useState } from 'react';
import Modal from '../Components/Modal';

const TabelaItens = styled.div`
    width: 95%;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;

    .single-item{
        display: flex;
        align-items: center;
        justify-content: space-around;
        text-align: center;
        margin-bottom: 5%;

        h4{
            width: 16%;
        }

        .botoes{
            width: 10%;
            button{
                padding: .5rem;
                border: none;
                outline: none;
                background: #5C42EE;
                color: white;
            }
        }
    }

    .single-item:first-child{
        margin-top: 2%;
    }

    .single-item:last-child{
        margin-bottom: 2%;
    }

`;

function Home() {

    const [produtos, SetProdutos] = useState([]);
    const [qttProdutos, SetQttProdutos] = useState();

    useEffect(() => {
        async function ListaProdutos() {
            const response = await api.get('/produtos')
            console.log(response);
            SetProdutos(response.data);
            console.log(qttProdutos);
            SetQttProdutos(1)
        }
        ListaProdutos();
    }, [])

    function aumentaProduto() {
        SetQttProdutos(qttProdutos + 1);
    }

    return(
        <div>
            <Navbar />
            <Modal />
            <div className='container mt-5 d-flex align-items-center flex-column justify-content-center'>
                <h2>Produtos</h2>
                <TabelaItens>
                    {produtos.map(prod =>
                    <div className='single-item' key={prod.id}>
                        <h4>{prod.nome}</h4>
                        <span><b>Fornecedor</b><br></br>{prod.fornecedor}</span>
                        <span><b>Quantidade</b><br></br>{qttProdutos}</span>
                        <span><b>Preço de Compra</b><br></br>{prod.precoCompra}</span>
                        <span><b>Preço de Venda</b><br></br>{prod.precoVenda}</span>
                        <span><b>Tipo</b><br></br>{prod.tipoproduto.nome}</span>
                        <span><b>Estoque</b><br></br>{prod.estoque_id.nome}</span>
                        <div className='botoes'>
                            <button>Editar</button>
                        </div>
                    </div>    
                    )}
                </TabelaItens>
            </div>
        </div>
    )
}

export default Home;