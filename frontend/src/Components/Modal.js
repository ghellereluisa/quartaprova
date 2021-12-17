import React from 'react';
import { useEffect, useState } from 'react/cjs/react.development';
import styled from 'styled-components';
import api from '../api';

const ModalWrapper = styled.div`
    width: 30%;
    height: 70%;
    position: absolute;
    left: 35%;
    box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;

    p {
        position: absolute;
        background-color: transparent;
        font-size: 35px;
        right: 5px;
        top: 5px;
    }

    form{
        width: 100%;
        height: 100%;
        display: flex;
        flex-flow: column;
        align-items: center;
        justify-content: center;

        input {
            width: 60%;
            margin-top: 2%;
            padding: 2%;
            outline: none;
            border: 1px solid transparent;
            background-color: white;
            border-radius: 5px;
        }

        input:focus {
            border: 1px solid white;
        }

        select {
            width: 60%;
            margin-top: 2%;
            padding: 2%;
            outline: none;
            border: 1px solid transparent;
            background-color: white;
            border-radius: 5px;
        }

        select:focus{
            border: 1px solid #0B3B86;
        }
    }
`;

function Modal(props) {

    useEffect(() => {
        async function BuscaProduto() {
            const response = await api.get(`produto/${props}`)
            setProduto(response.data);
        }
    });

    const [showModal, SetShowModal] = useState(true);

    const [produto, setProduto] = useState([]);

    const [id, SetId] = useState();

    const [nome, setNome] = useState("");

    const [fornecedor, setFornecedor] = useState("");

    const [qtt, setQtt] = useState();

    const [precoCompra, setPrecoCompra] = useState();

    const [precoVenda, setPrecoVenda] = useState();

    const [tipo, setTipo] = useState([]);

    const [estoque, setEstoqueipo] = useState([]);

    return(
        <ModalWrapper style={{display: showModal? 'flex' : 'none'}}>
            <p onClick={() => SetShowModal(!showModal)}>X</p>
            <form>
                <h3>alterar produto</h3>
                <h5>produto</h5>
                <input placeholder="Nome" />
                <input placeholder="Fornecedor" />
                <input placeholder="Quantidade" />
                <input placeholder="Valor bruto" />
                <input placeholder="Valor venda" />
                <select></select>
                <select></select>
            </form>
        </ModalWrapper>
    )
}
    export default Modal;