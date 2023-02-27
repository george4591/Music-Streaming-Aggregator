/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    colors: {
      "main-color": "#11102E",
      "main-color-hover": '#1c1c54',
    },

    extend: {
      backgroundImage: {
        "main-window": "url('/img/bg-main.jpg')",
      },
    },
  },
  plugins: [],
};
