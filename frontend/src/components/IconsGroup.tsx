import { Icon } from "@iconify/react";
import { IconProps } from "../types/PropTypes";

const IconsGroup = ({ icons, className }: IconProps) => {
  return (
    <div className={className}>
      {icons.map((icon) => {
        return (
          <Icon
            key={icon.src}
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
