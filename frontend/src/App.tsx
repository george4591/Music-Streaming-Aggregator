import { useState } from "react";
import Menu from "./components/Menu";
import MainWindow from "./components/MainWindow";
import Callback from "./components/Callback";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Player from "./components/Player";

function App() {
  return (
    <div className="h-[100vh] ">
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={
              <>
                <div className="h-[95%] bg-main-color font-semibold flex justify-around items-center">
                  <Menu />
                  <MainWindow />
                </div>
                <Player />
              </>
            }
          />
          <Route path="/callback" element={<Callback />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
