import { Icon } from "@iconify/react";
import { IconProps } from "../types/IconProps";


const IconsGroup = ({ icons, className }: IconProps) => {
  return (
    <div className={className}>
      {icons.map((icon) => {
        return (
          <Icon
            icon={icon.src}
            width={icon.size || "30"}
            className="cursor-pointer"
          ></Icon>
        );
      })}
    </div>
  );
};

export default IconsGroup;