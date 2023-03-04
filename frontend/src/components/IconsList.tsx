import { Icon } from "@iconify/react";
import { IconProps } from "../types/IconProps";

const IconsList = ({ icons, className }: IconProps) => {
  return (
    <ul className="w-full">
      {icons.map((item, index) => (
        <li key={index} className={className}>
          <Icon icon={item.src} width="30" />
        </li>
      ))}
    </ul>
  );
};

export default IconsList;
