import PlaybackDetails from "./PlaybackDetails";
import PlaybackControls from "./PlaybackControls";
import "../styles/Player.css";

const Player = () => {
  return (
    <div className="flex flex-col justify-evenly absolute bottom-0 h-[25%] w-full">
      <PlaybackDetails />
      <PlaybackControls />
    </div>
  );
};

export default Player;
