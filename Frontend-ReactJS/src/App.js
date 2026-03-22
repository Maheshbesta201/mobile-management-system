import MobileList from "./Components/MobileList";
import AddMobile from "./Components/AddMobile";
import { useState } from "react";

function App() {
  const [refresh, setRefresh] = useState(false);

  const reload = () => {
    setRefresh(!refresh);
  };

  return (
    <div>
      <h1>Mobile Management System</h1>
      <AddMobile refresh={reload} />
      <MobileList key={refresh} />
    </div>
  );
}

export default App;