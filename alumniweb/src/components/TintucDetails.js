import { useContext, useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";
import Apis, { authApi, endpoints } from "../configs/Apis";
import { MyUserContext } from "../App";
import { Button, Form, ListGroup } from "react-bootstrap";
import Moment from "react-moment";

const TintucDetails = () => {
    const [nguoidung, ] = useContext(MyUserContext);
    const {tintucId} = useParams();
    const [tintuc, setTintuc] = useState(null);
    const [binhluans, setBinhluans] = useState(null);
    const [noidung, setNoidung] = useState();

    useEffect(() => {
        const loadTintuc = async () => {
            let {data} = await Apis.get(endpoints['chitiets'](tintucId));
            setTintuc(data); 
        }

        const loadBinhluans = async () => {
            let {data} = await Apis.get(endpoints['binhluans'](tintucId));
            setBinhluans(data);
        }

        loadTintuc();
        loadBinhluans();
    }, []);

    const addBinhluan = () => {
        const process = async () => {
            let {data} = await authApi().post(endpoints['them-binhluan'], {
                "noidung": noidung, 
                "tintucId": tintuc.id
            });

            setBinhluans([...binhluans, data]);
        }

        process();
    }

    if (tintuc === null || binhluans === null ) 
    // || comments === null
    return <MySpinner /> ;

    let url = `/login?next=/tinucs/${tintucId}`;

    return <>
        <h1 className="text-center text-info mt-2">{tintuc.ten}</h1>
        <img  src={tintuc.hinhanh} alt={`${tintuc.ten}`} style={{
                                    width: '600px',
                                    height: '400px',
                                    marginLeft: '30%',
                                    marginTop: '5px'
                                }} />
        <p className="mt-3">{tintuc.noidung}</p>

        <hr />
        

        {nguoidung===null?<p>Vui lòng <Link to={url}>đăng nhập</Link> để bình luận! </p>:<>
        <Form.Control as="textarea" aria-label="With textarea" value={noidung} onChange={e => setNoidung(e.target.value)} placeholder="Nội dung bình luận" />
        <Button onClick={addBinhluan} className="mt-2" variant="info">Bình luận</Button>
        </>}
        <hr />
        {/* <ListGroup>
            {binhluans.map(b => <ListGroup.Item id={b.id}>
                        {b.nguoidungId.tendn} - {b.noidung} - <Moment locale="vi" fromNow>{b.createdDate}</Moment>
                    </ListGroup.Item>)
            }
        </ListGroup> */}
        <ListGroup>
                {binhluans.map(b => <ListGroup.Item id={b.id}>
                    <div>
                        <div>
                            <img src={b.nguoidungId.hinhdaidien} alt={`${b.nguoidungId.hinhdaidien} hinhdaidien`}
                                style={{
                                    borderRadius: '50%',
                                    width: '50px',
                                    height: '50px',
                                }}
                            />
                            <span> {b.noidung} </span>

                        </div>
                        <div>

                        </div>
                        <div>
                            <span style={{ fontWeight: 'bold' }}> {b.nguoidungId.tendn}</span>
                            <span> đã bình luận </span>
                            <span>
                                <Moment locale="vi" fromNow>{b.createdDate}</Moment>
                            </span>
                        </div>
                    </div>
                </ListGroup.Item>)}
            </ListGroup>
    </>
}
export default TintucDetails;