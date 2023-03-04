export interface IconType {
  src: string;
  size?: string;
}

export interface SongType {
  title: string;
  artist: string;
  duration?: string;
}

export interface PlaylistType {
  title: string;
}

interface Customizable {
  className?: string;
}

export interface IconProps extends Customizable {
  icons: IconType[];
  iconClassName?: string;
}

export interface SongProps extends Customizable {
  songs: SongType[];
}

export interface PlaylistProps extends Customizable {
  playlists: PlaylistType[];
}
