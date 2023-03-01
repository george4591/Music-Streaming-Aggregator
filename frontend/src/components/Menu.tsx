import profilePic from "../assets/profile-pic.jfif";
import { Icon } from "@iconify/react";

const Menu = () => {
  const items = [
    { img: "material-symbols:home-outline", text: "HOME" },
    { img: "material-symbols:search-rounded", text: "SEARCH" },
    { img: "material-symbols:music-note-rounded", text: "LIBRARY" },
    { img: "ri:heart-3-fill", text: "LIKED" },
    { img: "ph:user-bold", text: "PROFILE" },
  ];
  return (
    <div className="h-[100%] w-[5vw] bg-black bg-opacity-5 backdrop-blur-md flex flex-col items-center justify-around">
      {/* <img
        className="rounded-full w-[120px] hover:cursor-pointer"
        src={profilePic}
      /> */}
      <div className="mx-auto w-full">
        <ul className="">
          {items.map((item, index) => (
            <li
              key={index}
              className="pb-5 pt-5 w-full flex justify-center items-center hover:bg-gray-500 hover:bg-opacity-10 cursor-pointer"
            >
              <Icon icon={item.img} width="30" />
              {/* <p className="ml-3">{item.text}</p> */}
            </li>
          ))}
        </ul>
      </div>
      <div className="pb-5 pt-5  w-full flex justify-center items-center hover:bg-gray-500 hover:bg-opacity-10 cursor-pointer">
        <Icon icon="mdi:cog" width="30" />
        {/* <p className="ml-3">SETTINGS</p> */}
      </div>
    </div>
  );
};

export default Menu;
