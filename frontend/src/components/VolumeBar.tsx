import { Icon } from "@iconify/react";

const VolumeBar = () => {
  return (
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
  );
};

export default VolumeBar;
