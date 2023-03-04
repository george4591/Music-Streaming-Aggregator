import { Icon } from "@iconify/react";
import { IconProps } from "../types/PropTypes";

const IconsList = ({ icons, className }: IconProps) => {
  return (
    <ul className="w-full">
      {icons.map((icon) => (
        <li key={icon.src} className={className}>
          <Icon icon={icon.src} width={icon.size || "30"} />
        </li>
      ))}
    </ul>
  );
};

export default IconsList;
