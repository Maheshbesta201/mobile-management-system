// src/components/AddMobile.js

import axios from "axios";
import { useState } from "react";

function AddMobile({ refresh }) {
  const [mobile, setMobile] = useState({
    mobilename: "",
    model: "",
    price: "",
    ram: ""
  });

  const handleChange = (e) => {
    setMobile({ ...mobile, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post("http://localhost:9652/api/mobiles", mobile)
      .then(() => {
        refresh();
        setMobile({ mobilename: "", model: "", price: "", ram: "" });
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="mobilename" placeholder="MobileName" onChange={handleChange} />
      <input name="price" placeholder="Price" onChange={handleChange} />
      <input name="ram" placeholder="RAM" onChange={handleChange} />
      <input name="rom" placeholder="Rom" onChange={handleChange} />
      <button type="submit">Add Mobile</button>
    </form>
  );
}

export default AddMobile;