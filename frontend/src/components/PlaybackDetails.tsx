import { Icon } from "@iconify/react";
import MusicExample from "../assets/music.jfif";

const PlaybackDetails = () => {

    return (
        <div className="w-full flex justify-between">
        <div className="flex">
          <img src={MusicExample} alt="" width="100px" />
          <div className="ml-2 flex flex-col justify-center">
            <p className="text-xl">Make Me Feel</p>
            <p className="text-gray-400">John Summit</p>
          </div>
        </div>
        <div className="flex self-end">
          <Icon
            icon="material-symbols:lyrics"
            width="30"
            className="mr-3"
          ></Icon>
          <Icon icon="ri:heart-3-fill" width="30"></Icon>
        </div>
      </div>
    )
}

export default PlaybackDetails;