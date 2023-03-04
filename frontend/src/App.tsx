import Menu from "./components/Menu";
import MainWindow from "./components/MainWindow";
import Callback from "./components/Callback";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <div className="h-[100vh] ">
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={
              <div className="h-[100%] bg-main-window-5 bg-cover font-semibold flex justify-around items-center">
                <Menu />
                <MainWindow />
              </div>
            }
          />
          <Route path="/callback" element={<Callback />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
