import { useState } from "react";
import Menu from "./components/Menu";
import MainWindow from "./components/MainWindow";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";

function Data() {
  return <div>YO</div>;
}

function App() {
  return (
    <div className="font-semibold flex justify-between">
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={
              <>
                <Menu />
                <MainWindow />
              </>
            }
          />
          <Route path="/callback" element={<Data />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
