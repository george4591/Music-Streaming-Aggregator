import { Icon } from "@iconify/react";
import { IconType } from "../types/IconType";
import IconsList from "./IconsList";

const Menu = () => {
  const items: IconType[] = [
    { src: "material-symbols:home-outline" },
    { src: "material-symbols:search-rounded" },
    { src: "material-symbols:music-note-rounded" },
    { src: "ri:heart-3-fill" },
    { src: "ph:user-bold" },
    { src: "mdi:cog" },
  ];
  return (
    <div className="h-[100%] w-[5vw] bg-black bg-opacity-40 backdrop-blur-md flex flex-col items-center justify-around">
      <IconsList
        icons={items}
        className="pb-5 pt-5 w-full flex justify-center items-center hover:bg-gray-500 hover:bg-opacity-10 cursor-pointer"
      />
    </div>
  );
};

export default Menu;
