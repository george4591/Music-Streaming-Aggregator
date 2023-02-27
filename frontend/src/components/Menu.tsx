import homeSvg from "../assets/home.svg";
import searchSvg from "../assets/search.svg";
import librarySvg from "../assets/library.svg";
import likedSvg from "../assets/liked.svg";
import profileSvg from "../assets/profile.svg";
import settingsSvg from "../assets/settings.svg";
import profilePic from "../assets/profile-pic.jfif";

const Menu = () => {
  const items = [
    { img: homeSvg, text: "HOME" },
    { img: searchSvg, text: "SEARCH" },
    { img: librarySvg, text: "LIBRARY" },
    { img: likedSvg, text: "LIKED" },
    { img: profileSvg, text: "PROFILE" },
  ];
  return (
    <div className="h-[80%] flex flex-col items-center justify-evenly">
      <img className="rounded-full w-[120px] hover:cursor-pointer" src={profilePic} />
      <div>
        <ul className="w-[10vw] leading-[3]">
          {items.map((item, index) => (
            <li
              key={index}
              className="w-full flex justify-evenly hover:bg-main-color-hover mx-auto cursor-pointer"
            >
              <img src={item.img} />
              <p>{item.text}</p>
            </li>
          ))}
        </ul>
      </div>
      <div className="w-full leading-[3] flex justify-evenly hover:bg-main-color-hover mx-auto cursor-pointer">
        <img src={settingsSvg} />
        <p>SETTINGS</p>
      </div>
    </div>
  );
};

export default Menu;
