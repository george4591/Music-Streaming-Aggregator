import axios from "axios";

const MainWindow = () => {
  const handleLogin = async () => {
    axios.post("https://localhost:7070/login");
  };

  return (
    <div className="bg-main-window bg-cover w-full h-full">
      See What's Trending
      <button >Log in with Spotify</button>
    </div>
  );
};

export default MainWindow;
