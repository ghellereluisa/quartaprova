import Home from './Pages/Home';
import CriarNovo from './Pages/CriarNovo';
import { Routes, Route } from 'react-router-dom';

function Rotas() {

    return(
        <Routes>
            <Route path="/" element={<Home />} exact />
            <Route path="criar-novo" element={<CriarNovo />} />
        </Routes>
    )

}

export default Rotas;