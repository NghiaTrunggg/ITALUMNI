import { useContext, useEffect } from "react";
import { useState } from "react";
import { Badge, Button, Col, Container, Form, Nav, NavDropdown, Navbar, Row} from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "./MySpinner";
import { Link, useNavigate } from "react-router-dom";
import { MyCartContext, MyUserContext } from "../App";
// import Apis, {  endpoints } from "../configs/Apis";

const Header = () => {
  const [nguoidung, dispatch] = useContext(MyUserContext);
  const [danhmuctintucs, setDanhmuctintucs] = useState(null);
  const [kw,setKw] = useState("");
  const nav = useNavigate();

  const loadDanhmuc = async () => {
   

    let res = await Apis.get(endpoints['danhmuctintucs'])

    setDanhmuctintucs(res.data);
  }

  useEffect(() => {
    loadDanhmuc();
  }, [])

  const search = (evt) => {
    evt.preventDefault();
    nav(`/?kw=${kw}`)
  }

  const logout = () => {
    dispatch({
        "type" : "logout"
    })
}

  if (danhmuctintucs === null) 
    return <MySpinner/>;

  return (
    <>
      
      <Navbar expand="lg" className="bg-body-tertiary mb-1" >
        <Container>
          <Navbar.Brand href="#home" to="/">ITAlumni Website</Navbar.Brand>
          {/* <Link className="nav-link" to="/"> ITAlumni Website</Link> */}
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
            <Link className="nav-link" to="/">&#127968; Trang chủ</Link>
              

              <NavDropdown title="Tin tức" id="basic-nav-dropdown">
                {danhmuctintucs.map(d => {
                  let h = `/?danhmucId=${d.id}`;
                  return <Link className="dropdown-item" to={h} key={d.id}>{d.ten}</Link>
                })}
              </NavDropdown>
              {nguoidung == null ? <>
                                <Link className="text-danger nav-link" to="/login">Đăng nhập</Link>
                                <Link className="text-danger nav-link" to="/register">Đăng ký</Link>
                            </> : <>
                                <Link className="text-danger nav-link" to="/login">Chào {nguoidung.tendn}!</Link>
                                <Button variant="secondary" onClick={logout}>Đăng xuất</Button>
                </>}

            </Nav>
          </Navbar.Collapse>
          <Form onClick={search} inline>
            <Row>
              <Col xs="auto">
                <Form.Control
                  type="text"
                  value={kw}
                  onChange={e => setKw(e.target.value)}
                  placeholder="Nhập từ khóa..." name="kw"
                  className=" mr-sm-2"
                />
              </Col>
              <Col xs="sm">
                <Button type="submit">Tìm kiếm</Button>
              </Col>
            </Row>
        </Form>
      </Container>
      
    </Navbar>

    </>
  );
};

export default Header;
