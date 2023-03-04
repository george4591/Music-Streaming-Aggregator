import coverExampleImg from "../assets/cover.jfif";
import { PlaylistProps } from "../types/PropTypes";

const PlaylistList = ({ playlists, className }: PlaylistProps) => {
  return (
    <ul className={"leading-3"}>
      {playlists.map((item, index) => (
        <li key={index} className={className}>
          <img src={coverExampleImg} alt="" width="44px" />
          <div className="relative ml-2 flex flex-col justify-center">
            <p className="text-base">{item.title}</p>
            <p className="text-gray-400 text-sm">32 Tracks</p>
          </div>
          <p className="text-gray-300 absolute right-2 top-[40%]">3h40m</p>
        </li>
      ))}
    </ul>
  );
};

export default PlaylistList;
