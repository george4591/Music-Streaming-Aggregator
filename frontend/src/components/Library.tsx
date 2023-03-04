import SongList from "./SongList";
import PlaylistList from "./PlaylistList";
import LibraryInfo from "./LibraryInfo";

const Library = () => {
  const playlistExample = [
    { title: "House" },
    { title: "Pop" },
    { title: "Rap" },
    { title: "On Repeat" },
    { title: "Hip Hop" },
  ];

  const trackExample = [
    { title: "Make Me Feel", artist: "John Summit" },
    { title: "Make Me Feel", artist: "John Summit" },
    { title: "Make Me Feel", artist: "John Summit" },
    { title: "Make Me Feel", artist: "John Summit" },
    { title: "Make Me Feel", artist: "John Summit" },
  ];

  const similarExample = [
    { title: "Come Back to Me", artist: "Deeper Purpose" },
    { title: "Come Back to Me", artist: "Deeper Purpose" },
    { title: "Come Back to Me", artist: "Deeper Purpose" },
    { title: "Come Back to Me", artist: "Deeper Purpose" },
    { title: "Come Back to Me", artist: "Deeper Purpose" },
  ];
  return (
    <div className="h-[65%] flex justify-between">
      <LibraryInfo title="Your Playlists">
        <PlaylistList
          playlists={playlistExample}
          className="relative w-full py-4 px-2 cursor-pointer flex hover:bg-gray-500 hover:bg-opacity-10"
        />
      </LibraryInfo>
      <LibraryInfo title="Playlist Tracks">
        <SongList
          songs={trackExample}
          className="relative w-full py-4 px-2 cursor-pointer flex hover:bg-gray-500 hover:bg-opacity-10"
        />
      </LibraryInfo>
      <LibraryInfo title="Based on this Playlist">
        <SongList
          songs={similarExample}
          className="relative w-full py-4 px-2 cursor-pointer flex hover:bg-gray-500 hover:bg-opacity-10"
        />
      </LibraryInfo>
    </div>
  );
};

export default Library;
