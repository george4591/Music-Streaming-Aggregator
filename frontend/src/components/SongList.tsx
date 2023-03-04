import trackExampleImg from "../assets/music.jfif";
import { SongProps } from "../types/PropTypes";


const SongList = ({ songs, className}: SongProps) => {
  return (
    <ul className={"leading-3"}>
      {songs.map((item, index) => (
        <li
          key={index}
          className={className}
        >
          <img src={trackExampleImg} alt="" width="44px" />
          <div className="relative ml-2 flex flex-col justify-center">
            <p className="text-base">{item.title}</p>
            <p className="text-gray-400 text-sm">{item.artist}</p>
          </div>
          <p className="text-gray-300 absolute right-2 top-[40%]">3:28</p>
        </li>
      ))}
    </ul>
  );
};

export default SongList;
