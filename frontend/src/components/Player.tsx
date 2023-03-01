import { Icon } from "@iconify/react";
import MusicExample from "../assets/music.jfif";
import "./Player.css";

const Player = () => {
  return (
    <div className="flex flex-col justify-evenly absolute bottom-0 h-[25%] w-full">
      <div className="w-full flex justify-between">
        <div className="flex">
          <img src={MusicExample} alt="" width="100px" />
          <div className="ml-2 flex flex-col justify-center">
            <p className="text-xl">Make Me Feel</p>
            <p className="text-gray-400">John Summit</p>
          </div>
        </div>
        <div className="flex self-end">
          <Icon icon="material-symbols:lyrics" width="30" className="mr-3"></Icon>
          <Icon icon="ri:heart-3-fill" width="30"></Icon>
        </div>
      </div>
      <progress
        className="h-[4px] w-full rounded-lg bg-gray-400 bg-opacity-50"
        value="50"
        max="100"
      ></progress>
      <div className="relative flex justify-center">
        <div className="flex absolute left-0 self-center items-center justify-between">
          <Icon
            icon="radix-icons:dots-horizontal"
            width="30"
            className="cursor-pointer"
          ></Icon>
          <Icon
            icon="ph:shuffle"
            width="30"
            className="cursor-pointer ml-3 mr-3"
          ></Icon>
          <Icon
            icon="ph:repeat-bold"
            width="30"
            className="cursor-pointer"
          ></Icon>
        </div>
        <div className="w-[10%] flex items-center justify-between">
          <Icon
            icon="mdi:skip-previous-circle"
            width="40"
            className="hover:cursor-pointer"
          />
          <Icon
            icon="material-symbols:play-circle-rounded"
            width="55"
            className="hover:cursor-pointer"
          />
          <Icon
            icon="mdi:skip-next-circle"
            width="40"
            className="hover:cursor-pointer"
          />
        </div>
        <div className="flex absolute right-0 self-center items-center">
          <Icon
            icon="mingcute:volume-fill"
            width="30"
            className="cursor-pointer"
          ></Icon>
          <progress
            className="ml-3 h-[4px] rounded-lg bg-gray-400 bg-opacity-50"
            value="90"
            max="100"
          ></progress>
        </div>
      </div>
    </div>
  );
};

export default Player;
