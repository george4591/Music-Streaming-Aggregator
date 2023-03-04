import trackExampleImg from "../assets/music.jfif";
import similarExampleImg from "../assets/similar.jfif";
import coverExampleImg from "../assets/cover.jfif";
import { Icon } from "@iconify/react";


const Library = () => {
  const playlistExample = [
    { text: "House" },
    { text: "Pop" },
    { text: "Rap" },
    { text: "On Repeat" },
    { text: "Hip Hop" },
  ];

  const trackExample = [
    { title: "Make Me Feel", Artist: "John Summit" },
    { title: "Make Me Feel", Artist: "John Summit" },
    { title: "Make Me Feel", Artist: "John Summit" },
    { title: "Make Me Feel", Artist: "John Summit" },
    { title: "Make Me Feel", Artist: "John Summit" },
  ];

  const similarExample = [
    { title: "Come Back to Me", Artist: "Deeper Purpose" },
    { title: "Come Back to Me", Artist: "Deeper Purpose" },
    { title: "Come Back to Me", Artist: "Deeper Purpose" },
    { title: "Come Back to Me", Artist: "Deeper Purpose" },
    { title: "Come Back to Me", Artist: "Deeper Purpose" },
  ];
  return (
    <div className="h-[65%] flex justify-between">
      <div className="h-full w-[32%] bg-black rounded-3xl bg-opacity-40 backdrop-blur-md flex items-center">
        <div className="w-[90%] h-[90%] mx-auto">
          <p className="text-2xl border-b-[2px] pb-3 border-gray-300">
            Your Playlists
          </p>
          
          <ul className="leading-3">
            {playlistExample.map((item, index) => (
              <li
                key={index}
                className="relative w-full py-4 px-2 cursor-pointer flex hover:bg-gray-500 hover:bg-opacity-10"
              >
                <img src={coverExampleImg} alt="" width="44px" />
                <div className="relative ml-2 flex flex-col justify-center">
                  <p className="text-base">{item.text}</p>
                  <p className="text-gray-400 text-sm">32 Tracks</p>
                </div>
                <p className="text-gray-300 absolute right-2 top-[40%]">3h40m</p>
              </li>
            ))}
          </ul>
        </div>
      </div>
      <div className="h-full w-[32%] bg-black rounded-3xl bg-opacity-40 backdrop-blur-md flex items-center">
        <div className="w-[90%] h-[90%] mx-auto">
          <p className="text-2xl border-b-[2px] pb-3 border-gray-300">
            Playlist Tracks
          </p>
          <ul className="leading-3">
            {trackExample.map((item, index) => (
              <li
                key={index}
                className="relative w-full py-4 px-2 cursor-pointer flex hover:bg-gray-500 hover:bg-opacity-10"
              >
                <img src={trackExampleImg} alt="" width="44px" />
                <div className="relative ml-2 flex flex-col justify-center">
                  <p className="text-base">{item.title}</p>
                  <p className="text-gray-400 text-sm">{item.Artist}</p>
                </div>
                <p className="text-gray-300 absolute right-2 top-[40%]">3:28</p>
              </li>
            ))}
          </ul>
        </div>
      </div>
      <div className="h-full w-[32%] bg-black rounded-3xl bg-opacity-40 backdrop-blur-md flex items-center">
        <div className="w-[90%] h-[90%] mx-auto">
          <p className="text-2xl border-b-[2px] pb-3 border-gray-300">
            Based on this Playlist
          </p>
          <ul className="leading-3">
            {similarExample.map((item, index) => (
              <li
                key={index}
                className="relative w-full py-4 px-2 cursor-pointer flex hover:bg-gray-500 hover:bg-opacity-10"
              >
                <img src={similarExampleImg} alt="" width="44px" />
                <div className="relative ml-2 flex flex-col justify-center">
                  <p className="text-base">{item.title}</p>
                  <p className="text-gray-400 text-sm">{item.Artist}</p>
                </div>
                <p className="text-gray-300 absolute right-2 top-[40%]">3:45</p>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Library;
