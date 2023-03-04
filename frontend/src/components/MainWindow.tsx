import axios from "axios";
import Library from "./Library";
import Player from "./Player";
import { BrowserRouter, Routes, Route } from "react-router-dom";

const MainWindow = () => {
  const handleLogin = async () => {
    axios.post("https://localhost:7070/login");
  };

  return (
    <div className="w-[85%] mx-auto bg-cover h-[95%] relative">
      <Library />
      <Player />
    </div>
  );
};

export default MainWindow;
