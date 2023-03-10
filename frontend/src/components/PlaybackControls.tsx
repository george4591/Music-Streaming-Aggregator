import { IconType } from "../types/PropTypes";
import ProgressBar from "./ProgressBar";
import VolumeBar from "./VolumeBar";
import IconsGroup from "./IconsGroup";

const ShuffleIcons: IconType[] = [
  { src: "radix-icons:dots-horizontal" },
  { src: "ph:shuffle" },
  { src: "ph:repeat-bold" },
];

const PlayIcons: IconType[] = [
  { src: "mdi:skip-previous-circle", size: "40" },
  { src: "material-symbols:play-circle-rounded", size: "55" },
  { src: "mdi:skip-next-circle", size: "40" },
];

const PlaybackControls = () => {
  return (
    <div>
      <ProgressBar />
      <div className="mt-3 relative flex justify-center">
        <IconsGroup
          icons={ShuffleIcons}
          className="w-28 flex absolute left-0 self-center items-center justify-between"
        />
        <IconsGroup
          icons={PlayIcons}
          className="w-[10%] flex items-center justify-between"
        />
        <VolumeBar />
      </div>
    </div>
  );
};

export default PlaybackControls;
