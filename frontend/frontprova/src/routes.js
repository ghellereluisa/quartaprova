import Home from './Pages/Home';
import { Routes, Route } from 'react-router-dom';

function Routes() {

    return(
        <Routes>
            <Route path="/" element={<Home />} exact />
        </Routes>
    )

}

export default Routes;