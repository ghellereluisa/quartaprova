import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

const NavWrapper = styled.div`
    width: 100%;
    background-color: black;
    display: flex;
    align-items: center;
    justify-content: space-between;

    .container {
        background-color: black;
        display: flex;
        align-items: center;
        justify-content: space-between;

        h2{
            width: 13%;
            text-align: center;
            background-color: black;
            color: red;
        }

        .navigation{
            width: 20%;
            background-color: black;

            button{
                outline: none;
                border: 2px solid white;
                padding: 3%;
                border-radius: 10px;
                background: transparent;
                width: 40%;
                font-size: 1.2rem;
                font-weight: bold;
                color: white;
            }
        }
    }
`;

function Navbar() {
    return(
        <NavWrapper>
            <div className='container'>
                <h2>Butequin da esquina</h2>
                <div className='navigation d-flex align-items-center justify-content-around'>
                    <button>inicial</button>
                    <button>estoque</button>
                </div>
            </div>
        </NavWrapper>
    )
}

export default Navbar;