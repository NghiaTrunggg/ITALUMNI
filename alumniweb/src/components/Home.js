import {  useEffect, useState } from "react";
import MySpinner from "../layout/MySpinner";
import Apis, { endpoints } from "../configs/Apis";
import { Alert, Button, Card, Carousel, Col, Row } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";

import cookie from "react-cookies";

const Home = () => {
  
  const [tintucs, setTintucs] = useState(null);
  const [q] = useSearchParams();

  const [, setErr] = useState(null);

  useEffect(() => {
    const loadTintuc = async () => {
      try {
        let e = endpoints["tintucs"];

        let danhmucId = q.get("danhmucId");
        if (danhmucId !== null) e = `${e}?danhmucId=${danhmucId}`;
        else {
          let kw = q.get("kw");
          if (kw !== null) e = `${e}?kw=${kw}`;
        }

        let res = await Apis.get(e);
        setTintucs(res.data);
      } catch (ex) {
        console.error(ex);
      }
    };

    loadTintuc();
  }, [q]);

  

  if (tintucs === null) return <MySpinner />;

  if (tintucs.length === 0)
        return <Alert variant="info" className="mt-1">Chưa có thông tin bài đăng!</Alert>

  return (
    <>
      <Carousel>
        <Carousel.Item className="slides" style={{ height: "300px" }}>
          <img
            className="d-block w-100"
            src="https://ou.edu.vn/wp-content/uploads/2023/10/458a2f401d5dca03934c.jpg"
            alt="First slide"
          />
        </Carousel.Item>
        <Carousel.Item className="slides">
          <img
            className="d-block w-100"
            src="https://ou.edu.vn/wp-content/uploads/2023/07/baac7a93ffb32ced75a2.jpg"
            alt="First slide"
          />
        </Carousel.Item>
        <Carousel.Item className="slides">
          <img
            className="d-block w-100"
            src="https://ou.edu.vn/wp-content/uploads/2023/02/Banner-web-Thac-si_1900x500.png"
            alt="First slide"
          />
        </Carousel.Item>
      </Carousel>

      <h3 className="text-center mt-2">TIN TỨC TỔNG HỢP</h3>

      <Row>
        {tintucs.map((t) => {
          let url = `/tintucs/${t.id}`;

          return (
            <Col xs={12} md={3} className="mt-2 mb-4">
              <Card style={{ width: "300px", height: "480px" }}>
                <Card.Img
                  variant="top"
                  src={t.hinhanh}
                  style={{ height: "200px" }}
                />
                <Card.Body>
                  <Card.Title>{t.ten}</Card.Title>
                  <Card.Text>{t.tomtat}</Card.Text>
                  <Link
                    to={url}
                    className="btn btn-info"
                    style={{ marginRight: "5px" }}
                    variant="primary"
                  >Chi tiết</Link>
                  
                </Card.Body>
              </Card>
            </Col>
          );
        })}
      </Row>
    </>
  );
};

export default Home;
