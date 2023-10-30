import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import Home from "./components/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from "react-bootstrap";
import Login from "./components/Login";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducer/MyUserReducer";
import Register from "./components/Register";
import cookie from "react-cookies";


import TintucDetails from "./components/TintucDetails";
import 'moment/locale/vi';



export const MyUserContext = createContext();


const App = () => {
  const [nguoidung, dispatch] = useReducer(MyUserReducer, cookie.load("nguoidung") || null)
  

  return(
    <>
     <MyUserContext.Provider value={[nguoidung, dispatch]}>
        
          <BrowserRouter>
            <Header />
            <Container>
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/tintucs/:tintucId" element={<TintucDetails />} />

              </Routes>
            </Container>
            <Footer />
          </BrowserRouter>
        
      </MyUserContext.Provider>
    </>
  )
}

export default App;