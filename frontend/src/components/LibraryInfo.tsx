import { ReactNode } from "react";

type Props = {
    title: string,
    children: ReactNode;
}

const LibraryInfo = ({ title, children }: Props) => {
  return (
    <div className="h-full w-[32%] bg-black rounded-3xl bg-opacity-40 backdrop-blur-md flex items-center">
      <div className="w-[90%] h-[90%] mx-auto">
        <p className="text-2xl border-b-[2px] pb-3 border-gray-300">
          {title}
        </p>
        {children}
      </div>
    </div>
  );
};

export default LibraryInfo;