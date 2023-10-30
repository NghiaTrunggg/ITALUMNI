
import { useContext, useState } from "react";
import { Button, Form } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from "react-cookies";
import { MyUserContext } from "../App";
import { Navigate } from "react-router-dom";



const Login = () => {
    const [nguoidung, dispatch] = useContext(MyUserContext);
    const [tendn, setTendn] = useState();
    const [matkhau, setMatkhau] = useState();


    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                    "tendn": tendn,
                    "matkhau": matkhau
                });  
                cookie.save("token", res.data);

                let {data} = await authApi().get(endpoints['current-user']);
                cookie.save("nguoidung", data);

                dispatch({
                    "type": "login",
                    "payload": data

                });
                // console.info(res.data);
            } catch (err) {
                console.error(err);
            }
        }

        process();
    }

    if ( nguoidung !== null)
        return <Navigate to="/"/>

    return <>
        <h1 className="text-center text-info">ĐĂNG NHẬP NGƯỜI DÙNG</h1>
        <Form onSubmit={login}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={tendn} onChange={e => setTendn(e.target.value)} type="text" placeholder="Tên đăng nhập..." />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={matkhau} onChange={e => setMatkhau(e.target.value)} type="text" placeholder="Mật khẩu..." />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Button variant="info" type="submit">Đăng nhập</Button>
            </Form.Group>
        </Form>
    </>
}

export default Login;