/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {colors: {
      "main-color": "#11102E",
      "main-color-hover": "#1c1c54",
    },
      backgroundImage: {
        "main-window": "url('/img/bg-main.jpg')",
        "main-window-2": "url('/img/concert.jpg')",
        "main-window-3": "url('/img/rave.jpg')",
        "main-window-4": "url('/img/rave2.jpg')",
        "main-window-5": "url('/img/rave3.jpg')"
      },
    },
  },
  plugins: [],
};
