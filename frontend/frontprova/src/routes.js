import Home from './Pages/Home';
import { Routes, Route } from 'react-router-dom';

function Rotas() {

    return(
        <Routes>
            <Route path="/" element={<Home />} exact />
        </Routes>
    )

}

export default Rotas;