import { useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

const Register = () => {
    const [nguoidung, setNguoidung] = useState({
        "tendn": "", 
        "matkhau": "",
        "xacnhanmk": "", 
        "ho": "", 
        "ten": "", 
        "nienkhoa": "",
    });

    const hinhdaidien = useRef();

    const nav = useNavigate();

    const [err, setErr] = useState(null);

    const [loading, setLoading] = useState(false);
   

    const register = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let form = new FormData();

            for (let field in nguoidung)
                if (field !== "xacnhanmk")
                    form.append(field, nguoidung[field]);

            form.append("hinhdaidien", hinhdaidien.current.files[0]);

            setLoading(true)
            let res = await Apis.post(endpoints['register'], form);
            if (res.status === 201) {
                nav("/login");
            } else
            setErr("Hệ thống bị lỗi!");
        }

        if (nguoidung.matkhau === nguoidung.xacnhanmk)
            process();
        else {
            setErr("MẬT KHẨU KHÔNG KHỚP!");
        }
    }

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        setNguoidung(current => {
            return {...current, [field]: evt.target.value}
        })
    }

    return <>
        <h1 className="text-center text-info mt-2">ĐĂNG KÝ NGƯỜI DÙNG</h1>

        {err === null?"":<Alert variant="danger">{err}</Alert>}

        <Form onSubmit={register}>
            <Form.Group className="mb-3">
                <Form.Label>Họ</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "ho")} placeholder="Họ" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Tên</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "ten")} placeholder="Tên" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Niên khóa</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "nienkhoa")} placeholder="Niên khóa" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={nguoidung.tendn} onChange={(e) => change(e, "tendn")} type="text" placeholder="Tên đăng nhập" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={nguoidung.matkhau} onChange={(e) => change(e, "matkhau")} type="password" placeholder="Mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Xác nhận mật khẩu</Form.Label>
                <Form.Control value={nguoidung.xacnhanmk} onChange={(e) => change(e, "xacnhanmk")} type="password" placeholder="Xác nhận mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                <Form.Control type="file" ref={hinhdaidien}  />
            </Form.Group>
            <Form.Group className="mb-3">
            {loading === true?<MySpinner />: <Button variant="info" type="submit">Đăng ký</Button>}
                
            </Form.Group>
        </Form>
    </>
}

export default Register;