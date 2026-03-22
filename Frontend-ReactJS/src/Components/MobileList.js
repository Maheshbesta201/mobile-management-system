// src/components/MobileList.js

import axios from "axios";
import { useEffect, useState } from "react";

function MobileList() {
  const [mobiles, setMobiles] = useState([]);

  useEffect(() => {
    fetchMobiles();
  }, []);

  const fetchMobiles = () => {
    axios.get("http://localhost:9652/api/mobiles/Getmobiles")
      .then(res => setMobiles(res.data))
      .catch(err => console.log(err));
  };

  const deleteMobile = (id) => {
    axios.delete(`http://localhost:9652/api/mobiles/${id}`)
      .then(() => fetchMobiles());
  };

  return (
    <div>
      <h2>Mobile List</h2>
      <table border="1">
        <thead>
          <tr>
            <th>MobileName</th>
            <th>Price</th>
            <th>RAM</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {mobiles.map(m => (
            <tr key={m.id}>
              <td>{m.mobilename}</td>
              <td>{m.price}</td>
              <td>{m.ram}</td>
              <td>
                <button onClick={() => deleteMobile(m.mobileid)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MobileList;