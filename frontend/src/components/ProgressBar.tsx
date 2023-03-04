const ProgressBar = () => {
  return (
    <progress
      className="h-[4px] w-full rounded-lg bg-gray-400 bg-opacity-50"
      value="50"
      max="100"
    ></progress>
  );
};

export default ProgressBar;
